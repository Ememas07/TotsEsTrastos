-- Active: 1744015454928@@127.0.0.1@33700@organitzacio_empresa
/** 
Activitat 5.4

Tornant a la BD de l'activitat 5.2. Fes les següents seleccions:

**/

-- Compta els empleats de cada departament. Només ha de sortir una fila per departament

SELECT count(*), department_name
FROM employees
    LEFT JOIN departments USING (department_id)
GROUP BY
    department_id;

-- Mostra els departaments on el salari mitjà sigui major de 70000

SELECT count(*), AVG(salary) department_name
FROM employees
    LEFT JOIN departments USING (department_id)
WHERE
    salary > 70000
GROUP BY
    department_id;