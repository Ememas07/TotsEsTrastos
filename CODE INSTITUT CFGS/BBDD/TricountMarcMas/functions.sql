-- Active: 1778078067998@@127.0.0.1@5432@TricountMarcMas@public
CREATE OR REPLACE FUNCTION arrodonir(pagat MONEY, total MONEY)
RETURNS MONEY AS $$
DECLARE
    result MONEY;
BEGIN
    IF (pagat + 0.01::money) = total THEN
        result = total;
    ELSE
        result = pagat;
    END IF;
    RETURN result;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION arrodonirDespesa(idDespesa INT) -- TODO
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
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE assignarPreuPartsIguals(IN preu MONEY,IN idDespesa INT);

DECLARE numPagadors = (
    SELECT COUNT(*)
    FROM pagador
    WHERE
        pagador.idDespesa = idDespesa
);

DECLARE contribucio = preu / numPagadors;

UPDATE despesa
WHERE
    despesa.id = idDespesa;

-- select count noseque amb idDespesa
-- separar
--  i fer un insert
CREATE
OR REPLACE PROCEDURE asignarImportUsuari (
    IN import MONEY,
    IN idUsuari VARCHAR(300),
    IN idDespesa INT
);

-- create procedure asignarUsuari (import, idUsuari, idDespesa)
-- agafar import total de la despesa
-- comprovar que import no sigui major al total
-- calcular el total nou
-- assignar-lo a tots els usuari -1 pero dividit entre el nou numero (120-50 = 70 /3 i assignar a tots)
-- assignar import especific a l'usuari especific