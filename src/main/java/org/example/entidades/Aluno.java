package org.example.entidades;

public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private boolean aprovado;
    private Disciplinas disciplinas;

    public Aluno(String nome, int idade, String matricula, boolean aprovado, Disciplinas disciplinas) {

        if (nome == null || matricula == null || disciplinas == null) {
            System.out.println("Erro de entrada nos alunos!");

            this.nome = "vazio";
            this.matricula = "vazio";
        }
        else
        {
            this.nome = nome;

            if(idade > 0 && idade < 150)
            {
                this.idade = idade;
            }
            System.out.println("Erro, idade negativa!");

            this.matricula = matricula;
            this.aprovado = aprovado;
            this.disciplinas = disciplinas;
        }
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getMatricula() { return matricula; }
    public boolean isAprovado() { return aprovado; }
    public Disciplinas getDisciplinas() { return disciplinas; }
}
