CREATE DATABASE IF NOT EXISTS proyectoLibre;
USE proyectoLibre;

CREATE TABLE IF NOT EXISTS peliculas (
                                         id INT PRIMARY KEY,
                                         titulo VARCHAR(255) NOT NULL,
    duracion INT,
    genero VARCHAR(100)
    );

