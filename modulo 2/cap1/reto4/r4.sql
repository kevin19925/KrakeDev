-- Productos
-- Consulta 1: Productos que empiezan con "Q" 
SELECT *
FROM productos
WHERE nombre LIKE 'Q%';

-- Consulta 2: Productos con descripción NULL 
SELECT *
FROM productos
WHERE descripcion IS NULL;

-- Consulta 3: Productos con precio entre 2 y 3 
SELECT *
FROM productos
WHERE precio BETWEEN 2 AND 3;

-- Cuentas

-- Consulta 1: Número de cuenta y saldo de todas las cuentas 
SELECT numero_cuenta, saldo
FROM cuentas;

-- Consulta 2: Registros entre el día de hoy y 2 meses antes 
SELECT *
FROM registros_entrada
WHERE fecha BETWEEN '2023-07-26' AND '2023-09-26';


-- Consulta 3: Número de cuenta y saldo de las cuentas desde el día de hoy hasta 2 meses antes 
SELECT numero_cuenta, saldo
FROM cuentas
WHERE fecha_creacion BETWEEN '2023-07-26' AND '2023-09-26';

--  "Estudiantes"

-- Consulta 1: Nombre y cédula de los estudiantes 
SELECT nombre, cedula
FROM estudiantes;

-- Consulta 2: Nombres de estudiantes cuya cédula empiece con "17" 
SELECT nombre
FROM estudiantes
WHERE cedula LIKE '17%';

-- Consulta 3: Nombres completos de estudiantes cuyo nombre empiece con "A" (
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM estudiantes
WHERE nombre LIKE 'A%';


--  "Registros_entrada"

-- Consulta 1: Seleccionar todas las cédulas de empleado y la fecha y hora de los Registros de entrada
SELECT cedula_empleado, fecha, hora
FROM registros_entrada;

-- Consulta 2: Seleccionar los registros de entrada que estén entre las 7:00 y las 14:00
SELECT *
FROM registros_entrada
WHERE hora >= '07:00:00' AND hora <= '14:00:00';

-- Consulta 3: Seleccionar los registros de entrada que tengan horas superiores a las 8:00
SELECT *
FROM registros_entrada
WHERE hora > '08:00:00';


--  tabla "Videojuegos"

-- Consulta 1: Seleccionar todos los videojuegos con un nombre que comience con "C"
SELECT *
FROM videojuegos
WHERE nombre LIKE 'C%';

-- Consulta 2: Seleccionar videojuegos con una valoración entre 9 y 10
SELECT *
FROM videojuegos
WHERE valoracion BETWEEN 9 AND 10;
-- Consulta 3: Seleccionar videojuegos con una descripción NULL
SELECT *
FROM videojuegos
WHERE descripcion IS NULL;

--  transaccion
-- Consulta 1: Seleccionar todas las transacciones realizadas con un tipo 'D'
SELECT *
FROM transacciones
WHERE tipo = 'D';

-- Consulta 2: Seleccionar las transacciones con montos entre 200 y 2000
SELECT *
FROM transacciones
WHERE monto BETWEEN 200 AND 2000;

-- Consulta 3: Seleccionar el código, monto, tipo y fecha de las transacciones que tengan fecha diferente de NULL
SELECT codigo, monto, tipo, fecha
FROM transacciones
WHERE fecha IS NOT NULL;



