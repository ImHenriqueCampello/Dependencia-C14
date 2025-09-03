package org.example.entidades;

import java.util.List;

public class Escola {
    private String nome;
    private String endereco;
    private String turma;
    private int anoLetivo;
    private List<Aluno> alunos;

    public Escola(String nome, String endereco, String turma, int anoLetivo, List<Aluno> alunos) {
        if (nome == null || endereco == null || turma == null || anoLetivo < 0 || alunos == null) {
            System.out.println("Erro de entrada na escola!");

            this.nome = "vazio";
            this.endereco = "vazio";
            this.turma = "vazio";
        }
        else
        {
            this.nome = nome;
            this.endereco = endereco;
            this.turma = turma;
            this.anoLetivo = anoLetivo;
            this.alunos = alunos;
        }
    }

    public Escola() {}

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTurma() { return turma; }
    public int getAnoLetivo() { return anoLetivo; }
    public List<Aluno> getAlunos() { return alunos; }
}
