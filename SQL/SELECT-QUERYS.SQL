










/* 
SELECT * FROM users

SELECT name from users

SELECT user_id, name FROM users

SELECT DISTINCT age FROM users; SELECT camps únics

SELECT WHERE: SELECT pero on cada camp sigui x; e.g FROM users WHERE age=15->edad=15

SELECT DISTINCT name FROM users WHERE age=15;-> valors de name unics, age=15

SI CANVIAM name per AGE tenim valors de age unics on age=15

SELECT * FROM users ORDER BY age ASC/DESC; -> ordena tots per edad, ordre (asc/desc)

SELECT (DISTINCT) FROM (WHERE) (ORDER BY DESC)

SELECT name FROM users WHERE email = "sara@gmail.com" ORDER BY age DESC;

(WHERE) x LIKE= SE PARECE/CONTIENE 

WILDCARDS = %ASD -> xxasd; OR %@% -> "xxxx%xxxxx"

AND/OR/NOT VA DESPRES DE WHERE (WHERE NOT email)

AND/OR = despues de statement

LIMIT (numero) (limit 2 = dos primers) va al final

NULL -> WHERE EMAIL = NULL -> on no tenguin email, valors buits

SELECT * FROM users WHERE email IS NOT NULL AND AGE=15

NOT NULL -> el mateix, pero que tenguin valors

MIN/MAX SELECT MAX(age) FROM users; NOMES TREU EL VALOR

COUNT -> conta cuants de valors hi ha a aquesta columna COUNT()

SUM -> suma SUMA()

AVG -> AVERAGE AVG()

IN ->  SELECT * FROM users WHERE name IN ('brais') li donam un valor per cercar.

BETWEEN -> SELECT * FROM users WHERE age BETWEEN 10 AND 30

ALIAS -> per donar un nom diferent a una columna internament SELECT name, init_date AS 'FECHA DE INICIO EN PROGRAMACION' FROM users

CONCAT() -> SELECT CONCAT('Nombre: ',name,' Apellidos: ', surname) FROM users

CONCAT + ALIAS = SELECT CONCAT('Nombre: ',name,' Apellidos: ', surname) AS 'nombre y apellidos' FROM users

GROUP BY SELECT count(age) FROM users GROUP BY age;

SELECT MAX(AGE) group by age-> selecciona un valor de age de tots els que hi hagui, identic a "unique"

select count(age) group by age -> agrupa per edats, mostra el nombre de users amb aquesta edat

mes facil ^ SELECT count(age),age FROM users GROUP BY age;

++ facil SELECT count(age),age FROM users GROUP BY age ORDER BY age ASC;

HAVING SELECT COUNT(age) FROM users HAVING count(age) >3;

CASE HARD SYNTAX {
    SELECT *,
CASE 
    WHEN  age > 17 THEN 'Es mayor de edad'  
    ELSE  'Es menor'
END AS 'agetext'
from users;
}
COMA IMPORTANT
BOOLEAN
SELECT *,
CASE 
    WHEN  age > 17 THEN True  
    ELSE  False
END AS 'es mayor?'
FROM users; 

SELECT *,
CASE 
    WHEN  age = 18 THEN 'Acaba de cumplir 18'
    WHEN  age > 17 THEN 'Es menor'
    ELSE  'Es mayor'
END AS 'Es mayor o menor?'
FROM users; 

IFNULL SELECT name, surname, IFNULL(age,'0') AS 'age' FROM users; -> canvia "null" per 0 a la columna age

IF ISNULL -> IFNULL


*/
