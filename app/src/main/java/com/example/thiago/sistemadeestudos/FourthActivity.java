package com.example.thiago.sistemadeestudos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class FourthActivity extends AppCompatActivity {

    private ProgressBar progressoAulas;
    private ProgressBar progressoExercicios;
    private ProgressBar progressoLaboratorios;

    private Button btnVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        progressoAulas   = (ProgressBar) findViewById(R.id.progressAulas);
        progressoAulas.setProgress(50);

        progressoExercicios   = (ProgressBar) findViewById(R.id.progressExercicios);
        progressoExercicios.setProgress(80);

        progressoLaboratorios   = (ProgressBar) findViewById(R.id.progressLaboratorios);
        progressoLaboratorios.setProgress(30);

        configuraBotaoVoltar();
    }

    /**
     * configura o botao de voltar
     */
    private void configuraBotaoVoltar() {
        btnVoltar = (Button)findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }

    private void limpar(){
        FourthActivity.this.finish();
    }
}
