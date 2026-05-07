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