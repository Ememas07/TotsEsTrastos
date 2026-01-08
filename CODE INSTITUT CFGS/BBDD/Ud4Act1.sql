CREATE TABLE Alumne(  
    dni int(8) NOT NULL PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    Ll1 VARCHAR(30) NOT NULL,
    Ll2 VARCHAR(30)
)

CREATE TABLE Assignatura(  
    CodAssig VARCHAR(10) NOT NULL PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    NomHores Int(4) NOT NULL
)

CREATE TABLE Inscripció(
    dni int(8) FOREIGN KEY REFERENCES Alumne(dni),
    CodAssig VARCHAR(10) FOREIGN KEY REFERENCES Assignatura(CodAssig),
    Qualificació INT(2),
)