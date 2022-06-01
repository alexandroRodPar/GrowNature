package com.proyecto.alexandrorodriguez.grownature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity{

    private Button bRegis;
    private Button bIniSes;
    private FirebaseAuth mAuth;
    private EditText et_EmailUsuario;
    private EditText et_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bRegis = findViewById(R.id.bRegis);
        bIniSes = findViewById(R.id.bIniSes);
        et_EmailUsuario = findViewById(R.id.et_EmailUsuario);
        et_Password = findViewById(R.id.et_Password);

        mAuth = FirebaseAuth.getInstance();




        bRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_EmailUsuario.getText().toString();
                String pass = et_Password.getText().toString();
                if(email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getBaseContext(), getString(R.string.text_registro), Toast.LENGTH_SHORT).show();
                }else{
                    registro(email, pass);
                }


            }
        });
        bIniSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_EmailUsuario.getText().toString();
                String pass = et_Password.getText().toString();
                if(email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getBaseContext(), getString(R.string.text_logeo), Toast.LENGTH_SHORT).show();
                }else{
                    logueo(email, pass);
                }
            }
        });

    }

    private void registro(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getBaseContext(), getString(R.string.registro_correcto), Toast.LENGTH_SHORT).show();
                    et_EmailUsuario.setText("");
                    et_Password.setText("");
                }else{
                    Toast.makeText(getBaseContext(), getString(R.string.registro_incorrecto), Toast.LENGTH_SHORT).show();
                    et_EmailUsuario.setText("");
                    et_Password.setText("");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getBaseContext(), "Hubo un error al registrar un nuevo usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logueo(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getBaseContext(), getString(R.string.logeo_incorrecto), Toast.LENGTH_SHORT).show();
                    et_EmailUsuario.setText("");
                    et_Password.setText("");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getBaseContext(), "Hubo un error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        });

    }
}