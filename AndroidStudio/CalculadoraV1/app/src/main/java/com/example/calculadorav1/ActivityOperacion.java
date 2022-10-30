    package com.example.calculadorav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

    public class ActivityOperacion extends AppCompatActivity {
    // Declaración de elementos
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);
        Bundle extras = getIntent().getExtras();
        String op = extras.getString("operacion");
        String res = extras.getString("resultado");

        // Enlazar el TextView
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        // Poner el texto
        tvResultado.setText("El resultado de la "+op+" es:\n\n "+res);
    }

    public void volver(View view){
        // Volvemos a MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}