package com.example.thiago.sistemadeestudos.bean;

/**
 * Created by Thiago on 10/12/2016.
 */

public class Aluno {

    public static final String TABELA       = "ALUNO";
    public static final String NOME         = "NOME";
    public static final String MATRICULA    = "MATRICULA";
    public static final String EMAIL        = "EMAIL";
    public static final String CONTAGITHUB  = "CONTAGITHUB";
    public static final String SENHA        = "SENHA";
    public static final String ID_CURSO     = "ID_CURSO";

    private String nome;
    private String matricula;
    private String email;
    private String contaGitHub;
    private String senha;
    private Curso curso;

    public Aluno(String nome, String matricula, String email, String contaGitHub, String senha, Curso curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.contaGitHub = contaGitHub;
        this.senha = senha;
        this.curso = curso;
    }

    public Aluno(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContaGitHub() {
        return contaGitHub;
    }

    public void setContaGitHub(String contaGitHub) {
        this.contaGitHub = contaGitHub;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
