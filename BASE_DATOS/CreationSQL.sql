create table PROVEEDOR (
    codigo_proveedor varchar(10),
    ruc varchar(13),
    nombre_proveedor varchar(30),
    direccion varchar(50),
    telefonos varchar(13),
    emails varchar(50),
    usuario_registro varchar(30),
    fecha_registro varchar(30),
    primary key(codigo_proveedor)
);

create table SUBGRUPO (
    codigo_subgrupo varchar(10),
    descripcion_subgrupo varchar(13),
    usuario_subgrupo varchar(30),
    fecha_registro varchar(50),
    primary key(codigo_subgrupo)
);

create table BODEGA (
    codigo_bodega varchar(10),
    nombre_bodega varchar(30),
    usuario_bodega varchar(30),
    fecha_registro varchar(50),
    primary key(codigo_bodega)
);