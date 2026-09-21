-- Active: 1744015454928@@127.0.0.1@33700@cotxes_empleats

/* Descarrega i importa el script organització_empresa del Classroom. Fes les
següents seleccions emprant RIGHT i LEFT JOIN */


-- Mostrar els cotxes de cada empleat amb LEFT JOIN
SELECT *
FROM employees
    LEFT JOIN cars on cars.employee_id = employees.employee_id

-- El mateix, però amb RIGHT JOIN
SELECT *
FROM employees
    RIGHT JOIN cars on cars.employee_id = employees.employee_id

INSERT INTO
    cars (
        car_id,
        employee_id,
        make,
        model,
        year
    )
VALUES (5, 0, 'Renault', 'Clio', 2003)