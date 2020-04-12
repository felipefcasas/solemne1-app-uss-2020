package com.example.solemne1ncfvff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String seleccion = "seleccion";

    String[] platos = {
            "Porotos con riendas",
            "Cazuela",
            "Charquicán",
            "Chupe de mariscos",
            "Carbonada",
            "Arroz con pollo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> addPlatos = new ArrayAdapter<String>(this, R.layout.patron, R.id.platos, platos);

        GridView lista = new GridView(this);
        lista.setNumColumns(1);
        lista.setColumnWidth(60);
        lista.setVerticalSpacing(40);
        lista.setHorizontalSpacing(20);
        lista.setAdapter(addPlatos);

        setContentView(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra(MainActivity.seleccion, platos[i]);
                startActivity(intent);
            }
        });
    }
}
