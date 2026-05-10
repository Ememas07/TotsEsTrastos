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

drop Function mostrardeutes

CREATE OR REPLACE FUNCTION mostrarDeutes(grup int) RETURNS TABLE(usuariRep VARCHAR(300),usuariDeu VARCHAR(300),quantitat NUMERIC) AS
$BODY$
BEGIN
    RETURN QUERY SELECT pagadororiginal as usuariRep, idusuari as usuariDeu , sum(contribucio) as quantitat 
                FROM despesa 
                LEFT JOIN pagador ON pagador.iddespesa = despesa.id 
                WHERE hapagat = false AND idGrup = grup
                GROUP BY pagadororiginal,idusuari
                ORDER BY pagadororiginal;
    RETURN;
END;
$BODY$
language PLPGSQL;

-- select count noseque amb idDespesa
-- separar
--  i fer un insert
/* CREATE OR REPLACE PROCEDURE asignarImportUsuari (
IN import MONEY,
IN idUsuari VARCHAR(300),
IN idDespesa INT
); */

-- create procedure asignarUsuari (import, idUsuari, idDespesa)
-- agafar import total de la despesa
-- comprovar que import no sigui major al total
-- calcular el total nou
-- assignar-lo a tots els usuari -1 pero dividit entre el nou numero (120-50 = 70 /3 i assignar a tots)
-- assignar import especific a l'usuari especific

/* CREATE OR REPLACE FUNCTION arrodonirDespesa(idDespesa INT) -- TODO
RETURNS MONEY AS $$
DECLARE
pagat MONEY;
total MONEY;
BEGIN
pagat = (SELECT importpagat FROM despesa WHERE despesa.id = idDespesa);
total = (SELECT importtotal FROM despesa WHERE despesa.id = idDespesa);
IF (pagat + 0.01::money) = total THEN
RETURN total;
ELSE
RETURN pagat;
END IF;
END;
$$ LANGUAGE plpgsql; */