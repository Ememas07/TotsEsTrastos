-- Active: 1744015454928@@127.0.0.1@33700@Act6.5
/* Crea un procediment amb dos paràmetres d'entrada (usuari i clau). Fent us de IF i
ELSE, comprova si l'usuari existeix dins la base de dades.

Hi haurà un tercer paràmetre, que serà de sortida i serà un VARCHAR que
indicarà “Usuari correcte”, “Clau incorrecta” o “Usuari inexistent”, segons el cas.

La taula usuari tindrà els camps: usuari, clau, nom, ll1, email */

DROP table users;

create TABLE users (
    usuari VARCHAR(100) PRIMARY KEY,
    clau VARCHAR(100),
    nom VARCHAR(100),
    llinatge1 VARCHAR(100),
    email VARCHAR(300)
)

SELECT * from users

CREATE PROCEDURE comprovar_usuari (IN user VARCHAR(100), in contrassenya VARCHAR(100), out sortida VARCHAR(100))
BEGIN
    declare userPresent int;
    declare contrassenyaCorrecta int;
    set userPresent = (SELECT COUNT(*) FROM users WHERE user = usuari);
    set contrassenyaCorrecta = (SELECT COUNT(*) FROM users WHERE user = usuari and clau = contrassenya);

    if contrassenyaCorrecta = 1 then set @sortida = "Usuari Correcte";
    elseif userPresent = 1 then set @sortida = "Clau Incorrecta";
    else set @sortida = "usuari inexistent";
END



set
    @present = (
        SELECT COUNT(*)
        FROM users
            /* WHERE
            user = usuari and 
            clau = contrassenya
            */
    );