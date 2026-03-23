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

INSERT INTO TipoProducto (nombre_tipo) VALUES 
('Lácteos'),
('Carnicería'),
('Bebidas'),
('Limpieza'),
('Fruta y Verdura');

INSERT INTO Producto (referencia, nombre, descripcion, id_tipo, cantidad, precio, descuento, iva, aplicar_dto) 
VALUES 
('L001', 'Leche Entera 1L', 'Pack de 6 bricks de leche entera', 1, 50, 6.50, 10, 4, 1),
('C052', 'Pechuga de Pollo', 'Bandeja de 500g de pechuga de pollo corral', 2, 20, 4.95, 0, 4, 0),
('B007', 'Refresco Cola 2L', 'Botella de refresco de cola con gas', 3, 100, 1.80, 5, 21, 1),
('H021', 'Detergente Líquido', 'Detergente para lavadora 40 lavados', 4, 15, 8.99, 15, 21, 1),
('F009', 'Plátano de Canarias', 'Bolsa de 1kg de plátanos', 5, 30, 2.10, 0, 4, 0),
('B012', 'Agua Mineral 1.5L', 'Botella de agua mineral natural', 3, 200, 0.55, 0, 10, 0);