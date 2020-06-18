package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button _btnInsert, _btnDelete,_btnLista,_btnBack;
    EditText _txtID,_txtMake,_txtModel,_txtYear,_txtMileage,_txtPrice;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnInsert = (Button)findViewById(R.id.btnAdd);
        _btnBack = (Button)findViewById(R.id.btnBack);


        _txtMake = (EditText)findViewById(R.id.txtMake);
        _txtModel = (EditText)findViewById(R.id.txtModel);
        _txtYear = (EditText)findViewById(R.id.txtYear);
        _txtMileage = (EditText)findViewById(R.id.txtMileage);
        _txtPrice = (EditText)findViewById(R.id.txtPrice);

        openHelper = new Database(this);
        _btnInsert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String make = _txtMake.getText().toString();
                        String model = _txtModel.getText().toString();
                        String year = _txtYear.getText().toString();
                        String mileage = _txtMileage.getText().toString();
                        String price =_txtPrice.getText().toString();

                        db= openHelper.getWritableDatabase();
                        inserData(make,model,year,mileage,price);
                        Toast.makeText(getApplicationContext(),
                                "Inserted Success",Toast.LENGTH_LONG
                                ).show();

                    }
                });
        //    _btnDelete.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View v) {
        //            db = openHelper.getWritableDatabase();
        //             String id = _txtID.getText().toString();
        //            deleteData(id);
        //            Toast.makeText(getApplicationContext(),
        //                    "Delete Success",Toast.LENGTH_LONG
        //            ).show();

        //        }
        //    });

        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), Lista.class);
                startActivity(intento);
            }
        });
    }

    public boolean deleteData(String id){

        return db.delete(Database.TABLE_NAME,Database.COLS_1 + "=?",new String []{id})  > 0 ;
    }

    public void inserData(String make,String model, String year,String mileage ,String price){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.COLS_2,make);
        contentValues.put(Database.COLS_3,model);
        contentValues.put(Database.COLS_4,Integer.valueOf(year));
        contentValues.put(Database.COLS_5,Integer.valueOf(mileage));
        contentValues.put(Database.COLS_6,Integer.valueOf(price));
        long id = db.insert(Database.TABLE_NAME,null,contentValues);
        reset();

    }

    public void reset(){
        _txtMake.setText("");
        _txtModel.setText("");
        _txtYear.setText("");
        _txtMileage.setText("");
        _txtPrice.setText("");
    }
}
