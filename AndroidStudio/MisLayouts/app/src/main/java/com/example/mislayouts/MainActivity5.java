package com.example.mislayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();
    }

    public void anterior(View view){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void siguiente(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}