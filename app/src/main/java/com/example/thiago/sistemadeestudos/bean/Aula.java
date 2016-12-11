package com.example.thiago.sistemadeestudos.bean;

/**
 * Created by Thiago on 10/12/2016.
 */

public class Aula {

    public static final String TABELA  = "AULA";
    public static final String ID      = "_ID";
    public static final String NAME    = "NOME";
    public static final String ID_CURSO= "ID_CURSO";

    private int id;
    private String nome;
    private Curso curso;

    public Aula(int id, String nome, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
