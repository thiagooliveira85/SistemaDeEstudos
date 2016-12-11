package com.example.thiago.sistemadeestudos.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thiago.sistemadeestudos.R;
import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.business.AulaBusiness;
import com.example.thiago.sistemadeestudos.dao.AulaDAO;
import com.example.thiago.sistemadeestudos.dao.CursoDAO;
import com.example.thiago.sistemadeestudos.util.Util;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    // Cursos
    private Spinner selectCurso;
    private List<String> cursos = new ArrayList<>();

    // Aulas
    private Spinner selectAula;
    private List<String> aulas = new ArrayList<>();

    // Aula selecionada
    private TextView aulaSelecionada;

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

        selectCurso = (Spinner) findViewById(R.id.selectCurso);
        selectAula  = (Spinner) findViewById(R.id.selectAula);
        progresso   = (ProgressBar) findViewById(R.id.progressoGeral);

        configuraAulasPorCurso();
        configuraAulaSelecionada();

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

    private void configuraAulasPorCurso() {

        addAulasByCurso();

        /*selectCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                aulas.clear();
                addAulasByCurso();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                Util.toastMessage(getApplicationContext(), "Nenhum item selecionado");

            }
        });*/

    }

    private void configuraAulaSelecionada() {
        aulaSelecionada = (TextView)findViewById(R.id.nomeAula);

        selectAula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                aulaSelecionada.setText((String) selectAula.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                Util.toastMessage(getApplicationContext(), "Nenhum item selecionado");

            }
        });
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
        List<Curso> lstCursos= new CursoDAO(this).getCursos();
        if (lstCursos != null && !lstCursos.isEmpty()){
            for (Curso c : lstCursos){
                cursos.add(c.getNome());
            }
        }
    }

    private void addAulasByCurso() {
        List<Aula> lstAulas = AulaBusiness.getInstance().getAulas(this);
        if (lstAulas != null && !lstAulas.isEmpty()){
            for (Aula a : lstAulas){
                aulas.add(a.getNome());
            }
        }
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
