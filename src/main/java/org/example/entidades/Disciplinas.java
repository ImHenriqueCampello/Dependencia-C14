package org.example.entidades;

public class Disciplinas {
    private double java;
    private double python;
    private double bancoDeDados;
    private double redes;

    public Disciplinas(double java, double python, double bancoDeDados, double redes) {
        if(java >=0 && python >=0 && bancoDeDados >=0 && redes>=0 && java<=10 && python<=10 && bancoDeDados<=10 && redes<=10) {
            this.java = java;
            this.python = python;
            this.bancoDeDados = bancoDeDados;
            this.redes = redes;
        }
        else {
            System.out.println("Erro de entrada, Notas não podem ser negativas");
        }

    }

    public double getJava() { return java; }
    public double getPython() { return python; }
    public double getBancoDeDados() { return bancoDeDados; }
    public double getRedes() { return redes; }
}
