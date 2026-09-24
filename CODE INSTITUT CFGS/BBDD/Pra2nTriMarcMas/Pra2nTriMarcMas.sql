-- Active: 1744015454928@@127.0.0.1@33700@Pra2nTri

-- Bàsiques
-- 1. Mostrar tots els equips que comencin per la lletra "R"
SELECT * from equip WHERE nom like "R%"

-- 2. Mostrar totes les lligues amb una "H" al nom
SELECT * from lliga where nom like "%H%"

-- 3. Mostrar tots els id dels equips que juguen a l'esport "3"
SELECT * FROM `equipEsport` where `idEsport` = 3

-- 4. Mostrat tots els jugador que no tenen un 7 al nom
select * from jugador where dni not like "%7%"

-- 5. Seleccionar totes les accions que passen al camp
select * from accio where `margeAplicacio` = "camp"

-- 6. Mostrar totes les penalitzacions de temps o partits
select * from penalitzacio where tipus in ("temps", "partits")

--7. Mostrar tots els jugadors amb el nom "Marc"
SELECT * FROM jugador where nom = "Marc"

-- JOIN
-- 1. Mostrar tots els equips amb els seus esports corresponents
SELECT eq.nom, es.nom
FROM
    `equipEsport`
    left join equip eq using (idEquip)
    left join esport es USING (idEsport)

-- 2. Mostrar tots els equips amb els seus jugadors
SELECT e.nom, j.nom
FROM
    `equipJugador`
    left join equip e using (idEquip)
    left join jugador j using (idJugador)

-- 3. Mostrar tots els resultats dels partits de la temporada 2
SELECT resultat
from `temporadaPartit`
    left join partit p USING (`idPartit`)

-- 4. Mostrar totes les accions i penalitzacions del reglament "3"
SELECT a.nom as "Accio", p.nom as "Penalitzacio"
FROM
    reglament
    left join `reglamentAccio` USING (`idReglament`)
    left join accio a USING (`idAccio`)
    left join `accioPenalitzacio` USING (`idAccio`)
    left join penalitzacio p USING (`idPenalitzacio`)
where
    idReglament = 3

-- 5. Mostrar tota l'informació rellevant d'una lliga
SELECT l.nom as "Lliga", c.nom as "Categoria", e.nom as "Esport", f.nom as "Format", r.nom as "Reglament"
FROM
    lliga l
    left join categoria c USING (`idCategoria`)
    left join esport e USING (`idEsport`)
    left join format f USING (`idFormat`)
    left join reglament r USING (`idReglament`)

-- GROUP BY
-- 1. Mostrar quants d'equips juguen a cada esport
SELECT es.nom as "Esports", count(eq.nom) "Equips"
FROM
    `equipEsport`
    left join equip eq using (idEquip)
    left join esport es USING (idEsport)
GROUP BY
    es.nom

-- 2. Mostrar quants de jugador juguen a cada esport, ordenat de major a menor
SELECT e.nom as "Esport", count(j.nom) as "Jugadors"
FROM
    `jugadorEsport`
    left join jugador j using (idJugador)
    left join esport es using (idEsport)
GROUP BY
    e.nom
order by "Jugadors" desc

-- 3. Mostrar quants de jugadors hi ha a cada equip
SELECT e.nom as "Equip", count(j.nom) as "Jugadors"
FROM
    `equipJugador`
    left join equip e using (idEquip)
    left join jugador j using (idJugador)
group by
    e.nom
order by "Jugadors"

-- HAVING
-- 1. Mostrar tots els esports que tenen més de 10 jugadors
SELECT esport.nom as "Esport", COUNT(`idJugador`) as "Jugadors"
FROM `jugadorEsport`
    left join esport USING (`idEsport`)
group by
    `idEsport`
HAVING
    COUNT(*) > 10

-- 2. Mostrar les dates i els resultats dels partits que han tingut més de 5 esdevniments
SELECT resultat, `data`
FROM esdeveniment
    left join partit USING (`idPartit`)
group by
    `idPartit`
HAVING (count(`idEsdeveniment`) > 5)

-- 3 Mostrar tots els reglaments amb més de 20 accions
select reglament.nom
from `reglamentAccio`
    left JOIN reglament USING (`idReglament`)
group by
    `idReglament`
HAVING (COUNT(`idAccio`) > 20)

-- SUBCONSULTES

-- 1. Mostrar les alineacions dels partits on la durada és major de 120
SELECT `idAlineacio`
FROM `partitAlineacio`
    left join alineacio USING (`idAlineacio`)
WHERE
    `idAlineacio` IN (
        select `idAlineacio`
        from `partitAlineacio`
            left join partit USING (`idPartit`)
        where
            durada > 120
    )

-- 2. Mostrar el resultat i durada dels partits on hi ha més de 5 punts
SELECT resultat, durada
FROM `temporadaPartit`
    left JOIN partit USING (`idPartit`)
where
    `idPartit` IN (
        SELECT `idPartit`
        FROM partit
        where
            resultat > 5
    )

    