CREATE DATABASE IF NOT EXISTS Tienda;

USE Tienda;

CREATE TABLE IF NOT EXISTS CLIENTE (
	codigo INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, 
    apellidos VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS PRODUCTO (
	codigo CHAR(10) PRIMARY KEY, 
    nombre VARCHAR(100) NOT NULL, 
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL, 
    stock INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS CARRITO (
	codigo INT AUTO_INCREMENT PRIMARY KEY,
    codigoCliente INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_carrito_cliente FOREIGN KEY (codigoCliente)
		REFERENCES CLIENTE(codigo)
);

CREATE TABLE IF NOT EXISTS ITEMCARRITO (
	codigoCarrito INT NOT NULL, 
    codigoProducto CHAR(10) NOT NULL, 
    cantidad INT NOT NULL, 
    precio DECIMAL(10, 2) NOT NULL,
    
    PRIMARY KEY (codigoCarrito, codigoProducto),
    CONSTRAINT fk_itemcarrito_carrito FOREIGN KEY (codigoCarrito) 
        REFERENCES CARRITO(codigo),
    CONSTRAINT fk_itemcarrito_producto FOREIGN KEY (codigoProducto) 
        REFERENCES PRODUCTO(codigo)
);

CREATE TABLE IF NOT EXISTS ORDEN (
	codigo INT NOT NULL PRIMARY KEY, 
    codigoCarrito INT NOT NULL, 
    fecha DATETIME NOT NULL, 
    subTotal DECIMAL(10, 2) NOT NULL, 
    total DECIMAL(10, 2) NOT NULL, 
    
	CONSTRAINT fk_orden_carrito FOREIGN KEY (codigoCarrito)
		REFERENCES CARRITO(codigo)
);

CREATE TABLE IF NOT EXISTS ITEMORDEN (
	codigoOrden INT NOT NULL, 
    codigoProducto CHAR(10) NOT NULL, 
    cantidad INT NOT NULL, 
    precio DECIMAL(10, 2), 
    
	PRIMARY KEY (codigoOrden, codigoProducto),
    CONSTRAINT fk_itemorden_orden FOREIGN KEY (codigoOrden)
		REFERENCES ORDEN(codigo)
);

INSERT INTO CLIENTE (codigo, nombre, apellidos) VALUES
(10000001, 'Juan', 'Pérez López'),
(10000002, 'María', 'González Rodríguez'),
(10000003, 'Carlos', 'Martínez Sánchez'),
(10000004, 'Ana', 'Hernández Fernández'),
(10000005, 'Pedro', 'Díaz Ramírez');

INSERT INTO PRODUCTO (codigo, nombre, descripcion, precio, stock) VALUES
('PROD000001', 'Laptop ASUS X515', 'Laptop con procesador Intel Core i5, 8GB RAM y 512GB SSD', 799.99, 15),
('PROD000002', 'Samsung Galaxy S23', 'Teléfono inteligente con 128GB de almacenamiento, 8GB RAM y cámara de 50MP', 999.99, 10),
('PROD000003', 'Auriculares Sony WH-1000XM5', 'Auriculares inalámbricos con cancelación de ruido y sonido de alta fidelidad', 349.99, 20),
('PROD000004', 'Apple iPad Air', 'Tableta de 10.9 pulgadas, pantalla Liquid Retina, 64GB de almacenamiento y WiFi', 599.99, 12),
('PROD000005', 'Mouse Inalámbrico Logitech MX Master 3', 'Ratón ergonómico de alto rendimiento con precisión y control avanzado', 99.99, 25),
('PROD000006', 'Monitor Dell Ultrasharp U2723QE', 'Monitor 4K UHD de 27 pulgadas, tecnología IPS y conectividad USB-C', 679.99, 8),
('PROD000007', 'Apple MacBook Pro M2', 'Portátil de 14 pulgadas con chip M2, 16GB RAM y 512GB SSD', 1999.99, 5),
('PROD000008', 'Google Pixel 7 Pro', 'Teléfono inteligente con pantalla OLED de 6.7 pulgadas y cámara de 50MP', 899.99, 10),
('PROD000009', 'Bocina Bose SoundLink Revolve+', 'Bocina Bluetooth portátil con sonido envolvente y resistencia al agua', 249.99, 18),
('PROD000010', 'Microsoft Surface Pro 9', 'Tableta convertible de 13 pulgadas con procesador Intel i7 y 16GB RAM', 1399.99, 7),
('PROD000011', 'Disco Duro Samsung 980 Pro 1TB', 'Unidad SSD NVMe PCIe 4.0 con velocidad de lectura de 7000MB/s', 169.99, 30),
('PROD000012', 'Cámara Canon EOS R6', 'Cámara mirrorless de fotograma completo con video 4K y sensor de 20MP', 2499.99, 6),
('PROD000013', 'Teclado Mecánico Razer BlackWidow V4', 'Teclado gaming con retroiluminación RGB y switches mecánicos verdes', 179.99, 15),
('PROD000014', 'Consola Nintendo Switch OLED', 'Consola portátil con pantalla OLED de 7 pulgadas y almacenamiento de 64GB', 349.99, 22),
('PROD000015', 'Cámara Deportiva GoPro Hero 11 Black', 'Cámara resistente al agua con grabación en 5.3K y fotos de 27MP', 499.99, 12),
('PROD000016', 'Televisor LG OLED C2 55 pulgadas', 'Televisor 4K Smart TV con Dolby Vision, HDR y tasa de refresco de 120Hz', 1499.99, 8),
('PROD000017', 'Memoria RAM Corsair Vengeance RGB 32GB', 'Memoria DDR5 de 6000MHz con iluminación RGB y baja latencia', 189.99, 14),
('PROD000018', 'Sony PlayStation 5', 'Consola de videojuegos de última generación con gráficos en 4K y SSD ultra rápido', 499.99, 20),
('PROD000019', 'Apple Watch Series 9', 'Reloj inteligente de 45mm con pantalla Retina siempre encendida y GPS', 429.99, 17),
('PROD000020', 'Purificador de Aire Xiaomi Mi Smart 4 Pro', 'Purificador de aire con filtro HEPA y monitoreo en tiempo real', 229.99, 10);
