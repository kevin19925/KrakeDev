-- ejer1
CREATE TABLE usuario (
    cedula VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    tipo_cuenta VARCHAR(20) ,
    limite_credito DECIMAL(10,2)
);

CREATE TABLE cuentas (
    numero_cuenta VARCHAR(5) PRIMARY KEY,
    cedula VARCHAR(10) ,
    fecha_creacion date NOT NULL,
    saldo money NOT NULL,
	foreign key (cedula) references usuario(cedula)
);

------------ clientes 

CREATE TABLE clientes (
	cedula varchar(10) not null,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    constraint cedula_pk primary key (cedula)
);

CREATE TABLE compras (
	id_compra integer primary key,
    fecha_compra date NOT NULL,
    monto decimal(10,2) NOT NULL
	
);

-- Agregar la columna "cedula" a la tabla "compras" como NOT NULL
ALTER TABLE compras
ADD COLUMN cedula VARCHAR(10) NOT NULL;

-- Establecer la restricción de clave externa (FOREIGN KEY)
ALTER TABLE compras
ADD CONSTRAINT cedula_fk FOREIGN KEY (cedula) REFERENCES clientes(cedula);
----- ejer 3


CREATE TABLE productos (
    codigo VARCHAR(10) ,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
	constraint codigo_pk primary key (codigo)
);

CREATE TABLE ventas (
    id_venta SERIAL PRIMARY KEY,
    codigo_producto VARCHAR(10),
    fecha_venta DATE,
    cantidad INT,
    CONSTRAINT codigo_producto_fk FOREIGN KEY (codigo_producto) REFERENCES productos(codigo)
);

--ejer 4

CREATE TABLE videojuegos (
    codigo int ,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300),
    valoracion int,
	constraint codigo_video_pk primary key (codigo)
);

CREATE TABLE plataformas (
    id_plataforma int PRIMARY KEY,
    nombre_plataforma VARCHAR(50) NOT NULL,
    codigo_videojuego INT,
    CONSTRAINT codigo_videojuego_fk FOREIGN KEY (codigo_videojuego) 
	REFERENCES videojuegos(codigo)
);

--- ejer 5 

CREATE TABLE profesores (
    codigo int ,
    nombre VARCHAR(50) NOT NULL,
	constraint codigo_profesores_pf primary key (codigo)
);

CREATE TABLE estudiantes (
    cedula VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULl,
    fecha_nacimiento DATE,
    codigo_profesor int ,
   constraint  codigo_profesor_fk FOREIGN KEY (codigo_profesor) REFERENCES profesores(codigo)
);


--6



CREATE TABLE registro_entrada (
    codigo_registro int not null,
    cedula_empleado VARCHAR(10) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    codigo_empleado int not null,
	constraint codigo_empleado_fk
    FOREIGN KEY (codigo_empleado) REFERENCES empleados(codigo_empleado)
);

CREATE TABLE empleados (
    codigo_empleado int not null,
    nombre VARCHAR(25) NOT NULL,
    fecha date NOT NULL,
	hora time NOT NULL,
	constraint codigo_empleado_pk
	primary key (codigo_empleado)
)

--- 7

CREATE TABLE persona (
    cedula VARCHAR(10) NOT NULL ,
    nombre VARCHAR(50) NOT  NULL,
    apellido VARCHAR(50 )NOT NULL,
    estatura DECIMAL(10,2),
    fecha_nacimiento DATE,
    hora_nacimiento TIME,
    cantidad_ahorrada money ,
    numero_hijos INT, 
	CONSTRAINT cedula_PERSONA   PRIMARY KEY (CEDULA)
);

CREATE TABLE prestamo (
    cedula VARCHAR(10) NOT NULL PRIMARY key,
    monto money,
    fecha_prestamo DATE,
    hora_prestamo TIME,
    garante VARCHAR(40),
	constraint  cedula_prestamo_fk
    FOREIGN KEY (cedula) REFERENCES persona(cedula)
);

-- 8 

CREATE TABLE transacciones (
  codigo   int  primary key,
    numero_cuenta VARCHAR(5) NOT NULL,
    monto money    NOT NULL,
    tipo VARCHAR(1) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL
);
CREATE TABLE banco (
    codigo_banco  int  PRIMARY KEY,
    codigo_transaccion int ,
    detalle VARCHAR(100),
    FOREIGN KEY (codigo_transaccion) REFERENCES transacciones( codigo )
);



