-- Active: 1779361990273@@127.0.0.1@33700@calendari_empresa
-- Grup 2: Llorenç i Jaume

-- Bàsiques

-- 48 Tasques en estat pendent, amb retard o en procés.

SELECT id_tasca, titol, descripcio
FROM tasca
    LEFT JOIN estat_tasca USING (id_estat)
WHERE
    nom_estat IN (
        'En procés',
        'Pendents',
        'Retardada'
    )

-- 51 Tasques creades durant el març de 2026 amb data límit a l'abril.

SELECT *
FROM tasca
WHERE
    data_creacio BETWEEN '2026-03-01' AND '2026-03-31'
    AND data_limit BETWEEN '2026-04-01' AND '2026-04-30'

-- 52 Empleats amb cognoms que comencen per M.

SELECT * from empleat WHERE nom LIKE 'M%'

-- 53 Tasques en estat actiu (pendent, en procés o retardada).
SELECT id_tasca, titol, descripcio
FROM tasca
    LEFT JOIN estat_tasca USING (id_estat)
WHERE
    nom_estat IN (
        'En procés',
        'Pendents',
        'Retardada'
    )

-- 54 Empleats que no són programadors ni operaris.

SELECT * FROM empleat WHERE CARREC NOT IN('Programador', 'Operari')

-- Join

-- 57 Tasques amb el seu estat i prioritat.

SELECT id_tasca, titol, descripcio
FROM
    tasca
    LEFT JOIN prioritat USING (id_prioritat)
    LEFT JOIN estat_tasca USING (id_estat)

-- 59 Tasques urgents o crítiques que estan pendents o en procés.

SELECT id_tasca, titol, descripcio
FROM
    tasca
    LEFT JOIN prioritat USING (id_prioritat)
    LEFT JOIN estat_tasca USING (id_estat)
WHERE
    nom_estat IN ('En procés', 'Pendents')
    AND nom_prioritat IN ('Urgent', 'Crítica')

-- 60 Tasques amb les seves dependències (tasca i la que depèn).

SELECT t.titol, t.descripcio, t2.titol, t2.descripcio
FROM
    dependencia_tasca dt
    LEFT JOIN tasca t ON t.id_tasca = dt.id_tasca
    LEFT JOIN tasca t2 ON t2.id_tasca = dt.id_tasca_dependent

-- Group By

-- 61 Total de tasques per departament.

SELECT COUNT(id_tasca), nom
FROM tasca
    LEFT JOIN departament USING (id_departament)
GROUP BY
    id_departament

-- 63 Mitjana de prioritat per departament.

SELECT AVG(id_prioritat), nom
FROM tasca
    LEFT JOIN departament USING (id_departament)
GROUP BY
    id_departament

-- 65 Data límit més tardana de les tasques actives per departament.

SELECT MAX(data_limit), id_departament
FROM tasca
    LEFT JOIN estat_tasca USING (id_estat)
WHERE
    nom_estat = 'En procés'
GROUP BY
    id_departament

-- Having

-- 68 Empleats que han fet comentaris.

SELECT empleat.nom, COUNT(id_empleat)
FROM empleat
    LEFT JOIN comentari USING (id_empleat)
GROUP BY
    id_empleat
HAVING
    count(id_comentari) > 0

-- 70 Departaments amb almenys 3 empleats.

SELECT departament.nom, COUNT(id_empleat)
FROM departament
    LEFT JOIN empleat USING (id_departament)
GROUP BY
    id_empleat
HAVING
    count(departament.id_departament) > 3

-- Subconsultes

-- 73 Tasques amb prioritat inferior a la mitjana.
SELECT id_tasca, titol, descripcio
FROM tasca
WHERE
    id_prioritat IN (
        SELECT id_prioritat
        FROM prioritat
        WHERE
            id_prioritat < 2
    )

-- 74 Empleats que han creat alguna tasca urgent o crítica.
SELECT nom AS nom_empleat
FROM tasca
    LEFT JOIN prioritat USING (id_prioritat)
    LEFT JOIN empleat ON empleat.id_empleat = tasca.id_empleat_creador
WHERE
    nom_prioritat = 'Urgent'
    OR 'Crítica'
    AND id_empleat_creador IN (
        SELECT nom
        FROM empleat
    )