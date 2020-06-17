package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ListView list;
    ArrayList<String> lista;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        list = (ListView)findViewById(R.id.Lista);
        Database db = new Database(getApplicationContext());
        lista = db.llenar_lista();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        list.setAdapter(adapter);

    }
}
