CREATE TABLE productos (
    codigo SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    precio MONEY NOT NULL,
    stock INTEGER NOT NULL
);

