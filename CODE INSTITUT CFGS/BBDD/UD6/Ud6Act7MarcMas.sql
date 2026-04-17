-- Active: 1744015454928@@127.0.0.1@33700@Act6.7
/* Crea un procediment que passant-hi un nombre, insereixi un article a la taula de
l'exercici anterior.

S'ha de controlar els errors de clau duplicada (error 1062) i de afegir una clau
nul·la. (error 1048).

Pots mostrar el missatge amb una select:
SELECT CONCAT("article", num, " ja existeix") as 'avis_error'; */

create table articles (
    id int PRIMARY KEY,
    text_article VARCHAR(10),
    preu DOUBLE
)

create Procedure afegirArticle(in nombre int)
begin
DECLARE exit HANDLER for 1062
begin 
    SELECT CONCAT("Article ",nombre, " ja existeix") as "Avis error";
end;

DECLARE exit HANDLER for 1048
begin 
    SELECT CONCAT("Has posat una clau buida") as "Avis error";
end;
    INSERT into articles (id, text_article, preu) 
    VALUES(
            nombre, 
            CONCAT("Article ",nombre), 
            (nombre*100)
        );
    SELECT concat("S'ha afegit correctament l'article",nombre) as "Success";
END

call afegirArticle (7)