package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView textView;
    EditText editText;
    LinearLayout textLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        textLayout = findViewById(R.id.textLayout);
        button = findViewById(R.id.button);

        textLayout.setVisibility(View.INVISIBLE);
    }

    public void radioClick(View v){
        if(v.getId()==R.id.rbCall){
            textLayout.setVisibility(View.VISIBLE);
            button.setText("Llamar");
            editText.setInputType(InputType.TYPE_CLASS_PHONE);
            editText.setFocusable(true);
            textView.setText("Presiona el botón para llamar el número introducido.");
        }else if(v.getId()==R.id.rbWeb){
            textLayout.setVisibility(View.VISIBLE);
            button.setText("Ir");
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setFocusable(true);
            textView.setText("Presiona el botón para ir a la página introducida.");
        }else if(v.getId()==R.id.rbMap){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.034694, -114.094743"));
            startActivity(intent);
            textLayout.setVisibility(View.INVISIBLE);
        }
    }

    public void butonClick(View v){
        
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
        if (((RadioButton)findViewById(R.id.rbCall)).isChecked()) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
            } else {
                Log.i("Mensaje", "Se tiene permiso para realizar llamadas!");
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText().toString()));
                startActivity(intent);
                textLayout.setVisibility(View.INVISIBLE);
            }
            
        } else if (((RadioButton)findViewById(R.id.rbWeb)).isChecked()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+editText.getText().toString()));
            startActivity(intent);
            textLayout.setVisibility(View.INVISIBLE);
        }
    }
}
