-- CREATE
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

-- FUNCIONS
-- Active: 1778856311013@@127.0.0.1@5432@TricountMarcMas@public
CREATE OR REPLACE FUNCTION arrodonir(pagat NUMERIC, total NUMERIC)
RETURNS NUMERIC AS $$
DECLARE
    result NUMERIC;
BEGIN
    IF (pagat + 0.01) = total THEN
        result = total;
    ELSE
        result = pagat;
    END IF;
    RETURN result;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE assignarPreuPartsIguals(IN preu NUMERIC,IN despesa INT)
LANGUAGE plpgsql 
AS $$
DECLARE numPagadors INTEGER;
BEGIN
numPagadors = (
    SELECT COUNT(*)
    FROM pagador
    WHERE
        pagador.idDespesa = despesa
);
UPDATE pagador
SET
    contribucio = (preu / numPagadors)
WHERE
    pagador.iddespesa = despesa;
END
$$;


CREATE OR REPLACE FUNCTION mostrarDeutesGrup(grup INT)
RETURNS TABLE(usuariRep TEXT,usuariDeu TEXT,quantitat NUMERIC) AS
$BODY$
BEGIN
    RETURN QUERY SELECT pagadororiginal AS usuariRep, idusuari AS usuariDeu , sum(contribucio) AS quantitat 
                FROM despesa 
                LEFT JOIN pagador ON pagador.iddespesa = despesa.id 
                WHERE hapagat = false AND idGrup = grup
                GROUP BY pagadororiginal,idusuari
                ORDER BY pagadororiginal;
    RETURN;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION mostrarDespesesCategoriaGrup(grup INT) 
RETURNS TABLE (cat TEXT,import NUMERIC, percent TEXT) AS
$BODY$
BEGIN
    RETURN QUERY SELECT 
    categoria,
    sumatotal, 
    TO_CHAR(sumatotal * 100 / SUM(sumatotal) OVER (), 'fm90D00%')::TEXT AS percent
    FROM (
        SELECT categoria, SUM(importtotal) AS sumatotal
        FROM despesa
        WHERE despesa.idgrup = grup
        GROUP BY categoria
    )
    RETURN;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION mostrarDespesesUsuarisGrup(grup INT) 
RETURNS TABLE (usuari TEXT,import NUMERIC) AS
$BODY$
BEGIN
    RETURN QUERY SELECT idusuari, sumatotal
FROM (
        SELECT idusuari, sum(contribucio) AS sumatotal, idgrup
        from despesa
            LEFT JOIN pagador ON pagador.iddespesa = despesa.id
        WHERE
            hapagat = true
        GROUP BY
            idgrup, idusuari
        ORDER BY idgrup
    )
    WHERE idGrup = grup;
    RETURN;
END;
$BODY$
LANGUAGE plpgsql;       

-- TRIGGERS I TRIGGER FUNCTIONS


CREATE OR REPLACE FUNCTION public.omplirLog()
  RETURNS trigger
  LANGUAGE plpgsql 
AS $BODY$
BEGIN
  INSERT INTO LOG (datetime, oldrow,newrow)
  VALUES
  (NOW(),OLD::text, NEW::text);
  RETURN NULL;
END;
$BODY$

CREATE OR REPLACE TRIGGER omplirLog AFTER
INSERT OR UPDATE OR DELETE ON despesa
for each row
execute PROCEDURE PUBLIC.omplirLog();

CREATE OR REPLACE FUNCTION public.actualitzarImport()
    RETURNS trigger
    LANGUAGE plpgsql
AS $BODY$
BEGIN
UPDATE despesa set importpagat = (
    SELECT sum(contribucio) 
	FROM pagador 
	WHERE pagador.iddespesa = despesa.id
	AND hapagat='true')::numeric 
    WHERE despesa.id = id;
RETURN NULL;
END;
$BODY$;

CREATE OR REPLACE TRIGGER actualitzarImport AFTER
INSERT OR UPDATE OR DELETE ON pagador
execute PROCEDURE PUBLIC.actualitzarImport();

CREATE OR REPLACE FUNCTION public.arrodonirImport()
    RETURNS trigger
    LANGUAGE plpgsql
AS $BODY$
BEGIN
NEW.importpagat := arrodonir(NEW.importpagat,NEW.importtotal);
RETURN NEW;
END;
$BODY$;

CREATE OR REPLACE TRIGGER arrodonirImport
BEFORE UPDATE OF importpagat
ON despesa
FOR EACH ROW
execute PROCEDURE PUBLIC.arrodonirImport();

-- SELECTS

-- Active: 1778856311013@@127.0.0.1@5432@TricountMarcMas@public

-- Mostrar import i % de despeses de cada categoria
SELECT categoria, sumatotal, TO_CHAR(
        sumatotal * 100 / SUM(sumatotal) OVER (), 'fm90D00%'
    ) AS percent
FROM (
        SELECT categoria, SUM(importtotal) AS sumatotal
        FROM despesa
        GROUP BY
            categoria
    )

-- Doblers gastat per cada usuari (pagats)
SELECT idusuari, sum(contribucio)
FROM pagador
WHERE
    hapagat = true
GROUP BY
    idusuari;

-- Doblers pendents per pagar a cada usuari
SELECT idusuari, sum(contribucio)
FROM pagador
WHERE
    hapagat = false
GROUP BY
    idusuari;

-- Doblers gastat per cada grup
SELECT sum(importtotal), idgrup
FROM pagador p
    LEFT JOIN despesa d ON (p.iddespesa = d.id)
GROUP BY
    d.idgrup

-- Nombre de despeses que ha pagat cada usuari per advantat
SELECT count(*) as recompte, pagadororiginal
from despesa
group by
    pagadororiginal
ORDER BY recompte

-- Doblers pendents de cada persona a cada persona
SELECT
    pagadororiginal as recaudador,
    idusuari as debtor,
    sum(contribucio) as quantitat
FROM despesa
    LEFT JOIN pagador ON pagador.iddespesa = despesa.id
WHERE
    hapagat = false
    -- AND idGrup = 100 -- opcionalment es pot filtrar per nomes un grup
GROUP BY
    pagadororiginal,
    idusuari
ORDER BY pagadororiginal;

-- Mostrar import de despeses de cada usuari per cada grup
SELECT idusuari, sumatotal, idgrup
FROM (
        SELECT idusuari, sum(contribucio) AS sumatotal, idgrup
        from despesa
            LEFT JOIN pagador ON pagador.iddespesa = despesa.id
        WHERE
            hapagat = true
            -- AND idGrup = 100 -- opcionalment es pot filtrar per nomes un grup */
        GROUP BY
            idgrup, idusuari
        ORDER BY idgrup
    )


