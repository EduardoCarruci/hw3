package com.example.hw3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ListView list;
    ArrayList<String> lista;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        list = (ListView)findViewById(R.id.ListOrder);
        Database db = new Database(getApplicationContext());
        lista = db.llenar_lista();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,lista);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Log.i("Click", "click en el elemento " + position + " de mi ListView");
                Toast.makeText(getApplicationContext(),
                                           "" +position,Toast.LENGTH_LONG
                                   ).show();
            }


        });


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
                Intent intento = new Intent(getApplicationContext(), Order.class);
                startActivity(intento);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
