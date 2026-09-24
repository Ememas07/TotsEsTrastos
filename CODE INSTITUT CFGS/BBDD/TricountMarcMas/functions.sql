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