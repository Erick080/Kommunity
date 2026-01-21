Para rodar localmente:
* Iniciar primeiro o BD: ``docker compose --env-file [nome do arquivo .env] up -d postgres``
* Depois iniciar o Spring Boot: ``./mvnw spring-boot:run``