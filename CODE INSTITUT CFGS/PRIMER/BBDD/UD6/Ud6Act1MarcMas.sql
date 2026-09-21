-- Active: 1744015454928@@127.0.0.1@33700@Test
-- Calcular area cercle: PI * r^2
-- Calcular volum cilindre PI * r^2 * altura

CREATE PROCEDURE areaCercle(IN radi INT)
BEGIN
    DECLARE area FLOAT;
    SET @area = PI() * radi * radi;
END

CREATE PROCEDURE areaCercle2(IN radi INT, OUT area FLOAT)
BEGIN
    set area = PI() * radi * radi;
END

CREATE PROCEDURE volumCilindre(IN radi INT,IN altura INT)
BEGIN
    DECLARE volum float;
    CALL areaCercle(radi);
    SET @volum =  @area * altura;
END

CREATE PROCEDURE volumCilindre2(IN radi INT,IN altura INT, OUT volum FLOAT)
BEGIN
    CALL areaCercle2(radi,@area);
    SET volum =  @area * altura;
END

call areaCercle2 (7, @test);

select @test;

call volumCilindre2 (5, 10, @test);

select @volum;