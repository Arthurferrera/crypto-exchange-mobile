package com.example.pim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class telaSaque extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public EditText edtValor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saque);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        edtValor = (EditText) findViewById(R.id.edtValor);

        Spinner spinner = findViewById(R.id.edtBancos);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bancos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void transferir(View view){

        float valor = Float.parseFloat(edtValor.getText().toString());
        float atualizaSaldo = sharedPreferences.getFloat("saldo", 0) - valor;

        SharedPreferences.Editor saldoFinal = sharedPreferences.edit();
        saldoFinal.putFloat("saldo", (float) atualizaSaldo);
        saldoFinal.commit();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Sucesso");
        alert.setMessage("Saque realizado com sucesso");

        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();

    }

    public void telaHome(View view){

        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        startActivity(telaHome);
    }


}
