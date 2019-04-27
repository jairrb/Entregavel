package br.com.digitalhouse;

public class ProfessorTitular extends Professor {
    private String especialidade;

    public ProfessorTitular(String nome, String sobrenome, int tempoCasa, int codigo, String especialidade) {
        super(nome, sobrenome, tempoCasa, codigo);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
