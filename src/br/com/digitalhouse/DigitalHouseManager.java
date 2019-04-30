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

        System.out.println("--- REGISTRANDO CURSO ---");
        Curso curso = new Curso(nome, codigoCurso, quantidadeMaximaDeAlunos);

        if ((cursos.contains(curso) )) {
            System.out.println("--- ERRO CADASTRO CURSO"+
                    "\n Codigo de curso já cadastrado!\n");
        }else{
            cursos.add(curso);
            System.out.println("--- Curso cadastrado com sucesso.\n");
        }



    }

    public void excluirCurso(Integer codigoCurso){
        int pos = posicaoList(cursos,codigoCurso,1);
        System.out.println("--- EXCLUINDO CURSO ---");
        if (pos >= 0 ) {
            cursos.remove(pos);
            System.out.println("--- Curso informado excluido com sucesso.\n");
        } else {

            System.out.println("--- ERRO EXCLUSAO CURSO"+
                    "\n Codigo de curso não encontrado!\n");
        }

    }

    public void registrarProfessorAdjunto(String nome, String sobrenome,
                                          Integer codigoProfessor, Integer quantidadeDeHoras){
        System.out.println("--- REGISTRANDO PROFESSOR ADJUNTO ---");
        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto(nome,sobrenome,codigoProfessor,quantidadeDeHoras);

        if ((professores.contains(professorAdjunto) )) {
            System.out.println("--- ERRO CADASTRO PROFESSOR ADJUNTO"+
                    "\n Codigo de professor adjunto já cadastrado!\n");
        }else {
            professores.add(professorAdjunto);
            System.out.println("--- Professor adjunto cadastrado com sucesso.\n");
        }

    }

    public void registrarProfessorTitular(String nome, String sobrenome,
                                          Integer codigoProfessor, String especialidade){
            System.out.println("--- Registrando Professor Titular ---");
            ProfessorTitular professorTitular = new ProfessorTitular(nome,sobrenome,codigoProfessor,especialidade);


        if ((professores.contains(professorTitular) )) {
            System.out.println("--- ERRO CADASTRO PROFESSOR TITULAR"+
                    "\n Codigo de professor adjunto já cadastrado!\n");
        }else {
            professores.add(professorTitular);
            System.out.println("--- Professor titular cadastrado com sucesso.\n");
        }

    }

    public void excluirProfessor(Integer codigoProfessor){
        int pos = posicaoList(professores,codigoProfessor,2);

        System.out.println("--- EXCLUINDO PROFESSOR ---");
        if (pos >= 0 ) {
            professores.remove(pos);
            System.out.println("--- Curso informado excluido com sucesso.\n");
        } else {

            System.out.println("--- ERRO EXCLUSAO CURSO"+
                    "\n Codigo de professor não encontrado!\n");
        }


    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular,
                                  Integer codigoProfessorAdjunto){
            int posCurso = posicaoList(cursos,codigoCurso,1);
            int posProfT = posicaoList(professores,codigoProfessorTitular,2);
            int posProfA = posicaoList(professores,codigoProfessorAdjunto,2);
            System.out.println("--- ALOCANDO PROFESSORES ---");

            if (posCurso == -1){
                System.out.println("--- ERRO ALOCAÇÃO PROFESSOR"+
                        "\n Codigo de curso não encontrado!\n");
            }else if (posProfT == -1){
                System.out.println("--- ERRO ALOCAÇÃO PROFESSOR"+
                        "\n Codigo de professor titular não encontrado!\n");

            }else if (posProfA == -1){
                System.out.println("--- ERRO ALOCAÇÃO PROFESSOR"+
                        "\n Codigo de professor adjunto não encontrado!\n");
            }else {
                cursos.get(posCurso).setProfessorTitular((ProfessorTitular) professores.get(posProfT));
                System.out.println("Professor Titular: "+professores.get(posProfT).getNome()+" alocado.");
                cursos.get(posCurso).setProfessorAdjunto((ProfessorAdjunto) professores.get(posProfA));
                System.out.println("Professor Adjunto: "+professores.get(posProfA).getNome()+" alocado.|\n");
            }

    }

    public void matricularAluno(String nome, String sobrenome,
                                Integer codigoAluno){
        System.out.println("--- MATRICULANDO ALUNO ---");
        Aluno aluno = new Aluno(nome,sobrenome,codigoAluno);

        if ((alunos.contains(aluno) )) {
            System.out.println("--- ERRO CADASTRO ALUNO"+
                    "\n Codigo de aluno já cadastrado!\n");
        }else{
            alunos.add(aluno);
            System.out.println("--- Curso cadastrado com sucesso.\n");
        }

    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        int posCurso = posicaoList(cursos,codigoCurso,1);
        int posAluno = posicaoList(alunos,codigoAluno,3);

        if (posCurso == -1) {
            System.out.println("--- ERRO MATRICULA ALUNO" +
                    "\n Codigo de curso não encontrado!\n");
        }else if (posAluno  == -1){
            System.out.println("--- ERRO MATRICULA ALUNO" +
                    "\n Codigo de aluno(a) não encontrado!\n");
        } else if (cursos.get(posCurso).validaQtdMax()) {
            System.out.println("--- MATRICULANDO AO CURSO ---");
            matriculas.add(new Matricula(alunos.get(posAluno), cursos.get(posCurso)));

            System.out.println( "Aluno(a): "+alunos.get(posAluno).getNome()+
                    " foi matriculado(a) ao curso "+ cursos.get(posCurso).getNome()+"com sucesso!\n");
        }


    }

    public int posicaoList(List lista, Integer codigoBusca, int tipoClasse){
        for (int i = 0; i < lista.size(); i++) {

            if (tipoClasse == 1){
                Curso curso = (Curso)lista.get(i);
                if (curso.getCodigo().equals(codigoBusca)) {
                    return i;
                }
            }else if (tipoClasse == 2){
                Professor professor = (Professor) lista.get(i);
                if (professor.getCodigo().equals(codigoBusca)) {
                    return i;
                }
            }else if (tipoClasse == 3){
                Aluno aluno = (Aluno) lista.get(i);
                if (aluno.getRa().equals(codigoBusca)) {
                    return i;
                }
            }
        }
        return -1;
    }
}