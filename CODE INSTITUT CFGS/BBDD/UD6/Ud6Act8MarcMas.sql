-- Active: 1744015454928@@127.0.0.1@33700@Act6.8
/* Crea una funció determinista de mode que passant-li un id d'usuari ens retorni el
seu email.

Empra la sentència DECLARE EXIT HANDLER FOR NOT FOUND
per a retornar NULL; si no es troba i torna l'email en cas de que es trobi. */

create TABLE users (
    id int PRIMARY key AUTO_INCREMENT,
    nom VARCHAR(100),
    llinatge1 VARCHAR(100),
    email VARCHAR(300)
)

SELECT * from users

create function cercarEmail(num int)
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
DECLARE exit HANDLER FOR NOT FOUND
begin 
    return NULL;
end;
return (SELECT email from users where id = num);
END