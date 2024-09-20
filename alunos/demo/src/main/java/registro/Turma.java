package registro;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;

    public Turma(int capacidade) {
        this.alunos = new ArrayList<>(capacidade);
    }

    public boolean incluir(Aluno aluno) {
        if (consultarMat(aluno.getMatricula()) == null) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    public Aluno consultarMat(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno consultarNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public boolean alterar(String matricula, String novoCurso, List<Double> novasNotas, List<Double> novosPesos) {
        Aluno aluno = consultarMat(matricula);
        if (aluno != null) {
            aluno.setCurso(novoCurso);
            aluno.setNotas(novasNotas);
            aluno.setPesos(novosPesos);
            return true;
        }
        return false;
    }

    public boolean excluir(String nome) {
        Aluno alunoParaExcluir = consultarNome(nome);
        if (alunoParaExcluir != null) {
            alunos.remove(alunoParaExcluir);
            return true;
        }
        return false;
    }

    public void imprimir() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
