package com.example.thiago.sistemadeestudos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private Spinner selectCurso;
    private List<String> cursos = new ArrayList<>();

    private Button cadastrar;
    private Button limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        selectCurso = (Spinner) findViewById(R.id.selectCurso2);
        addCursos();
        populaCursos();
        configuraBotaoOK();
        configuraBotaoLimpar();
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

    private void populaCursos() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cursos);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectCurso.setAdapter(spinnerArrayAdapter);
    }

    /**
     * Configura o evento do botão limpar
     */
    private void configuraBotaoOK() {
        cadastrar = (Button)findViewById(R.id.btnOK);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }

    /**
     * Realiza o cadastro do aluno
     */
    private void cadastrar() {
        Toast.makeText(getApplicationContext(), "Em construção...", Toast.LENGTH_SHORT).show();
    }

    /**
     * Configura o evento do botão limpar
     */
    private void configuraBotaoLimpar() {
        limpar = (Button)findViewById(R.id.btnLimpar);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    /**
     * Limpa os campos de texto do formulário
     */
    private void limparCampos(){
        EditText nome   = (EditText)findViewById(R.id.nome);
        EditText matr   = (EditText)findViewById(R.id.matr);
        EditText email  = (EditText)findViewById(R.id.email);
        EditText cGit   = (EditText)findViewById(R.id.gitHub);

        nome.setText("");
        matr.setText("");
        email.setText("");
        cGit.setText("");
    }
}
