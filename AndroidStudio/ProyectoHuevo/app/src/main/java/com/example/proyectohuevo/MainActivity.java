package com.example.proyectohuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Variables del la GUI
    private ImageView imagen;
    private TextView tiempo;

    // Variables para el temporizador
    private int segundos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imagen);
        tiempo = findViewById(R.id.tiempo);

        imagen.setImageDrawable(null);
        runTimer();
    }

    public void radioClick(View view){

        switch (view.getId()){
            case R.id.radioButton_Agua:
                imagen.setImageDrawable(getDrawable(R.drawable.b_huevoblando));
                segundos = 90;
                break;

            case R.id.radioButton_Mollet:
                imagen.setImageDrawable(getDrawable(R.drawable.b_huevomedio));
                segundos = 240;
                break;

            case R.id.radioButton_Duro:
                imagen.setImageDrawable(getDrawable(R.drawable.b_huevoduro));
                segundos = 540;
                break;

            case R.id.radioButton_Frito:
                imagen.setImageDrawable(getDrawable(R.drawable.a_huevofrito));
                segundos = 180;
                break;
        }
        int minutos = segundos/60;
        int secs = segundos%60;
        String t = String.format(Locale.getDefault(),"%d:%02d",minutos, secs);
        tiempo.setText(t);
    }

    private void runTimer(){
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                if(segundos>0){
                    int minutos = segundos/60;
                    int secs = segundos%60;

                    String t = String.format(Locale.getDefault(),"%d:%02d",minutos, secs);

                    tiempo.setText(t);

                    segundos--;
                }else{
                    tiempo.setText("0:00");
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}