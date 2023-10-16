-- Consultas para la tabla "Productos"
-- 1. Seleccionar todos los productos con stock igual a 10 y precio menor a 10
SELECT * FROM productos WHERE stock = 10 AND precio < 10;

-- 2. Seleccionar los nombres y stocks de todos los productos que tengan una 'm' en su nombre o tengan un espacio en blanco en su descripción
SELECT nombre, stock FROM productos WHERE nombre LIKE '%m%' OR descripcion LIKE '% ';

-- 3. Seleccionar el nombre de todos los productos que tengan el campo de descripción nulo (NULL) o tengan un stock de 0
SELECT nombre FROM productos WHERE descripcion IS NULL OR stock = 0;



-- Consultas para la tabla "Cuentas"
-- 1. Seleccionar el número de cuenta y saldo de todas las cuentas con saldo mayor a 100 y menor a 1000
SELECT numero_cuenta, saldo FROM cuentas WHERE saldo > 100 AND saldo < 1000;

-- 2. Seleccionar las cuentas entre el día de hoy y hace 1 año
SELECT * FROM cuentas WHERE fecha_creacion >='2022-09-25' AND fecha_creacion <='2023-09-25';

-- 3. Seleccionar las cuentas con saldo 0 o con una cédula de propietario que termine con '2'
SELECT * FROM cuentas WHERE saldo = 0 OR cedula_propietario LIKE '%2';



-- Consultas para la tabla "Estudiantes"
-- 1. Seleccionar el nombre y apellido de los estudiantes cuyos nombres empiecen con 'Mo' si su apellido termina en 'Z'
SELECT nombre, apellido FROM estudiantes WHERE nombre LIKE 'Mo%' AND apellido LIKE '%Z';

-- 2. Crear una consulta que traiga los nombres de todos los estudiantes que tengan un número '32' y empiece con '18' en alguna parte de su cédula
SELECT nombre FROM estudiantes WHERE cedula LIKE'18%'  AND cedula LIKE '%32%';

-- 3. Crear una consulta que traiga los nombres completos de todos los estudiantes cuya cédula termine en '06' o empiece con '17'
SELECT nombre , apellido FROM estudiantes WHERE cedula LIKE'%06'  OR cedula LIKE '17%';


-- Consultas para la tabla "Registros_entrada"
-- 1. Seleccione los registros del mes de septiembre, o realizados por las cédulas de Pichincha (que inician con 17)
SELECT * FROM registros_entrada WHERE (fecha_creacion >= '2023-09-01' AND fecha_creacion <= '2023-09-30')
 OR cedula_empleado LIKE '17%';

-- 2. Seleccione los registros del mes de agosto, realizados por las cédulas de Pichincha (que inician con 17) y realizados entre las 08:00 a 12:00.
SELECT * FROM registros_entrada 
WHERE (fecha_creacion >= '2023-08-01' AND fecha_creacion <= '2023-08-30') 
AND (cedula_empleado LIKE '17%') AND (hora BETWEEN '08:00' AND '12:00');

-- 3. Seleccione los registros del mes de agosto, realizados por las cédulas de Pichincha (que inician con 17) y realizados entre las 08:00 a 12:00 o los registros del mes de septiembre, realizados por las cédulas de Esmeraldas (que inician con 08) y realizados entre las 09:00 a 13:00.
SELECT * FROM registros_entrada 
WHERE  ((fecha >= '2023-08-01' AND fecha <= '2023-08-30') AND 
(cedula_empleado LIKE '17%') AND (hora BETWEEN '08:00' AND '12:00'))
OR ((fecha >= '2023-09-01' AND fecha <= '2023-09-30') AND (cedula_empleado LIKE '08%') AND (hora BETWEEN '09:00' AND '13:00'));



-- Consultas para la tabla "Videojuegos"
-- 1. Listar los registros de videojuegos con un nombre que contengan la letra "C" o una valoración de 7.
SELECT * FROM videojuegos WHERE nombre LIKE '%C%' OR valoracion = 7;

-- 2. Seleccionar videojuegos con un código entre 3 y 7 o una valoración de 7.
SELECT * FROM videojuegos WHERE (codigo BETWEEN 3 AND 7) OR valoracion = 7;

-- 3. Seleccionar videojuegos de guerra, con una valoración mayor a 7 y que en su nombre empiezan con C o los videojuegos con una valoración mayor a 8 y que en su nombre empiezan con D.
SELECT * FROM videojuegos
WHERE (descripcion LIKE '%guerra%')
AND ( ((valoracion > 7) AND (nombre LIKE 'C%')) OR ((valoracion > 8) AND (nombre LIKE 'D%')) );


-- Consultas para la tabla "Transacciones"
-- 1. Seleccionar transacciones de tipo C realizadas por los clientes con números de cuentas entre 222001 y 22004.
SELECT * FROM transacciones WHERE (tipo = 'C') AND (numero_cuenta BETWEEN 222001 AND 22004);

-- 2. Seleccionar transacciones de tipo D que fueron realizadas el 25 de mayo y con el rango de cuenta entre 22007 y 22010.
SELECT * FROM transacciones WHERE (tipo = 'D') AND (fecha = '2023-05-25') AND (numero_cuenta BETWEEN 22007 AND 22010);

-- 3. Seleccione todas las transacciones en donde el código sea entre 1 y 5, número de cuenta entre 22002 O 22004 que se hayan realizado los días 26 y 29 de mayo.
SELECT * FROM transacciones WHERE (codigo BETWEEN 1 AND 5) AND ((numero_cuenta = 22002) OR (numero_cuenta = 22004)) AND (fecha = '2023-05-26'AND fecha= '2023-05-29');
