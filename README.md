# 📚 🎉 Spring Boot 3: API Rest em Java
## Visão Geral
Este projeto é uma aplicação Spring Boot para gestão de consultas de uma clínica médica fictícia chamada Voll.med. A aplicação permite a realização de operações básicas de CRUD (Create, Read, Update, Delete) utilizando Spring Data JPA, com suporte para requisições RESTful, realizado paginação e ordenação de dados.

Abaixo estão os principais tópicos abordados e as tecnologias utilizadas:

## 📍 Criação do Projeto
Durante o desenvolvimento deste projeto, os seguintes tópicos e tecnologias foram abordados:
- **Criação do Projeto com Spring Initializr:** Configuração inicial do projeto utilizando [Spring Initializr](https://start.spring.io/), com as dependências necessárias para o desenvolvimento da API.
- **Spring Boot Framework:** Desenvolvimento de uma aplicação Java com Spring Boot, aproveitando suas funcionalidades para criar uma API RESTful robusta.
- **Desenvolvimento de API REST:**
  - **Criação de Controllers:** Implementação dos endpoints da API utilizando as anotações @RestController, @RequestMapping, @GetMapping, @PostMapping, @PutMapping, e @DeleteMapping.
  - **Mapeamento de URLs:** Utilização de @RequestMapping e outras anotações para definir as rotas e métodos HTTP correspondentes.
- **Mapeamento de Entidades JPA:**
  - **Definição de Entidades:** Criação de classes de entidades representando as tabelas do banco de dados.
  - **Validação de Dados:** Uso de Bean Validation (@NotBlank, @Size, etc.) para garantir a integridade dos dados.
- **DTO (Data Transfer Object):**
  - **Java Records:** Utilização de Java Records para definir DTOs que simplificam a transferência de dados entre a camada de controle e a de persistência.
- **Repositórios JPA:**
  - **Criação de Interfaces Repository:** Extensão da interface JpaRepository para fornecer métodos de acesso e manipulação de dados.
- **Módulos do Spring Boot:**
  - **Spring Web:** Para construção da API REST.
  - **Spring Data JPA:** Para mapeamento objeto-relacional e persistência de dados.
  - **Spring Validation:** Para validação de dados nas requisições.
- **Migrations com Flyway:** Configuração e execução de migrations de banco de dados usando Flyway, garantindo versionamento e consistência das mudanças no esquema do banco de dados.
- **Banco de Dados PostgreSQL:** Integração com o PostgreSQL para persistência de dados.
- **Lombok:** Utilização de anotações do Lombok (@Getter, @NoArgsConstructor, @AllArgsConstructor, etc.) para reduzir a verbosidade do código.

---

## ⚙️ Funcionalidades

O projeto inclui as seguintes funcionalidades:

- [x] CRUD de Médicos: Endpoints para criação, leitura, atualização e exclusão (lógica) de registros de médicos.
- [x] CRUD de Pacientes: Endpoints para criação, leitura, atualização e exclusão (lógica) de registros de pacientes.

---

## 🛠 Tecnologias Utilizadas

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java):** Linguagem de programação utilizada para desenvolver a aplicação.
- **[Spring Boot 3](https://spring.io/projects/spring-boot):** Framework principal para construção da API REST.
- **[Maven](https://maven.apache.org):** Ferramenta de automação de build e gerenciamento de dependências.
- **[Postgresql](https://www.postgresql.org/):** Banco de dados relacional utilizado para persistência de dados.
- **[Hibernate](https://hibernate.org):** Framework de mapeamento objeto-relacional (ORM) utilizado em conjunto com Spring Data JPA.
- **[Flyway](https://flywaydb.org):**  Ferramenta de migração de banco de dados para controle de versão do esquema de banco de dados.
- **[Lombok](https://projectlombok.org):** Biblioteca para simplificação do código Java, reduzindo a necessidade de código boilerplate.

---

## 🚀 Como Executar o Projeto
1. Clone o Repositório:
```bash
git clone https://github.com/leidyAguiar/API-Rest-Java.git
```
2. Entre no Diretório do Projeto, use no terminal o comando abaixo:
```bash
cd <nome-do-diretório>
```
3. Configure o Banco de Dados:
    * Certifique-se de que o PostgreSQL está instalado e em execução.
    * Crie um banco de dados para o projeto e configure as credenciais no arquivo application.yml
    * As migrations do Flyway serão executadas automaticamente na inicialização do projeto.

Por padrão, a aplicação é iniciada em http://localhost:8080/

---

### 👩🏻‍💻 Leidiane Aguiar

### [![LinkedIn](https://img.icons8.com/color/48/linkedin.png)](https://www.linkedin.com/in/leidianeaguiar/)

Projeto desenvolvido durante o curso **Spring Boot 3: desenvolva uma API Rest em Java** na [Alura](https://www.alura.com.br)

Professor: [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira)

---