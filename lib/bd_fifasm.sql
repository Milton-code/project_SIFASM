CREATE DATABASE fifasm_bd;
	USE fifasm_bd;
    
    -- TABLA INVENTARIO
CREATE TABLE IF NOT EXISTS inventario (
	id_inventario INT AUTO_INCREMENT,
    nombre_producto VARCHAR(50) NOT NULL,
	tipo_producto VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    tamaño_producto VARCHAR(50),
    estilo_producto VARCHAR(50),
    fecha_ingreso VARCHAR(10) NOT NULL,
    precio_unitario FLOAT NOT NULL,
    cantidad_disponible INT NOT NULL,
    estado VARCHAR(10) NOT NULL,
    PRIMARY KEY (id_inventario)
);


-- TABLA SERVICIOS
CREATE TABLE IF NOT EXISTS servicios (
	id_servicio INT AUTO_INCREMENT,
    nombre_servicio VARCHAR(50) NOT NULL,
    descripcion_servicio VARCHAR(150) NOT NULL,
    precio_servicio FLOAT,
    PRIMARY KEY (id_servicio)
);


-- TABLA CAJA    
CREATE TABLE IF NOT EXISTS caja (
    id_caja INT AUTO_INCREMENT,
    nombre_prod_caja VARCHAR(50) NOT NULL,
    tipo_prod_caja VARCHAR(50) NOT NULL,
    categoria_prod_caja VARCHAR(50) NOT NULL,
    tamaño_prod_caja VARCHAR(50) NOT NULL,
    estilo_prod_caja VARCHAR(50),
    cantidad_compra INT NOT NULL,
    tipo_servicio VARCHAR(50),
    modo_pago VARCHAR(10),
    total_pago FLOAT,
    efectivo FLOAT,
    cambio FLOAT,
    fecha_salida VARCHAR(50),
    cantidad_restante FLOAT,
    id_inventario1 INT,
    PRIMARY KEY (id_caja),
    FOREIGN KEY (id_inventario1) REFERENCES inventario(id_inventario) ON UPDATE CASCADE ON DELETE RESTRICT
);


-- TABLA CLIENTE
CREATE TABLE IF NOT EXISTS cliente_solicitante (
	id_cliente INT AUTO_INCREMENT,
    nombre_cliente VARCHAR(50) NOT NULL,
    apellido_cliente VARCHAR(50) NOT NULL,
    tipo_documento VARCHAR(10) NOT NULL,
    numero_documento INT NOT NULL,
    estado_cliente VARCHAR(10),
    -- Registro difunto
    nombre_difunto VARCHAR(50) NOT NULL,
    apellido_difunto VARCHAR(50) NOT NULL,
    fecha_nacimiento VARCHAR(10) NOT NULL,
    fecha_fallecimiento VARCHAR(10) NOT NULL,
    msm_recordatorio VARCHAR(150),
    id_servicio1 INT,
    id_caja1 INT,
    PRIMARY KEY (id_cliente),
    FOREIGN KEY (id_servicio1) REFERENCES servicios(id_servicio) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (id_caja1) REFERENCES caja(id_caja) ON UPDATE CASCADE ON DELETE RESTRICT
);