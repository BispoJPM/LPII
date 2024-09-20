package registro;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Limite da turma: ");
        int capacidade = scanner.nextInt();
        Turma turma = new Turma(capacidade);

        for (int i = 0; i < capacidade; i++) {
            System.out.println("\n"+"Aluno " + (i + 1) + ":");

            System.out.print("Digite a matrícula: ");
            String matricula = scanner.next();

            System.out.print("Digite o nome: ");
            String nome = scanner.next();

            System.out.print("Digite o curso: ");
            String curso = scanner.next();

            List<Double> notas = new ArrayList<>();
            List<Double> pesos = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite a nota da prova " + (j + 1) + ": ");
                notas.add(scanner.nextDouble());

                System.out.print("Digite o peso da prova " + (j + 1) + ": ");
                pesos.add(scanner.nextDouble());
            }
            Aluno aluno = new Aluno(matricula, nome, curso, notas, pesos);
            aluno.setNotas(notas);
            aluno.setPesos(pesos);

            boolean inserido = turma.incluir(aluno);

            if (inserido) {
                System.out.print("\n"+ "Aluno adicionado." + "\n");
            } else {
                System.out.print("Aluno já cadastrado.");
            }
        }

        // Menu de operações
        int opcao;
        do {
            System.out.println("\nOpções:");
            System.out.println("1 - Consultar por matrícula");
            System.out.println("2 - Consultar por nome");
            System.out.println("3 - Alterar dados de um aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("5 - Imprimir lista de alunos");
            System.out.println("6 - Sair");
            System.out.print("\nDigite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a matrícula para consultar: ");
                    String matriculaConsulta = scanner.next();
                    Aluno alunoPorMatricula = turma.consultarMat(matriculaConsulta);
                    if (alunoPorMatricula != null) {
                        System.out.print(alunoPorMatricula);
                    } else {
                        System.out.print("Aluno não encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome para consultar: ");
                    String nomeConsulta = scanner.next();
                    Aluno alunoPorNome = turma.consultarNome(nomeConsulta);
                    if (alunoPorNome != null) {
                        System.out.print(alunoPorNome);
                    } else {
                        System.out.print("Aluno não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno que deseja alterar: ");
                    String matriculaAlterar = scanner.next();

                    System.out.print("Digite o novo curso: ");
                    String novoCurso = scanner.next();

                    List<Double> novasNotas = new ArrayList<>();
                    List<Double> novosPesos = new ArrayList<>();
                    for (int j = 0; j < 4; j++) {
                        System.out.print("Digite a nova nota da prova " + (j + 1) + ": ");
                        novasNotas.add(scanner.nextDouble());

                        System.out.print("Digite o novo peso da prova " + (j + 1) + ": ");
                        novosPesos.add(scanner.nextDouble());
                    }

                    if (turma.alterar(matriculaAlterar, novoCurso, novasNotas, novosPesos)) {
                        System.out.print("Dados do aluno alterados.");
                    } else {
                        System.out.print("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do aluno para excluir: ");
                    String nomeExcluir = scanner.next();
                    if (turma.excluir(nomeExcluir)) {
                        System.out.print("Aluno excluído com sucesso.");
                    } else {
                        System.out.print("Aluno não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Lista de alunos:");
                    turma.imprimir();
                    break;

                case 6:
                    System.out.print("Saindo...");
                    break;

                default:
                    System.out.print("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);

        scanner.close();
    }
}

