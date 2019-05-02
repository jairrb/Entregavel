package br.com.digitalhouse;

import java.util.Date;
import java.util.Objects;

public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private Date dataMatricula;

    public Matricula(Aluno aluno, Curso curso) {
        curso.adicionarUmAluno(aluno);
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = new Date();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(aluno, matricula.aluno);
    }

}