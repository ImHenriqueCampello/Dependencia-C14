package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        // Lê o arquivo JSON
        Path path = Path.of("src/main/resources/dados.json");
        String conteudo = Files.readString(path);

        // Converte para JsonObject
        JsonObject json = gson.fromJson(conteudo, JsonObject.class);

        // Acessa os campos da escola
        String escola = json.get("escola").getAsString();
        String endereco = json.get("endereco").getAsString();
        String turma = json.get("turma").getAsString();
        int anoLetivo = json.get("anoLetivo").getAsInt();

        System.out.println("=== Dados da Escola ===");
        System.out.println("Escola: " + escola);
        System.out.println("Endereço: " + endereco);
        System.out.println("Turma: " + turma);
        System.out.println("Ano Letivo: " + anoLetivo);

        // Acessa os alunos
        JsonArray alunos = json.getAsJsonArray("alunos");

        System.out.println("\n=== Alunos ===");
        for (int i = 0; i < alunos.size(); i++) {
            JsonObject aluno = alunos.get(i).getAsJsonObject();
            String nome = aluno.get("nome").getAsString();
            int idade = aluno.get("idade").getAsInt();
            String matricula = aluno.get("matricula").getAsString();
            boolean aprovado = aluno.get("aprovado").getAsBoolean();

            JsonObject disciplinas = aluno.getAsJsonObject("disciplinas");
            double java = disciplinas.get("java").getAsDouble();
            double python = disciplinas.get("python").getAsDouble();
            double bancoDados = disciplinas.get("bancoDeDados").getAsDouble();
            double redes = disciplinas.get("redes").getAsDouble();


            System.out.println("\nNome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Matrícula: " + matricula);
            System.out.println("Notas:");
            System.out.println("  Java: " + java);
            System.out.println("  Python: " + python);
            System.out.println("  Banco de Dados: " + bancoDados);
            System.out.println("  Redes: " + redes);
            System.out.println("Aprovado: " + aprovado);
        }
    }
}