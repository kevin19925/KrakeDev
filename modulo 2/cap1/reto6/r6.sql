-- Elimina productos con descripción NULL
DELETE FROM productos
WHERE descripcion IS NULL;
-- Elimina cuentas cuya cédula del propietario empiece por "10"
DELETE FROM cuentas
WHERE cedula_propietario LIKE '10%';

-- Elimina estudiantes con cédula que termine en "05"
DELETE FROM estudiantes
WHERE SUBSTRING(cedula, LENGTH(cedula) - 1) = '05';


-- Elimina todos los registros del mes de junio
DELETE FROM registros_entrada
WHERE EXTRACT(MONTH FROM fecha) = 6;

-- Elimina los videojuegos cuya valoración sea menor que 7
DELETE FROM videojuegos
WHERE valoracion < 7;


-- Elimina las transferencias entre las 14:00 y las 18:00 del mes de agosto del año actual

DELETE FROM registros_entrada 
 WHERE 
 fecha >= '2023-08-01'
 AND fecha <= '2023-08-30'AND 
 hora BETWEEN '14:00:00' AND '20:00:00'
 AND tipo = 'Transferencia'
   

