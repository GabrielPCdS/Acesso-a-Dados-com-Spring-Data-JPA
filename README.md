📚 Library API
Este projeto é uma API desenvolvida para o gerenciamento de uma biblioteca, focada no aprendizado e aplicação prática de Spring Data JPA e Spring Boot. O foco central do desenvolvimento foi a exploração profunda do ciclo de vida das entidades, gerenciamento de transações e manipulação de consultas avançadas.

🚀 Tecnologias Utilizadas
Java 21+

Spring Boot 3.x

Spring Data JPA (Hibernate)

PostgreSQL

Docker (Containerização do banco)

Lombok

JUnit 5

🐳 Infraestrutura com Docker
Para facilitar o desenvolvimento, o banco de dados PostgreSQL é gerenciado via Docker. Isso garante que você não precise instalar o banco diretamente no seu sistema operacional.

Como subir o banco de dados:
Certifique-se de ter o Docker instalado e rodando em sua máquina, depois execute na raiz do projeto:

Bash
# Subir o container do banco de dados
docker run --name library-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=library -p 5432:5432 -d postgres
Host: localhost

Porta: 5432

Usuário/Senha: postgres / postgres

🧠 Modelo de Domínio (JPA)
A estrutura das entidades foi desenhada priorizando a performance e a integridade dos dados:

Identificação Universal: Utilização de UUID (gerado via GenerationType.UUID) para chaves primárias, garantindo escalabilidade e segurança.

Relacionamentos:

Autor (1) ↔ (N) Livro: Mapeamento bidirecional. O relacionamento utiliza FetchType.LAZY para evitar o carregamento desnecessário de objetos em memória.

Cascata: Configuração CascadeType.ALL em Autor, facilitando a gestão do ciclo de vida dos livros associados.

Enumerações: Uso de @Enumerated(EnumType.STRING) para garantir que gêneros literários sejam persistidos como texto no banco de dados.

⚖️ Gerenciamento de Transações
O módulo de transações explora os conceitos de Atomicidade e Consistência do banco de dados:

Dirty Checking: Demonstração de como o Hibernate detecta automaticamente alterações em entidades gerenciadas (Managed), permitindo atualizações de estado sem a necessidade de chamadas explícitas ao .save().

Atomicidade: Uso da anotação @Transactional para garantir que operações complexas sejam atômicas (com rollback automático em caso de falha).

🛠️ Principais Funcionalidades Implementadas
Consultas Customizadas: Uso de @Query (JPQL e SQL Nativo) para otimizar consultas específicas.

Gestão de Estado: Testes automatizados focados no comportamento do Persistence Context.

CRUD Completo: Manipulação segura de autores e livros.

⚙️ Como executar
Clone o repositório:

Bash
git clone https://github.com/GabrielPCdS/libraryapi.git
Inicie o banco (Docker):
Siga as instruções da seção Infraestrutura com Docker.

Execução:

Bash
./mvnw spring-boot:run
