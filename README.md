# To-Do List com Java Spring Boot e MySQL

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-4.0-red)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

## 📝 Descrição

Este é um projeto Full-Stack de uma aplicação de Lista de Tarefas (To-Do List), desenvolvido como parte de um estudo aprofundado em tecnologias Java para o backend e desenvolvimento web básico para o frontend. A aplicação permite ao usuário gerenciar suas rotinas diárias e planos de estudo, com funcionalidades de criar, listar, atualizar e deletar tarefas.

O projeto foi construído seguindo as melhores práticas de desenvolvimento, incluindo a separação de responsabilidades (Controller, Repository), o uso de testes unitários com JUnit e Mockito, e a configuração segura de credenciais com variáveis de ambiente.

**Status do Projeto:** Concluído (Versão 1.0) ✔️

---

## 🛠️ Tecnologias Utilizadas

**Backend:**
* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (com Hibernate)
* **Maven** (Gerenciador de Dependências)

**Frontend:**
* HTML5
* CSS3
* JavaScript (Vanilla JS) com Fetch API para consumo da API REST.

**Banco de Dados:**
* **MySQL 8**

**Testes:**
* **JUnit 5**
* **Mockito**
* **Spring Boot Test** (com `@WebMvcTest` e `@SpringBootTest`)

---

## ✨ Funcionalidades

* **Criar Tarefas:** Adicionar novas tarefas com título e descrição.
* **Listar Tarefas:** Visualizar todas as tarefas pendentes.
* **Atualizar Tarefas:** Marcar tarefas como concluídas ou não.
* **Deletar Tarefas:** Remover tarefas da lista.

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

* **Java (JDK)** - Versão 17 ou superior
* **Maven** - Versão 3.6 ou superior
* **MySQL Server** - Versão 8 ou superior
* Uma IDE de sua preferência (ex: IntelliJ IDEA, VS Code)

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)[SEU-USUARIO-GITHUB]/java-spring-todolist.git
    cd java-spring-todolist
    ```

2.  **Configure o Banco de Dados:**
    * Abra o seu cliente MySQL (Workbench, DBeaver, etc.).
    * Crie um novo banco de dados (schema) chamado `todolist_db`.
        ```sql
        CREATE DATABASE IF NOT EXISTS todolist_db;
        ```
    * Garanta que você tenha um usuário e senha com permissões para acessar este banco.

3.  **Configure as Variáveis de Ambiente:**
    * Este projeto não armazena credenciais do banco de dados no código por segurança. Você precisa configurá-las no ambiente da sua IDE.
    * **No IntelliJ IDEA:**
        * Vá em `Run` -> `Edit Configurations...`.
        * Selecione sua `TodolistApplication`.
        * Em "Environment variables", adicione as seguintes variáveis:
            * `DB_USERNAME=seu_usuario_mysql` (ex: `root`)
            * `DB_PASSWORD=sua_senha_mysql` (ex: `1234`)

4.  **Execute o Backend:**
    * Você pode rodar a aplicação pela sua IDE (recomendado) ou pelo terminal.
    * Pelo terminal, na raiz do projeto, execute:
        ```bash
        ./mvnw spring-boot:run
        ```
    * O servidor backend estará rodando em `http://localhost:8080`.

5.  **Acesse o Frontend:**
    * Navegue até a pasta `src/main/resources/static`.
    * Abra o arquivo `index.html` diretamente no seu navegador.

---

## API Endpoints

A API REST segue os seguintes padrões:

| Método | Endpoint           | Descrição                       | Exemplo de Corpo (Body)                                     |
| :----- | :----------------- | :------------------------------ | :---------------------------------------------------------- |
| `GET`  | `/api/tasks`       | Retorna a lista de todas as tarefas. | N/A                                                         |
| `POST` | `/api/tasks`       | Cria uma nova tarefa.             | `{"title": "Nova Tarefa", "description": "Descrição"}`      |
| `PUT`  | `/api/tasks/{id}`  | Atualiza uma tarefa existente.    | `{"title": "Título Atualizado", "description": "...", "completed": true}` |
| `DELETE` | `/api/tasks/{id}`| Deleta uma tarefa pelo seu ID.    | N/A                                                         |
---
