-- Active: 1744015454928@@127.0.0.1@33700@organitzacio_empresa

/** Activitat 5.2

Descarrega i importa el script organització_empresa del Classroom. Fes les següents seleccions:
**/
-- Mostrar el nom complet dels empleats i el seu email si guanyen més de 80000
SELECT CONCAT(first_name, " ", last_name) AS 'Nom', email
FROM employees
WHERE
    salary > 80000;
-- Els dos si >8000

-- Ordenar els empleats per data de contractació

SELECT * from employees ORDER BY hire_date DESC;
-- DESC
SELECT * from employees ORDER BY hire_date ASC;
-- ASC

-- Mostra quin empleat fa feina a cada departament. Han de sortir el nom de l'empleat i el nom del departament

SELECT CONCAT(first_name, ' ', last_name) AS 'Nom', department_name AS 'Departament'
FROM employees
    JOIN departments USING (department_id)

-- Mostra els empleats, el que guanyen, el departament d'on fan feina i on és aquesta ciutat dels departaments ubicats a Beverly Hills
SELECT CONCAT(first_name, ' ', last_name) AS 'Nom', salary, department_name AS 'Departament', CONCAT(street_address,', ',postal_code,', ',city,', ',state_province) AS 'Ubicacio'
from
    departments
    JOIN locations USING (location_id)
    JOIN employees USING (department_id)
WHERE city = "Beverly Hills"