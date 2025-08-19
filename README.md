# 📌 Projeto Leitura de JSON com Gson

Este projeto em **Java** demonstra como ler e processar arquivos JSON utilizando a biblioteca [Gson](https://github.com/google/gson).  

O exemplo incluso acessa os campos `nome` e `idade` de um arquivo `dados.json` localizado em `src/main/resources/`.

---

## 📂 Estrutura do Projeto
- `src/main/java/org/example/Main.java` → Código principal
- `src/main/resources/dados.json` → Arquivo JSON com os dados de entrada
- `pom.xml` → Configuração de dependências e build
- `.gitignore` → Ignora arquivos desnecessários do versionamento

---

## ⚙️ Pré-requisitos

- [Java 21]
- [Maven]

---
## 📦 Dependências

A principal dependência usada é o **Gson**, já configurado no `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>