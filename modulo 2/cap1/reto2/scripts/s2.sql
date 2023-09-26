CREATE TABLE cuentas (
    numero_cuenta CHAR(5) PRIMARY KEY,
    cedula_propietario CHAR(5) NOT NULL,
    fecha_creacion DATE NOT NULL,
    saldo MONEY NOT NULL
);
