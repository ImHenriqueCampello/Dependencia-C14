package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import org.example.entidades.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeitorGson {
    private final Gson gson = new Gson();

    public Escola lerArquivo(Path path) throws IOException {
        String conteudo = Files.readString(path);
        JsonObject json = gson.fromJson(conteudo, JsonObject.class);

        String nome = json.get("escola").getAsString();
        String endereco = json.get("endereco").getAsString();
        String turma = json.get("turma").getAsString();
        int anoLetivo = json.get("anoLetivo").getAsInt();

        List<Aluno> alunos = new ArrayList<>();
        JsonArray arrAlunos = json.getAsJsonArray("alunos");
        for (int i = 0; i < arrAlunos.size(); i++) {
            JsonObject a = arrAlunos.get(i).getAsJsonObject();

            String nomeAluno = a.get("nome").getAsString();
            int idade = a.get("idade").getAsInt();
            String matricula = a.get("matricula").getAsString();
            boolean aprovado = a.get("aprovado").getAsBoolean();

            JsonObject d = a.getAsJsonObject("disciplinas");
            Disciplinas disciplinas = new Disciplinas(
                    d.get("java").getAsDouble(),
                    d.get("python").getAsDouble(),
                    d.get("bancoDeDados").getAsDouble(),
                    d.get("redes").getAsDouble()
            );

            alunos.add(new Aluno(nomeAluno, idade, matricula, aprovado, disciplinas));
        }

        return new Escola(nome, endereco, turma, anoLetivo, alunos);
    }
}
