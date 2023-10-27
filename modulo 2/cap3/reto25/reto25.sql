
--1

SELECT AVG(cast(saldo as numeric)) AS saldo_promedio
FROM cuentas
WHERE cedula = '1111111111';
--2
SELECT tipo_cuenta, COUNT(*) AS total_cuentas
FROM cuentas
GROUP BY tipo_cuenta;

--3
SELECT cedula, SUM(monto) AS monto_total_compras
FROM compras
GROUP BY cedula;

--4

SELECT fecha_compra ,COUNT(*) AS cantidad_total_compras
FROM compras
WHERE fecha_compra = '2023-02-15'
group by fecha_compra

--5

SELECT codigo_profesor, COUNT(*) AS cantidad_estudiantes_asignados
FROM estudiantes
GROUP BY codigo_profesor;
--- 6

--Escribir la sentencia SQL utilizando la función ROUND para mostrar la
--edad promedio como entero, dentro de ROUND la función de agregación AVG
--(EXTRACT(YEAR FROM CURRENT_DATE) Extract para obtener la
--diferencia en años entre la fecha actual y la fecha de nacimiento de cada
--estudiante seguido de un guion hacer otro EXTRACT que lleva dentro EL AÑO
--(YEAR) de la fecha de nacimiento de los estudiantes, con ello obtendremos el
--promedio de las edades de los estudiantes.
 --
SELECT ROUND(AVG(EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM fecha_nacimiento)))
AS edad_promedio
FROM estudiantes;
--7

SELECT cedula, SUM(monto) AS suma_total_prestamos
FROM prestamo
GROUP BY cedula;

-- 8
SELECT COUNT(*) AS cantidad_personas_con_mas_de_un_hijo
FROM persona
WHERE numero_hijos > 1;
--9  
SELECT MAX(precio) AS maximo_precio
FROM productos;

-- 10

SELECT SUM(cantidad) AS suma_total_cantidad_productos_vendidos
FROM ventas;


--11
SELECT COUNT(*) AS cantidad_transacciones_credito
FROM transacciones
WHERE tipo = 'C';
--12
SELECT numero_cuenta, ROUND(AVG(monto::DECIMAL), 2) AS promedio_monto
FROM transacciones
GROUP BY numero_cuenta;



--13


select v.codigo,v.nombre,count(p.id_plataforma) total_plataforma
FROM videojuegos v ,plataformas p
where v.codigo = p.codigo_videojuego
GROUP BY v.codigo,v.nombre
--14

select round(avg(v.valoracion),2)  promedio
FROM videojuegos v

--15

SELECT cedula_empleado ,  COUNT(codigo_registro) AS cantidad_registros
FROM registro_entrada
GROUP BY cedula_empleado;

--16
SELECT MIN(fecha) AS fecha_minima, MAX(fecha) AS fecha_maxima
FROM registro_entrada;
