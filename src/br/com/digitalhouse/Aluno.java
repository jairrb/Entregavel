package br.com.digitalhouse;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String sobrenome;
    private Integer ra;

    public Aluno(String nome, String sobrenome, Integer ra) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ra = ra;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "ALUNO" +
                "\nRA: " + ra +
                "\nNome: " + nome +
                "\nSobrenome: " + sobrenome+"\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return ra == aluno.getRa();
    }

    @Override
    public int hashCode() {

        return Objects.hash(ra);
    }
}