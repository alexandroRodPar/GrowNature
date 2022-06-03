package com.proyecto.alexandrorodriguez.grownature;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.common.ChangeEventType;
import com.firebase.ui.firestore.ChangeEventListener;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.proyecto.alexandrorodriguez.grownature.adapters.ChatAdapter;
import com.proyecto.alexandrorodriguez.grownature.model.Conferencia;
import com.proyecto.alexandrorodriguez.grownature.model.FirebaseContract;
import com.proyecto.alexandrorodriguez.grownature.model.Mensaje;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class ContactoActivity extends AppCompatActivity {

    private static final String TAG = "GrowNature";

    private RecyclerView rv_chat;
    private EditText et_mensaje;
    private ImageButton ib_envio;
    private FirebaseAuth auth;
    private FirebaseUser usrFB;
    private Conferencia conferenciaActual;
    private ArrayList<Conferencia> listaConferencias;
    private String usuario;
    private ChatAdapter adapter;
    private Spinner sConferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        rv_chat = findViewById(R.id.rv_chat);
        et_mensaje = findViewById(R.id.et_mensaje);
        ib_envio = findViewById(R.id.ib_envio);
        sConferencias = findViewById(R.id.sConferencias);

        conferenciaActual = new Conferencia();

        auth = FirebaseAuth.getInstance();
        usrFB = auth.getCurrentUser();

        leerConferencias();
        iniciarConferenciasIniciadas();

        /**LE DAMOS ACTION AL BOTÓN DE ENVÍO**/
        ib_envio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensaje();
            }
        });

    }

    /**
     * PERMITE HACER EL ENVÍO DEL MENSAJE
     */
    private void enviarMensaje() {
        String body = et_mensaje.getText().toString();
        String usuario = usrFB.getEmail();
        if (!body.isEmpty()) {
            //usuario y mensaje
            Mensaje mensaje = new Mensaje(usuario, body);
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection(FirebaseContract.ConferenciaEntry.COLLECTION_NAME)
                    //documento conferencia actual
                    .document(conferenciaActual.getId())
                    //subcolección de la conferencia
                    .collection(FirebaseContract.ChatEntry.COLLECTION_NAME)
                    //añadimos el mensaje nuevo
                    .add(mensaje);
            et_mensaje.setText("");
            this.usuario = usuario;
            ocultarTeclado();
            /**AL PULSAR ENVIAR HACE QUE SE CARGUEN LOS MENSAJES EN EL RECYCLER VIEW**/
            defineAdaptador();
        }
    }

    /**
     * PERMITE QUE PUEDAN MOSTRARSE LOS MENSAJES EN EL RECYCLER VIEW
     */
    private void defineAdaptador() {
        rv_chat.setLayoutManager(new LinearLayoutManager(this));
        //consulta en Firebase
        Query query = FirebaseFirestore.getInstance()
                //coleccion conferencias
                .collection(FirebaseContract.ConferenciaEntry.COLLECTION_NAME)
                //documento: conferencia actual
                .document(conferenciaActual.getId())
                //colección chat de la conferencia
                .collection(FirebaseContract.ChatEntry.COLLECTION_NAME)
                //obtenemos la lista ordenada por fecha
                .orderBy(FirebaseContract.ChatEntry.FECHA_CREACION,
                        Query.Direction.DESCENDING);
        //Creamos la opciones del FirebaseAdapter
        FirestoreRecyclerOptions<Mensaje> options = new
                FirestoreRecyclerOptions.Builder<Mensaje>()
                //consulta y clase en la que se guarda los datos
                .setQuery(query, Mensaje.class)
                .setLifecycleOwner(this)
                .build();
        //si el usuario ya habia seleccionado otra conferencia, paramos lasescucha
        if (adapter != null) {
            adapter.stopListening();
        }
        //Creamos el adaptador
        adapter = new ChatAdapter(options, usuario);
        //asignamos el adaptador
        rv_chat.setAdapter(adapter);
        //comenzamos a escuchar. Normalmente solo tenemos un adaptador, estotenemos que
        //hacerlo en el evento onStar, como indica la documentación
        adapter.startListening();
        //Podemos reaccionar ante cambios en la query( se añade un mesaje).Nosotros,
        // //lo que necesitamos es mover el scroll
        // del recyclerView al inicio para ver el mensaje nuevo
        try{
            adapter.getSnapshots().addChangeEventListener(new ChangeEventListener() {
                @Override
                public void onChildChanged(@NonNull ChangeEventType type, @NonNull
                        DocumentSnapshot snapshot, int newIndex, int oldIndex) {
                    rv_chat.smoothScrollToPosition(0);
                }
                @Override
                public void onDataChanged() {
                }
                @Override
                public void onError(@NonNull FirebaseFirestoreException e) {
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Permite ocultar el teclado
     */
    private void ocultarTeclado() {
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(et_mensaje.getWindowToken(), 0);
        }
    }



    /**
     * PARA LEER LAS CONFERENCIAS
     */
    private void leerConferencias() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        listaConferencias=new ArrayList<Conferencia>();

        db.collection(FirebaseContract.ConferenciaEntry.COLLECTION_NAME)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " +
                                        document.getData());

                                listaConferencias.add(document.toObject(Conferencia.class));
                            }
                            cargaSpinner();

                        } else {
                            Log.d(TAG, "Error getting documents: ",
                                    task.getException());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * PERMITE HACER LAS CARGA DEL SPINNER, Y REALIZAR LAS FUNCIONES
     */
    private void cargaSpinner() {
        ArrayList<String> nombres = new ArrayList<>();
        for(Conferencia conferencia : listaConferencias){
            nombres.add(conferencia.getNombre());
        }
        sConferencias.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, nombres));

        sConferencias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Conferencia conferencia = listaConferencias.get(position);
                conferenciaActual = conferencia;

                String fecha = getResources().getString(R.string.mensaje_fecha, conferencia.getFecha());
                String horario = getResources().getString(R.string.mensaje_horario, conferencia.getHorario());
                String sala = getResources().getString(R.string.mensaje_sala, conferencia.getSala());

                String mensaje = conferencia.getNombre()+"\n"+fecha+"\n"+horario+"\n"+sala;

                /*AlertDialog.Builder dialog = new AlertDialog.Builder(getBaseContext());
                dialog.setTitle(getResources().getString(R.string.titulo_dialog_conferencia));
                dialog.setMessage(mensaje);
                dialog.setPositiveButton(getResources().getString(R.string.ok), null);
                dialog.create();
                dialog.show();*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void iniciarConferenciasIniciadas() {
        //https://firebase.google.com/docs/firestore/query-data/listen
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference docRef =
                db.collection(FirebaseContract.ConferenciaIniciadaEntry.COLLECTION_NAME).document(FirebaseContract.ConferenciaIniciadaEntry.ID);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    String conferenciaIniciada=snapshot.getString(FirebaseContract.ConferenciaIniciadaEntry.CONFERENCIA);
                    Log.d(TAG, "Conferencia iniciada: " + snapshot.getData());
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }


}