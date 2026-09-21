/* Escriu una funció anomenada comptar_empleats que rebi com entrada el nom de l'ofici i retorni el nombre d'empleats que amb aquest ofici. */

CREATE FUNCTION contar_empleats (nomOfici VARCHAR(100))
    returns int UNSIGNED
BEGIN
  return (SELECT
    COUNT(*)
  FROM
    emp
  WHERE
    ofici = nomOfici);
END