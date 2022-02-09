package com.aplicacion.ejercicio_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityMostrar extends AppCompatActivity {

    TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        txtresultado = (TextView) findViewById(R.id.txtresultado);

        txtresultado.setText(getIntent().getStringExtra("resultado"));

    }
}