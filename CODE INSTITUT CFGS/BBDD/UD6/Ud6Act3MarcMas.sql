/** 
Escriu un procediment anomenat calcular_max_min_mitja que rebi com entrada el codi de client i retorni l'import màxim, el mínim i la mitjana de les comandes realitzades per un client. L'has de resoldre de dos maneres:
Emprant SET
Emprant SELECT...INTO
**/

CREATE PROCEDURE max_min_mitja (IN codiClient int, OUT maxim float, out minim float, out mitjana float)
BEGIN
  SET maxim = (select max(total) from `COMANDA` GROUP BY `CLIENT_COD`);
  SET minim = (select min(total) from `COMANDA` GROUP BY `CLIENT_COD`);
  SET mitjana = (select avg(total) from `COMANDA` GROUP BY `CLIENT_COD`);
END

CREATE PROCEDURE max_min_mitja2 (IN codiClient int, OUT maxim float, out minim float, out mitjana float)
BEGIN
  select max(total) INTO maxim from `COMANDA` GROUP BY `CLIENT_COD`;
  select min(total) into minim from `COMANDA` GROUP BY `CLIENT_COD`;
  select avg(total) into mitjana from `COMANDA` GROUP BY `CLIENT_COD`;
END