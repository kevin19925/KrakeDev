create table productos1 (
codigo int not null,
nombre varchar (50) not null,
stock int not null,
constraint productos_pk primary key (codigo)
	)
	
	create table proveedores1(
codigo int not null,
nombre varchar (50) not null,
telefono char (10) not null,
constraint proveedores_pk primary key (codigo))


create table productos_por_proveedor1 (
pp_codigo_producto int not null,
pp_codigo_proveedor int not null,
pp_precio money int not null,
constraint producto_fk foreign key (pp_codigo_producto) references productos (codigo),
constraint proveedor_fk foreign key (pp_codigo_proveedor) references proveedores (codigo),
constraint productos_por_proveedor_pk primary key (pp_codigo_producto,pp_codigo_proveedor)