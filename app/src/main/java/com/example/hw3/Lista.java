package com.example.hw3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){

            case R.id.action_add:

                Intent intent_item = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_item);


            case R.id.action_delete:
                //AQUI EJECUTAS EL BORRAR
                return true;

            case R.id.action_sort:
                //AQUI EJECUTAS EL ordenar
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
