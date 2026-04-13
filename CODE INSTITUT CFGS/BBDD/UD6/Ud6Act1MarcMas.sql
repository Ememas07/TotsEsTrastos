-- Calcular area cercle: PI * r^2
-- Calcular volum cilindre PI * r^2 * altura

CREATE PROCEDURE areaCercle(IN radi INT)
BEGIN
    DECLARE area FLOAT;
    SET @area = PI() * radi * radi;
END

CREATE PROCEDURE volumCilindre(IN radi INT,IN altura INT)
BEGIN
    DECLARE volum float;
    CALL areaCercle(radi);
    SET @volum =  @area * altura;
END
call areaCercle(7);
select @area;

call volumCilindre(5,10);
select @volum;
