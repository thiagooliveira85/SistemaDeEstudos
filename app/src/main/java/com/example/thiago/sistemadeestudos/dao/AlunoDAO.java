package com.example.thiago.sistemadeestudos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.db.DBSQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 10/12/2016.
 */

public class AlunoDAO {

    private Context context;
    private DBSQLite dbsqLite;

    public AlunoDAO(Context context){
        this.context = context;
        dbsqLite = new DBSQLite(context);
    }

    public long insert(Aluno aluno){

        SQLiteDatabase db = dbsqLite.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Aluno.EMAIL, aluno.getEmail());
        values.put(Aluno.NOME, aluno.getNome());
        values.put(Aluno.MATRICULA, aluno.getMatricula());
        values.put(Aluno.SENHA, aluno.getSenha());
        values.put(Aluno.CONTAGITHUB, aluno.getContaGitHub());
        values.put(Aluno.ID_CURSO, new CursoDAO(context).getCursoByName(aluno.getCurso().getNome()).getId());
        long id = db.insert(Aluno.TABELA, null, values);
        db.close();
        return id;
    }

    public Aluno getAluno(String email){

        Aluno aluno = null;

        try {

            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String query = " SELECT " + Aluno.NOME + ", " + Aluno.MATRICULA + ", " + Aluno.EMAIL + ", " + Aluno.CONTAGITHUB + ", "
                    + Aluno.SENHA + ", " + Aluno.ID_CURSO + " FROM " + Aluno.TABELA + " WHERE " + Aluno.EMAIL + " = '" + email + "'";

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    aluno = new Aluno();
                    aluno.setNome(cursor.getString(0));
                    aluno.setMatricula(cursor.getString(1));
                    aluno.setEmail(cursor.getString(2));
                    aluno.setContaGitHub(cursor.getString(3));
                    aluno.setSenha(cursor.getString(4));
                    aluno.setCurso(new CursoDAO(context).getCursoById(cursor.getInt(5)));
                } while (cursor.moveToNext());
                db.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return aluno;
    }

    public boolean update(Aluno aluno){

        int rows = 0;

        try {

            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Aluno.EMAIL, aluno.getEmail());
            values.put(Aluno.NOME, aluno.getNome());
            values.put(Aluno.MATRICULA, aluno.getMatricula());
            values.put(Aluno.SENHA, aluno.getSenha());
            values.put(Aluno.CONTAGITHUB, aluno.getContaGitHub());
            values.put(Aluno.ID_CURSO, aluno.getCurso().getId());
            String where = Aluno.EMAIL + " = ? ";

            rows = db.update(Aluno.TABELA, values, where, new String[]{aluno.getEmail()});
            db.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows > 0;
    }

    public List<Aluno> getAlunos(){

        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno;

        try{

            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String query = " SELECT " + Aluno.NOME + ", " + Aluno.MATRICULA + ", " + Aluno.EMAIL + ", " + Aluno.CONTAGITHUB + ", "
                    + Aluno.SENHA + ", " + Aluno.ID_CURSO + " FROM " + Aluno.TABELA;
            //String query = "SELECT name FROM sqlite_master";

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    aluno = new Aluno();
                    aluno.setNome(cursor.getString(0));
                    aluno.setMatricula(cursor.getString(1));
                    aluno.setEmail(cursor.getString(2));
                    aluno.setContaGitHub(cursor.getString(3));
                    aluno.setSenha(cursor.getString(4));
                    aluno.setCurso(new CursoDAO(context).getCursoById(cursor.getInt(5)));
                    alunos.add(aluno);
                } while (cursor.moveToNext());
                db.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return alunos;

    }


    public boolean validaAcesso(String email, String senha) {
        SQLiteDatabase db = dbsqLite.getReadableDatabase();

        try {

            String query = " SELECT " + Aluno.NOME + ", " + Aluno.MATRICULA + ", " + Aluno.EMAIL + ", " + Aluno.CONTAGITHUB + ", "
                    + Aluno.SENHA + ", " + Aluno.ID_CURSO + " FROM " + Aluno.TABELA + " WHERE " + Aluno.EMAIL + " = '" + email + "' AND " + Aluno.SENHA + " = '" + senha + "'";

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst())
                return true;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
        return false;
    }
}
