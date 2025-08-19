package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        Path path = Path.of("src/main/resources/dados.json");
        String conteudo = Files.readString(path);

        JsonObject json = gson.fromJson(conteudo, JsonObject.class);

        // Acessa os campos
        String nome = json.get("nome").getAsString();
        int idade = json.get("idade").getAsInt();

        System.out.println("=== Dados do JSON ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
