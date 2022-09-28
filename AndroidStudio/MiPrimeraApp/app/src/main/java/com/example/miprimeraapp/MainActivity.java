package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPersonName =  findViewById(R.id.editTextPersonName);
        textViewName = findViewById(R.id.textViewName);
    }

    // Views del proyecto
    EditText editTextPersonName;
    TextView textViewName;

    // Called when the user presses the button
    public void sendMessage(View view){
        // Cojer el texto del EditText y ponerlo en el TextView
        textViewName.setText("Bienvenido "+editTextPersonName.getText());

        // Para esconder el teclado cuando se pulsa (controlar si el teclado esta o no activo)
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        } catch (Exception e) {
            // No hacer nada
        }

        // Copiar texto al corta-papeles
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Nombre", editTextPersonName.getText());
        clipboard.setPrimaryClip(clip);
    }
}