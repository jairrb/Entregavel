package br.com.digitalhouse;

public class ProfessorAdjunto extends Professor {
    private int horasMonitoria;

    public ProfessorAdjunto(String nome, String sobrenome, int tempoCasa, int codigo, int horasMonitoria) {
        super(nome, sobrenome, tempoCasa, codigo);
        this.horasMonitoria = horasMonitoria;
    }

    public int getHorasMonitoria() {
        return horasMonitoria;
    }

    public void setHorasMonitoria(int horasMonitoria) {
        this.horasMonitoria = horasMonitoria;
    }
}
