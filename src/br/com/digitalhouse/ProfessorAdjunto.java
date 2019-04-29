package br.com.digitalhouse;

public class ProfessorAdjunto extends Professor {
    private int horasMonitoria;

    public ProfessorAdjunto(String nome, String sobrenome, int codigo, int horasMonitoria) {
        super(nome, sobrenome, 0, codigo);
        this.horasMonitoria = horasMonitoria;
    }

    public int getHorasMonitoria() {
        return horasMonitoria;
    }

    public void setHorasMonitoria(int horasMonitoria) {
        this.horasMonitoria = horasMonitoria;
    }
}