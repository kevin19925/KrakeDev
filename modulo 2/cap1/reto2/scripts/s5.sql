CREATE TABLE videojuegos (
    codigo SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300),
    valoracion INTEGER NOT NULL
);
