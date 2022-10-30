package com.example.calculadorav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Declaracion de elementos
    private ImageButton ibtnSumar, ibtnRestar, ibtnMultiplicar, ibtnDividir;
    private EditText etN1, etN2;

    // Para formatear el número
    DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.UK));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los elementos del Layout con Java
        ibtnSumar = findViewById(R.id.ibtnSumar);
        ibtnRestar = findViewById(R.id.ibtnRestar);
        ibtnMultiplicar = findViewById(R.id.ibtnMultiplicar);
        ibtnDividir = findViewById(R.id.ibtnDividir);
        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);

    }

    /**
     * Método utilizado para sumar o restar las dos textos que tengan los TextEdit
     * @param view el elemento que ejecuta el método.
     */
    public void operacion(View view){
        String operacion = "";
        String resultado = "";
        try {
            // Convertimos el texto a Double
            double num1 = Double.parseDouble(etN1.getText().toString());
            double num2 = Double.parseDouble(etN2.getText().toString());
            double res = 0;

            // Hacemos la operación correspondiente
            if(view.getId() == ibtnSumar.getId()){
                res = num1 + num2;
                operacion = "suma";
            }else if(view.getId() == ibtnRestar.getId()){
                res = num1 - num2;
                operacion = "resta";
            }else if(view.getId() == ibtnMultiplicar.getId()){
                res = num1 * num2;
                operacion = "multiplicacion";
            }else if(view.getId() == ibtnDividir.getId()){
                res = num1 / num2;
                operacion = "division";
            }

            // Mostramos el resultado
            resultado = df.format(res);

        }catch(NumberFormatException nfe){
            // Pos si por algún casual el usuario copia y pega texto...
            System.out.println("Error formateando los números.");
            resultado = "NaN";
        }catch(ArithmeticException ae){
            System.out.println("Error en la opracion.");
            resultado = "Error";
        }

        // Borramos el texto escrito
        etN1.setText("");
        etN2.setText("");

        // Para esconder el teclado cuando se pulse el botón
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        // Iniciamos ActivityOperacion
        Intent intent = new Intent(this, ActivityOperacion.class);
        intent.putExtra("operacion", operacion);
        intent.putExtra("resultado", resultado);
        startActivity(intent);
    }
}