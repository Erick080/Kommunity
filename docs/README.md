# Kommunity - Backend

Backend de uma plataforma de eventos sociais inspirada em soluções como Sympla, desenvolvida com Spring Boot.

A aplicação permite cadastro de usuários, criação e gerenciamento de eventos e integração com banco de dados relacional. O projeto foi containerizado com Docker para facilitar a execução e o deploy.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Docker
- Maven

---

## 📌 Visão Geral da Aplicação

O sistema foi desenvolvido seguindo uma arquitetura RESTful, utilizando boas práticas como:

- Separação em camadas (Controller, Service, Repository)
- Uso de DTOs para transporte de dados
- Persistência com JPA/Hibernate
- Criptografia de senhas com BCrypt
- Configuração de CORS
- Containerização com Docker
- Autenticação com JWT
- Documentação de endpoints com Swagger

---

## 👤 Funcionalidades

### Usuários
- Cadastro de usuário
- Criptografia de senha no banco
- Autenticação

### Eventos
- Criação de eventos
- Listagem de eventos
- Consulta de evento

Todos endpoints da aplicação são documentados pelo swagger e podem ser conferidos em ```<URI_DA_APLICACAO>/swagger-ui.html```.

---

## 🗄️ Banco de Dados

- Banco: PostgreSQL
- Mapeamento via JPA/Hibernate

---

## 🐳 Execução de Deploy


```bash
docker-compose up --build
```

## Execução Local
* Iniciar primeiro o BD: ``docker compose --env-file [nome do arquivo .env] up -d postgres``
* Depois iniciar o Spring Boot: ``./mvnw spring-boot:run``
