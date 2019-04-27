package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {
    List<Aluno> alunos = new ArrayList<>();
    List<Professor> professores = new ArrayList<>();
    List<Curso> cursos = new ArrayList<>();
    List<Matricula> matriculas = new ArrayList<>();

    public void registrarCurso(String nome, Integer codigoCurso,
                               Integer quantidadeMaximaDeAlunos){

        cursos.add(new Curso(nome,codigoCurso,quantidadeMaximaDeAlunos));

    }

    public void excluirCurso(Integer codigoCurso){

        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).equals(codigoCurso)) {
                cursos.remove(i);
                break;
            }
        }


    }

}


