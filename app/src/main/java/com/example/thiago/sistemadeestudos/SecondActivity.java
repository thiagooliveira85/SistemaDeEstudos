package com.example.thiago.sistemadeestudos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    // Cursos
    private Spinner selectCurso;
    private List<String> cursos = new ArrayList<>();

    // Aulas
    private Spinner selectAula;
    private List<String> aulas = new ArrayList<>();

    // Progresso
    private ProgressBar progresso;

    private Button btnCadastro;
    private Button btnProgresso;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        addCursos();
        addAulas();

        selectCurso = (Spinner) findViewById(R.id.selectCurso);
        selectAula  = (Spinner) findViewById(R.id.selectAula);
        progresso   = (ProgressBar) findViewById(R.id.progressoGeral);

        // Insere valores nas combos
        populaCursos();
        populaAulas();

        // Seta um valor randomico de 0 a 100 para o progresso
        progresso.setProgress((int) (Math.random() * 101));

        // Configura os botões
        configuraBotaoProgresso();
        configuraBotaoCadastrar();
        configuraBotaoSair();

    }

    /**
     * Muda a tela para a tela de progresso
     */
    private void configuraBotaoProgresso() {
        btnProgresso = (Button)findViewById(R.id.progresso);

        btnProgresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trocadorTela = new Intent(SecondActivity.this,FourthActivity.class);
                startActivity(trocadorTela);
            }
        });
    }

    /**
     * Muda a tela para a tela com o formulário de cadastro
     */
    private void configuraBotaoCadastrar() {
        btnCadastro = (Button)findViewById(R.id.cadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trocadorTela = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(trocadorTela);
            }
        });
    }

    /**
     * Configura o botão sair, voltando para a tela de login
     */
    private void configuraBotaoSair() {
        btnSair = (Button)findViewById(R.id.sair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trocadorTela = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(trocadorTela);
            }
        });
    }

    private void addCursos() {
        //Adicionando cursos no ArrayList
        cursos.add("Selecione o Curso");
        cursos.add("Java padrão");
        cursos.add("Java Web");
        cursos.add("Android");
        cursos.add("Modelagem");
        cursos.add("Banco de Dados");
    }

    private void addAulas() {
        //Adicionando aulas no ArrayList
        aulas.add("Selecione a Aula");
        aulas.add("Instalando o Android Studio");
        aulas.add("Criando componentes");
        aulas.add("Ajustando layout");
        aulas.add("Navegando entre telas");
        aulas.add("Exibindo o aplicativo em um dispositivo físico");
    }

    private void populaCursos() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cursos);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectCurso.setAdapter(spinnerArrayAdapter);
    }

    private void populaAulas() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aulas);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectAula.setAdapter(spinnerArrayAdapter);
    }
}
