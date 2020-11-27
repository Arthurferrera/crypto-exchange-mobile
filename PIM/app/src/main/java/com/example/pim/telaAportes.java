package com.example.pim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class telaAportes extends AppCompatActivity {

    ListView listView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aportes);

        listView=(ListView) findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListSaque = new ArrayList<>();


        arrayList.add("03-11-2020                 SAQUE                          -171,00");
        arrayList.add("03-11-2020                 TED                                171,00");
        arrayList.add("05-11-2020                 DEPÓSITO                     51,00");
        arrayList.add("07-11-2020                 SAQUE                          -221,00");
        arrayList.add("07-11-2020                 SAQUE                          -250,00");
        arrayList.add("08-11-2020                 SAQUE                          -289,00");
        arrayList.add("08-11-2020                 SAQUE                          -153,50");
        arrayList.add("09-11-2020                 SAQUE                          -2012,00");
        arrayList.add("10-11-2020                 SAQUE                          -5000,00");
        arrayList.add("14-11-2020                 DEPÓSITO                     8000,00");
        arrayList.add("14-11-2020                 SAQUE                          -11,00");
        arrayList.add("14-11-2020                 SAQUE                          -181,00");
        arrayList.add("15-11-2020                 SAQUE                          -189,00");
        arrayList.add("16-11-2020                 SAQUE                          -215,00");
        arrayList.add("16-11-2020                 SAQUE                          -217,00");
        arrayList.add("17-11-2020                 SAQUE                          -580,00");
        arrayList.add("17-11-2020                 SAQUE                          -7000,00");
        arrayList.add("19-11-2020                 SAQUE                          -8000,00");
        arrayList.add("19-11-2020                 SAQUE                          -182,00");
        arrayList.add("19-11-2020                 SAQUE                          -176,00");
        arrayList.add("19-11-2020                 SAQUE                          -151,00");
        arrayList.add("19-11-2020                 SAQUE                          -150,00");
        arrayList.add("20-11-2020                 SAQUE                          -10000,00");
        arrayList.add("20-11-2020                 SAQUE                          -5000,00");
        arrayList.add("20-11-2020                 SAQUE                          -8000,00");
        arrayList.add("20-11-2020                 SAQUE                          -171,00");
        arrayList.add("22-11-2020                 SAQUE                          -151,00");
        arrayList.add("25-11-2020                 SAQUE                          -181,00");






        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public void telaHome(View view){

        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        startActivity(telaHome);
    }
}
