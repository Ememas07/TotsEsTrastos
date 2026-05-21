-- Active: 1779361990273@@127.0.0.1@33700@JuegoTorneo

-- 4 Moviments de tipus 'Atac' o 'Fortificació'.
SELECT *
FROM `Moviment`
WHERE
    `Tipo_Moviment` = 'atac'
    OR `Tipo_Moviment` = 'fortificació'

-- 6 Territoris d’un continent concret (ex. "Europa").
SELECT * FROM `Territori` WHERE `Continent` = 'europa';
-- 9 Tropes amb preu dins d’un rang concret (ex. 1.5, 2.0, 3.5).
SELECT nom FROM `Tropa` WHERE `Preu` BETWEEN 1.5 AND 2.5

-- 11 Torneigs actius dins d’un interval de dates (ex. 2026-02-01 a 2026-05-09).
SELECT *
FROM `Torneig`
WHERE
    `Torneig`.`Estat` = 'actiu'
    AND `Data_Inici` BETWEEN '2026-02-01 10:00:00' AND '2026-05-01 10:00:00';

-- 14 Moviments de tipus 'ATAC' amb 4 tropes finals.
SELECT *
FROM `Moviment`
WHERE
    `Tipo_Moviment` = 'ATAC'
    AND `Tropas_Final` = 4

-- Join
-- 19 Nom del jugador guanyador de cada torneig.

SELECT JUGADOR.nom as guanyador
FROM `Torneig`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Torneig`.`Guanyador`

-- 23 Moviments d’un jugador concret (ex. DNI = 10000015) amb el seu nom.
SELECT nom, llinatge1, `Tipo_Moviment`
FROM `Moviment`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Moviment`.`Jugador_DNI`
WHERE
    `Jugador_DNI` = 10000015

-- 24 Partides amb el mapa i el nom del jugador guanyador (ex. guanyadora Laia).

SELECT JUGADOR.nom as guanyador, mapa.nom as mapa
FROM
    `Partida`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Partida`.`Resultat_ID_Jugador_Guanyador`
    LEFT JOIN `Mapa` ON `Mapa_ID` = mapa.`ID`

-- Group By

-- 28 Quantes partides s’han jugat per cada mapa.
SELECT nom, COUNT(nom)
FROM `Partida`
    LEFT JOIN `Mapa` ON `Mapa_ID` = mapa.`ID`
GROUP BY
    `Mapa_ID`

-- 31 Jugadors amb el total de partides guanyades.
SELECT
    nom,
    `Llinatge1`,
    COUNT(nom) AS partidesGuanyades
FROM `Partida`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Partida`.`Resultat_ID_Jugador_Guanyador`
GROUP BY
    `DNI`
ORDER BY partidesGuanyades DESC

-- 32 Jugadors amb el nombre total de continents capturats.
SELECT
    nom,
    `Llinatge1`,
    COUNT(nom) AS continentsCapturats
FROM
    `Continent_Capturat`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Continent_Capturat`.`Jugador_DNI`
GROUP BY
    `DNI`
ORDER BY continentsCapturats DESC

-- Having

-- 34 Mapes amb més de 5 territoris.
SELECT * from `Mapa` HAVING `Territoris` > 5

-- 38 Jugadors que han capturat més d’un continent.

SELECT `Nom`, COUNT(`Jugador_DNI`) AS continents
FROM
    `Continent_Capturat`
    LEFT JOIN `Jugador` ON `Jugador_DNI` = `DNI`
GROUP BY
    `Jugador_DNI`
HAVING
    continents > 1

-- Subconsultes
-- 40 Jugadors que han guanyat algun torneig.

select guanyador from torneig;

SELECT DISTINCT
    nom,
    `Llinatge1`,
    `Llinatge2`
FROM `Torneig`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `Torneig`.`Guanyador`
WHERE
    `dni` IN (
        SELECT Guanyador
        FROM `Torneig`
    );

-- 43 Jugadors que han guanyat més de 3 partides.
SELECT
    nom,
    `Llinatge1`,
    `Llinatge2`,
    COUNT(nom) AS guanyades
FROM `Partida`
    LEFT JOIN `Jugador` ON `Jugador`.`DNI` = `partida`.`Resultat_ID_Jugador_Guanyador`
WHERE
    `dni` IN (
        SELECT
            `Resultat_ID_Jugador_Guanyador`
        FROM `Partida`
    )
GROUP BY
    `DNI`
HAVING
    guanyades > 3