CREATE DATABASE IF NOT EXISTS proyectoLibre;
USE proyectoLibre;

-- 1. TABLA PELICULAS
CREATE TABLE IF NOT EXISTS peliculas (
    id INT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    duracion INT,
    genero VARCHAR(100)
);

-- 2. TABLA USUARIOS
CREATE TABLE IF NOT EXISTS usuarios (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- 3. TABLA SALAS 
CREATE TABLE IF NOT EXISTS salas (
    id INT PRIMARY KEY,
    filas INT NOT NULL,
    columnas INT NOT NULL
);

-- 4. TABLA SESIONES 
CREATE TABLE IF NOT EXISTS sesiones (
    id INT PRIMARY KEY,
    id_pelicula INT,
    id_sala INT,
    hora VARCHAR(10) NOT NULL,
    CONSTRAINT fk_sesion_pelicula FOREIGN KEY (id_pelicula) REFERENCES peliculas(id) ON DELETE CASCADE,
    CONSTRAINT fk_sesion_sala FOREIGN KEY (id_sala) REFERENCES salas(id) ON DELETE CASCADE
);

-- 5. TABLA VENTAS 
CREATE TABLE IF NOT EXISTS ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_sesion INT NOT NULL,
    fila INT NOT NULL,
    columna INT NOT NULL,
    precio_final DOUBLE NOT NULL,
    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_venta_sesion FOREIGN KEY (id_sesion) REFERENCES sesiones(id) ON DELETE CASCADE
);

