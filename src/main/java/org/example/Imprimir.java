package org.example;

import org.example.entidades.*;

public class Imprimir {
    public static void MostrarDados(Escola escola) {
        System.out.println("=== Dados da Escola ===");
        System.out.println("Escola: " + escola.getNome());
        System.out.println("Endereço: " + escola.getEndereco());
        System.out.println("Turma: " + escola.getTurma());
        System.out.println("Ano Letivo: " + escola.getAnoLetivo());

        System.out.println("=== Alunos ===");
        for (Aluno aluno : escola.getAlunos()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Idade: " + aluno.getIdade());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Notas:");
            System.out.println("  Java: " + aluno.getDisciplinas().getJava());
            System.out.println("  Python: " + aluno.getDisciplinas().getPython());
            System.out.println("  Banco de Dados: " + aluno.getDisciplinas().getBancoDeDados());
            System.out.println("  Redes: " + aluno.getDisciplinas().getRedes());
            System.out.println("Aprovado: " + aluno.isAprovado());
        }
    }
}
