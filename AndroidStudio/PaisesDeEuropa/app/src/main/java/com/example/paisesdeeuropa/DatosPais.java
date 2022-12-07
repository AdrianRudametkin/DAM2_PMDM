package com.example.paisesdeeuropa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosPais extends AppCompatActivity {
    private Pais pais;
    TextView tvTitulo, tvCapital, tvPoblación, tvSuperficie;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_pais);
        Intent intent = getIntent();
        pais = (Pais)intent.getSerializableExtra("datos");

        img = findViewById(R.id.img);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvCapital = findViewById(R.id.tvCapital);
        tvPoblación = findViewById(R.id.tvPoblacion);
        tvSuperficie = findViewById(R.id.tvSuperficie);

        img.setImageResource(pais.getResource());
        tvTitulo.setText(pais.getNombre());
        tvCapital.setText(pais.getCapital());
        tvPoblación.setText(String.valueOf(pais.getPoblacion()));
        tvSuperficie.setText(String.valueOf(pais.getSuperficie()));
    }

    public void atras(View view){
        finish();
    }
}