-- Active: 1778856311013@@127.0.0.1@5432@TricountMarcMas@public

CREATE TABLE usuari (
    correu TEXT PRIMARY KEY,
    nom TEXT NOT NULL,
    llinatge1 TEXT,
    llinatge2 TEXT,
    IBAN TEXT NOT NULL,
    alias TEXT
)

CREATE TABLE grup (
    id SERIAL PRIMARY KEY,
    nom TEXT,
    descripcio TEXT,
    dataCreacio TIMESTAMP(5) WITH TIME ZONE NOT NULL
)

CREATE TABLE usuariGrup (
    idUsuari TEXT,
    idGrup INTEGER,
    PRIMARY KEY (idUsuari, idGrup),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (correu),
    FOREIGN KEY (idGrup) REFERENCES public.grup (id)
);

CREATE TABLE despesa (
    id SERIAL PRIMARY KEY,
    idGrup INTEGER NOT NULL,
    pagadorOriginal TEXT NOT NULL,
    dataDespesa TIMESTAMP(5) WITH TIME ZONE NOT NULL,
    descripcio TEXT,
    categoria TEXT,
    importTotal NUMERIC(10, 2) NOT NULL,
    importPagat NUMERIC(10, 2),
    FOREIGN KEY (idGrup) REFERENCES public.grup (id),
    FOREIGN KEY (pagadorOriginal) REFERENCES public.usuari (correu)
)

CREATE TABLE pagador (
    id SERIAL PRIMARY KEY,
    idDespesa INTEGER NOT NULL,
    idUsuari TEXT NOT NULL,
    contribucio NUMERIC(10, 2) NOT NULL,
    haPagat BOOLEAN NOT NULL,
    FOREIGN KEY (idDespesa) REFERENCES public.despesa (id),
    FOREIGN KEY (idUsuari) REFERENCES public.usuari (correu)
)

CREATE TABLE log(
    id SERIAL PRIMARY KEY,
    datetime TIMESTAMP(5) WITH TIME ZONE NOT NULL,
    oldRow TEXT,
    newRow TEXT
)