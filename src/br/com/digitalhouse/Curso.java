package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private Integer codigo;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private int qtdeMaxAluno;

    List<Aluno> alunos = new ArrayList<>();

    public Curso(String nome, Integer codigo, int qtdeMaxAluno) {
        this.nome = nome;
        this.codigo = codigo;
        this.qtdeMaxAluno = qtdeMaxAluno;
    }

    public Curso() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public int getQtdeMaxAluno() {
        return qtdeMaxAluno;
    }

    public void setQtdeMaxAluno(int qtdeMaxAluno) {
        this.qtdeMaxAluno = qtdeMaxAluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "CURSO" +
                "\nNome: " + nome +
                "\nCodigo: " + codigo +
                "\nQuantidade Atual Alunos: " + alunos.size() +
                "\nQuantidade Maxima Alunos: " + qtdeMaxAluno + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codigo == curso.getCodigo();
    }


    public Boolean adicionarUmAluno(Aluno umAluno) {
        if (validaQtdMax()) {
            alunos.add(umAluno);
            return true;
        } else {
            return false;
        }
    }

    public void excluirAluno(Aluno umAluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).equals(umAluno)) {
                alunos.remove(i);
                break;
            }
        }
    }

    public boolean validaQtdMax() {
        if (alunos.size() >= qtdeMaxAluno) {
            System.out.println(this.toString());
            System.out.println("Quantidade de alunos maxima foi atingida!");
            return false;
        } else {
            return true;
        }
    }
}