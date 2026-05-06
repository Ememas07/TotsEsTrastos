-- Active: 1778078067998@@127.0.0.1@5432@TricountMarcMas@public
CREATE TABLE usuari (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    llinatge1 VARCHAR(100) NOT NULL,
    llinatge2 VARCHAR(100)
)

CREATE TABLE grup (
    id SERIAL PRIMARY KEY,
    descripcio VARCHAR(300),
    dataCreacio TIMESTAMP(5) with time zone NOT NULL
)

CREATE TABLE usuariGrup (
    idUsuari INTEGER,
    idGrup INTEGER,
    PRIMARY KEY (idUsuari, idGrup),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (id),
    FOREIGN KEY (idGrup) REFERENCES public.grup (id)
);

CREATE TABLE despesa (
    id SERIAL PRIMARY KEY,
    idGrup INTEGER,
    dataDespesa TIMESTAMP(5) with time zone NOT NULL,
    descripcio VARCHAR(500),
    categoria VARCHAR(100),
    importTotal MONEY NOT NULL,
    importPagat MONEY NOT NULL
)

CREATE TABLE pagador (
    id SERIAL PRIMARY KEY,
    idDespesa INTEGER NOT NULL,
    idUsuari INTEGER NOT NULL,
    contribucio MONEY NOT NULL,
    haPagat boolean NOT NULL,
    FOREIGN KEY (idDespesa) REFERENCES public.despesa (id),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (id)
)

CREATE TABLE log(
    id SERIAL PRIMARY KEY,
    idDespesa INTEGER NOT NULL,
    idUsuari INTEGER NOT NULL,
    oldRow VARCHAR(1000),
    newRow VARCHAR(1000),
    FOREIGN KEY (idDespesa) REFERENCES public.despesa (id),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (id)
)