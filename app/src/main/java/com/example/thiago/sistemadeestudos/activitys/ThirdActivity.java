package com.example.thiago.sistemadeestudos.activitys;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.thiago.sistemadeestudos.R;
import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.business.AlunoBusiness;
import com.example.thiago.sistemadeestudos.dao.CursoDAO;
import com.example.thiago.sistemadeestudos.util.Util;

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

        buscaAlunoAtual();
        addCursos();
        configuraBotaoOK();
        configuraBotaoLimpar();
    }

    private void buscaAlunoAtual() {

        SharedPreferences pref = getSharedPreferences("CONFIG", MODE_PRIVATE);
        String strEmail = pref.getString("email", null);

        Aluno alunoAtual = AlunoBusiness.getInstance().getAlunoByEmail(this, strEmail);

        if (alunoAtual != null){
            EditText nome   = (EditText)findViewById(R.id.nome);
            EditText matr   = (EditText)findViewById(R.id.matr);
            EditText email  = (EditText)findViewById(R.id.email);
            EditText senha  = (EditText)findViewById(R.id.senhaCad);
            EditText cGit   = (EditText)findViewById(R.id.gitHub);

            nome.setText(alunoAtual.getNome());
            matr.setText(alunoAtual.getMatricula());
            email.setText(alunoAtual.getEmail());
            senha.setText(alunoAtual.getSenha());
            cGit.setText(alunoAtual.getContaGitHub());

        }

    }

    private void addCursos() {
        List<Curso> lstCursos= new CursoDAO(this).getCursos();
        if (lstCursos != null && !lstCursos.isEmpty()){
            for (Curso c : lstCursos){
                cursos.add(c.getNome());
            }
        }
        populaCursos();
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

        EditText nome   = (EditText)findViewById(R.id.nome);
        EditText matr   = (EditText)findViewById(R.id.matr);
        EditText email  = (EditText)findViewById(R.id.email);
        EditText senha  = (EditText)findViewById(R.id.senhaCad);
        EditText cGit   = (EditText)findViewById(R.id.gitHub);

        Spinner curso =(Spinner) findViewById(R.id.selectCurso2);
        String txtCurso = curso.getSelectedItem().toString();

        Aluno aluno = new Aluno();
        aluno.setNome(nome.getText().toString());
        aluno.setMatricula(matr.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setContaGitHub(cGit.getText().toString());
        aluno.setSenha(senha.getText().toString());
        aluno.setCurso(new CursoDAO(this).getCursoByName(txtCurso));

        boolean ok = AlunoBusiness.getInstance().insertOrUpdate(this, aluno);

        if (ok){
            Util.toastMessage(getApplicationContext(), "Aluno cadastrado com sucesso!");
        }else{
            Util.toastMessage(getApplicationContext(), "Não foi possível cadastrar o aluno!");
        }
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
        EditText senha  = (EditText)findViewById(R.id.senhaCad);
        EditText cGit   = (EditText)findViewById(R.id.gitHub);

        nome.setText("");
        matr.setText("");
        email.setText("");
        senha.setText("");
        cGit.setText("");
    }
}
