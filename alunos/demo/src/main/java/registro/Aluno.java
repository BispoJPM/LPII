package registro;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private List<Double> notas;
    private List<Double> pesos;

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public List<Double> getNotas() {
        return notas;
    }
    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
    public List<Double> getPesos() {
        return pesos;
    }
    public void setPesos(List<Double> pesos) {
        this.pesos = pesos;
    }

    public Aluno(String matricula, String nome, String curso, List<Double> notas, List<Double> pesos){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.notas = notas != null ? new ArrayList<>(notas) : new ArrayList<>();
        this.pesos = pesos != null ? new ArrayList<>(pesos) : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + "\n" +
                "Matricula: " + matricula + "\n" +
                "Curso: " + curso + "\n" +
                "Notas: " + notas.toString() + "\n" + "Pesos: " + pesos.toString();
    }
}




    