-- Actualizar el stock a 0 en productos con descripción NULL
UPDATE productos
SET stock = 0
WHERE descripcion IS NULL;

-- Actualizar el saldo a 10 en cuentas cuya cedula_propietario empiece por "17"
UPDATE cuentas
SET saldo = 10
WHERE cedula_propietario LIKE '17%';

-- Actualizar el apellido a "Hernández" en estudiantes con cédula que empiece por "17"
UPDATE estudiantes
SET apellido = 'Hernández'
WHERE cedula LIKE '17%';


-- Actualiza las cédulas de Registro_entrada por "082345679ª" para los registros de agosto
UPDATE registros_entrada
SET cedula_empleado = '082345679ª'
WHERE fecha >= '2023-08-01' AND fecha <= '2023-08-31';

-- Actualiza las descripciones de los videojuegos con valoración mayor que 9
UPDATE videojuegos
SET descripcion = 'Mejor puntuado'
WHERE valoracion > 9;


--
-- Actualiza el tipo de transacciones entre 100 y 500, realizadas en septiembre entre las 14:00 y las 20:00, por "Transferencia"
UPDATE registros_entrada
SET tipo = 'Transferencia'
 WHERE monto > 100 AND monto < 500 AND fecha >= '2023-09-01' AND fecha <= '2023-09-30' AND hora BETWEEN '14:00:00' AND '20:00:00'
   

