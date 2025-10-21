package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> array;
    private ListView lstView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView = (ListView) findViewById(R.id.lista);
        array = new ArrayList<String>();

        array.add("Mexico");
        array.add("Canada");
        array.add("Estados Unidos");
        array.add("Rusia");
        array.add("Brasil");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,array);
        lstView.setAdapter(adapter);

        // Metodo para programar los clic en cada item de una lista.
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento clickeado
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Clic en: " + item, Toast.LENGTH_SHORT).show();
            }
        });


    }
}