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
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class telaCadastro extends AppCompatActivity {

    List<Cliente> clientes = new ArrayList<Cliente>();


    public EditText edtNomeCadastro;
    public EditText edtCelular;
    public EditText edtNascimento;
    public EditText edtEndereco;
    public EditText edtCpf;
    public EditText edtEmail;
    public EditText edtSenhaCadastro;

    //declarando atributos necessarios
    SharedPreferences sharedPreferences;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edtNomeCadastro = (EditText) findViewById(R.id.edtNomeCadastro);
        edtCelular = (EditText) findViewById(R.id.edtCelular);
        edtCpf = (EditText) findViewById(R.id.TextView);
        edtNascimento = (EditText) findViewById(R.id.edtNascimentoCadastro);
        edtEndereco = (EditText) findViewById(R.id.edtEnderecoCadastro);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenhaCadastro = (EditText) findViewById(R.id.edtSenhaCadastro);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

        public void cadastrar(View view) {

            TextView erroCadastro = findViewById(R.id.edtErroCadastro);

            if (edtNomeCadastro.getText().toString().isEmpty() ||
                    edtCelular.getText().toString().isEmpty() ||
                            edtCpf.getText().toString().isEmpty() ||
                                edtNascimento.getText().toString().isEmpty() ||
                                    edtEndereco.getText().toString().isEmpty() ||
                                        edtEmail.getText().toString().isEmpty() ||
                                            edtSenhaCadastro.getText().toString().isEmpty()) {



                    AlertDialog.Builder alert = new AlertDialog.Builder(this);

                    alert.setTitle("Erro");
                    alert.setMessage("Por favor, preencha todos os campos");

                    alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();
            }

            else {
                Random random = new Random();
                int id = random.nextInt(1000);

                SharedPreferences.Editor valorCadastroBTC = sharedPreferences.edit();
                valorCadastroBTC.putFloat("valorBTC", (float) 92000);
                valorCadastroBTC.commit();

                SharedPreferences.Editor idCadastro = sharedPreferences.edit();
                idCadastro.putInt("id", id);
                idCadastro.commit();

                SharedPreferences.Editor saldoCadastro = sharedPreferences.edit();
                saldoCadastro.putFloat("saldo", (float) 3600000);
                saldoCadastro.commit();

                SharedPreferences.Editor saldoCadastroBTC = sharedPreferences.edit();
                saldoCadastroBTC.putFloat("saldoBTC", (float) 0);
                saldoCadastroBTC.commit();

                SharedPreferences.Editor nomeCadastro = sharedPreferences.edit();
                nomeCadastro.putString("nome", edtNomeCadastro.getText().toString());
                nomeCadastro.commit();

                SharedPreferences.Editor celularCadastro = sharedPreferences.edit();
                celularCadastro.putString("celular", edtCelular.getText().toString());
                celularCadastro.commit();

                SharedPreferences.Editor cpfCadastro = sharedPreferences.edit();
                cpfCadastro.putString("cpf", edtCpf.getText().toString());
                cpfCadastro.commit();

                SharedPreferences.Editor nascimentoCadastro = sharedPreferences.edit();
                nascimentoCadastro.putString("nascimento", edtNascimento.getText().toString());
                nascimentoCadastro.commit();

                SharedPreferences.Editor enderecoCadastro = sharedPreferences.edit();
                enderecoCadastro.putString("endereco", edtEndereco.getText().toString());
                enderecoCadastro.commit();

                SharedPreferences.Editor emailCadastro = sharedPreferences.edit();
                emailCadastro.putString("email", edtEmail.getText().toString());
                emailCadastro.commit();

                SharedPreferences.Editor senhaCadastro = sharedPreferences.edit();
                senhaCadastro.putString("senha", edtSenhaCadastro.getText().toString());
                senhaCadastro.commit();


                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("Sucesso");
                alert.setMessage("Usuario cadastrado com sucesso");

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();

            }

        }

        public void telaLogin(View view) {
            Intent telaLogin = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(telaLogin);
        }

}
