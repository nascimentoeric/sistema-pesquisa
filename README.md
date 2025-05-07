# Sistema de Gerenciamento de Pesquisas Acadêmicas

Este projeto é uma aplicação Java de console para gerenciamento de pesquisas acadêmicas. 
Utiliza **JDBC** para se conectar a um banco de dados **PostgreSQL**.

---

## 📦 Funcionalidades

- Cadastrar, listar, alterar e remover:
  - Pesquisadores
  - Instituições
  - Orientandos
  - Projetos
  - Publicações
  - Financiamentos

- Consultas úteis:
  - Publicações por projeto e pesquisador
  - Projetos financiados por instituições

---

## ⚙️ Tecnologias usadas

- Java 17+
- PostgreSQL
- JDBC
- NetBeans (ou outro IDE compatível)

---

## 🛠️ Como instalar e executar

#### 1. Clone o repositório para um repositório seu local.
#### 2. Crie uma database no pgAdmin com o nome desejado, definindo uma senha.
#### 3. Abra a pasta 'database' do projeto, e então abra um dos backups com um editor de texto.
#### 4. Copie e cole o texto do backup na Query Tool do pgAdmin dentro da database criada.
#### 5. Execute o script selecionando tudo. (CTRL + A -> F5)
#### 6. Abra o projeto na IDE desejada. (recomendado Apache NetBeans 25)
#### 7. Modifique dentro do arquivo Conexao.java as variáveis user e senha para o usuário e senha do seu banco no pgAdmin.
#### 8. Ainda no Conexao.java, modifique o final da url para o nome da sua database. Exemplo: "jdbc:postgresql://localhost:5432/minha-database"
#### 9. Baixe o driver postgresql-42.7.4.jar no link https://jdbc.postgresql.org/download/postgresql-42.7.4.jar
#### 10. Insira o driver como um Classpath. (No NetBeans, se encontra em Propriedades do projeto -> Bibliotecas)
#### 11. Salve e execute a classe Principal.java para começar a utilizar.
