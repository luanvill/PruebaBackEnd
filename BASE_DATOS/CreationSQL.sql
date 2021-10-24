create table PROVEEDOR (
    codigo_proveedor numeric(10) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    ruc varchar(13) not null,
    nombre_proveedor varchar(30) not null,
    direccion varchar(50) not null,
    telefonos varchar(13) not null,
    emails varchar(50) not null,
    usuario_registro varchar(30) not null,
    fecha_registro date not null,
    primary key(codigo_proveedor)
);

create table SUBGRUPO (
    codigo_subgrupo numeric(10) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    descripcion_subgrupo varchar(13) not null,
    usuario_subgrupo varchar(30) not null,
    fecha_registro date not null,
    primary key(codigo_subgrupo)
);

create table BODEGA (
    codigo_bodega numeric(10) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    nombre_bodega varchar(30) not null,
    usuario_bodega varchar(30) not null,
    fecha_registro date not null,
    primary key(codigo_bodega)
);

create table ITEM (
    codigo_item numeric(10) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    grupo varchar(3) CONSTRAINT chgrupo CHECK (grupo in ('PRO', 'SER'))  not null,
    subgrupo numeric(10) not null,
    descripcion_item varchar(50) not null,
    stock numeric(10) not null,
    precio numeric(10) not null,
    codigo_bodega numeric(10) not null,
    estado varchar(3)CONSTRAINT chestado CHECK (estado in ('ACT', 'INA'))  not null,
    usuario_registro varchar(30) not null,
    fecha_registro date not null,
    primary key(codigo_item),
    CONSTRAINT fk_subgrupo
        FOREIGN KEY (subgrupo)
        REFERENCES SUBGRUPO(codigo_subgrupo)
        ON DELETE CASCADE,
    CONSTRAINT fk_bodega
        FOREIGN KEY (codigo_bodega)
        REFERENCES BODEGA(codigo_bodega)
        ON DELETE CASCADE
);

create table MOVIMIENTO (
    secuencia numeric(20) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    codigo_item numeric(10) not null,
    codigo_proveedor numeric(10) not null,
    fecha_hora_movimiento varchar(50) not null,
    tipo_movimiento varchar(3) CONSTRAINT chtipoMov CHECK (tipo_movimiento in ('ING', 'SAL'))  not null,
    cantidad numeric(20) not null,
    usuario_bodega varchar(30) not null,
    fecha_registro date not null,
    primary key(secuencia),
    CONSTRAINT fk_item
        FOREIGN KEY (codigo_item)
        REFERENCES ITEM(codigo_item)
        ON DELETE CASCADE,
    CONSTRAINT fk_proveedor
        FOREIGN KEY (codigo_proveedor)
        REFERENCES PROVEEDOR(codigo_proveedor)
        ON DELETE CASCADE
);

INSERT INTO PROVEEDOR(ruc,nombre_proveedor,direccion,telefonos,emails,usuario_registro,fecha_registro) VALUES ('222','nomProv','direccionPru2','1324','ejeplo2@gmail.com','pruebaUser2',TO_DATE(SYSDATE, 'DD/MM/YYYY'));
INSERT INTO SUBGRUPO(descripcion_subgrupo,usuario_subgrupo,fecha_registro) VALUES ('descripcionP2','pruebaUser',TO_DATE(SYSDATE, 'DD/MM/YYYY'));
INSERT INTO BODEGA(nombre_bodega,usuario_bodega,fecha_registro) VALUES ('nombrePrueba','pruebaUser',TO_DATE(SYSDATE, 'DD/MM/YYYY'));
INSERT INTO ITEM(grupo,subgrupo,descripcion_item,stock,precio,codigo_bodega,estado,usuario_registro,fecha_registro) VALUES ('PRO',1,'descripcionPrueba',50,100,1,'ACT','pruebaUser',TO_DATE(SYSDATE, 'DD/MM/YYYY'));
INSERT INTO MOVIMIENTO(codigo_item,codigo_proveedor,fecha_hora_movimiento,tipo_movimiento,cantidad,usuario_bodega,fecha_registro) VALUES (1,1,TRUNC(SYSDATE),'ING',50,'pruebaUser',TO_DATE(SYSDATE, 'DD/MM/YYYY'));

COMMIT;

create or replace trigger actualizar_stock
after update
    on MOVIMIENTO
    for each row
declare
    ejemplo numeric(10);
    cantidad_trigger numeric(20);
    indice numeric(10);

begin
    SELECT stock INTO ejemplo
    FROM ITEM;
    SELECT cantidad INTO cantidad_trigger
    FROM MOVIMIENTO;
    SELECT codigo_item INTO indice
    FROM MOVIMIENTO;
    
    IF (ejemplo - cantidad_trigger) >= 0
    THEN
        UPDATE ITEM
        SET stock = ejemplo - cantidad_trigger
        WHERE  codigo_item = indice;
    END IF;
end;

--CREATE OR REPLACE PROCEDURE PROCEDUREPRUEBA 
--(
  --CODIGO IN NUMBER 
--) AS 
    --cursor c1 is
       --SELECT course_number
        --FROM courses_tbl
        --WHERE course_name = name_in;
--BEGIN
    --descripcion_item,stock,precio
  --NULL;
--END PROCEDUREPRUEBA;