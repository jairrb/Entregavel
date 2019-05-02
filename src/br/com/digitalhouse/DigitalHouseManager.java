package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {
    List<Estudioso> alunos = new ArrayList<>();
    List<Professor> professores = new ArrayList<>();
    List<Curso> cursos = new ArrayList<>();
    List<Matricula> matriculas = new ArrayList<>();

    /**
     * Metodo para registro de curso
     */
    public void registrarCurso(String nome, Integer codigoCurso,
                               Integer quantidadeMaximaDeAlunos) {

        System.out.println("|--- CADASTRO DE CURSO ---|");
        Curso curso = new Curso(nome, codigoCurso, quantidadeMaximaDeAlunos);

        if ((cursos.contains(curso))) {
            System.out.println("--- ERRO CADASTRO CURSO" +
                    "\n Codigo de curso já cadastrado!\n");
        } else {
            cursos.add(curso);
            System.out.println("--- Curso cadastrado com sucesso.");
            System.out.println(curso.toString());
        }
    }

    /**
     * Metodo para exclusao de curso
     */
    public void excluirCurso(Integer codigoCurso) {
        int pos = posicaoList(cursos, codigoCurso, 1);
        boolean exclui = true;
        System.out.println("|--- EXCLUSAO CURSO ---|");
        if (pos >= 0) {
            for (Matricula matricula : matriculas) {
                if (matricula.getCurso().equals(cursos.get(pos))) {
                    System.out.println("--- ERRO EXCLUSAO CURSO" +
                            "\n Curso possui matriculas e não poderá ser excluido!\n");
                    exclui = false;
                    break;
                }
            }
            if (exclui) {
                System.out.println(cursos.get(pos).toString());
                cursos.remove(pos);
                System.out.println("--- Curso informado excluido com sucesso.\n");
            }

        } else {

            System.out.println("--- ERRO EXCLUSAO CURSO" +
                    "\n Codigo de curso não encontrado!\n");
        }
    }

    /**
     * Metodo para registro de professor adjunto
     */
    public void registrarProfessorAdjunto(String nome, String sobrenome,
                                          Integer codigoProfessor, Integer quantidadeDeHoras) {
        System.out.println("|--- CADASTRO PROFESSOR ADJUNTO ---|");
        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto(nome, sobrenome, codigoProfessor, quantidadeDeHoras);

        if ((professores.contains(professorAdjunto))) {
            System.out.println("--- ERRO CADASTRO PROFESSOR ADJUNTO" +
                    "\n Codigo " + codigoProfessor + " de professor adjunto já cadastrado!\n");
        } else {
            professores.add(professorAdjunto);
            System.out.println("--- Professor adjunto cadastrado com sucesso.");
            System.out.println(professorAdjunto.toString());
        }
    }

    /**
     * Metodo para registro de professor titular
     */
    public void registrarProfessorTitular(String nome, String sobrenome,
                                          Integer codigoProfessor, String especialidade) {
        System.out.println("|--- CADASTRO PROFESSOR TITULAR  ---|");
        ProfessorTitular professorTitular = new ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade);


        if ((professores.contains(professorTitular))) {
            System.out.println("--- ERRO CADASTRO PROFESSOR TITULAR" +
                    "\n Codigo de professor adjunto já cadastrado!\n");
        } else {
            professores.add(professorTitular);
            System.out.println("--- Professor titular cadastrado com sucesso.");
            System.out.println(professorTitular.toString());
        }

    }

    /**
     * Metodo para exclusão de professor
     */
    public void excluirProfessor(Integer codigoProfessor) {
        int pos = posicaoList(professores, codigoProfessor, 2);
        boolean exclui = true;

        System.out.println("|--- EXCLUSAO PROFESSOR ---|");
        if (pos >= 0) {
            for (Curso curso : cursos) {
                if (curso.getProfessorAdjunto().equals(professores.get(pos)) ||
                        curso.getProfessorTitular().equals(professores.get(pos))) {
                    System.out.println("--- ERRO EXCLUSAO PROFESSOR" +
                            "\n Professor esta alocado a curso e não poderá ser excluido!\n");
                    exclui = false;
                    break;

                }
            }
            if (exclui) {
                System.out.println(professores.get(pos).toString());
                professores.remove(pos);
                System.out.println("--- Professor informado excluido com sucesso.\n");
            }
        } else {

            System.out.println("--- ERRO EXCLUSAO PROFESSOR" +
                    "\n Codigo de professor não encontrado!\n");
        }
    }

    /**
     * Metodo para alocação de professores ao curso previamente cadastrado
     */
    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular,
                                  Integer codigoProfessorAdjunto) {
        int posCurso = posicaoList(cursos, codigoCurso, 1);
        int posProfT = posicaoList(professores, codigoProfessorTitular, 2);
        int posProfA = posicaoList(professores, codigoProfessorAdjunto, 2);
        System.out.println("|--- ALOCACAO DE PROFESSORES ---|");

        if (posCurso == -1) {
            System.out.println("--- ERRO ALOCAÇÃO PROFESSOR" +
                    "\n Codigo de curso não encontrado!\n");
        } else if (posProfT == -1) {
            System.out.println("--- ERRO ALOCAÇÃO PROFESSOR" +
                    "\n Codigo de professor titular não encontrado!\n");

        } else if (posProfA == -1) {
            System.out.println("--- ERRO ALOCAÇÃO PROFESSOR" +
                    "\n Codigo de professor adjunto não encontrado!\n");
        } else {
            System.out.println(cursos.get(posCurso).toString());
            cursos.get(posCurso).setProfessorTitular((ProfessorTitular) professores.get(posProfT));
            System.out.println("Professor Titular: " + professores.get(posProfT).getNome());
            cursos.get(posCurso).setProfessorAdjunto((ProfessorAdjunto) professores.get(posProfA));
            System.out.println("Professor Adjunto: " + professores.get(posProfA).getNome() + "\n");
        }

    }

    /**
     * Metodo para matricula inicial do aluno
     */
    public void matricularAluno(String nome, String sobrenome,
                                Integer codigoAluno) {
        System.out.println("|--- CADASTRO ALUNO ---|");
        Estudioso aluno = new Aluno(nome, sobrenome, codigoAluno);

        if ((alunos.contains(aluno))) {
            System.out.println("--- ERRO CADASTRO ALUNO" +
                    "\n Codigo de aluno já cadastrado!\n");
        } else {
            alunos.add(aluno);
            System.out.println("--- Aluno matriculado com sucesso.");
            System.out.println(aluno.toString());
        }
    }

    /**
     * Metodo para matricula do aluno ao curso
     */
    public void matricularAluno(Integer codigoAluno, Integer codigoCurso) {
        int posCurso = posicaoList(cursos, codigoCurso, 1);
        int posAluno = posicaoList(alunos, codigoAluno, 3);

        System.out.println("|--- MATRICULA ALUNO AO CURSO ---|");
        if (posCurso == -1) {
            System.out.println("--- ERRO MATRICULA ALUNO" +
                    "\n Codigo de curso não encontrado!\n");
        } else if (posAluno == -1) {
            System.out.println("--- ERRO MATRICULA ALUNO" +
                    "\n Codigo de aluno(a) não encontrado!\n");
        } else if (cursos.get(posCurso).validaQtdMax()) {

            DigitalException digitalException = new DigitalException();
            try {
                if (digitalException.matriculaDH(alunos.get(posAluno))) {
                    matriculas.add(new Matricula(alunos.get(posAluno), cursos.get(posCurso)));
                    System.out.println("Aluno(a) matriculado(a) ao curso com sucesso!");
                    System.out.println(alunos.get(posAluno).toString());
                    System.out.println(cursos.get(posCurso).toString());
                }
            } catch (DHException e) {
                System.out.println("Vir ao co-learning");
            } catch (OtherException e) {
                System.out.println("Falar com os alunos");
            }
        }
    }


    /**
     * Metodo para matricula do aluno ao curso
     */
    public void consultaCursoMatriculado(Integer codigoAluno) {
        int posAluno = posicaoList(alunos, codigoAluno, 3);
        boolean matriculado = false;

        System.out.println("|--- BUSCA CURSO MATRICULADO ---|");
        if (posAluno == -1) {
            System.out.println("--- ERRO MATRICULA ALUNO" +
                    "\n Codigo de aluno(a) não encontrado!\n");
        } else {
            for (Matricula matricula : matriculas) {
                if (matricula.getAluno().equals(alunos.get(posAluno))) {
                    System.out.println(matricula.getCurso().toString());
                    matriculado = true;
                }
            }

            if (!matriculado) {
                System.out.println("--- ALUNO NAO MATRICULADO" +
                        "\nAluno(a) não esta matriculado em nenhum curso!");
                System.out.println(alunos.get(posAluno).toString());
            }

        }
    }


    /**
     * Metodo para retorno de posição em uma lista de acordo com o codigo da busca
     */
    private int posicaoList(List lista, Integer codigoBusca, int tipoClasse) {
        for (int i = 0; i < lista.size(); i++) {

            if (tipoClasse == 1) {
                Curso curso = (Curso) lista.get(i);
                if (curso.getCodigo().equals(codigoBusca)) {
                    return i;
                }
            } else if (tipoClasse == 2) {
                Professor professor = (Professor) lista.get(i);
                if (professor.getCodigo().equals(codigoBusca)) {
                    return i;
                }
            } else if (tipoClasse == 3) {
                Aluno aluno = (Aluno) lista.get(i);
                if (aluno.getRa().equals(codigoBusca)) {
                    return i;
                }
            }
        }
        return -1;
    }
}