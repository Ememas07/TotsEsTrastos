CREATE TABLE Director (
    dni int(8) NOT NULL PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    Domicilio VARCHAR(200) NOT NULL,
    Telefono int(9) NOT NULL,
    Email VARCHAR(100)
)
CREATE TABLE Supermercado(
    CodSup int(5) PRIMARY KEY AUTO_INCREMENT,
    Direccion VARCHAR(200) NOT NULL,
    
)