DROP DATABASE IF EXISTS mercaDaw;
CREATE DATABASE mercaDaw;
USE mercaDaw;


CREATE TABLE TipoProducto (
                              id_tipo INT PRIMARY KEY AUTO_INCREMENT,
                              nombre_tipo VARCHAR(50)
);

CREATE TABLE Producto (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          referencia VARCHAR(15) NOT NULL,
                          nombre VARCHAR(50) NOT NULL,
                          descripcion VARCHAR(100),
                          id_tipo INT,
                          cantidad INT DEFAULT 0,
                          precio DECIMAL(10,2),
                          descuento INT,
                          iva INT,
                          aplicar_dto BOOLEAN,

                          CONSTRAINT fk_tipo FOREIGN KEY (id_tipo) REFERENCES TipoProducto(id_tipo)
);