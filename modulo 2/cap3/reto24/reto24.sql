
-- 1)
-- :: para convertir netero a money 
SELECT u.nombre, c.numero_cuenta
FROM cuentas c, usuario u
WHERE c.cedula = u.cedula AND c.saldo >= 100::money AND c.saldo <= 1000::money;

-- 2)
SELECT c.numero_cuenta,c.fecha_creacion,c.saldo, u.cedula
FROM usuario u
JOIN cuentas c ON u.cedula = c.cedula
WHERE c.fecha_creacion BETWEEN '2022-09-21' AND '2023-09-21';
--3)
select c.nombre,c.apellido
from clientes c, compras com
where c.cedula=com.cedula and c.cedula like '%7%'
--4)
select c.cedula, c.nombre,c.apellido
from clientes c, compras com
where c.cedula=com.cedula and  c.cedula=(select cedula from clientes where nombre='Monica')

--5
SELECT p.codigo as codigo_profesor, e.nombre, e.apellido
FROM profesores p ,estudiantes e
WHERE p.codigo = e.codigo_profesor and e.apellido LIKE '%n%';

--6

SELECT e.*
FROM estudiantes e
WHERE e.codigo_profesor=(select codigo from profesores  where nombre='Profesor Smith' )
--7 


SELECT p.cantidad_ahorrada, prestamo.monto, prestamo.garante
FROM persona p , prestamo
WHERE p.cedula = prestamo.cedula
and prestamo.monto BETWEEN 100.00:: money AND 2000.00 :: money ;


--8

SELECT *
FROM persona
WHERE cedula = ANY (SELECT cedula FROM persona WHERE nombre = 'Sean');
--9

SELECT p.nombre, p.stock, v.cantidad 
FROM productos p, ventas v
WHERE p.nombre LIKE '%m%' or  descripcion= 'o'
--10
SELECT nombre, stock
FROM productos
WHERE codigo = any (SELECT codigo_producto FROM ventas WHERE cantidad = 5);

---11
SELECT *
FROM transacciones
WHERE tipo = 'C' AND numero_cuenta BETWEEN '22001' AND '22004';

-- 12
SELECT *
FROM transacciones
WHERE codigo = ANY (SELECT codigo_transaccion FROM banco WHERE codigo_banco = 1);

-- 13

SELECT vj.nombre AS nombre_videojuego, vj.descripcion, vj.valoracion, p.nombre_plataforma
FROM videojuegos vj, plataformas p
WHERE vj.codigo = p.codigo_videojuego
AND( (vj.descripcion LIKE '%Guerra%' AND vj.valoracion > 7)
   OR (vj.nombre LIKE 'C%' AND vj.valoracion > 8)
   OR (vj.nombre LIKE 'D%' AND vj.valoracion > 8));

--14


CREATE TABLE productos (
    codigo VARCHAR(10) ,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
	constraint codigo_pk primary key (codigo)
);

--15
SELECT *
FROM plataformas
WHERE codigo_videojuego = ANY (SELECT codigo FROM videojuegos WHERE nombre = 'God of War');

--16
ALTER TABLE empleados
ADD COLUMN cedula_empleado VARCHAR(10) ;

SELECT e.cedula_empleado, re.fecha, e.nombre
FROM registro_entrada re, empleados e 
WHERE re.codigo_empleado = e.codigo_empleado
AND 
    (re.fecha BETWEEN '2023-08-01' AND '2023-08-31'
    OR (e.cedula_empleado LIKE '17%' AND re.hora BETWEEN '08:00' AND '12:00'))
    OR
    (re.fecha BETWEEN '2023-10-06' AND '2023-10-20'
    AND e.cedula_empleado LIKE '08%'
    AND re.hora BETWEEN '09:00' AND '13:00');

--17

SELECT *
FROM empleados
WHERE codigo_empleado = ANY (SELECT codigo_registro
                        FROM registro_entrada
                        WHERE cedula_empleado = '2201');
