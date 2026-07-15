# 📚 Library API

Este projeto é uma API desenvolvida para o gerenciamento de uma biblioteca, focada no aprendizado e aplicação prática de **Spring Data JPA** e **Spring Boot**.

## 🚀 Tecnologias Utilizadas

* **Java 21+**
* **Spring Boot 3.x**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **Docker**
* **Lombok**
* **JUnit 5**

## 🐳 Infraestrutura com Docker

Para subir o banco de dados, utilize o comando abaixo na raiz do projeto:

`docker run --name library-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=library -p 5432:5432 -d postgres`

## 🧠 Modelo de Domínio (JPA)

* **Identificação Universal:** Utilização de `UUID` para chaves primárias.
* **Relacionamentos:** Mapeamento bidirecional entre **Autor** e **Livro** com `FetchType.LAZY`.
* **Cascata:** Configuração `CascadeType.ALL` em `Autor` para gerenciar o ciclo de vida dos livros.
* **Enumerações:** Uso de `@Enumerated(EnumType.STRING)` para persistir gêneros como texto.

## ⚖️ Gerenciamento de Transações

* **Dirty Checking:** O Hibernate detecta automaticamente alterações em entidades gerenciadas, dispensando `.save()` manual.
* **Atomicidade:** Uso da anotação `@Transactional` para garantir operações seguras com *rollback* automático.

## 🛠️ Principais Funcionalidades

* **Consultas Customizadas:** Uso de `@Query` (JPQL e SQL Nativo).
* **Gestão de Estado:** Testes automatizados no *Persistence Context*.
* **CRUD Completo:** Manipulação segura de autores e livros.

## ⚙️ Como executar

1. **Clone o repositório:**
   `git clone https://github.com/GabrielPCdS/libraryapi.git`

2. **Inicie o banco (Docker):**
   Execute o comando de `docker run` citado na seção de infraestrutura.

3. **Execução:**
   `./mvnw spring-boot:run`
