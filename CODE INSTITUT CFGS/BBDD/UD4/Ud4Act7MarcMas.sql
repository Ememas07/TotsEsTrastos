-- Active: 1767885358260@@localhost@3306@act7

CREATE TABLE Sede (
    codSede INT(10) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Direccion VARCHAR(300) not null
)

CREATE TABLE Departamento (
    codDep INT(10) PRIMARY key,
    Nombre VARCHAR(30) NOT NULL,
    Direccion VARCHAR(300) not null,
    sedeDep INT(10),
    Foreign Key (sedeDep) REFERENCES Sede (codSede)
)

CREATE TABLE Programador (
    dni INT(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30),
    Direccion VARCHAR(300) NOT NULL,
    Cuenta VARCHAR(50) NOT NULL,
    Telefono INT(8) NOT NULL,
    Tipo VARCHAR(30) NOT NULL,
    dniMentor INT(8),
    codDep INT(10),
    Foreign Key (dniMentor) REFERENCES Programador (dni),
    Foreign Key (codDep) REFERENCES Departamento (codDep)
)