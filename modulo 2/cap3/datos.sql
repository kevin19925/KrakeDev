---------------------************************1
-- Insertar datos en la tabla "usuario"
INSERT INTO usuario (cedula, nombre, apellido, tipo_cuenta, limite_credito)
VALUES
  ('1111111111', 'Juan', 'Pérez', 'Ahorros', 1500.00),
  ('2222222222', 'María', 'González', 'Corriente', 2000.00),
  ('3333333333', 'Luis', 'Martínez', 'Ahorros', 1000.00),
  ('4444444444', 'Ana', 'López', 'Corriente', 2500.00),
  ('5555555555', 'Carlos', 'Gómez', 'Ahorros', 1200.00),
  ('6666666666', 'Sofía', 'Ramírez', 'Corriente', 1800.00),
  ('7777777777', 'Pedro', 'Hernández', 'Ahorros', 900.00),
  ('8888888888', 'Laura', 'Torres', 'Corriente', 2200.00),
  ('9999999999', 'Javier', 'Sánchez', 'Ahorros', 1100.00),
  ('1010101010', 'Marta', 'Díaz', 'Corriente', 2600.00);

-- Insertar datos en la tabla "cuentas"
INSERT INTO cuentas (numero_cuenta, cedula, fecha_creacion, saldo)
VALUES
  ('C001', '1111111111', '2023-01-15', 1500.00),
  ('C002', '2222222222', '2023-02-20', 2000.00),
  ('C003', '3333333333', '2023-03-25', 1000.00),
  ('C004', '4444444444', '2023-04-10', 2500.00),
  ('C005', '5555555555', '2023-05-12', 1200.00),
  ('C006', '6666666666', '2023-06-08', 1800.00),
  ('C007', '7777777777', '2023-07-30', 900.00),
  ('C008', '8888888888', '2023-08-05', 2200.00),
  ('C009', '9999999999', '2023-09-17', 1100.00),
  ('C010', '1010101010', '2023-10-21', 2600.00);
  
  ----------------------*********************2
  INSERT INTO clientes (cedula, nombre, apellido)
VALUES
  ('1212121212', 'Cliente1', 'Apellido1'),
  ('1313131313', 'Cliente2', 'Apellido2'),
  ('1414141414', 'Cliente3', 'Apellido3'),
  ('1515151515', 'Cliente4', 'Apellido4'),
  ('1616161616', 'Cliente5', 'Apellido5'),
  ('1717171717', 'Cliente6', 'Apellido6'),
  ('1818181818', 'Cliente7', 'Apellido7'),
  ('1919191919', 'Cliente8', 'Apellido8'),
  ('2020202020', 'Cliente9', 'Apellido9'),
  ('2121212121', 'Cliente10', 'Apellido10');

-- Insertar datos en la tabla "compras"
INSERT INTO compras (id_compra, fecha_compra, monto, cedula)
VALUES
  (11, '2023-02-15', 100.00, '1212121212'),
  (2, '2023-02-15', 75.50, '1313131313'),
  (3, '2023-03-10', 50.25, '1414141414'),
  (4, '2023-04-05', 120.80, '1515151515'),
  (5, '2023-05-25', 90.00, '1616161616'),
  (6, '2023-06-20', 30.75, '1717171717'),
  (7, '2023-07-15', 65.40, '1818181818'),
  (8, '2023-08-10', 110.00, '1919191919'),
  (9, '2023-09-05', 40.20, '2020202020'),
  (10, '2023-10-30', 85.60, '2121212121');
  
  ----------------------*********************3
  
  -- Tabla "productos"
INSERT INTO productos (codigo, nombre, descripcion, precio, stock)
VALUES
  ('P001', 'Zapatos Deportivos Nike', 'Zapatos deportivos de alta calidad', 129.99, 50),
  ('P002', 'Portátil Dell XPS 13', 'Portátil ultradelgado con pantalla táctil', 1399.99, 10),
  ('P003', 'Camiseta de Algodón Puma', 'Camiseta cómoda de algodón', 19.99, 100),
  ('P004', 'Bolso de Cuero Louis Vuitton', 'Bolso de cuero de diseñador', 999.99, 30),
  ('P005', 'Auriculares Inalámbricos Sony', 'Auriculares con cancelación de ruido', 199.99, 20),
  ('P006', 'Silla de Oficina Herman Miller', 'Silla ergonómica de lujo', 799.99, 5),
  ('P007', 'Smartphone iPhone 13', 'Smartphone de última generación', 1099.99, 15),
  ('P008', 'Cafetera Nespresso', 'Cafetera para café espresso', 149.99, 8),
  ('P009', 'Juego de Mesa Catan', 'Juego de estrategia para la familia', 39.99, 25),
  ('P010', 'Monitor LG 4K', 'Monitor 4K de 27 pulgadas con colores vivos', 349.99, 12);

-- Tabla "ventas"
INSERT INTO ventas (codigo_producto, fecha_venta, cantidad)
VALUES
  ('P001', '2023-01-15', 5),
  ('P002', '2023-02-20', 2),
  ('P003', '2023-03-25', 10),
  ('P004', '2023-04-10', 1),
  ('P005', '2023-05-12', 3),
  ('P006', '2023-06-08', 2),
  ('P007', '2023-07-30', 6),
  ('P008', '2023-08-05', 4),
  ('P009', '2023-09-17', 7),
  ('P010', '2023-10-21', 5);

  ----------------*************************** 4
  -- Tabla "videojuegos"
INSERT INTO videojuegos (codigo, nombre, descripcion, valoracion)
VALUES
  (1, 'The Legend of Zelda: Breath of the Wild', 'Juego de aventuras en un mundo abierto', 9),
  (2, 'Cyberpunk 2077', 'Juego de rol y acción en un futuro distópico', 7),
  (3, 'Red Dead Redemption 2', 'Juego de vaqueros en el salvaje oeste', 8),
  (4, 'The Witcher 3: Wild Hunt', 'Juego de rol de fantasía', 9),
  (5, 'Super Mario Odyssey', 'Aventura de plataformas con Mario', 9),
  (6, 'Dark Souls III', 'Juego de rol de acción desafiante', 8),
  (7, 'Minecraft', 'Juego de construcción y creatividad', 9),
  (8, 'The Last of Us Part II', 'Juego de acción y supervivencia', 9),
  (9, 'Fallout 4', 'Juego de rol en un mundo postapocalíptico', 7),
  (10, 'Persona 5', 'Juego de rol con elementos de simulación social', 8);

-- Tabla "plataformas"
INSERT INTO plataformas (id_plataforma, nombre_plataforma, codigo_videojuego)
VALUES
  (1, 'Nintendo Switch', 1),
  (2, 'PlayStation 5', 2),
  (3, 'Xbox Series X', 2),
  (4, 'PlayStation 4', 3),
  (5, 'Xbox One', 3),
  (6, 'PC', 4),
  (7, 'Nintendo Switch', 5),
  (8, 'PlayStation 4', 5),
  (9, 'PC', 6),
  (10, 'Xbox Series X', 7);

---------------------*******************5

-- Tabla "profesores"
INSERT INTO profesores (codigo, nombre)
VALUES
  (1, 'Profesor Smith'),
  (2, 'Profesora García'),
  (3, 'Profesor Johnson'),
  (4, 'Profesora Rodríguez'),
  (5, 'Profesor Lee'),
  (6, 'Profesora López'),
  (7, 'Profesor Martin'),
  (8, 'Profesora Pérez'),
  (9, 'Profesor Wilson'),
  (10, 'Profesora González');

-- Tabla "estudiantes"
INSERT INTO estudiantes (cedula, nombre, apellido, email, fecha_nacimiento, codigo_profesor)
VALUES
  ('1111111111', 'Estudiante1', 'Apellido1', 'estudiante1@example.com', '2000-01-10', 1),
  ('2222222222', 'Estudiante2', 'Apellido2', 'estudiante2@example.com', '2001-02-15', 2),
  ('3333333333', 'Estudiante3', 'Apellido3', 'estudiante3@example.com', '2002-03-20', 3),
  ('4444444444', 'Estudiante4', 'Apellido4', 'estudiante4@example.com', '2003-04-25', 4),
  ('5555555555', 'Estudiante5', 'Apellido5', 'estudiante5@example.com', '2004-05-30', 5),
  ('6666666666', 'Estudiante6', 'Apellido6', 'estudiante6@example.com', '2005-06-05', 6),
  ('7777777777', 'Estudiante7', 'Apellido7', 'estudiante7@example.com', '2006-07-10', 7),
  ('8888888888', 'Estudiante8', 'Apellido8', 'estudiante8@example.com', '2007-08-15', 8),
  ('9999999999', 'Estudiante9', 'Apellido9', 'estudiante9@example.com', '2008-09-20', 9),
  ('1010101010', 'Estudiante10', 'Apellido10', 'estudiante10@example.com', '2009-10-25', 10);

------------ **********************6

-- Tabla "empleados"
INSERT INTO empleados (codigo_empleado, nombre, fecha, hora)
VALUES
  (1, 'Empleado1', '2023-01-15', '08:00:00'),
  (2, 'Empleado2', '2023-02-20', '09:30:00'),
  (3, 'Empleado3', '2023-03-25', '10:15:00'),
  (4, 'Empleado4', '2023-04-10', '08:45:00'),
  (5, 'Empleado5', '2023-05-12', '09:00:00'),
  (6, 'Empleado6', '2023-06-08', '10:30:00'),
  (7, 'Empleado7', '2023-07-30', '08:30:00'),
  (8, 'Empleado8', '2023-08-05', '10:00:00'),
  (9, 'Empleado9', '2023-09-17', '09:15:00'),
  (10, 'Empleado10', '2023-10-21', '08:15:00');

-- Tabla "registro_entrada"
INSERT INTO registro_entrada (codigo_registro, cedula_empleado, fecha, hora, codigo_empleado)
VALUES
  (11, '1111111111', '2023-01-15', '08:00:00', 1),
  (2, '2222222222', '2023-02-20', '09:30:00', 2),
  (3, '3333333333', '2023-03-25', '10:15:00', 3),
  (4, '4444444444', '2023-04-10', '08:45:00', 4),
  (5, '5555555555', '2023-05-12', '09:00:00', 5),
  (6, '6666666666', '2023-06-08', '10:30:00', 6),
  (7, '7777777777', '2023-07-30', '08:30:00', 7),
  (8, '8888888888', '2023-08-05', '10:00:00', 8),
  (9, '9999999999', '2023-09-17', '09:15:00', 9),
  (10, '1010101010', '2023-10-21', '08:15:00', 10);
---------------------------*****************7
-- Tabla "persona"
INSERT INTO persona (cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos)
VALUES
  ('1111111111', 'Persona1', 'Apellido1', 1.75, '1980-03-15', '08:30:00', 5000.00, 2),
  ('2222222222', 'Persona2', 'Apellido2', 1.68, '1995-05-20', '09:15:00', 7000.00, 1),
  ('3333333333', 'Persona3', 'Apellido3', 1.80, '1988-11-10', '10:45:00', 3000.00, 3),
  ('4444444444', 'Persona4', 'Apellido4', 1.70, '2000-07-08', '11:30:00', 4500.00, 0),
  ('5555555555', 'Persona5', 'Apellido5', 1.72, '1993-02-12', '08:00:00', 6000.00, 2),
  ('6666666666', 'Persona6', 'Apellido6', 1.78, '1985-09-25', '12:15:00', 8000.00, 2),
  ('7777777777', 'Persona7', 'Apellido7', 1.65, '1998-04-30', '09:30:00', 3500.00, 1),
  ('8888888888', 'Persona8', 'Apellido8', 1.73, '1990-06-18', '14:00:00', 5500.00, 4),
  ('9999999999', 'Persona9', 'Apellido9', 1.76, '1983-12-05', '10:00:00', 4500.00, 3),
  ('1010101010', 'Persona10', 'Apellido10', 1.67, '1997-08-21', '13:30:00', 6500.00, 1);

-- Tabla "prestamo"
INSERT INTO prestamo (cedula, monto, fecha_prestamo, hora_prestamo, garante)
VALUES
  ('1111111111', 2000.00, '2023-01-10', '08:15:00', 'Garante1'),
  ('2222222222', 1500.00, '2023-02-15', '09:30:00', 'Garante2'),
  ('3333333333', 3000.00, '2023-03-20', '10:45:00', 'Garante3'),
  ('4444444444', 2500.00, '2023-04-25', '08:30:00', 'Garante4'),
  ('5555555555', 1800.00, '2023-05-30', '09:00:00', 'Garante5'),
  ('6666666666', 2200.00, '2023-06-05', '10:00:00', 'Garante6'),
  ('7777777777', 2800.00, '2023-07-10', '08:45:00', 'Garante7'),
  ('8888888888', 3200.00, '2023-08-15', '11:30:00', 'Garante8'),
  ('9999999999', 2100.00, '2023-09-20', '12:00:00', 'Garante9'),
  ('1010101010', 2600.00, '2023-10-25', '09:15:00', 'Garante10');
  
---------------*****************8

-- Tabla "transacciones"
INSERT INTO transacciones (codigo, numero_cuenta, monto, tipo, fecha, hora)
VALUES
  (1, 'C001', 1500.00, 'D', '2023-01-10', '08:15:00'),
  (2, 'C002', 1000.00, 'R', '2023-02-15', '09:30:00'),
  (3, 'C003', 2000.00, 'D', '2023-03-20', '10:45:00'),
  (4, 'C004', 2500.00, 'D', '2023-04-25', '08:30:00'),
  (5, 'C005', 1800.00, 'R', '2023-05-30', '09:00:00'),
  (6, 'C006', 2200.00, 'D', '2023-06-05', '10:00:00'),
  (7, 'C007', 2800.00, 'D', '2023-07-10', '08:45:00'),
  (8, 'C008', 3200.00, 'D', '2023-08-15', '11:30:00'),
  (9, 'C009', 2100.00, 'R', '2023-09-20', '12:00:00'),
  (10, 'C010', 2600.00, 'D', '2023-10-25', '09:15:00');

-- Tabla "banco"
INSERT INTO banco (codigo_banco, codigo_transaccion, detalle)
VALUES
  (1, 1, 'Transferencia a cuenta externa'),
  (2, 2, 'Retiro en cajero automático'),
  (3, 3, 'Transferencia entre cuentas propias'),
  (4, 4, 'Depósito en efectivo'),
  (5, 5, 'Pago de factura de servicios'),
  (6, 6, 'Transferencia a cuenta externa'),
  (7, 7, 'Retiro en cajero automático'),
  (8, 8, 'Transferencia entre cuentas propias'),
  (9, 9, 'Depósito en efectivo'),
  (10, 10, 'Pago de factura de servicios');

