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

        System.out.println("--- Registrando Curso ---");
        cursos.add(new Curso(nome,codigoCurso,quantidadeMaximaDeAlunos));

    }

    public void excluirCurso(Integer codigoCurso){
        int pos = posicaoList(cursos,codigoCurso);
        if (pos >= 0 && cursos.get(pos).equals(codigoCurso)) {
            System.out.println("--- Excluindo Curso ---");
            cursos.remove(pos);
        }

    }

    public void registrarProfessorAdjunto(String nome, String sobrenome,
                                          Integer codigoProfessor, Integer quantidadeDeHoras){
        System.out.println("--- Registrando Professor Adjunto ---");
        professores.add(new ProfessorAdjunto(nome,sobrenome,codigoProfessor,quantidadeDeHoras));
    }

    public void registrarProfessorTitular(String nome, String sobrenome,
                                          Integer codigoProfessor, String especialidade){
            System.out.println("--- Registrando Professor Titular ---");
            professores.add(new ProfessorTitular(nome,sobrenome,codigoProfessor,especialidade));

    }

    public void excluirProfessor(Integer codigoProfessor){
        int pos = posicaoList(professores,codigoProfessor);
        if (pos >= 0 && professores.get(pos).equals(codigoProfessor)) {
            System.out.println("--- Excluindo Professor ---");
            professores.remove(pos);
        }
    }

    public void matricularAluno(String nome, String sobrenome,
                                Integer codigoAluno){
        System.out.println("--- Matriculando Aluno ---");
        alunos.add(new Aluno(nome,sobrenome,codigoAluno));

    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        if (alunos.contains(codigoAluno) && cursos.contains(codigoCurso) ){
            int posAluno = posicaoList(alunos,codigoAluno);
            int posCurso = posicaoList(cursos,codigoCurso);

            if (cursos.get(posCurso).validaQtdMax()) {
                System.out.println("--- Matriculando ao Curso ---");
                matriculas.add(new Matricula(alunos.get(posAluno), cursos.get(codigoCurso)));
            }
        }

    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular,
                                  Integer codigoProfessorAdjunto){
        if (cursos.contains(codigoCurso) &&
                professores.contains(codigoProfessorTitular) &&
                cursos.contains(codigoProfessorAdjunto)){

            int posCurso = posicaoList(cursos,codigoCurso);
            int posProfT = posicaoList(professores,codigoProfessorTitular);
            int posProfA = posicaoList(professores,codigoProfessorAdjunto);
            System.out.println("--- Alocando Professores ---");
            cursos.get(posCurso).setProfessorTitular((ProfessorTitular) professores.get(posProfT));
            cursos.get(posCurso).setProfessorAdjunto((ProfessorAdjunto) professores.get(posProfA));
        }

    }

    public int posicaoList(List lista, Integer codigoBusca){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(codigoBusca)) {
                return i;
            }
        }
        return -1;
    }
}