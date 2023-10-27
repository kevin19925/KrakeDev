-- Crear la tabla "usuarios"
CREATE TABLE usuarios (
    id serial PRIMARY KEY,
    nombre varchar(25) NOT NULL,
    apellido varchar(25) NOT NULL,
    fecha_nacimiento DATE
);

-- Crear la tabla "grupo"
CREATE TABLE grupo (
    id serial PRIMARY KEY,
    nombre varchar(25) NOT NULL,
    descripcion varchar(75),
    fecha_creacion DATE
);

-- Crear la tabla de unión "usuario_grupo"
CREATE TABLE usuario_grupo (
    us_id int NOT NULL,
    gr_id int NOT NULL,
    FOREIGN KEY (us_id) REFERENCES usuarios(id),
    FOREIGN KEY (gr_id) REFERENCES grupo(id),
    PRIMARY KEY (us_id, gr_id)
);
----2
-- Crear la tabla "habitaciones"
CREATE TABLE habitaciones (
    habitacion_numero int PRIMARY KEY,
    precio_por_noche decimal NOT NULL,
    piso int NOT NULL,
    max_personas int
);

-- Crear la tabla "huéspedes"
CREATE TABLE huespedes (
    id serial PRIMARY KEY,
    nombres varchar(45) NOT NULL,
    apellidos varchar(45) NOT NULL,
    telefono char(10),
    correo varchar(45),
    direccion varchar(45),
    ciudad varchar(45),
    pais varchar(45)
);

-- Crear la tabla de unión "reservas"
CREATE TABLE reservas (
    inicio_fecha DATE,
    fin_fecha DATE,
    habitacion int NOT NULL,
    huesped_id int NOT NULL,
    FOREIGN KEY (habitacion) REFERENCES habitaciones(habitacion_numero),
    FOREIGN KEY (huesped_id) REFERENCES huespedes(id),
    PRIMARY KEY (habitacion, huesped_id)
);

---3
-- Crear la tabla "ciudad"
CREATE TABLE ciudad (
    id serial PRIMARY KEY,
    nombre varchar(45) NOT NULL
);

-- Crear la tabla "municipio"
CREATE TABLE municipio (
    id serial PRIMARY KEY,
    nombre varchar(45),
    ciudad_id int,
    FOREIGN KEY (ciudad_id) REFERENCES ciudad(id)
);

-- Crear la tabla "proyecto"
CREATE TABLE proyecto (
    id serial PRIMARY KEY,
    proyecto varchar(50) NOT NULL,
    monto money NOT NULL,
    fecha_inicio date,
    fecha_entrega date
);

-- Crear la tabla de unión "proyecto_municipio"
CREATE TABLE proyecto_municipio (
    municipio_id int NOT NULL,
    proyecto_id int NOT NULL,
    FOREIGN KEY (municipio_id) REFERENCES municipio(id),
    FOREIGN KEY (proyecto_id) REFERENCES proyecto(id),
    PRIMARY KEY (municipio_id, proyecto_id)
);
-----------------////////////////////////////////////
SELECT usuarios.nombre AS nombre_usuario, grupo.nombre AS nombre_grupo
FROM usuarios, usuario_grupo, grupo
WHERE usuarios.id = usuario_grupo.us_id AND grupo.id = usuario_grupo.gr_id;
--////
SELECT nombre
FROM usuarios
WHERE id IN (SELECT us_id FROM usuario_grupo WHERE gr_id = 1);

--///
SELECT grupo.nombre AS nombre_grupo, COUNT(usuario_grupo.us_id) AS cantidad_usuarios
FROM grupo
JOIN usuario_grupo ON grupo.id = usuario_grupo.gr_id
GROUP BY grupo.nombre;


--///////////////////////////////////

SELECT usuarios.nombre AS nombre_usuario, grupo.nombre AS nombre_grupo
FROM usuarios, usuario_grupo, grupo
WHERE usuarios.id = usuario_grupo.us_id
  AND grupo.id = usuario_grupo.gr_id
  AND grupo.nombre LIKE 'intensivo%';




--///////////////////////////////////


SELECT nombre
FROM usuarios
WHERE id = (SELECT us_id FROM usuario_grupo WHERE id = 21);


--///////////////////////////////////

SELECT grupo.nombre AS nombre_grupo, MAX(usuario_grupo.us_id) AS max_us_id, MIN(usuario_grupo.us_id) AS min_us_id
FROM grupo
JOIN usuario_grupo ON grupo.id = usuario_grupo.gr_id
GROUP BY grupo.nombre;




--////////////////////////////////////////////////***********3

SELECT usuarios.nombre AS nombre_usuario, grupo.fecha_creacion
FROM usuarios, usuario_grupo, grupo
WHERE usuarios.id = usuario_grupo.us_id
  AND grupo.id = usuario_grupo.gr_id
  AND grupo.fecha_creacion BETWEEN '2020-03-08' AND '2022-03-08';


--///////////////////////////////////
SELECT nombre
FROM usuarios
WHERE id IN (SELECT us_id FROM usuario_grupo WHERE gr_id = 3);





--///////////////////////////////////

SELECT grupo.descripcion AS descripcion_grupo, COUNT(usuario_grupo.us_id) AS cantidad_usuarios
FROM grupo
JOIN usuario_grupo ON grupo.id = usuario_grupo.gr_id
WHERE grupo.descripcion LIKE '%matutino%'
GROUP BY grupo.descripcion;


--///////////////////////////////////************ 4


SELECT habitaciones.habitacion_numero, huespedes.nombres, huespedes.apellidos
FROM habitaciones, reservas, huespedes
WHERE habitaciones.habitacion_numero = reservas.habitacion
  AND huespedes.id = reservas.huesped_id;


--///////////////////////////////////


SELECT nombres, apellidos
FROM huespedes
WHERE id = ANY (SELECT huesped_id FROM reservas WHERE habitacion = 2);


--///////////////////////////////////


SELECT habitaciones.habitacion_numero, COUNT(reservas.huesped_id) AS cantidad_huespedes
FROM habitaciones, reservas
WHERE habitaciones.habitacion_numero = reservas.habitacion
GROUP BY habitaciones.habitacion_numero;



--///////////////////////////////////***************5


SELECT habitaciones.habitacion_numero, habitaciones.piso, huespedes.nombres, huespedes.apellidos
FROM habitaciones, reservas, huespedes
WHERE habitaciones.piso = 4
  AND habitaciones.habitacion_numero = reservas.habitacion
  AND huespedes.id = reservas.huesped_id;

--///////////////////////////////////

SELECT nombres, apellidos
FROM huespedes
WHERE id IN (SELECT huesped_id FROM reservas WHERE habitacion = 3);




--///////////////////////////////////

SELECT habitaciones.habitacion_numero, AVG(reservas.huesped_id) AS promedio_huespedes
FROM habitaciones, reservas
WHERE habitaciones.habitacion_numero = reservas.habitacion
GROUP BY habitaciones.habitacion_numero;


--/////////////////////////////////// *******************6


SELECT habitaciones.habitacion_numero, huespedes.nombres, huespedes.apellidos
FROM habitaciones, reservas, huespedes
WHERE habitaciones.habitacion_numero = reservas.habitacion
  AND huespedes.id = reservas.huesped_id;



--///////////////////////////////////


SELECT nombres, apellidos
FROM huespedes
WHERE id IN (SELECT huesped_id FROM reservas WHERE habitacion = 4);


--///////////////////////////////////

SELECT habitaciones.habitacion_numero, SUM(habitaciones.precio_por_noche) AS total_recaudado
FROM habitaciones, reservas
WHERE habitaciones.habitacion_numero = reservas.habitacion
GROUP BY habitaciones.habitacion_numero;

--///////////////////////////////////*****7


SELECT municipio.nombre AS nombre_municipio, proyecto.nombre AS nombre_proyecto
FROM municipio
JOIN proyecto_municipio ON municipio.id = proyecto_municipio.municipio_id
JOIN proyecto ON proyecto.id = proyecto_municipio.proyecto_id;


--///////////////////////////////////
SELECT nombre
FROM proyecto
WHERE id IN (SELECT proyecto_id FROM proyecto_municipio WHERE municipio_id = 1);


--///////////////////////////////////

SELECT municipio.nombre AS nombre_municipio, COUNT(proyecto_municipio.proyecto_id) AS cantidad_proyectos
FROM municipio
JOIN proyecto_municipio ON municipio.id = proyecto_municipio.municipio_id
GROUP BY municipio.nombre;



--///////////////////////////////////*******8
SELECT municipio.nombre AS nombre_municipio, proyecto.nombre AS nombre_proyecto
FROM municipio
JOIN proyecto_municipio ON municipio.id = proyecto_municipio.municipio_id
JOIN proyecto ON proyecto.id = proyecto_municipio.proyecto_id
WHERE municipio.nombre LIKE '%GAD%';

--///////////////////////////////////
SELECT municipio.nombre AS nombre_municipio, MIN(proyecto_municipio.proyecto_id) AS min_proyecto_id
FROM municipio
JOIN proyecto_municipio ON municipio.id = proyecto_municipio.municipio_id
GROUP BY municipio.nombre;




--///////////////////////////////////*******9 
SELECT municipio.nombre AS nombre_municipio, ciudad.nombre AS nombre_ciudad
FROM municipio
JOIN ciudad ON municipio.ciudad_id = ciudad.id;


--///////////////////////////////////
SELECT *
FROM proyecto
WHERE id IN (SELECT proyecto_id FROM proyecto_municipio WHERE municipio_id = 3);


--///////////////////////////////////
SELECT municipio.nombre AS nombre_municipio, MAX(proyecto_municipio.proyecto_id) AS max_proyecto_id
FROM municipio
JOIN proyecto_municipio ON municipio.id = proyecto_municipio.municipio_id
GROUP BY municipio.nombre;





