-- Active: 1767885358260@@localhost@3306@act3
CREATE TABLE Alumno(
    dni int(8) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    Ap1 VARCHAR(30) NOT NULL,
    Ap2 VARCHAR(30)
)

CREATE TABLE Asignatura(
    codAsig VARCHAR(100) PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    NumHoras INT(100) NOT NULL
)

CREATE TABLE Matricula(
    id_Alumno_Matricula INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni_Alumno INT(8),
    codAsig VARCHAR(100),
    Calificacion INT(3) NOT NULL,
    Foreign Key (dni_alumno) REFERENCES Alumno(dni),
    Foreign Key (codAsig) REFERENCES Asignatura(codAsig)
)
