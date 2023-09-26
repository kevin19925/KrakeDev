CREATE TABLE estudiantes (
    cedula CHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);
