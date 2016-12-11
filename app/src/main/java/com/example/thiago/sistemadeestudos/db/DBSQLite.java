package com.example.thiago.sistemadeestudos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;

import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;

/**
 * Created by Thiago on 10/12/2016.
 */

public class DBSQLite extends SQLiteOpenHelper{

    public DBSQLite(Context context){
        super(context, "SIDED6", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Script.createTableCurso());
        db.execSQL(Script.createTableAluno());
        db.execSQL(Script.createTableAula());
        //db.execSQL(Script.createTableExercicio());


        ContentValues values = new ContentValues();
        values.put(Curso.NOME, "Java Web");
        db.insert(Curso.TABELA, null, values);

        values = new ContentValues();
        values.put(Curso.NOME, "Java padrão");
        long idCurso = db.insert(Curso.TABELA, null, values);

        values = new ContentValues();
        values.put(Curso.NOME, "Java android");
        long idCurso2 = db.insert(Curso.TABELA, null, values);

        values = new ContentValues();
        values.put(Aluno.EMAIL, "thi@gmail.com");
        values.put(Aluno.NOME, "Thiago Oliveira");
        values.put(Aluno.MATRICULA, "12345");
        values.put(Aluno.SENHA, "123");
        values.put(Aluno.CONTAGITHUB, "http://github");
        values.put(Aluno.ID_CURSO, idCurso2);
        db.insert(Aluno.TABELA, null, values);

        values = new ContentValues();
        values.put(Aula.NAME, "Ajustando layout");
        values.put(Aula.ID_CURSO, idCurso);
        db.insert(Aula.TABELA, null, values);

        values = new ContentValues();
        values.put(Aula.NAME, "Criando componentes");
        values.put(Aula.ID_CURSO, idCurso);
        db.insert(Aula.TABELA, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        ContentValues values = new ContentValues();
        values.put(Curso.NOME, "Java Web");
        db.insert(Curso.TABELA, null, values);

    }
}
