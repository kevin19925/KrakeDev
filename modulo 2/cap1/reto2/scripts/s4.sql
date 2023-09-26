CREATE TABLE registros_entrada (
    codigo_registro SERIAL PRIMARY KEY,
    cedula_empleado CHAR(10) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL
);
