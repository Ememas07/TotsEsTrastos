-- Active: 1778078067998@@127.0.0.1@5432@TricountMarcMas@public
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

CREATE OR REPLACE PROCEDURE assignarPreuPartsIguals(IN preu MONEY,IN despesa INT)
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

CREATE OR REPLACE PROCEDURE castIban(IN input VARCHAR(50), OUT resultat iban)
LANGUAGE plpgsql AS $$
DECLARE l CHAR;
DECLARE n BIGINT;
BEGIN
l = left(input,2);
n = right(input, input.length-2);
resultat.lletres = l;
resultat.numeros = n;
END;
$$;

CREATE OR REPLACE FUNCTION mostrarDeutes(grup INT)
RETURNS TABLE(usuariRep VARCHAR(300),usuariDeu VARCHAR(300),quantitat NUMERIC) AS
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

CREATE OR REPLACE FUNCTION mostrarDespesesCategoria(grup INT) 
RETURNS TABLE (cat varchar(300),import NUMERIC, percent VARCHAR) AS
$BODY$
BEGIN
    RETURN QUERY SELECT 
    categoria,
    sumatotal, 
    TO_CHAR(sumatotal * 100 / SUM(sumatotal) OVER (), 'fm90D00%')::VARCHAR AS percent
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

CREATE OR REPLACE FUNCTION mostrarDespesesUsuari(grup INT) 
RETURNS TABLE (usuari varchar(300),import NUMERIC) AS
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