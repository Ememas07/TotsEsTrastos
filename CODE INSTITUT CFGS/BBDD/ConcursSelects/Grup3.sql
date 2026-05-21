-- Active: 1779361990273@@127.0.0.1@33700@Grup3
-- Bàsiques
-- 75 Jocs per a majors de 18 anys.
SELECT * FROM videojoc WHERE pegi = 18;
-- 76 Jugadors premium.
SELECT * FROM jugador WHERE premium = 1;
-- 78 Jocs multijugador que contenen “Ring”.
SELECT * FROM videojoc WHERE titol LIKE '%RING%';
-- 82 Jocs llançats el 2022 o després.
SELECT * FROM videojoc WHERE data_llancament > '2022-01-01';
-- 84 Jocs sense multijugador i amb preu superior a 40 €.
SELECT * FROM videojoc WHERE multijugador = 1 AND preu_base > 40;

-- Join

-- 88 Jocs amb el nom del seu estudi desenvolupador.
SELECT titol, nom FROM videojoc LEFT JOIN estudi USING (id_estudi);
-- 91 Jocs disponibles a PS5 amb el seu preu.
SELECT titol, preu_base
FROM
    joc_plataforma
    LEFT JOIN videojoc USING (id_joc)
    LEFT JOIN plataforma USING (id_plataforma)
WHERE
    plataforma.nom = 'PlayStation 5';
-- 92 Assoliments obtinguts per GalacticHero.
SELECT *
FROM
    jugador_assoliment
    LEFT JOIN jugador USING (id_jugador)
    LEFT JOIN assoliment USING (id_assoliment)
WHERE
    nom_usuari = 'GalacticHero'

-- Group By

-- 98 Nombre de jocs per gènere.
SELECT COUNT(*), id_genere
FROM videojoc
    LEFT JOIN genere USING (id_genere)
GROUP BY
    id_genere
    -- 100 Hores totals jugades per cada jugador.

SELECT (sum(durada_minuts) / 60) as hores, nom_real
FROM partida
    LEFT JOIN jugador USING (id_jugador)
GROUP BY
    id_jugador;
-- 105 Nombre de jugadors que ha jugat cada joc.
SELECT DISTINCT
    id_jugador
FROM partida
GROUP BY
    id_joc
    -- Having

-- 110 Jugadors amb més de 400 XP acumulats.

-- 111 Jocs disponibles en més d'una plataforma.

-- Subconsultes

-- 114 Jocs del mateix estudi que Elden Ring.

-- 116 Jocs que mai han estat jugats.