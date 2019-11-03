package com.example.test1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String MY_NAME ="my_name";
    private Button btnSaveData;
    private Button btnReadData;
    private Button btnRemoveKey;
    private Button btnRemoveAll;
    private final String TAG = getClass().getSimpleName();

    private SaveData saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaveData = (Button) findViewById(R.id.btn_save_date);
        btnReadData = (Button) findViewById(R.id.btn_read_data);
        btnRemoveKey = (Button) findViewById(R.id.btn_remove_key);
        btnRemoveAll = (Button) findViewById(R.id.btn_remove_all);

        saveData = new SaveData(this);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData.addData();
            }
        });
        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData.readData();
            }
        });
        btnRemoveKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData.removeByKey(MY_NAME);
                saveData.readData();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData.removeAll();

            }
        });


    }

}