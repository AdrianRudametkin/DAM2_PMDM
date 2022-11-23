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

    Switch switch1;
    EditText et1, et2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        textView = findViewById(R.id.textView);
    }

    public void onClick(View v){
        if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()){
            Toast.makeText(this, "Tienes que poner un número...", Toast.LENGTH_SHORT).show();
            switch1.setChecked(false);
            return;
        }

        try {
            double n1 = Double.parseDouble(et1.getText().toString());
            double n2 = Double.parseDouble(et2.getText().toString());

            if (switch1.isChecked()) {
                textView.setText(String.format(Locale.UK,"%.2f", n1+n2));
            }else{
                textView.setText("0");
                et1.setText("");
                et2.setText("");
            }
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
            Toast.makeText(this, "Mal...", Toast.LENGTH_SHORT).show();
            switch1.setChecked(false);
        }
    }
}