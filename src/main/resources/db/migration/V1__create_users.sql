-- V1__create_users.sql


CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    rodne_cislo VARCHAR(20) NOT NULL UNIQUE
    );


INSERT INTO users (name, surname, rodne_cislo) VALUES
                                                   ('Anna', 'Nováková', '015101/1234'),
                                                   ('Petr',  'Svoboda',  '991231/5678'),
                                                   ('Julie', 'Skopová',  '035512/0007');
