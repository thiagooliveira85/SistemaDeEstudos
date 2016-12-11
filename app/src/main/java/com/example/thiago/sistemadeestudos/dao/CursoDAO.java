package com.example.thiago.sistemadeestudos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;

import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.db.DBSQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 10/12/2016.
 */

public class CursoDAO {


    private Context context;
    private DBSQLite dbsqLite;

    public CursoDAO(Context context){
        this.context = context;
        dbsqLite = new DBSQLite(context);
    }

    public List<Curso> getCursos(){

        List<Curso> cursos = new ArrayList<>();
        Curso curso;

        try{

            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String query = " SELECT " + Curso.ID + ", " + Curso.NOME + " FROM " + Curso.TABELA;
            //String query = "SELECT name FROM sqlite_master";

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    curso = new Curso(cursor.getInt(0), cursor.getString(1));
                    cursos.add(curso);
                } while (cursor.moveToNext());
                db.close();
            }

        }catch (Exception e){
           e.printStackTrace();
        }

        return cursos;
    }

    public Curso getCursoByName(String nome){
        Curso curso = null;

        SQLiteDatabase db = dbsqLite.getReadableDatabase();

        try {

            String query = " SELECT " + Curso.ID + ", " + Curso.NOME + " FROM " + Curso.TABELA + " WHERE " + Curso.NOME + " = '" + nome + "'";

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                   return curso = new Curso(cursor.getInt(0), cursor.getString(1));
                } while (cursor.moveToNext());

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }

        return null;
    }

    public Curso getCursoById(int id){
        Curso curso = null;

        SQLiteDatabase db = dbsqLite.getReadableDatabase();

        try {

            String query = " SELECT " + Curso.ID + ", " + Curso.NOME + " FROM " + Curso.TABELA + " WHERE " + Curso.ID + " = " + id;

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    return curso = new Curso(cursor.getInt(0), cursor.getString(1));
                } while (cursor.moveToNext());

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }

        return null;
    }
}
