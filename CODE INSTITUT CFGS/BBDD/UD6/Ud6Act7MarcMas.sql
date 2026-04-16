/* Crea un procediment que passant-hi un nombre, insereixi un article a la taula de
l'exercici anterior.

S'ha de controlar els errors de clau duplicada (error 1062) i de afegir una clau
nul·la. (error 1048).

Pots mostrar el missatge amb una select:
SELECT CONCAT("article", num, " ja existeix") as 'avis_error'; */