package com.example.thiago.sistemadeestudos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button acessar;
    private Button limpar;

    private EditText email;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraBotaoAcessar();
        configuraBotaoLimpar();
    }

    /**
     * Configura o botão Acessar
     */
    private void configuraBotaoAcessar() {
        acessar = (Button)findViewById(R.id.acessar);

        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trocadorTela = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(trocadorTela);
            }
        });
    }

    /**
     * Configura o botão Limpar
     */
    private void configuraBotaoLimpar() {
        limpar = (Button)findViewById(R.id.limparLogin);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }

    /**
     * Limpar os campos de login e senha
     */
    private void limpar(){
        email = (EditText)findViewById(R.id.email);
        email.setText("");
        senha = (EditText)findViewById(R.id.senha);
        senha.setText("");
    }
}
