package com.example.milene.verificaidade;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private Button btnVerificaIdade;
    private EditText edtAno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificaIdade = findViewById(R.id.btnVerificaIdade);
        edtAno = findViewById(R.id.edtAno);

    }

    public void CalculaIdade (View v){
        try {
            int ano = Integer.parseInt(edtAno.getText().toString());
            Calendar cal = GregorianCalendar.getInstance();
            int anoAtual = cal.get(Calendar.YEAR);
            int calculo = (anoAtual - ano);
            String resposta = situacaoIdade(calculo);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("O resultado é: ");
            alertDialog.setMessage(resposta);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }catch (Exception ex){

        }

    }

    private String situacaoIdade(int calculo) {
        String situacao = null;

       if (calculo <= 12){
           situacao = "Você ainda é uma criança!";
       }else if (calculo >= 13 && calculo <= 18){
           situacao = "Você é um adolescente!";
       }else if (calculo > 18){
           situacao = "Você já é adulto!";
       }

        return situacao;
    }
}
