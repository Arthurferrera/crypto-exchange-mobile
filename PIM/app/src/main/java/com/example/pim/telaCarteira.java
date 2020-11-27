package com.example.pim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class telaCarteira extends AppCompatActivity {

    public TextView edtSaldoReais;
    public TextView edtSaldoBTC;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carteira);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edtSaldoBTC = (TextView) findViewById(R.id.edtSaldoBtc);
        edtSaldoReais = (TextView) findViewById(R.id.edtSaldoReais);

        /*
        SharedPreferences.Editor saldoCadastro = sharedPreferences.edit();
        saldoCadastro.putFloat("saldo", (float) 360000);
        saldoCadastro.commit();

        SharedPreferences.Editor saldoCadastroBTC = sharedPreferences.edit();
        saldoCadastroBTC.putFloat("saldoBTC", (float) 0);
        saldoCadastroBTC.commit();

        Double saldo = (double)sharedPreferences.getFloat("saldo", 9999);
        *  /
         */
        Locale ptBr = new Locale("pt", "BR"); //define a região
        NumberFormat moeda = NumberFormat.getCurrencyInstance(ptBr);


        edtSaldoReais.setText(moeda.format(sharedPreferences.getFloat("saldo", 0)).toString());

        String BTC = Float.toString((sharedPreferences.getFloat("saldoBTC", 9999)));
        edtSaldoBTC.setText(BTC);

    }

    public void escondeReais(View view){


        if (sharedPreferences.getString("ligado", "").equals("ligado")){
            edtSaldoReais.setVisibility(View.INVISIBLE);

            SharedPreferences.Editor verdadeiro = sharedPreferences.edit();
            verdadeiro.putString("ligado", "desligado");
            verdadeiro.commit();

        }

        else {
            edtSaldoReais.setVisibility(View.VISIBLE);

            SharedPreferences.Editor verdadeiro = sharedPreferences.edit();
            verdadeiro.putString("ligado", "ligado");
            verdadeiro.commit();
        }

    }

    public void escondeBtc(View view){

        if (sharedPreferences.getString("ligadoBtc", "").equals("ligado")){
            edtSaldoBTC.setVisibility(View.INVISIBLE);

            SharedPreferences.Editor verdadeiro = sharedPreferences.edit();
            verdadeiro.putString("ligadoBtc", "desligado");
            verdadeiro.commit();

        }

        else {
            edtSaldoBTC.setVisibility(View.VISIBLE);

            SharedPreferences.Editor verdadeiro = sharedPreferences.edit();
            verdadeiro.putString("ligadoBtc", "ligado");
            verdadeiro.commit();
        }


    }

    public void telaHome(View view){

        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        startActivity(telaHome);
    }

    public void telaSaque(View view){

        Intent telaSaque = new Intent(getApplicationContext(), telaSaque.class);
        startActivity(telaSaque);
    }
}
