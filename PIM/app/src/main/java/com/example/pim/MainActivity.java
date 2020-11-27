package com.example.pim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    public EditText edtLogin;
    public EditText edtSenha;


    SharedPreferences sharedPreferences;
    private Object HttpConnectionParams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenhaCadastro);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor verdadeiro = sharedPreferences.edit();
        verdadeiro.putString("ligado", "ligado");
        verdadeiro.commit();

        SharedPreferences.Editor verdadeiroBtc = sharedPreferences.edit();
        verdadeiroBtc.putString("ligadoBtc", "ligado");
        verdadeiroBtc.commit();

    }

    public void erroLogin(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Erro");
        alert.setMessage("Usuario ou senha invalidos");

        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                edtLogin.setText("");
                edtSenha.setText("");

            }
        });
        alert.show();
    }

    public void validaCadastro() {

        if (sharedPreferences.getString("nome", "").isEmpty()) {

            SharedPreferences.Editor nomeCadastro = sharedPreferences.edit();
            nomeCadastro.putString("nome", "ruan");
            nomeCadastro.commit();

            SharedPreferences.Editor celularCadastro = sharedPreferences.edit();
            celularCadastro.putString("celular", "11995405095");
            celularCadastro.commit();

            SharedPreferences.Editor nascimentoCadastro = sharedPreferences.edit();
            nascimentoCadastro.putString("nascimento", "06/11/2001");
            nascimentoCadastro.commit();

            SharedPreferences.Editor cpfCadastro = sharedPreferences.edit();
            cpfCadastro.putString("cpf", "XXX.XXX.XXX-XX");
            cpfCadastro.commit();

            SharedPreferences.Editor emailCadastro = sharedPreferences.edit();
            emailCadastro.putString("email", "ruan@email.com");
            emailCadastro.commit();

            SharedPreferences.Editor senhaCadastro = sharedPreferences.edit();
            senhaCadastro.putString("senha", "123");
            senhaCadastro.commit();

            SharedPreferences.Editor saldoCadastro = sharedPreferences.edit();
            saldoCadastro.putFloat("saldo", (float) 2000);
            saldoCadastro.commit();
        }

    }

    public void cadastrar(View view){

        Intent telaCadastro = new Intent(getApplicationContext(), telaCadastro.class);
        startActivity(telaCadastro);

    }

    public void entrar(View view) {

        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        TextView erroLogin = findViewById(R.id.edtLoginIncorreto);

        validaCadastro();

        if (edtLogin.getText().toString().equals(sharedPreferences.getString("email", "")) && edtSenha.getText().toString().equals(sharedPreferences.getString("senha", ""))) {
            startActivity(telaHome);
        } else {
            erroLogin();
        }

    }
}










