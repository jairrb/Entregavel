package br.com.digitalhouse;

public class Principal {
    public static void main(String[] args) throws DHException, OtherException {
        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();

        digitalHouseManager.registrarProfessorAdjunto("Guido", "Rossum", 56, 10);
        digitalHouseManager.registrarProfessorAdjunto("Jawed", "Karim", 78, 10);

        digitalHouseManager.registrarProfessorAdjunto("Jawed", "Karim", 99, 10);
        digitalHouseManager.excluirProfessor(99);
        digitalHouseManager.registrarProfessorTitular("Alan", "Turing", 12, "Criptoanalista ");
        digitalHouseManager.registrarProfessorTitular("Ken", "Thompson", 34, "Unix");

        digitalHouseManager.registrarCurso("Full Stack", 20001, 3);
        digitalHouseManager.registrarCurso("Android", 20002, 2);


        digitalHouseManager.alocarProfessores(20001, 12, 56);
        digitalHouseManager.alocarProfessores(20002, 34, 78);

        digitalHouseManager.matricularAluno("Jair", "Ribeiro", 12);
        digitalHouseManager.matricularAluno("Angela", "Ribeiro", 34);
        digitalHouseManager.matricularAluno("Emily", "Vitoria", 56);

        digitalHouseManager.consultaCursoMatriculado(12);

        digitalHouseManager.matricularAluno(12, 20001);
        digitalHouseManager.matricularAluno(34, 20001);

        digitalHouseManager.excluirCurso(20001);
        digitalHouseManager.excluirProfessor(56);

        digitalHouseManager.matricularAluno(12, 20002);
        digitalHouseManager.matricularAluno(34, 20002);
        digitalHouseManager.matricularAluno(56, 20002);

        digitalHouseManager.consultaCursoMatriculado(12);
    }
}
