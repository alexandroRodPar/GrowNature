package com.proyecto.alexandrorodriguez.grownature;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class ContactoActivity extends AppCompatActivity {

    private RecyclerView rv_chat;
    private EditText et_mensaje;
    private ImageButton ib_envio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        rv_chat = findViewById(R.id.rv_chat);
        et_mensaje = findViewById(R.id.et_mensaje);
        ib_envio = findViewById(R.id.ib_envio);


    }
}