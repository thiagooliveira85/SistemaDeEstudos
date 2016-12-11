package com.example.thiago.sistemadeestudos.bean;

/**
 * Created by Thiago on 10/12/2016.
 */

public class Curso {

    public static final String TABELA  = "CURSO";
    public static final String ID      = "_ID";
    public static final String NOME    = "NOME";

    private int id;
    private String nome;

    public Curso(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public static String getID() {
        return ID;
    }

    public static String getNOME() {
        return NOME;
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
}
