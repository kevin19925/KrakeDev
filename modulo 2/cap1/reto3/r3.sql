-- Inserciones en la tabla "productos" con todos los campos
INSERT INTO productos (codigo, nombre, descripcion, precio, stock)
VALUES
  (1, 'Producto 1', 'Descripción 1', 10.99, 100),
  (2, 'Producto 2', 'Descripción 2', 15.99, 50),
  (3, 'Producto 3', 'Descripción 3', 20.49, 75),
  (4, 'Producto 4', 'Descripción 4', 8.99, 120),
  (5, 'Producto 5', 'Descripción 5', 12.75, 80),
  -- Inserciones en la tabla "productos" solo con campos obligatorios
  INSERT INTO productos (codigo, nombre, precio, stock)
VALUES
  (6, 'Producto 6', 25.99, 60),
  (7, 'Producto 7', 18.49, 90),
  (8, 'Producto 8', 22.99, 40);
  
  
  -- Inserciones en la tabla "cuentas"
INSERT INTO cuentas (numero_cuenta, cedula_propietario, fecha_creacion, saldo)
VALUES
  ('10001', '12345', '2023-09-25', 1000.00),
  ('10002', '67890', '2023-09-25', 1500.50),
  ('10003', '54321', '2023-09-25', 200.25),
  ('10004', '98765', '2023-09-25', 3000.75),
  ('10005', '11111', '2023-09-25', 500.00),
  ('10006', '22222', '2023-09-25', 800.30),
  ('10007', '33333', '2023-09-25', 600.20),
  ('10008', '44444', '2023-09-25', 750.10),
  ('10009', '55555', '2023-09-25', 1200.00),
  ('10010', '66666', '2023-09-25', 950.75);

-- Inserciones en la tabla "estudiantes"
INSERT INTO estudiantes (cedula, nombre, apellido, email, fecha_nacimiento)
VALUES
  ('1234567890', 'Estudiante1', 'Apellido1', 'estudiante1@example.com', '2000-01-15'),
  ('2345678901', 'Estudiante2', 'Apellido2', 'estudiante2@example.com', '1999-07-20'),
  ('3456789012', 'Estudiante3', 'Apellido3', 'estudiante3@example.com', '2001-03-10'),
  ('4567890123', 'Estudiante4', 'Apellido4', 'estudiante4@example.com', '2002-05-05'),
  ('5678901234', 'Estudiante5', 'Apellido5', 'estudiante5@example.com', '1998-12-30'),
  ('6789012345', 'Estudiante6', 'Apellido6', 'estudiante6@example.com', '2003-09-08'),
  ('7890123456', 'Estudiante7', 'Apellido7', 'estudiante7@example.com', '2004-11-25'),
  ('8901234567', 'Estudiante8', 'Apellido8', 'estudiante8@example.com', '2000-04-03');


-- Inserciones en la tabla "registros_entrada"
INSERT INTO registros_entrada (cedula_empleado, fecha, hora)
VALUES
  ('12345', '2023-09-25', '08:00:00'),
  ('54321', '2023-09-25', '09:15:00'),
  ('98765', '2023-09-25', '10:30:00'),
  ('11111', '2023-09-25', '12:45:00'),
  ('55555', '2023-09-25', '14:00:00'),
  ('66666', '2023-09-25', '15:30:00'),
  ('44444', '2023-09-25', '16:45:00'),
  ('22222', '2023-09-25', '18:00:00'),
  ('88888', '2023-09-25', '19:15:00'),
  ('77777', '2023-09-25', '20:30:00');
  
  -- Inserciones en la tabla "videojuegos" con todos los campos
INSERT INTO videojuegos (codigo, nombre, descripcion, valoracion)
VALUES
  (1, 'Juego 1', 'Descripción 1', 4),
  (2, 'Juego 2', 'Descripción 2', 5),
  (3, 'Juego 3', 'Descripción 3', 3),
  (4, 'Juego 4', 'Descripción 4', 4),
  (5, 'Juego 5', 'Descripción 5', 5),
  -- Inserciones en la tabla "videojuegos" solo con campos obligatorios
  INSERT INTO videojuegos (codigo, nombre, valoracion)
VALUES
  (6, 'Juego 6', 3),
  (7, 'Juego 7', 4),
  (8, 'Juego 8', 2);


-- Inserciones en la tabla "transacciones" con todos los campos
INSERT INTO transacciones (numero_cuenta, monto, tipo, fecha, hora)
VALUES
  ('10001', 100.50, 'C', '2023-09-25', '08:30:00'),
  ('10002', 50.25, 'D', '2023-09-25', '09:45:00'),
  ('10003', 200.00, 'C', '2023-09-25', '11:00:00'),
  ('10004', 75.75, 'D', '2023

