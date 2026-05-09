-- Active: 1778078067998@@127.0.0.1@5432@TricountMarcMas@public

CREATE TYPE public.IBAN AS
(
	Lletres character(2),
	Numeros bigint
);

CREATE TABLE usuari (
    correu VARCHAR(300) PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    llinatge1 VARCHAR(100) NOT NULL,
    llinatge2 VARCHAR(100),
    IBAN VARCHAR(50) NOT NULL,
    alias VARCHAR(100)
)

CREATE TABLE grup (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descripcio VARCHAR(300),
    dataCreacio TIMESTAMP(5) with time zone NOT NULL
)

CREATE TABLE usuariGrup (
    idUsuari VARCHAR(300),
    idGrup INTEGER,
    PRIMARY KEY (idUsuari, idGrup),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (correu),
    FOREIGN KEY (idGrup) REFERENCES public.grup (id)
);

CREATE TABLE despesa (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idGrup INTEGER NOT NULL,
    pagadorOriginal VARCHAR(300) NOT NULL,
    dataDespesa TIMESTAMP(5) with time zone NOT NULL,
    descripcio VARCHAR(500),
    categoria VARCHAR(100),
    importTotal NUMERIC(10,2) NOT NULL,
    importPagat NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (idGrup) REFERENCES public.grup (id),
    FOREIGN KEY (pagadorOriginal) REFERENCES public.usuari (correu)
)

CREATE TABLE pagador (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idDespesa INTEGER NOT NULL,
    idUsuari VARCHAR(300) NOT NULL,
    contribucio NUMERIC(10,2) NOT NULL,
    haPagat boolean NOT NULL,
    FOREIGN KEY (idDespesa) REFERENCES public.despesa (id),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (correu)
)

CREATE TABLE log(
    id SERIAL PRIMARY KEY,
    datetime TIMESTAMP(5) with time zone NOT NULL,
    oldRow VARCHAR(1000),
    newRow VARCHAR(1000)
)