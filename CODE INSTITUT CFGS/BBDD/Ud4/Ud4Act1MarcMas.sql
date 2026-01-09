CREATE TABLE Alumne (
    dni int(8) NOT NULL PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    Ll1 VARCHAR(30) NOT NULL,
    Ll2 VARCHAR(30)
)

CREATE TABLE Assignatura (
    CodAssig VARCHAR(10) NOT NULL PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    NomHores Int(4) NOT NULL
)

CREATE TABLE Inscripció (
    dni int(8),
    CodAssig VARCHAR(10),
    Qualificació INT(2),
    PRIMARY KEY (dni, CodAssig),
    FOREIGN KEY(dni) references Alumne(dni),
    FOREIGN KEY(CodAssig) references Assignatura(CodAssig)
)