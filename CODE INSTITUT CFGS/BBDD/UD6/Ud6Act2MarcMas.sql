-- Active: 1744015454928@@127.0.0.1@33700@empresa
-- Activitat 6.2
/* 
Utilitzar la base de dades empresa (BBDD - UD4. Definició, manipulació i control de dades.pdf diapositiva 81)

Escriu un procediment anomenat comptar_empleats que rebi com entrada el nom de l'ofici i retorni el nombre d'empleats que amb aquest ofici. L'has de resoldre de dos maneres: 
Emprant SET
Emprant SELECT...INTO */

CREATE PROCEDURE contar_empleats (IN nomOfici VARCHAR(100), OUT numEmpleats INT)
BEGIN
  SET numEmpleats = (SELECT
    COUNT(*)
  FROM
    emp
  WHERE
    ofici = nomOfici);
END

CREATE PROCEDURE contar_empleats2 (IN nomOfici VARCHAR(100), OUT numEmpleats INT)
BEGIN
  SELECT
    COUNT(*) into numEmpleats
  FROM
    emp
  WHERE
    ofici = nomOfici ;
END