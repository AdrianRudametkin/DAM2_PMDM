//Hecho por Rogelio Rodriguez
package com.example.calculadoraswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Creamos las variables que vayamos a utilizar
    Switch switch1;
    EditText et1, et2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Las vinculamos con el XML
        switch1 = findViewById(R.id.switch1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        textView = findViewById(R.id.textView);
    }

    public void onClick(View v){
        // Si cuando se activa el switch, los textedit estan vacios...
        if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()){
            // Notificar al usuario de su error
            Toast.makeText(this, "Tienes que poner un número...", Toast.LENGTH_SHORT).show();
            // Apaga el switch
            switch1.setChecked(false);
            // Salir del metodo
            return;
        }

        try {
            // Sacamos los valores de los edit text
            double n1 = Double.parseDouble(et1.getText().toString());
            double n2 = Double.parseDouble(et2.getText().toString());

            // Si cuando se pulsa el switch esta encendido...
            if (switch1.isChecked()) {
                // Mostramos la suma
                textView.setText(String.format(Locale.UK,"%.2f", n1+n2));
            // Si esta apagado...
            }else{
                // Mostramos un 0
                textView.setText("0");
                // Y borramos los números introducidos
                et1.setText("");
                et2.setText("");
            }
        }catch(NumberFormatException nfe){
            // Si el número introducido es incorrecto, notificar al usuario
            nfe.printStackTrace();
            Toast.makeText(this, "Mal...", Toast.LENGTH_SHORT).show();
            switch1.setChecked(false);
        }
    }
}