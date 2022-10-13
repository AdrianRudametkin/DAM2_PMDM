package com.example.mislayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();
    }

    public void siguiente(View view){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void anterior(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}