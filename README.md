# 📚 Projeto Biblioteca: Livros & Empréstimos

## 📝 Descrição

API RESTful para o gerenciamento de uma biblioteca, permitindo o cadastro de livros e usuários, e o controle de empréstimos e devoluções.

## ✨ Funcionalidades

- Cadastro, consulta, atualização e exclusão (lógica) de livros.
- Cadastro e consulta de usuários.
- Sistema de empréstimo de livros para usuários.
- Registro de devoluções.
- Validação de regras de negócio, como disponibilidade de estoque e cálculo de multas.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA (Hibernate)
- **Banco de Dados:** H2 (para desenvolvimento) / PostgreSQL (para produção)
- **Build:** Maven

## 🗃️ Modelo de Dados

O sistema é composto por três entidades principais:

#### 1\. `Livro`

| Atributo | Tipo    | Restrições        | Descrição                             |
| :------- | :------ | :---------------- | :------------------------------------ |
| `id`     | Long    | PK (Primary Key)  | Identificador único do livro.         |
| `isbn`   | String  | UNIQUE, NOT NULL  | ISBN do livro (13 caracteres).        |
| `titulo` | String  | NOT NULL          | Título do livro.                      |
| `autor`  | String  | NOT NULL          | Autor do livro.                       |
| `estoque`| Integer | \>= 0              | Quantidade de exemplares disponíveis. |
| `ativo`  | Boolean | NOT NULL          | Indica se o livro está ativo (pode ser emprestado). |

#### 2\. `Usuario`

| Atributo | Tipo   | Restrições       | Descrição                      |
| :------- | :----- | :--------------- | :----------------------------- |
| `id`     | Long   | PK (Primary Key) | Identificador único do usuário.|
| `nome`   | String | NOT NULL         | Nome do usuário.               |
| `email`  | String | UNIQUE, NOT NULL | E-mail do usuário (254 chars). |

#### 3\. `Emprestimo`

| Atributo           | Tipo          | Restrições               | Descrição                               |
| :----------------- | :------------ | :----------------------- | :-------------------------------------- |
| `id`               | Long          | PK (Primary Key)         | Identificador único do empréstimo.      |
| `livro_id`         | Long          | FK (Foreign Key), NOT NULL | ID do livro emprestado.                 |
| `usuario_id`       | Long          | FK (Foreign Key), NOT NULL | ID do usuário que pegou o empréstimo.   |
| `retirado_em`      | LocalDateTime | NOT NULL                 | Data e hora da retirada do livro.       |
| `devolucao_prevista`| LocalDateTime | NOT NULL                 | Data e hora prevista para devolução.    |
| `devolvido_em`     | LocalDateTime | NULL                     | Data e hora da devolução efetiva.       |

## Regra de Negócio

1.  **Estoque Mínimo:** Um empréstimo só pode ser realizado se o `estoque` do livro for maior que zero.
2.  **Controle de Estoque:** Ao realizar um empréstimo, o `estoque` do livro é decrementado (`--`). Ao registrar uma devolução, o estoque é incrementado (`++`).
3.  **Prazo de Devolução:** A data `devolucao_prevista` é calculada como a data de retirada (`retirado_em`) mais 7 dias.
4.  **Empréstimo Único:** Um usuário não pode ter mais de um empréstimo ativo para o mesmo livro simultaneamente.
5.  **ISBN Obrigatório:** O campo `isbn` é obrigatório e único para cada livro.
6.  **Registro de Devolução:** Para concluir uma devolução, o campo `devolvido_em` deve ser preenchido com a data/hora atual.
7.  **Livros Inativos:** Livros com o status `ativo = false` não podem ser emprestados.
8.  **Cálculo de Multa:** Se `devolvido_em` for posterior a `devolucao_prevista`, será aplicada uma multa de R$ 2,00 por dia de atraso.
9.  **Consultas Específicas:** A API deve prover uma forma de listar todos os livros atualmente emprestados, informando qual usuário está com cada livro.

## ⚙️ API Endpoints

A seguir, a documentação dos endpoints da API.

-----

### Livros (`/livros`)

- **`POST /livros`**

    - **Descrição:** Cadastra um novo livro no sistema.
    - **Request Body:**
      ```json
      {
        "isbn": "978-85-333-0227-3",
        "titulo": "O Senhor dos Anéis",
        "autor": "J.R.R. Tolkien",
        "estoque": 10
      }
      ```

- **`GET /livros`**

    - **Descrição:** Lista todos os livros ativos. Permite filtrar por título.
    - **Query Param (Opcional):** `?titulo=Senhor`
    - **Resposta (Sucesso):** `200 OK`

- **`PUT /livros/{id}`**

    - **Descrição:** Atualiza os dados de um livro existente.
    - **Path Param:** `id` (ID do livro)
    - **Request Body:** Similar ao `POST`.

- **`DELETE /livros/{id}`**

    - **Descrição:** Realiza a exclusão lógica de um livro, alterando seu status para `ativo = false`.
    - **Path Param:** `id` (ID do livro)
    - **Resposta (Sucesso):** `204 No Content`

-----

### Usuários (`/usuarios`)

- **`POST /usuarios`**
    - **Descrição:** Cadastra um novo usuário.
    - **Request Body:**
      ```json
      {
        "nome": "Aragorn",
        "email": "aragorn@terra-media.com"
      }
      ```

-----

### Empréstimos (`/emprestimos`)

- **`POST /emprestimos`**

    - **Descrição:** Cria um novo empréstimo, aplicando as regras de negócio.
    - **Request Body:**
      ```json
      {
        "livroId": 1,
        "usuarioId": 1
      }
      ```
    - **Resposta (Sucesso):** `201 Created` com os detalhes do empréstimo.

- **`GET /emprestimos`**

    - **Descrição:** Lista todos os empréstimos. Permite filtrar por ID do usuário.
    - **Query Param (Opcional):** `?usuarioId=1`

- **`PUT /emprestimos/{id}`**

    - **Descrição:** Registra a devolução de um livro, finalizando o empréstimo.
    - **Path Param:** `id` (ID do empréstimo)
    - **Resposta (Sucesso):** `200 OK` com os detalhes do empréstimo atualizado (incluindo `devolvido_em` e possível multa).

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:**

    - Java JDK 17 ou superior.
    - Maven 3.8 ou superior.
    - Git.

2.  **Clone o repositório:**

    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio
    ```

3.  **Compile o projeto:**

    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.