package registro;

    public class Turma {
        private Aluno[] alunos;
        private int quantidadeAtual;
    
        public Turma(int capacidade) {
            this.alunos = new Aluno[capacidade];
            this.quantidadeAtual = 0;
        }
    
        public boolean incluir(Aluno aluno) {
            if (quantidadeAtual < alunos.length) {
                if (consultarMat(aluno.getMatricula()) == null) {
                    alunos[quantidadeAtual] = aluno;
                    quantidadeAtual++;
                    return true;
                }
            }
            return false;
        }
    
        public Aluno consultarMat(String matricula) {
            for (int cstm = 0; cstm < quantidadeAtual; cstm++) {
                if (alunos[cstm].getMatricula().equals(matricula)) {
                    return alunos[cstm];
                }
            }
            return null;
        }
    
        public Aluno consultarNome(String nome) {
            for (int cstn = 0; cstn < quantidadeAtual; cstn++) {
                if (alunos[cstn].getNome().equalsIgnoreCase(nome)) {
                    return alunos[cstn];
                }
            }
            return null;
        }
    
        public boolean alterar(String matricula, String novoCurso, double[] novasNotas, double[] novosPesos) {
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
            for (int exc = 0; exc < quantidadeAtual; exc++) {
                if (alunos[exc].getNome().equalsIgnoreCase(nome)) {
                    for (int ex = exc; ex < quantidadeAtual - 1; ex++) {
                        alunos[ex] = alunos[ex + 1]; 
                    }
                    alunos[quantidadeAtual - 1] = null;  
                    quantidadeAtual--;
                    return true;
                }
            }
            return false;
        }
    
        public void imprimir() {
            for (int imp = 0; imp < quantidadeAtual; imp++) {
                System.out.println(alunos[imp]);
            }
        }
    }