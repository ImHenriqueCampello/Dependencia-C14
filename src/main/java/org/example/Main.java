package org.example;

import org.example.entidades.Escola;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        LeitorGson leitor = new LeitorGson();
        Escola escola = new Escola();

        try {
            escola = leitor.lerArquivo(Path.of("src/main/resources/dados.json"));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }

        Imprimir.MostrarDados(escola);
    }
}
