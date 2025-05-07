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
#### 3. Abra o SQL Shell que é instalado junto com o PostgreSQL.
#### 4. Pressione Enter na opção Server [localhost].
#### 5. Digite o nome da sua database criada anteriormente e pressione enter.
#### 6. Pressione Enter na opção Port [5432] (É a porta padrão geralmente utilizada, caso a sua não seja, digite sua porta).
#### 7. Digite seu usuário do pgAdmin e pressione Enter.
#### 8. Digite sua senha e pressione Enter. (É normal não aparecer nada, o shell vai avisar caso algo dê errado)
#### 9. Copie e cole o comando = \i 'C:\\Users\\seu-usuario\\sistema-pesquisa\\database\\dumpbanco' (Substitua o caminho exemplo pelo caminho onde está o seu arquivo .sql da database)
#### 10. Digite \q e pressione Enter duas vezes. (O terminal deve fechar)
#### 11. Abra o projeto na IDE desejada. (recomendado Apache NetBeans 25)
#### 12. Modifique dentro do arquivo Conexao.java as variáveis user e senha para o usuário e senha do seu banco no pgAdmin.
#### 13. Ainda no Conexao.java, modifique o final da url para o nome da sua database. Exemplo: "jdbc:postgresql://localhost:5432/minha-database"
#### 14. Baixe o driver postgresql-42.7.4.jar no link https://jdbc.postgresql.org/download/postgresql-42.7.4.jar
#### 15. Insira o driver como um Classpath. (No NetBeans, se encontra em Propriedades do projeto -> Bibliotecas)
#### 16. Salve e execute a classe Principal.java para começar a utilizar.
