// Hecho por Rogelio Rodriguez :D
package com.example.emocines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Creamos elementos que esten presentes en el Activity y que vayamos a utilizar en el programa
    private CheckBox cbSi, cbNo;
    private TextView tvEmocion, tvTriste, tvEnfadarse, tvLlorar, tvReir;
    private ImageView ivImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Borrar los asteriscos del ejercicio que quieras ejecutar, y ponerlos en los otros

        /*/ Para el ejercicio 1A
        // Ponemos el activity que queremos
        setContentView(R.layout.activity_playemo);

        // Vinculamos los objetos del XM
        cbSi = findViewById(R.id.cbSi);
        cbNo = findViewById(R.id.cbNo);
        /*/


        /*/ Para el ejercicio 1B
        // Vinculamos los objetos del XML
        setContentView(R.layout.activity_imgagenesemo);

        // Vinculamos los objetos del XML
        ivImagen = findViewById(R.id.ivImagen);
        tvEmocion = findViewById(R.id.tvEmocion);
        // Inicializamos la imagen para que este vacia
        ivImagen.setImageDrawable(null);
        /*/


        // Para el ejercicio 1C
        // Vinculamos los objetos del XML
        setContentView(R.layout.activity_botonesemo);

        // Vinculamos los objetos del XML
        tvEnfadarse = findViewById(R.id.tv_enfafarse);
        tvLlorar = findViewById(R.id.tv_llorar);
        tvReir = findViewById(R.id.tv_reir);
        tvTriste = findViewById(R.id.tv_triste);
        //
    }

    /**
     * Metodo OnClick para los Checbox (Actividad 1.A)
     */
    public void onClickA(View v){
        // Si es el checkbox "si"
        if(v == cbSi){
            // Cambiamos el estado del los checkbox
            cbNo.setChecked(false);
            cbSi.setChecked(true);
            // Mostramos la notificacion
            Toast.makeText(this, "Has decidido jugar", Toast.LENGTH_SHORT).show();
        }

        // Si es el checkbox "no"
        if(v == cbNo){
            // Cambiamos el estado del los checkbox
            cbNo.setChecked(true);
            cbSi.setChecked(false);
            // Mostramos la notificacion
            Toast.makeText(this, "Ohhh!!! Te lo has perdido...", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Metodo OnClick para los radio button (Actividad 1.B)
     */
    public void onClickB(View v){
        // Variable que almecena el texto que luego mostraremos en el textview
        String s = "";

        // Dependiendo del radio buton que se pulsa, asignamos una imagen u otra a nuestra vista de imagen.
        // Utilizamos el ID del view que llama al metodo y lo comparamos con los ID del Activity
        switch(v.getId()){
            case R.id.rbSonreir:
                // Aquí actualizamos el ImageView con la imagen que queremos
                ivImagen.setImageResource(R.drawable.sonrio);
                // Cambiamos el texto
                s = "Estoy feliz";
                break;
            case R.id.rbEnfadarse:
                ivImagen.setImageResource(R.drawable.menfado);
                s = "Estoy triste";
                break;
            case R.id.rbLlorar:
                ivImagen.setImageResource(R.drawable.lloro);
                s = "¡¡¡Me duele!!!";
                break;
            case R.id.rbEntristecerse:
                ivImagen.setImageResource(R.drawable.triste);
                s = "¡¡¡Yo no quiero ESO!!!";
                break;
            default:
                // En caso de que ocurra algo raro, simplemente borramos
                ivImagen.setImageDrawable(null);
                s = "";
        }
        // Cambiamos el texto al TextView
        tvEmocion.setText(s);
    }

    /**
     * Metodo OnClick para los botones(Actividad 1.C)
     */
    public void onClickC(View v){
        // Ponemos todos los textos vacios
        tvReir.setText("");
        tvTriste.setText("");
        tvLlorar.setText("");
        tvEnfadarse.setText("");

        // Dependiendo del boton que se pulso, ponemos el texto correspondiente
        switch(v.getId()){
            case R.id.button_sonreir:
                tvReir.setText("Estoy feliz");
                break;
            case R.id.button_entristecerse:
                tvTriste.setText("Estoy triste");
                break;
            case R.id.button_llorar:
                tvLlorar.setText("¡¡¡Me duele!!!");
                break;
            case R.id.button_enfadarse:
                tvEnfadarse.setText("¡¡¡Yo no quiero ESO!!!");
                break;
            default:

        }
    }
}