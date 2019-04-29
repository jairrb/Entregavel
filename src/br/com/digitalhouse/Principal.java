package br.com.digitalhouse;

public class Principal {
    public static void main(String[] args) {
        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();

        digitalHouseManager.registrarProfessorAdjunto("Guido","Rossum",56,10);
        digitalHouseManager.registrarProfessorAdjunto("Jawed","Karim",78,10);

        digitalHouseManager.registrarProfessorTitular("Alan","Turing",12,"Criptoanalista ");
        digitalHouseManager.registrarProfessorTitular("Ken","Thompson",34,"Unix");

        digitalHouseManager.registrarCurso("Full Stack", 20001,3);
        digitalHouseManager.registrarCurso("Android", 20002,2);


        digitalHouseManager.alocarProfessores(20001,12,56);
        digitalHouseManager.alocarProfessores(20002,34,78);

        digitalHouseManager.matricularAluno("JAIR","RIBEIRO", 12 );
        digitalHouseManager.matricularAluno("ANGELA","RIBEIRO", 34 );
        digitalHouseManager.matricularAluno("EMILY","VITORIA", 56 );

        digitalHouseManager.matricularAluno(12,2001);
        digitalHouseManager.matricularAluno(34,2001);

        digitalHouseManager.matricularAluno(12,2002);
        digitalHouseManager.matricularAluno(34,2002);
        digitalHouseManager.matricularAluno(56,2002);
    }
}
