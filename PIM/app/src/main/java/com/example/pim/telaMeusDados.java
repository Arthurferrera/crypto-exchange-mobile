package com.example.pim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;



public class telaMeusDados extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    public TextView edtNome;
    public TextView edtCpf;
    public TextView edtCelular;
    public TextView edtEmail;
    public TextView edtSenha;
    public TextView edtNascimento;
    public TextView edtEndereco;
    public TextView edtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_meus_dados);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        edtNome = (TextView) findViewById(R.id.edtNome);
        edtCpf = (TextView) findViewById(R.id.edtCpf);
        edtCelular = (TextView) findViewById(R.id.edtCelular);
        edtEmail = (TextView) findViewById(R.id.edtEmail);
        edtSenha = (TextView) findViewById(R.id.edtSenha);
        edtNascimento = (TextView) findViewById(R.id.edtNascimento);
        edtEndereco = (TextView) findViewById(R.id.edtEndereco);
        edtId = (TextView) findViewById(R.id.edtId);

        String[] textoSeparado = sharedPreferences.getString("nome", "").split(" ");

        if (textoSeparado.length > 1){
        edtNome.setText(textoSeparado[0] + " " + textoSeparado[1]);
        }
        else {
            edtNome.setText(textoSeparado[0]);
        }

        String id = String.valueOf(sharedPreferences.getInt("id", 100));

        edtId.setText(id);
        edtEndereco.setText(sharedPreferences.getString("endereco", ""));
        edtCpf.setText(sharedPreferences.getString("cpf", ""));
        edtCelular.setText(sharedPreferences.getString("celular", ""));
        edtEmail.setText(sharedPreferences.getString("email", ""));
        edtSenha.setText("************");
        edtNascimento.setText(sharedPreferences.getString("nascimento", ""));
    }

    public void telaAlteraCadastro(View view){
        Intent telaAlteraCadastro = new Intent(getApplicationContext(), telaAlteraDados.class);
        startActivity(telaAlteraCadastro);
    }

    public void telaHome(View view){
        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        startActivity(telaHome);

    }
}
