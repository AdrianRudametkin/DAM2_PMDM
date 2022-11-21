// Programado por Rogelio Rodriguez :D
package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaramos las variables de las vistas que vallamos a utilizar
    EditText etNombre, etTelefono, etEmail, etDireccion, etEmpresa;
    TextView tvDatos;
    Button btnAgregar, btnEliminar, btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculamos las vistas del XML al .java
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDireccion = findViewById(R.id.etDireccion);
        etEmpresa = findViewById(R.id.etEmpresa);

        tvDatos = findViewById(R.id.tvDatos);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnLlamar = findViewById(R.id.btnLlamar);
    }

    /**
     * Metodo al que llaman los botones
     */
    public void onClick(View v){
        // Borramos los datos del textview
        tvDatos.setText("");

        // Si lo llama el boton agregar...
        if(v==btnAgregar){
            // Construimos la cadena con los datos
            String s = "*Nombre: "+etNombre.getText()+"\n" +
                    "*Telefono: " + etTelefono.getText()+"\n"+
                    "*E-mail: " + etEmail.getText() + "\n"+
                    "*Dirección: " + etDireccion.getText() + "\n"+
                    "*Empresa" + etEmpresa.getText();
            // Mostramos la cadena en el textview
            tvDatos.setText(s);
        }

        // Si es el boton eliminar...
        if(v==btnEliminar){
            // Mostramos la notificacion
            Toast.makeText(this,"¿Está seguro de que desea eliminar el contacto?", Toast.LENGTH_SHORT)
                    .show();
        }

        // Si es el boton de llamar...
        if(v==btnLlamar){
            // Mostramos la notificacion
            String s = "Va a llamar a " +cogerNombre();
            Toast.makeText(this,"Va a llamar a "+ cogerNombre(),Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * Metodo que devuelve solo el nombre introducido en el Edittext
     */
    public String cogerNombre(){
        String s = String.valueOf(etNombre.getText());
        if(s.isEmpty())
            return "";

        if(!s.contains(" "))
            return s;

        return s.substring(0, s.indexOf(" "));
    }
}