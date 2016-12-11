package com.example.thiago.sistemadeestudos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;

import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.db.DBSQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 10/12/2016.
 */

public class AulaDAO {


    private Context context;
    private DBSQLite dbsqLite;

    public AulaDAO(Context context){
        this.context = context;
        dbsqLite = new DBSQLite(context);
    }

    public long insert(Aula aula){

        SQLiteDatabase db = dbsqLite.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Aula.NAME, aula.getNome());
        values.put(Aula.ID_CURSO, aula.getCurso().getId());
        return db.insert(Aula.TABELA, null, values);
    }

    public List<Aula> getAulas(){

        List<Aula> aulas = new ArrayList<>();
        Aula aula;

        try{

            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String query = " SELECT " + Aula.ID + ", " + Aula.NAME + ", " + Aula.ID_CURSO + " FROM " + Aula.TABELA;

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    aula = new Aula(cursor.getInt(0), cursor.getString(1), new CursoDAO(context).getCursoById(cursor.getInt(2)));
                    aulas.add(aula);
                } while (cursor.moveToNext());
                db.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return aulas;
    }

    public List<Aula> getAulas(int idCurso){

        List<Aula> aulas = new ArrayList<>();
        Aula aula;

        try{

            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String query = " SELECT " + Aula.ID + ", " + Aula.NAME + ", " + Aula.ID_CURSO + " FROM " + Aula.TABELA + " WHERE " + Aula.ID_CURSO + " = " + idCurso;

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                do {
                    aula = new Aula(cursor.getInt(0), cursor.getString(1), new CursoDAO(context).getCursoById(cursor.getInt(2)));
                    aulas.add(aula);
                } while (cursor.moveToNext());
                db.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return aulas;
    }
}
