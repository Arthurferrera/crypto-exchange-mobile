package com.example.pim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class telaHome extends AppCompatActivity {

    public TextView edtSessao;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);



        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        edtSessao = (TextView) findViewById(R.id.edtSessao);


       // edtSessao.setText(Integer.toString(sharedPreferences.getInt("id", 0)));

        String[] textoSeparado = sharedPreferences.getString("nome", "").split(" ");

            edtSessao.setText("Seja bem-vindo(a), " + textoSeparado[0]);

    }


    public void meusDados(View view){

        Intent telaMeusDados = new Intent(getApplicationContext(), telaMeusDados.class);
        startActivity(telaMeusDados);

    }

    public void carteira(View view){
        Intent telaCarteira = new Intent(getApplicationContext(), telaCarteira.class);
        startActivity(telaCarteira);
    }

    public void investir(View view){
        Intent telaInvestir = new Intent(getApplicationContext(), telaInvestir.class);
        startActivity(telaInvestir);
    }

    public void aportes(View view){
        Intent telaAportes = new Intent(getApplicationContext(), telaAportes.class);
        startActivity(telaAportes);
    }

    public void sair(View view){

        Intent sair = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(sair);

        /*
        sair.addCategory(Intent.CATEGORY_HOME);
        sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(sair);
        */
    }


    }
