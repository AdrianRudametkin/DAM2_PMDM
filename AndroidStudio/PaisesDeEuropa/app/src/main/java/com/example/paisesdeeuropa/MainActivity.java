package com.example.paisesdeeuropa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private HashMap<String, Pais> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DatosPais.class);
                String img, arr[];

                String i = (String)parent.getItemAtPosition(position);
                intent.putExtra("datos",lista.get(i));
                startActivity(intent);
            }
        });
        lista = new HashMap<>();
        initLista();
    }

    private void initLista(){
        lista.put("España", new Pais("España", "Madrid",47450795,505944, R.drawable.es));
        lista.put("Portugal", new Pais("Portugal", "Lisboa", 10295909,92212, R.drawable.pt));
        lista.put("Francia", new Pais("Francia", "París", 67407241, 675417, R.drawable.fr));
        lista.put("Alemania", new Pais("Alemania", "Berlín", 83155031, 35737562, R.drawable.al));
        lista.put("Suiza", new Pais("Suiza", "Berna", 8670300, 41277, R.drawable.sz));

        ArrayList<String> l = new ArrayList<>();

        for(Map.Entry<String, Pais> set: lista.entrySet())
            l.add(set.getKey());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,l);
        listView.setAdapter(adapter);
    }
}