package com.example.thiago.sistemadeestudos.activitys;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thiago.sistemadeestudos.R;
import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.business.AlunoBusiness;
import com.example.thiago.sistemadeestudos.dao.AlunoDAO;
import com.example.thiago.sistemadeestudos.dao.AulaDAO;
import com.example.thiago.sistemadeestudos.dao.CursoDAO;
import com.example.thiago.sistemadeestudos.db.DBSQLite;
import com.example.thiago.sistemadeestudos.util.Util;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button acessar;
    private Button limpar;

    private EditText email;
    private EditText senha;

    SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraBaseDados(this);
        configuraBotaoAcessar();
        configuraBotaoLimpar();
    }

    private void configuraBaseDados(MainActivity mainActivity) {

        try {

            DBSQLite db = new DBSQLite(mainActivity);
            conn = db.getReadableDatabase();

        }catch (SQLException ex){
            Util.showMessage(this, "Erro ao criar a base de dados: " + ex.getMessage(), "OK");
        }
    }


    /**
     * Configura o botão Acessar
     */
    private void configuraBotaoAcessar() {
        acessar = (Button)findViewById(R.id.acessar);

        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                autenticaAluno();

            }
        });
    }

    private void autenticaAluno() {
        email = (EditText)findViewById(R.id.email);
        senha = (EditText)findViewById(R.id.senha);

        Aluno aluno = new Aluno();
        aluno.setEmail(email.getText().toString());
        aluno.setSenha(senha.getText().toString());

        boolean autenticado = AlunoBusiness.getInstance().isAutenticado(getApplicationContext(), aluno);

        if (autenticado){

            SharedPreferences pref = getSharedPreferences("CONFIG", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("email", aluno.getEmail());
            editor.commit();

            Intent trocadorTela = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(trocadorTela);
        }else{
            Util.toastMessage(getApplicationContext(), "E-mail ou senha inválidos!");
        }
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
