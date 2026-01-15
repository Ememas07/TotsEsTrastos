-- Active: 1767885358260@@localhost@3306@act4
CREATE TABLE Profesor (
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30),
    Direccion VARCHAR(300) NOT NULL,
    Cuenta VARCHAR(50) NOT NULL,
    Telefono INT(9) NOT NULL
)

CREATE TABLE Profesor_Idiomas (
    id_profesor_pdiomas INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni INT(8),
    Idioma VARCHAR(30),
    Foreign Key (dni) REFERENCES Profesor (dni)
)

CREATE TABLE Asignatura (
    codAsig INT(10) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    NumHoras INT(10) NOT NULL,
    dni_profesor INT(10),
    codCiclo INT(10),
    Foreign Key (dni_profesor) REFERENCES Profesor (dni),
    Foreign Key (codCiclo) REFERENCES CicloForm (codCiclo)
)

CREATE TABLE CicloForm (
    codCiclo INT(10) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Tipo VARCHAR(30) NOT NULL
)

Create TABLE Alumno (
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30),
    Direccion VARCHAR(300) NOT NULL,
    Email VARCHAR(300) NOT NULL,
    Telefono INT(9) NOT NULL
)

CREATE TABLE Matricula (
    id_Alumno_Matricula INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni_Alumno INT(8),
    codAsig int (10),
    Foreign Key (dni_alumno) REFERENCES Alumno (dni),
    Foreign Key (codAsig) REFERENCES Asignatura (codAsig)
)