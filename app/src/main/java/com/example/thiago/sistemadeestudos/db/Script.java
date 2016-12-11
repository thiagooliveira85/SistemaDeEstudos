package com.example.thiago.sistemadeestudos.db;

/**
 * Created by Thiago on 10/12/2016.
 */

public class Script {

    public static String createTableAluno(){

        StringBuilder sb = new StringBuilder();

        sb.append(" CREATE TABLE IF NOT EXISTS ALUNO ( ");
        sb.append(" _ID INTEGER NOT NULL ");
        sb.append(" PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" NOME VARCHAR(255), ");
        sb.append(" MATRICULA VARCHAR(255), ");
        sb.append(" EMAIL VARCHAR(255), ");
        sb.append(" CONTAGITHUB VARCHAR(255), ");
        sb.append(" SENHA VARCHAR(20), ");
        sb.append(" ID_CURSO INTEGER NOT NULL, ");
        sb.append(" FOREIGN KEY(ID_CURSO) REFERENCES CURSO(_id)); ");

        return sb.toString();

    }

    public static String createTableCurso(){

        StringBuilder sb = new StringBuilder();

        sb.append(" CREATE TABLE IF NOT EXISTS CURSO ( ");
        sb.append(" _ID INTEGER NOT NULL ");
        sb.append(" PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" NOME VARCHAR(255)); ");

        return sb.toString();

    }

    public static String createTableAula(){

        StringBuilder sb = new StringBuilder();

        sb.append(" CREATE TABLE IF NOT EXISTS AULA ( ");
        sb.append(" _ID INTEGER NOT NULL ");
        sb.append(" PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" NOME VARCHAR(255), ");
        sb.append(" ID_CURSO INTEGER NOT NULL, ");
        sb.append(" FOREIGN KEY(ID_CURSO) REFERENCES CURSO(_id)); ");

        return sb.toString();

    }

    public static String createTableExercicio(){

        StringBuilder sb = new StringBuilder();

        sb.append(" CREATE TABLE IF NOT EXISTS EXERCICIO ( ");
        sb.append(" _ID INTEGER NOT NULL ");
        sb.append(" PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" ID_ALUNO INTEGER NOT NULL, ");
        sb.append(" FOREIGN KEY(ID_ALUNO) REFERENCES ALUNO(_id), ");
        sb.append(" ID_AULA INTEGER NOT NULL, ");
        sb.append(" FOREIGN KEY(ID_AULA) REFERENCES AULA(_id), ");
        sb.append(" EX_FEITO INTEGER,  ");
        sb.append(" LAB_ENVIADO INTEGER ); ");

        return sb.toString();
    }

}
