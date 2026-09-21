-- 1. Mostrar nom i llinatges dels alumnes bilingues
select nom, llinatge1, llinatge2 from alumnes where esBilingue = 1;

-- 2. Mostrar DNI dels professors que imparteixen o han impartit l'assignatura 1

select professor
from `professorsAssignatures`
where
    `professorsAssignatures`.assignatura = "1"

-- 3. Mostrar el nom de les assignatures de més de 100 hores, que no són bilingues i pertanyen al Cicle de codi 1

select nom
from assignatura
where
    numeroHores > 100
    and `esBilingue` = 0
    and assignatura.`cicleFormatiu` = 1;

-- 4. Mostrar nom i llinatges dels alumnes bilingues el nom dels quals comença per A
select nom, llinatge1, llinatge2
from alumnes
where
    `esBilingue` = 1
    and nom LIKE 'A%';

-- 5. Mostrar el DNI dels professors el nom dels quals té una m i el seu primer llinatge té una g i acaba en n
select dni
from professor
where
    nom like '%m%'
    and llinatge1 like '%g%'
    and llinatge1 like '%n';

-- 6. Mostrar el nom de les assignatures de menys de 150 hores, que pertanyen al cicle de codi 2 i el nom dels quals no té una j.
select nom
from assignatura
where
    `numeroHores` < 150
    and cicleFormatiu = 2
    and nom not like '%j%';

-- 7. Mostrar el nom complet dels alumnes que són de Palma, Inca o Manacor
/* select alumnes.nom, llinatge1, llinatge2 */
select *
from alumnes
    left join poble on alumnes.poble = poble.`codiPoble`
where
    poble.nom IN ("Palma", "Inca", "Manacor")

-- 8. Mostrar el nom complet dels alumnes que no són de Palma i el nom dels quals comença per M
select alumnes.nom, llinatge1, llinatge2
from alumnes
    left join poble on alumnes.poble = poble.`codiPoble`
where
    poble.nom <> 'Palma'
    and alumnes.nom like 'M%';

-- 9. Mostrar el nom i el primer llinatge dels empleats que són de Palma o Inca, o d'un altre lloc que comença per A (Artà, Algaida...). Els has d'ordenar per ordre descendent de llinatge
select professor.nom, llinatge1
from professor
    left join poble on professor.poble = poble.`codiPoble`
where
    poble.nom in ('Palma', 'Inca')
    or poble.nom like 'A%'
order by llinatge1 desc;
-- 10. Mostrar el DNI dels professors que pertanyen al departament “Informàtica”
select p.dni
from professor p
    join departament d on p.departament = d.nom
where
    d.nom = 'Informatica';

-- 11. Mostrar nom complet dels alumnes matriculats a “Base de dades” i “Accés a Dades”
SELECT
    alumnes.nom,
    llinatge1,
    llinatge2,
    assignatura
FROM
    `alumnes`
    LEFT join `alumnesAssignatures` on alumnesAssignatures.alumne = alumnes.dni
WHERE
    `alumnesAssignatures`.assignatura LIKE "% dades"

-- 12. Mostrar nom i llinatges dels alumnes que han aprovat assignatures que pertanyen al cicle “DAM”
SELECT CONCAT(alumnes.nom, " ", llinatge1)
FROM
    `alumnes`
    left join `alumnesAssignatures` on alumnesAssignatures.alumne = alumnes.dni
    left join assignatura on `alumnesAssignatures`.assignatura = assignatura.`nom`
WHERE
    nota > 5
    AND `cicleFormatiu` = "dam"

-- 13. Mostrar el nombre de professors que fan feina a cada departament
select COUNT(*), departament from professor group by departament

-- 14. Mostrar el nombre d'alumnes que son bilingues
select count(*) as num_bilingues from alumnes where esBilingue = 1 group by `esBilingue`;

-- 15. Mostrar els alumnes matriculats a cada assignatura
select count(*), assignatura
from `alumnesAssignatures`
group by
    assignatura

-- 16. Mostrar per cada assignatura i curs el nombre d'alumnes matriculats
select count(*), assignatura, any
from `alumnesAssignatures`
group by
    assignatura,
    any

    
    -- 17. Mostrar la nota mitjana de cada alumne
select dni, avg(nota)
from
    `alumnesAssignatures`
    left JOIN alumnes on alumne = alumnes.dni
group by
    alumne

-- 18. Mostrar la mitjana de cada alumne per curs
select dni, any, avg(nota)
from
    `alumnesAssignatures`
    left JOIN alumnes on alumne = alumnes.dni
group by
    any,
    dni

-- 19. Mostrar la nota més alta dels alumnes bilingues
select dni, max(nota)
from
    `alumnesAssignatures`
    left JOIN alumnes on alumne = alumnes.dni
where
    alumnes.`esBilingue` = 1
group by
    alumne

-- 20. Mostrar la nota més alta a cada curs d'aquelles assignatures del cicle amb sigles DAM
SELECT assignatura, MAX(nota), any
FROM
    `alumnesAssignatures`
    left join assignatura on `alumnesAssignatures`.assignatura = assignatura.nom
where
    assignatura.`cicleFormatiu` = "DAM"
group by
    any

-- 21. Mostrar la mitjana d'aquells alumnes el primer llinatge dels quals és vocal, que fa assignatures de les quals el seu professor pertany al departament “Administració i Finances”
SELECT alumne, AVG(nota)
FROM
    `alumnesAssignatures`
    right JOIN alumnes ON `alumnesAssignatures`.alumne = alumnes.dni
    left join `professorsAssignatures` on `alumnesAssignatures`.assignatura = `professorsAssignatures`.assignatura
    left join professor on professor.dni = `professorsAssignatures`.professor
where
    alumnes.llinatge1 REGEXP '^[AEIOUaeiou]'
    and professor.departament = "Administració i Finances"
GROUP BY
    alumne;

-- 22 Mostrar el DNI dels professors que fan 4 o més assignatures enguany
SELECT professor
FROM `professorsAssignatures`
where
    `any` = "2025-2026"
GROUP BY
    professor
HAVING
    COUNT(*) > 3;
-- pos 3 per ampliar resultats

-- 23. Mostrar el DNI dels alumnes que tenen més d'un nou en les assignatures que s'ha matriculat
SELECT alumne
FROM `alumnesAssignatures`
WHERE
    nota > 7
    -- pos 7 enlloc de 9 perque surtin resultats, se pot canviar a 5 perque en surtin mes encara
GROUP BY
    alumne
HAVING
    COUNT(*) > 1;

-- 24 Mostrar el DNI dels professors que pertanyen al departament “Informàtica”
SELECT dni
FROM `professor`
WHERE
    dni IN (
        SELECT dni
        FROM `professor`
            left join departament on `professor`.departament = departament.`nom`
        where
            departament.nom = "Informatica"
    )

-- 25 Mostrar el nom complet dels alumnes que estan matriculats a “Base de Dades” i "Accés a dades"
SELECT CONCAT(
        nom, " ", llinatge1, " ", llinatge2
    )
FROM `alumnes`
WHERE
    dni IN (
        SELECT alumne
        FROM
            `alumnesAssignatures`
            left join assignatura on `alumnesAssignatures`.assignatura = assignatura.`nom`
        WHERE
            nom = "Base de dades"
    )
    AND dni in (
        SELECT alumne
        FROM
            `alumnesAssignatures`
            left join assignatura on `alumnesAssignatures`.assignatura = assignatura.`nom`
        WHERE
            nom = "Accés a dades"
    );

-- 26 Mostrar el nom i llinatges dels alumnes que han aprovat assignatures del cicle “DAM”
SELECT CONCAT(nom, " ", llinatge1)
FROM `alumnes`
WHERE
    dni IN (
        SELECT alumne
        FROM
            `alumnesAssignatures`
            left join assignatura on `alumnesAssignatures`.assignatura = assignatura.`nom`
        WHERE
            nota > 5
            AND `cicleFormatiu` = "dam"
    );