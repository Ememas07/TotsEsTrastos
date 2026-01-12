-- Active: 1767885358260@@localhost@3306@act2ambcanvis
-- a) El telèfon i el correu dels directors, venedors i clients són obligatoris i no es poden compartir entre ells.
ALTER TABLE director
MODIFY Telefono int(9) UNIQUE NOT NULL,
MODIFY email VARCHAR(100) UNIQUE NOT NULL;

ALTER TABLE vendedor
MODIFY Telefono int(9) UNIQUE NOT NULL,
MODIFY email VARCHAR(100) UNIQUE NOT NULL;

ALTER TABLE cliente
MODIFY Telefono int(9) UNIQUE NOT NULL,
MODIFY email VARCHAR(100) UNIQUE NOT NULL;

-- b) El camp Telefon de les taules Director, Venedor i Client ha de tenir nou dígits.
ALTER TABLE director MODIFY Telefono int(9);

ALTER TABLE vendedor MODIFY Telefono int(9);

ALTER TABLE cliente MODIFY Telefono int(9);
ALTER TABLE cliente MODIFY Telefono int(9) UNIQUE NOT NULL;

-- c) Els camps dni han de tenir entre 7 i 8 dígits numèrics.
ALTER TABLE director 
ADD CHECK (dni > 999999),
ADD CHECK (dni < 100000000);


-- d) A la taula Venda el DNI del venedor ha de ser diferent del DNI del client.

-- e) A la taula Producte la descripció és única i per a les claus foranes Família i Genere s'inclou la restricció d'integritat referencial ON DELETE SET NULL.

-- f) A la taula LineaVenda, el camp numLinea es limita al rang [1-99].