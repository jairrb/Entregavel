package br.com.digitalhouse;

import java.util.Date;

public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private Date dataMatricula;

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = new Date();
    }
}
