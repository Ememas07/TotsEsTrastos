-- Active: 1767885358260@@localhost@3306@fempo
CREATE TABLE Persona (
    dni int(8) PRIMARY KEY,
    Nom1 VARCHAR(30) NOT NULL,
    Nom2 VARCHAR(30),
    Llinatge1 VARCHAR(30) NOT NULL,
    Llinatge2 VARCHAR(30)
)

CREATE TABLE Director_IES (
    dni int(8) PRIMARY KEY,
    FOREIGN KEY (dni) REFERENCES Persona (dni)
)

CREATE TABLE Tutor_IES (
    dni int(8) PRIMARY KEY,
    FOREIGN KEY (dni) REFERENCES Persona (dni)
)

CREATE TABLE Alumne_IES (
    dni int(8) PRIMARY KEY,
    NAF int(12) UNIQUE,
    Curs VARCHAR(20) NOT NULL,
    FOREIGN KEY (dni) REFERENCES Persona (dni)
)

CREATE TABLE IES (
    idIES INT(10) PRIMARY KEY AUTO_INCREMENT,
    dniDirector_IES int(8),
    Nom VARCHAR(30) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefon int(9) NOT NULL,
    Codi_Postal INT(5) NOT NULL,
    Adreça VARCHAR(300) NOT NULL,
    FOREIGN KEY (dniDirector_IES) REFERENCES Director_IES (dni)
)

CREATE TABLE Cicle_Formatiu (
    idCF int(10) PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50) NOT NULL,
    Descripcio VARCHAR(500) NOT NULL,
    Curs VARCHAR(20) NOT NULL,
    Horari VARCHAR(50) NOT NULL
)

CREATE TABLE CF_IES (
    idCF_IES INT(10) PRIMARY KEY AUTO_INCREMENT,
    idIES INT(10),
    idCF INT(10),
    FOREIGN key (idIES) REFERENCES IES (idIES),
    FOREIGN KEY (idCF) REFERENCES Cicle_Formatiu (idCF)
)

CREATE TABLE Modul (
    idModul int(10) PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50) NOT NULL,
    Descripcio VARCHAR(500) NOT NULL
)

CREATE TABLE Modul_CF (
    idModul_CF INT(10) PRIMARY KEY AUTO_INCREMENT,
    idModul INT(10),
    idCF INT(10),
    FOREIGN KEY (idModul) REFERENCES Modul (idModul),
    FOREIGN KEY (idCF) REFERENCES Cicle_Formatiu (idCF)
)

CREATE TABLE Resultats_Aprenentatge (
    idRA int(10) PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50) NOT NULL,
    Descripcio VARCHAR(500) NOT NULL
)

CREATE TABLE Modul_RA (
    idModul_RA INT(10) PRIMARY KEY AUTO_INCREMENT,
    idModul INT(10),
    idRA INT(10),
    FOREIGN KEY (idModul) REFERENCES Modul (idModul),
    FOREIGN KEY (idRA) REFERENCES Resultats_Aprenentatge (idRA)
)

CREATE TABLE Control_Activitats (
    idCA int(10) PRIMARY KEY AUTO_INCREMENT,
    Descripcio VARCHAR(500) NOT NULL,
    idRA INT(10),
    FOREIGN KEY (idRA) REFERENCES Resultats_Aprenentatge (idRA)
)

CREATE TABLE Empresa (
    nif INT(8) PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefon int(9) NOT NULL,
    Codi_Postal INT(5) NOT NULL,
    Adreça VARCHAR(300) NOT NULL
)

CREATE TABLE Director_Empresa (
    dni int(8) PRIMARY KEY,
    nif int(8),
    FOREIGN KEY (dni) REFERENCES Persona (dni),
    FOREIGN key (nif) REFERENCES Empresa (nif)
)

CREATE TABLE Tutor_Empresa (
    dni int(8) PRIMARY KEY,
    FOREIGN KEY (dni) REFERENCES Persona (dni)
)

CREATE TABLE Tutors_Empresa (
    idTutors_Empresa INT(10) PRIMARY KEY AUTO_INCREMENT,
    dni INT(8),
    nif INT(8),
    FOREIGN key (dni) REFERENCES Tutor_Empresa (dni),
    FOREIGN key (nif) REFERENCES Empresa (nif)
)

CREATE TABLE Annex (
    idAnnex INT(10) PRIMARY KEY,
    dni_tutor_empresa INT(8),
    dni_tutor_ies INT(8),
    Numero_Hores INT(5) NOT NULL,
    FOREIGN KEY (dni_tutor_ies) REFERENCES Tutor_Empresa (dni),
    FOREIGN KEY (dni_tutor_ies) REFERENCES Tutor_ies (dni)
)

CREATE TABLE Alumne_Annex (
    dni int(8) PRIMARY KEY,
    DataEntrada DATE NOT NULL,
    DataSortida DATE NOT NULL,
    idAnnex INT(10),
    FOREIGN KEY (idAnnex) REFERENCES Annex (idAnnex),
    FOREIGN KEY (dni) REFERENCES Alumne_ies (dni)
)

CREATE TABLE Pla_Formatiu (
    idPF INT(10) PRIMARY KEY AUTO_INCREMENT,
    idIES INT(10),
    dni_tutor_IES INT(8),
    FOREIGN KEY (idIES) REFERENCES ies (idIES),
    FOREIGN KEY (dni_tutor_IES) REFERENCES tutor_ies (dni)
)

CREATE TABLE PF_Annex (
    idPF INT(10),
    idAnnex INT(10),
    PRIMARY KEY (idPF, idAnnex),
    FOREIGN KEY (idPF) REFERENCES Pla_Formatiu (idPF),
    FOREIGN KEY (idAnnex) REFERENCES Annex (idAnnex)
)

CREATE TABLE PF_CA (
    idPF_CA INT(10) PRIMARY KEY AUTO_INCREMENT,
    idPF INT(10),
    idCA INT(10),
    FOREIGN KEY (idPF) REFERENCES Pla_Formatiu (idPF),
    FOREIGN KEY (idCA) REFERENCES Control_Activitats (idCA)
)

CREATE TABLE Acord (
    idAcord INT(10) PRIMARY key AUTO_INCREMENT,
    nifEmpresa int(8),
    Data DATE NOT NULL,
    Descripcio VARCHAR(500) NOT NULL
)

CREATE TABLE Acord_Annex (
    idAcord INT(10),
    idAnnex INT(10),
    FOREIGN KEY (idAcord) REFERENCES Acord (idAcord),
    FOREIGN KEY (idAnnex) REFERENCES Annex (idAnnex)
)