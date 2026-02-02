-- Active: 1767885358260@@localhost@3306@act2
CREATE TABLE Director (
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    Domicilio VARCHAR(200) NOT NULL,
    Telefono int(9) NOT NULL,
    Email VARCHAR(100)
)

CREATE TABLE Supermercado (
    CodSup int(10) PRIMARY KEY AUTO_INCREMENT,
    Direccion VARCHAR(200) NOT NULL,
    Superficie INT(10) NOT NULL,
    esAlquiler BOOLEAN NOT NULL,
    FECHA DATE NOT NULL,
    DNI INT(8),
    FOREIGN KEY (dni) REFERENCES Director (dni)
)

CREATE TABLE Vendedor (
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    Domicilio VARCHAR(200) NOT NULL,
    Telefono int(9) NOT NULL,
    Email VARCHAR(100),
    CodSup int(10),
    FOREIGN KEY (CodSup) REFERENCES Supermercado (CodSup)
)

CREATE TABLE Cliente (
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    Domicilio VARCHAR(200) NOT NULL,
    Telefono int(9) NOT NULL,
    Email VARCHAR(100)
)

CREATE TABLE Venta (
    CodVenta int(10) PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    dniVend int(8),
    dniCl int(8),
    FOREIGN KEY (dniVend) REFERENCES Vendedor (dni),
    FOREIGN KEY (dniCl) REFERENCES Cliente (dni)
)

CREATE TABLE Producto (
    CodProducto int(10) PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(300) NOT NULL,
    Descuento INT(3),
    IVA INT(3) NOT NULL
)

CREATE TABLE LineaVenta (
    CodVenta int(10),
    numLinea int(10),
    cantidad int(4) NOT NULL,
    PRIMARY KEY (CodVenta, numLinea),
    Foreign Key (CodVenta) REFERENCES Venta (CodVenta)
)

CREATE TABLE Devolucion (
    CodVenta int(10),
    numLinea int(10),
    Fecha DATETIME,
    Estado VARCHAR(100) NOT NULL,
    TipoDev int(2) NOT NULL,
    PRIMARY KEY (CodVenta, numLinea, fecha),
    FOREIGN KEY (CodVenta, numLinea) REFERENCES LineaVenta (CodVenta, numLinea)
)

CREATE TABLE Precio (
    CodProd INT(10),
    Fecha DATE,
    precio INT(5) NOT NULL,
    PRIMARY KEY (CodProd, Fecha),
    Foreign Key (CodProd) REFERENCES Producto (CodProducto)
)