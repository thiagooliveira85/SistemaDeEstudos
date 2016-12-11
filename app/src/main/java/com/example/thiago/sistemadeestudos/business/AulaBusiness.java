package com.example.thiago.sistemadeestudos.business;

import android.content.Context;

import com.example.thiago.sistemadeestudos.bean.Aula;
import com.example.thiago.sistemadeestudos.bean.Curso;
import com.example.thiago.sistemadeestudos.dao.AulaDAO;
import com.example.thiago.sistemadeestudos.dao.CursoDAO;

import java.util.List;

/**
 * Created by Thiago on 11/12/2016.
 */

public class AulaBusiness {

    private static AulaBusiness instance;

    private AulaBusiness(){}

    public static synchronized AulaBusiness getInstance() {
        if (instance == null)
            instance = new AulaBusiness();

        return instance;
    }

    public List<Aula> getAulas(Context context, String nomeCurso){
        Curso curso = new CursoDAO(context).getCursoByName(nomeCurso);
        return new AulaDAO(context).getAulas(curso.getId());
    }

    public List<Aula> getAulas(Context context){
        return new AulaDAO(context).getAulas();
    }

}
