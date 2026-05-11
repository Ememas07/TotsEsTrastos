-- Active: 1767885358260@@localhost@3306@act6
CREATE TABLE TIENDA (
    codTienda INT(10) PRIMARY KEY AUTO_INCREMENT,
    Domicilio VARCHAR(300) NOT NULL,
    Telefono INT(9) NOT NULL
)

CREATE TABLE Empleado (
    dni INT(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30),
    cuentaBancaria VARCHAR(50) NOT NULL,
    CodTienda INT(10),
    Foreign Key (CodTienda) REFERENCES Tienda (CodTienda)
)

CREATE TABLE Cliente (
    dni INT(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30)
)

CREATE TABLE Fabricante(
    Fabricante VARCHAR(300) PRIMARY KEY
)

CREATE TABLE Marca(
    Marca VARCHAR(300) PRIMARY KEY
)

CREATE TABLE Movil (
    codMovil INT(10) PRIMARY KEY,
    NombreCompleto VARCHAR(150) NOT NULL,
    PrecioCoste FLOAT(10) NOT NULL,
    PrecioVenta FLOAT(10) NOT NULL,
    Fabricante VARCHAR(300),
    Marca VARCHAR(300),
    Foreign Key (Fabricante) REFERENCES Fabricante (Fabricante),
    Foreign Key (Marca) REFERENCES Marca (Marca)
)

CREATE TABLE Proveedor(
    codProv INT(10) PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) not null,
    Telefono INT(9) NOT NULL
)

CREATE TABLE Venta (
    idVenta INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni_empleado INT(8),
    dni_cliente INT(8),
    codMovil INT(10),
    cantidad INT(5) NOT NULL,
    Foreign Key (dni_empleado) REFERENCES Empleado (dni),
    Foreign Key (dni_cliente) REFERENCES Cliente (dni),
    Foreign Key (codMovil) REFERENCES Movil (codMovil)
)

CREATE TABLE Compra (
    idCompra INT(10) PRIMARY KEY AUTO_INCREMENT,
    codTienda INT(10),
    codProv INT(10),
    codMovil INT(10),
    cantidad INT(5) not null,
    Foreign Key (codTienda) REFERENCES Tienda (codTienda),
    Foreign Key (codProv) REFERENCES Proveedor (codProv),
    Foreign Key (codMovil) REFERENCES Movil (codMovil)
)

