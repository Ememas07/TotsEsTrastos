select * 
FROM users
LEFT JOIN dni
ON users.user_id = dni.user_id
UNION ALL
SELECT *
FROM users
RIGHT JOIN dni
on users.user_id = dni.user_id
WHERE users.user_id is null






/* INNER JOIN Datos comunes de dos tablas (filas de 2+ mas tablas cuando hay coincidencias)


select * from marcmas.users INNER JOIN marcmas.dni ON marcmas.users.user_id = marcmas.dni.user_id;
se pot llevar "inner" a la majoria de motors

select * from marcmas.users JOIN marcmas.companies ON marcmas.users.company_id= marcmas.companies.company_id

select users.name,surname,companies.name from marcmas.users JOIN marcmas.companies ON marcmas.users.company_id= marcmas.companies.company_id

se pot girar (select from companies join users = from users join companies)
(on companies.company_id = users.company_id == users.company_id=companies.company_id)

3 taules

SELECT * FROM users_languages 
INNER JOIN users ON users_languages.user_id=users.user_id 
INNER JOIN languages ON users_languages.language_id= languages.language_id
més net
SELECT users.name, languages.name FROM users_languages 
INNER JOIN users ON users_languages.user_id=users.user_id 
INNER JOIN languages ON users_languages.language_id= languages.language_id

LEFTJOIN se queda amb totes les dades de la primera taula
SELECT * FROM users LEFT JOIN dni ON users.user_id=dni.user_id

RIGHTJOIN lo mateix pero de sa segona taula
SELECT * FROM users right JOIN dni ON users.user_id=dni.user_id
 
FULL JOIN no existeix lol
(from users join dni) es una manera
union 

select users.user_id as u_id, dni.user_id as d_id
FROM users
LEFT JOIN dni
ON users.user_id = dni.user_id
UNION ALL
SELECT users.user_id AS u_id, dni.user_id AS d_id
FROM users
RIGHT JOIN dni
on users.user_id = dni.user_id

select * 
FROM users
LEFT JOIN dni
ON users.user_id = dni.user_id
UNION ALL
SELECT *
FROM users
RIGHT JOIN dni
on users.user_id = dni.user_id
WHERE users.user_id is null


aqui tenim tots es user id i dni_id de ses dues taules, unides (right join + left join)








*/

