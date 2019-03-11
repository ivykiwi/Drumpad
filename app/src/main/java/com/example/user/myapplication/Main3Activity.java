package com.example.user.myapplication;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {

    Button button;
    TextView textView;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String product = "";
//
//                Cursor cursor = mDb.rawQuery("SELECT * FROM clicks", null);
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    product += cursor.getString(1) + " | ";
//                    cursor.moveToNext();
//                }
//                cursor.close();
//
//                textView.setText(product);

            }
        });
        //Список клиентов
        ArrayList<HashMap<String, Object>> clients = new ArrayList<HashMap<String, Object>>();

//Список параметров конкретного клиента
        HashMap<String, Object> client;

//Отправляем запрос в БД
        Cursor cursor = mDb.rawQuery("SELECT * FROM clicks", null);
        cursor.moveToFirst();

//Пробегаем по всем клиентам
        while (!cursor.isAfterLast()) {
            client = new HashMap<String, Object>();

            //Заполняем клиента
            client.put("name",  cursor.getString(1));
            client.put("count",  cursor.getString(2));
            clients.add(client);
            cursor.moveToNext();
        }
        cursor.close();
        String[] from = { "name", "count"};
        int[] to = { R.id.textView, R.id.textView2};
        SimpleAdapter adapter = new SimpleAdapter(this, clients, R.layout.adapter_item, from, to);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
