-- Active: 1744015454928@@127.0.0.1@33700@Act6.6
/* Crea un procediment que crei 10 articles dins una taula d'articles buida

Abans d'entrar al while, es farà un borrat de la taula si existeix i es crearà de nou.
Tindrà els camps id (INT), text_article (VARCHAR 10) i preu (DOUBLE).

En cada una de les 10 iteracions, s'haurà d'afegir un article, de la següent
manera:

1 - Article 1 - 100
2 - Article 2 - 200 ...
10 - Article 10 - 1000 */

create table articles (
    id int PRIMARY KEY,
    text_article VARCHAR(10),
    preu DOUBLE
)

CREATE PROCEDURE crearArticles()
BEGIN
    DECLARE i INT default 1;
    while i < 11 DO
        INSERT into articles (id, text_article, preu) VALUES(
            i, CONCAT("Article ",i), (i*100)
        );
        set i = i + 1;
    end WHILE;
END

call `crearArticles`

SELECT * FROM articles

delete from articles where id < 11