package br.com.digitalhouse;

import java.util.Objects;

public class Professor {
    private String nome;
    private String sobrenome;
    private int tempoCasa;
    private int codigo;

    public Professor(String nome, String sobrenome, int tempoCasa, int codigo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoCasa = tempoCasa;
        this.codigo = codigo;
    }

    public Professor() {
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

    public int getTempoCasa() {
        return tempoCasa;
    }

    public void setTempoCasa(int tempoCasa) {
        this.tempoCasa = tempoCasa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return codigo == professor.codigo;
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo);
    }
}
