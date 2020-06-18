package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    ListView list;
    ArrayList<String> lista;
    ArrayAdapter adapter;
    Button _btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        list = (ListView)findViewById(R.id.ListOrder);
        Database db = new Database(getApplicationContext());
        lista = db.getOrderDesc();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);

        list.setAdapter(adapter);
        _btnBack = (Button)findViewById(R.id.btnBack);

        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), Lista.class);
                startActivity(intento);
            }
        });
    }
}
