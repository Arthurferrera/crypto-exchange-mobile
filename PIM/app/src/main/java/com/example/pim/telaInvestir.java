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

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class telaInvestir extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public TextView edtSaldoReais;
    public TextView edtSaldoBtc;
    public TextView edtCotacaoBtc;


    public EditText edtQntdBtc;
    public EditText edtQntdVendaBtc;
    public TextView edtSucessoCompra;
    public TextView edtSucessoVenda;

    public ArrayList<String> historico = new ArrayList();
    public ArrayList<Float> historicoSaldo = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_investir);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edtSaldoReais = (TextView) findViewById(R.id.edtSaldoReais);
        edtSaldoBtc = (TextView) findViewById(R.id.edtSaldoBtc);
        edtCotacaoBtc = (TextView) findViewById(R.id.edtCotacaoBtc);

        edtSucessoCompra = (TextView) findViewById(R.id.edtSucessoCompra);
        edtSucessoVenda = (TextView) findViewById(R.id.edtSucessoVenda);


        edtQntdBtc = (EditText) findViewById(R.id.edtQntdBtc);
        edtQntdVendaBtc = (EditText) findViewById(R.id.edtQntdVendaBtc);


        Locale ptBr = new Locale("pt", "BR"); //define a região
        NumberFormat moeda = NumberFormat.getCurrencyInstance(ptBr);

        Double saldoDouble = (double)sharedPreferences.getFloat("saldo", 9999);
        edtSaldoReais.setText(moeda.format(saldoDouble).toString());

        String BTC = Float.toString((sharedPreferences.getFloat("saldoBTC", 9999)));
        edtSaldoBtc.setText(BTC);

        Double cotacaoDouble = (double)sharedPreferences.getFloat("valorBTC", 9999);
        Locale ptBr1 = new Locale("pt", "BR"); //define a região
        NumberFormat btc = NumberFormat.getCurrencyInstance(ptBr);

        edtCotacaoBtc.setText(moeda.format(cotacaoDouble));



    }

    public String consultaData(){

        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        String dataFormatada = formataData.format(data);

        return dataFormatada;
    }

    public void comprar(View view) throws InterruptedException {

        float unidadeBTC = 1;
        float valorBTC = sharedPreferences.getFloat("valorBTC", 99999);

        float qtdBtc = Float.parseFloat(edtQntdBtc.getText().toString());
        float calculoBtc = qtdBtc * valorBTC;

        float saldoAtualiza = sharedPreferences.getFloat("saldoBTC", 0);


        if (sharedPreferences.getFloat("saldo", 0) >= calculoBtc)
        {
           // float saldo = Float.parseFloat(edtQntdReal.getText().toString());
            float atualizaSaldo = sharedPreferences.getFloat("saldo", 0) - calculoBtc;

            SharedPreferences.Editor saldoCadastro = sharedPreferences.edit();
            saldoCadastro.putFloat("saldo", (float) atualizaSaldo);
            saldoCadastro.commit();

            SharedPreferences.Editor saldoCadastroBTC = sharedPreferences.edit();
            saldoCadastroBTC.putFloat("saldoBTC", (float) saldoAtualiza + qtdBtc);
            saldoCadastroBTC.commit();



            Double saldoDouble = (double)sharedPreferences.getFloat("saldo", 9999);
            Locale ptBr = new Locale("pt", "BR"); //define a região
            NumberFormat moeda = NumberFormat.getCurrencyInstance(ptBr);

            edtSaldoReais.setText(moeda.format(saldoDouble));
            String BTC = Float.toString((sharedPreferences.getFloat("saldoBTC", 9999)));
            edtSaldoBtc.setText(BTC);

            edtQntdBtc.setText("");

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Compra realizada com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();

            SharedPreferences.Editor aporte = sharedPreferences.edit();
            aporte.putString("aporte", "compra");
            aporte.commit();

        }

        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Erro");
            alert.setMessage("Você não possui saldo suficiente");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }

    }

    public void vender(View view){

        float unidadeBtcVenda = 1;
        float valorBTC = sharedPreferences.getFloat("valorBTC", 99999);

        float qtdBtcVenda = Float.parseFloat(edtQntdVendaBtc.getText().toString());
        float calculoBtcVenda = qtdBtcVenda * valorBTC;

        float saldoReaisAtualiza = sharedPreferences.getFloat("saldo", 0);
        float saldoBTCAtualiza = sharedPreferences.getFloat("saldoBTC", 0);


        if (sharedPreferences.getFloat("saldoBTC", 0) >= qtdBtcVenda){

            SharedPreferences.Editor saldoCadastro = sharedPreferences.edit();
            saldoCadastro.putFloat("saldo", (float) saldoReaisAtualiza + calculoBtcVenda);
            saldoCadastro.commit();

            SharedPreferences.Editor saldoCadastroBTC = sharedPreferences.edit();
            saldoCadastroBTC.putFloat("saldoBTC", (float) saldoBTCAtualiza - qtdBtcVenda);
            saldoCadastroBTC.commit();

            Double saldoDouble = (double)sharedPreferences.getFloat("saldo", 9999);

            //Double saldoDouble = (double)sharedPreferences.getFloat("saldo", 9999);

            Locale ptBr = new Locale("pt", "BR"); //define a região
            NumberFormat moeda = NumberFormat.getCurrencyInstance(ptBr);

            edtSaldoReais.setText(moeda.format(saldoDouble));

            edtQntdVendaBtc.setText("");

            String BTC = Float.toString((sharedPreferences.getFloat("saldoBTC", 9999)));
            edtSaldoBtc.setText(BTC);

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Sucesso");
            alert.setMessage("Venda realizada com sucesso");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    edtQntdVendaBtc.setText("");
                }
            });
            alert.show();

        }

        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Erro");
            alert.setMessage("Você não possui saldo suficiente");

            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    edtQntdVendaBtc.setText("");
                }
            });
            alert.show();
        }

    }

    public void telaHome(View view){

        Intent telaHome = new Intent(getApplicationContext(), telaHome.class);
        startActivity(telaHome);
    }
}

