-- Limpa os dados existentes
DELETE FROM events;

-- Insere eventos de teste
INSERT INTO events (name, date, place, description) VALUES
('Spring Boot Meetup', '2026-02-10 19:00:00', 'São Paulo', 'Meetup sobre Spring Boot e boas práticas'),
('PostgreSQL Workshop', '2026-02-15 09:00:00', 'Campinas', 'Workshop prático de PostgreSQL'),
('Hackathon Universitário', '2026-03-01 08:00:00', 'São Carlos', 'Hackathon de 24h com foco em inovação'),
('Conferência Java', '2026-03-10 10:00:00', 'Rio de Janeiro', 'Conferência nacional sobre Java'),
('DevOps Day', '2026-03-20 09:00:00', 'Belo Horizonte', 'Evento sobre CI/CD e automação'),
('AI Summit', '2026-04-05 14:00:00', 'São Paulo', 'Discussões sobre IA generativa'),
('Cloud Expo', '2026-04-18 10:00:00', 'Curitiba', 'Evento sobre computação em nuvem'),
('Tech Talk: Microservices', '2026-05-02 19:30:00', 'Florianópolis', 'Palestra sobre arquitetura de microsserviços'),
('Open Source Festival', '2026-05-15 11:00:00', 'Porto Alegre', 'Festival de projetos open source'),
('Backend Engineering Meetup', '2026-06-01 18:00:00', 'São Paulo', 'Discussões avançadas sobre backend')
;
