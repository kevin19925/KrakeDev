drop table if exists categorias;
CREATE TABLE categorias (
    codigo_cat SERIAL not null,
    nombre VARCHAR(100) NOT NULL,
    categoria_padre INT,
	CONSTRAINT categorias_pk PRIMARY KEY (codigo_cat),
    CONSTRAINT categorias_fk FOREIGN KEY (categoria_padre) 
	REFERENCES categorias(codigo_cat)
);

insert into categorias (nombre, categoria_padre)
values ('Materia Prima',null);
insert into categorias (nombre, categoria_padre)
values ('Proteina',1);
insert into categorias (nombre, categoria_padre)
values ('Salsas',1);
insert into categorias (nombre, categoria_padre)
values ('Punto de Venta',null);
insert into categorias (nombre, categoria_padre)
values ('Bebidas',4) ;
insert into categorias (nombre,categoria_padre)
values ('Con Alcohol',5);
insert into categorias (nombre, categoria_padre)
values ('Sin Alcohol ',5);

select * from categorias;


drop table if exists tipo_documentos;
CREATE TABLE tipo_documentos (
    codigo CHAR(1) not null,
   descripcion VARCHAR(100) NOT NULL,
	CONSTRAINT codigo_pk PRIMARY KEY (codigo)
);

insert into tipo_documentos (codigo, descripcion )
values ('C','CEDULA'),
 ('R','RUC');

select * from tipo_documentos;



drop table if exists estado_pedido ;
CREATE TABLE estado_pedido  (
    codigo CHAR(1) not null,
   descripcion VARCHAR(100) NOT NULL,
	CONSTRAINT codigo_pedido_pk PRIMARY KEY (codigo)
);

insert into estado_pedido (codigo, descripcion )
values ('S','Solicitado'),
 ('R','Recibido');

select * from  estado_pedido;



drop table if exists categorias_unidad_medida ;
CREATE TABLE categorias_unidad_medida  (
    codigo CHAR(1) not null,
   nombre VARCHAR(100) NOT NULL,
	CONSTRAINT codigo_unidad_pk PRIMARY KEY (codigo)
);

insert into categorias_unidad_medida (codigo, nombre )
values ('U','Unidades'),
 ('V','Volumen'),('P','Peso');

select * from  categorias_unidad_medida;


drop table if exists unidades_de_medida;
CREATE TABLE unidades_de_medida (
    codigo VARCHAR(10) not null,
    descripcion VARCHAR(100) NOT NULL,
    categoria_UDM CHAR(1) NOT NULL,
	CONSTRAINT codigo_unidades_pk PRIMARY KEY (codigo),
    CONSTRAINT categorias_unid_fk FOREIGN KEY (categoria_UDM) 
	REFERENCES categorias_unidad_medida(  codigo)
);

insert into unidades_de_medida (codigo, descripcion, categoria_UDM)
values ('ml','mililitros','V'),
 ('l','litros','V'),
 ('u','unidad','U'),
('d','docena','U'),
 ('g','gramos','U'),
 ('kg','kilogramos','P'),
 ('lb','libras','P');
 

select * from  unidades_de_medida ;

drop table if exists productos;
CREATE TABLE productos (
    codigo_producto SERIAL not null,
    nombre VARCHAR(100) NOT NULL,
    
    udm VARCHAR(10) NOT NULL,
    precio_venta MONEY NOT NULL,
    tiene_iva BOOLEAN NOT NULL,
    coste MONEY NOT NULL,
    categoria INT NOT NULL,
	stock INT NOT NULL,
	
  CONSTRAINT  codigo_producto_pk  PRIMARY KEY (codigo_producto),
    CONSTRAINT udm_fk FOREIGN KEY (udm) 
	REFERENCES  unidades_de_medida(codigo),
	
	CONSTRAINT categoria_fk_producto FOREIGN KEY (categoria) 
	REFERENCES  categorias(codigo_cat)
);

INSERT INTO productos (codigo_producto, nombre, udm, precio_venta, tiene_iva, coste, categoria, stock)
VALUES 
    (1, 'Coca cola pequeña', 'u', 0.5804, true, 0.3729, 7, 105),
    (2, 'Salsa de tomate', 'kg', 0.95, true, 0.8736, 3, 0),
    (3, 'Mostaza', 'kg', 0.95, true, 0.89, 3, 0),
    (4, 'Fuze Tea', 'u', 0.8, true, 0.7, 7, 50);


select * from productos ;


drop table if exists proveedores;
CREATE TABLE proveedores (
    identificador VARCHAR(10) PRIMARY KEY,
    tipo_documento CHAR(1) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL
);
INSERT INTO proveedores (identificador, tipo_documento, nombre, telefono, correo, direccion)
VALUES 
    ('1792285747', 'R', 'SANTIAGO MO', '0992920306', 'zantycb89@g', 'Cumbayork'),
    ('179228555', 'R', 'SNACKS SA', '0992920398', 'snacks@gmai', 'La Tola');




drop table if exists cabecera_pedido ;

CREATE TABLE cabecera_pedido (
    numero SERIAL not NULL PRIMARY KEY,
    proveedor VARCHAR(100) NOT NULL,
    fecha DATE,
    estado CHAR(1) NOT NULL,
	
	CONSTRAINT proveedor_fk FOREIGN KEY (proveedor) 
	REFERENCES  proveedores(identificador),
	CONSTRAINT estado_fk FOREIGN KEY( estado) 
	REFERENCES  estado_pedido(codigo)
);
INSERT INTO cabecera_pedido ( proveedor, fecha, estado)
VALUES ( '1792285747', '30/11/2023', 'R'),
( '1792285747', '30/11/2023', 'R');

select * from cabecera_pedido ;




drop table if exists historial_stock  ;

CREATE TABLE historial_stock (
    codigo SERIAL NOT NULL PRIMARY key,
    fecha TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    referencia VARCHAR(100) NOT NULL,
    producto INT NOT NULL,
    cantidad INT NOT NULL,
	
	CONSTRAINT producto_fk_historial FOREIGN KEY( producto) 
	REFERENCES  productos (codigo_producto)
);

INSERT INTO historial_stock (codigo, fecha, referencia, producto, cantidad)
VALUES 
    (1, '2023-11-20 19:59', 'PEDIDO 1', 1, 100),
    (2, '2023-11-20 19:59', 'PEDIDO 1', 4, 50),
    (3, '2023-11-20 20:00', 'PEDIDO 2', 2, 50);
	
	select * from historial_stock;
	
	
drop table if exists detalle_pedido  ;	
	CREATE TABLE detalle_pedido (
    codigo SERIAL PRIMARY KEY not null,
    cabecera_pedido INT NOT NULL,
    producto INT NOT NULL,
    cantidad_solicitada INT NOT NULL,
    cantidad_recibida INT NOT NULL,
    subTotal MONEY NOT NULL,
	CONSTRAINT producto_fk_pedido FOREIGN KEY( producto) 
	REFERENCES  productos (codigo_producto)	,
	CONSTRAINT  cabecera_pedido_fk FOREIGN KEY( cabecera_pedido) 
	REFERENCES cabecera_pedido  (numero)	
);

INSERT INTO detalle_pedido (cabecera_pedido, producto, cantidad_solicitada, cantidad_recibida, subTotal)
VALUES 
    (1, 1, 100, 100, 37.29),
    (1, 4, 50, 50, 11.8),
    (2, 1, 10, 10, 3.73);

select * from detalle_pedido;


drop table if exists cabecera_ventas  ;	
CREATE TABLE cabecera_ventas (
    codigo SERIAL NOT NULL PRIMARY key,
    fecha TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    total_sin_iva MONEY NOT NULL,
    iva DECIMAL NOT NULL,
    total MONEY NOT NULL
);

INSERT INTO cabecera_ventas ( fecha, total_sin_iva, iva, total)
VALUES ('2023-11-20 20:30', 3.26, 0.39, 3.65);

select * from  cabecera_ventas;

drop table if exists detalle_ventas  ;	
CREATE TABLE detalle_ventas (
    codigo SERIAL PRIMARY KEY,
    cabecera_venta INT NOT NULL,
    producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_venta MONEY NOT NULL,
    subtotal MONEY NOT NULL,
    Total_con_iva MONEY NOT NULL,
	CONSTRAINT producto_fk_ventas FOREIGN KEY( producto) 
	REFERENCES  productos (codigo_producto)	,
	CONSTRAINT  cabecera_ventas_fk FOREIGN KEY( cabecera_venta) 
	REFERENCES cabecera_ventas  (codigo)
	
);


INSERT INTO detalle_ventas ( cabecera_venta, producto, cantidad, precio_venta, subtotal, total_con_iva)
VALUES ( 1, 1, 5, 0.58, 2.9, 3.25),(  1, 4, 1, 0.36, 0.36,0.4);

select * from  detalle_ventas;

