package com.example.solemne1ncfvff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String seleccion = intent.getExtras().getString(Main2Activity.seleccion);
        String metodo = intent.getExtras().getString(Main2Activity.metodo);

        TextView seleccionTextView = (TextView)findViewById(R.id.seleccion);
        TextView metodoTextView = (TextView)findViewById(R.id.metodo);

        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.leadcoat);
        seleccionTextView.setTypeface(typeface);
        metodoTextView.setTypeface(typeface);

        seleccionTextView.setWidth(60);
        seleccionTextView.setTextSize(30);

        metodoTextView.setWidth(60);
        metodoTextView.setTextSize(30);

        seleccionTextView.setText(seleccion);
        metodoTextView.setText(metodo);
    }
}
