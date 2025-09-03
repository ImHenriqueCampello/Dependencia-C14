package org.example;

import org.example.entidades.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LeitorGsonTest {

    //Testes Positivos -------------------------------------------------------------------------------

    //1
    @Test
    void TestePosValoresDisciplinas(){
        Disciplinas disciplinas = new Disciplinas(8, 8, 6, 10);
        double java = disciplinas.getJava();
        double python = disciplinas.getPython();
        double bancoDeDados = disciplinas.getBancoDeDados();
        double redes = disciplinas.getRedes();

        assertEquals(8, java);
        assertEquals(8, python);
        assertEquals(6, bancoDeDados);
        assertEquals(10, redes);
    }

    //2
    @Test
    void TestePosValoresAluno() {
        Disciplinas disciplinas = new Disciplinas(10, 5, 4, 3);
        Aluno aluno = new Aluno("Maria", 20, "12345", true, disciplinas);
        String nome = aluno.getNome();
        int idade = aluno.getIdade();
        String matricula = aluno.getMatricula();

        assertEquals("Maria", nome);
        assertEquals(20, idade);
        assertEquals("12345", matricula);
    }

    //3
    @Test
    void TestePosListaAlunos(){
        Disciplinas disciplina1 = new Disciplinas(1, 2.5, 3.0, 4);
        Aluno aluno1 = new Aluno("Maria", 20, "12345", false, disciplina1);

        Disciplinas disciplina2 = new Disciplinas(10, 10.0, 9.5, 10.0);
        Aluno aluno2 = new Aluno("Jon", 25, "78910", true, disciplina2);

        List<Aluno> lista = new ArrayList<>();

        lista.add(aluno1);
        lista.add(aluno2);

        assertEquals(2, lista.size());
    }

    //4
    @Test
    void TestePosDisciplinasDecimal(){
        Disciplinas disciplinas = new Disciplinas(8.5, 9.1, 7.6, 10.0);
        double java = disciplinas.getJava();
        double python = disciplinas.getPython();
        double bancoDeDados = disciplinas.getBancoDeDados();
        double redes = disciplinas.getRedes();

        assertEquals(8.5, java);
        assertEquals(9.1, python);
        assertEquals(7.6, bancoDeDados);
        assertEquals(10.0, redes);
    }

    //5
    @Test
    void TestePosAlunoAprovado() {
        Aluno aluno = new Aluno("Maria", 19, "123", true, new Disciplinas(9, 8, 7, 10));
        assertTrue(aluno.isAprovado());
    }

    //6
    @Test
    void TestePosValoresEscola(){

        Disciplinas disciplina1 = new Disciplinas(1, 2.5, 3.0, 4);
        Aluno aluno1 = new Aluno("Maria", 20, "12345", false, disciplina1);

        Disciplinas disciplina2 = new Disciplinas(10, 10.0, 9.5, 10.0);
        Aluno aluno2 = new Aluno("Jon", 25, "78910", true, disciplina2);

        List<Aluno> lista = new ArrayList<>();

        Escola escola = new Escola("Inatel", "Rua 1", "Turma 10", 2025, lista);
        assertEquals("Inatel", escola.getNome());
        assertEquals("Rua 1",escola.getEndereco());
        assertEquals("Turma 10",escola.getTurma());
        assertEquals(2025, escola.getAnoLetivo());
    }

    //7
    @Test
    void TestePosAlunoDisciplinasLigadas() {
        Disciplinas disciplinas = new Disciplinas(7, 8, 9, 6);
        Aluno aluno = new Aluno("Lucas", 22, "777", true, disciplinas);
        assertEquals(disciplinas, aluno.getDisciplinas());
    }

    //8
    @Test
    void TestePosEscolaAlunosLigadas() {
        List<Aluno> lista = new ArrayList<>();
        lista.add(new Aluno("Ana", 21, "123", true, new Disciplinas(10, 9, 8, 10)));
        lista.add(new Aluno("Joao", 23, "456", false, new Disciplinas(5, 5, 5, 5)));

        Escola escola = new Escola("Inatel", "Rua 1", "Turma A", 2024, lista);

        assertEquals(2, escola.getAlunos().size());

        assertEquals("Ana", escola.getAlunos().get(0).getNome());
        assertEquals("Joao", escola.getAlunos().get(1).getNome());
        assertEquals(21, escola.getAlunos().get(0).getIdade());
        assertEquals(23, escola.getAlunos().get(1).getIdade());
        assertEquals("123", escola.getAlunos().get(0).getMatricula());
        assertEquals("456", escola.getAlunos().get(1).getMatricula());
    }

    //9
    @Test
    void TestePosDisciplinasLimiteZeroDez() {
        Disciplinas disciplinas = new Disciplinas(0, 10, 0, 10);
        assertEquals(0, disciplinas.getJava());
        assertEquals(10, disciplinas.getPython());
    }

    //10
    @Test
    void TestePosAlunoNomeLongo() {
        String nomeGrande = "AlunoComNomeMuitoGrandeParaTestar123123123213123213213aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Aluno aluno = new Aluno(nomeGrande, 30, "999", false, new Disciplinas(9, 10, 6, 10));
        assertEquals(nomeGrande, aluno.getNome());
    }




    //Testes Negativos -------------------------------------------------------------------------------

    //1
    @Test
    void TesteNegIdadeNegativa() {
        Disciplinas disciplinas = new Disciplinas(7, 7, 7, 7);
        Aluno aluno = new Aluno("Carlos", -5, "X1", true, disciplinas);
        assertFalse(aluno.getIdade() < 0);
    }

    //2
    @Test
    void TesteNegIdadeGigantesca() {
        Disciplinas disciplinas = new Disciplinas(7, 7, 7, 7);
        Aluno aluno = new Aluno("Carlos", 9999, "X1", true, disciplinas);
        assertFalse(aluno.getIdade() > 150);
    }


    //3
    @Test
    void TesteNegMatriculaVazia() {
        Aluno aluno = new Aluno("Paulo", 19, null, true, new Disciplinas(5, 5, 5, 5));
        assertFalse(aluno.getMatricula() == "");
    }

    //4
    @Test
    void TesteNegNotaMaiorQue10() {
        Disciplinas disciplinas = new Disciplinas(15, 9, 8, 7);
        assertFalse(disciplinas.getJava() > 10);
    }

    //5
    @Test
    void TesteNegEscolaNull() {
        Escola escola = new Escola(null, null, null, 2013, null);
        assertFalse(escola.getNome() == null);
    }

    //6
    @Test
    void TesteNegAlunoNull() {
        Aluno aluno = new Aluno(null, 50, null, true, new Disciplinas(5, 5, 5, 5));

        assertFalse(aluno.getNome() == null);
        assertFalse(aluno.getMatricula() == null);
    }

    //7
    @Test
    void TesteNegAnoLetivoNegativo() {
        Escola escola = new Escola("Inatel", "Rua 1", "Turma 1", -2020, new ArrayList<>());
        assertNotEquals(-2020, escola.getAnoLetivo());
    }

    //8
    @Test
    void TesteNegDisciplinasNegativas() {
        Disciplinas disciplinas = new Disciplinas(-1, -5, 3, 2);
        assertFalse(disciplinas.getJava() < 0);
    }

    //9
    @Test
    void TesteNegEscolaSemAlunos() {
        List<Aluno> listavazia = new ArrayList<>();
        Escola escola = new Escola("Inatel", "Rua 1", "Turma 1", 2022, listavazia);

        assertEquals(0, escola.getAlunos().size());
    }

    //10
    @Test
    void TesteNegEscolaListaNull() {
        Escola escola = new Escola("Inatel", "Rua 1", "Turma 1", 2023, null);

        assertNull(escola.getAlunos());
    }
}
