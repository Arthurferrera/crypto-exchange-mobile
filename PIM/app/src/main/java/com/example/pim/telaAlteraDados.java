package com.example.pim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class telaAlteraDados extends AppCompatActivity {

    public EditText edtCelular;
    public EditText edtEndereco;
    public EditText edtEmail;
    public EditText edtSenha;

    public TextView edtSucesso;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_altera_dados);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        edtCelular = (EditText) findViewById(R.id.edtCelular);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        edtSucesso = (TextView) findViewById(R.id.edtSucesso);

    }


    public void alterar(View view){

        if(edtCelular.getText().toString().isEmpty())
        {

        }

        else {

            SharedPreferences.Editor celularCadastro = sharedPreferences.edit();
            celularCadastro.putString("celular", edtCelular.getText().toString());
            celularCadastro.commit();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Dados alterados com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();

        }

        if(edtEmail.getText().toString().isEmpty())
        {

        }

        else {

            SharedPreferences.Editor emailCadastro = sharedPreferences.edit();
            emailCadastro.putString("email", edtEmail.getText().toString());
            emailCadastro.commit();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Dados alterados com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();

        }

        if(edtEndereco.getText().toString().isEmpty())
        {

        }

        else {

            SharedPreferences.Editor enderecoCadastro = sharedPreferences.edit();
            enderecoCadastro.putString("endereco", edtEndereco.getText().toString());
            enderecoCadastro.commit();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Dados alterados com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();

        }

        if(edtSenha.getText().toString().isEmpty())
        {

        }

        else {

            SharedPreferences.Editor senhaCadastro = sharedPreferences.edit();
            senhaCadastro.putString("senha", edtSenha.getText().toString());
            senhaCadastro.commit();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Dados alterados com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }

    }

    public void telaMeusDados(View view){

        Intent telaMeusDados = new Intent(getApplicationContext(), telaMeusDados.class);
        startActivity(telaMeusDados);
    }
}
