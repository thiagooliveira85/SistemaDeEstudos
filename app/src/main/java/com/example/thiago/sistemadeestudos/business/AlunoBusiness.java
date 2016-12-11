package com.example.thiago.sistemadeestudos.business;

import android.content.Context;

import com.example.thiago.sistemadeestudos.bean.Aluno;
import com.example.thiago.sistemadeestudos.dao.AlunoDAO;

/**
 * Created by Thiago on 10/12/2016.
 */

public class AlunoBusiness {

    private static AlunoBusiness instance;

    private AlunoBusiness(){}

    public static synchronized AlunoBusiness getInstance() {
        if (instance == null)
            instance = new AlunoBusiness();

        return instance;
    }

    public boolean insertOrUpdate(Context context, Aluno aluno){

        AlunoDAO dao = new AlunoDAO(context);
        Aluno alunoEncontrado = dao.getAluno(aluno.getEmail());

        if (alunoEncontrado == null){
            return dao.insert(aluno) > 0;
        }else{
            return dao.update(aluno);
        }
    }

    public boolean isAutenticado(Context context, Aluno aluno){
        return new AlunoDAO(context).validaAcesso(aluno.getEmail(), aluno.getSenha());
    }

    public Aluno getAlunoByEmail(Context context, String email){
        AlunoDAO dao = new AlunoDAO(context);
        return dao.getAluno(email);
    }
}
