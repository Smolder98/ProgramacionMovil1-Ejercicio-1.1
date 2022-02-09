package com.aplicacion.ejercicio_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum1, txtnum2;

    private Double num1, num2, resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum1 = (EditText) findViewById(R.id.txtnum1);
        txtnum2 = (EditText) findViewById(R.id.txtnum2);
    }

    //Metodo que se ejecuta declarado en el xml
    public void operacion(View view) {
        try {
            num1 = Double.parseDouble(txtnum1.getText().toString());
            num2 = Double.parseDouble(txtnum2.getText().toString());
        }catch (Exception e){

            Toast.makeText(this, "Error al leer los numeros: " + e.getMessage(), Toast.LENGTH_LONG).show();

            return;
        }




        switch (view.getId()){
            case R.id.btnsuma: sumar(num1, num2);
                break;

            case R.id.btnresta: restar(num1, num2);
                break;

            case R.id.btnmultiplicacion: multiplicar(num1, num2);
                break;

            case R.id.btndivision: dividir(num1, num2);
                break;
        }

    }

    private void sumar(double num1, double num2) {
        //Toast.makeText(this, "Suma: "+ String.format("%.2f", (num1 + num2)), Toast.LENGTH_LONG).show();
        resultado = num1 + num2;

        enviarResutaldo();
    }

    private void restar(double num1, double num2){
        //Toast.makeText(this, "Resta: "+ String.format("%.2f", (num1 - num2)), Toast.LENGTH_LONG).show();
        resultado = num1 - num2;

        enviarResutaldo();
    }

    private void multiplicar(double num1, double num2){
        //Toast.makeText(this, "Multiplicación: "+ String.format("%.2f", (num1 * num2)), Toast.LENGTH_LONG).show();
        resultado = num1 * num2;

       enviarResutaldo();
    }

    private void dividir(double num1, double num2){
        if(num2 == 0)
            Toast.makeText(this, "El numero 2 no puede ser cero", Toast.LENGTH_LONG).show();
        else{
            //Toast.makeText(this, "División: "+ String.format("%.2f", (num1 / num2)), Toast.LENGTH_LONG).show();
            resultado = num1 / num2;

            enviarResutaldo();
        }
    }

    private void enviarResutaldo(){

        Intent intent = new Intent(getApplicationContext(), ActivityMostrar.class);
        intent.putExtra("resultado", String.format("%.2f", resultado));
        startActivity(intent);
    }
}