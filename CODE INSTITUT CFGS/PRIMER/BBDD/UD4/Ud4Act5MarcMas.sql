-- Active: 1767885358260@@localhost@3306@act5
CREATE TABLE Empleado (
    dni INT(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30),
    cuentaBancaria VARCHAR(50) NOT NULL
)

CREATE TABLE Cliente (
    dni INT(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30)
)

CREATE TABLE Movil(
    codMovil INT(10) PRIMARY KEY,
    NombreCompleto VARCHAR(150) NOT NULL,
    PrecioCoste FLOAT(10) NOT NULL,
    PrecioVenta FLOAT(10) NOT NULL
)

CREATE TABLE Venta(
    idVenta INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni_empleado INT(8),
    dni_cliente INT(8),
    codMovil INT(10),
    cantidad INT(5) not null,
    Foreign Key (dni_empleado) REFERENCES Empleado(dni),
    Foreign Key (dni_cliente) REFERENCES Cliente(dni),
    Foreign Key (codMovil) REFERENCES Movil(codMovil)
)