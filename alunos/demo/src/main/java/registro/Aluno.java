package registro;

import java.util.Arrays;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private double[] notas;
    private double[] pesos;

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
    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    public double[] getPesos() {
        return pesos;
    }
    public void setPesos(double[] pesos) {

        this.pesos = pesos;
    }

    public Aluno(String matricula, String nome, String curso, double[] notas, double[] pesos){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.notas = new double[4];
        this.pesos = new double[4];
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + "\n"+"Matricula: " + matricula + "\n"+"Curso: " + curso + "\n"+"Notas: " + Arrays.toString(notas) + "\n"+"Pesos: " + Arrays.toString(pesos);
    }
}




    