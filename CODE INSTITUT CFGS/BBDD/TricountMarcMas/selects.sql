-- Active: 1778078067998@@127.0.0.1@5432@TricountMarcMas@public

-- Mostrar import i % de despeses de cada categoria
SELECT categoria, sumatotal, TO_CHAR(
        sumatotal * 100 / SUM(sumatotal) OVER (), 'fm90D00%'
    ) AS percent
FROM (
        SELECT categoria, SUM(importtotal) AS sumatotal
        FROM despesa
        GROUP BY
            categoria
    )

-- Doblers gastat per cada usuari (pagats)
SELECT idusuari, sum(contribucio)
FROM pagador
WHERE
    hapagat = true
GROUP BY
    idusuari;

-- Doblers pendents per pagar a cada usuari
SELECT idusuari, sum(contribucio)
FROM pagador
WHERE
    hapagat = false
GROUP BY
    idusuari;

-- Doblers gastat per cada grup
SELECT sum(importtotal), idgrup
FROM pagador p
    LEFT JOIN despesa d ON (p.iddespesa = d.id)
GROUP BY
    d.idgrup

-- Nombre de despeses que ha pagat cada usuari per advantat
SELECT count(*) as recompte, pagadororiginal
from despesa
group by
    pagadororiginal
ORDER BY recompte

-- Doblers pendents de cada persona a cada persona
SELECT
    pagadororiginal as recaudador,
    idusuari as debtor,
    sum(contribucio) as quantitat
FROM despesa
    LEFT JOIN pagador ON pagador.iddespesa = despesa.id
WHERE
    hapagat = false
    -- AND idGrup = 100 -- opcionalment es pot filtrar per nomes un grup
GROUP BY
    pagadororiginal,
    idusuari
ORDER BY pagadororiginal;

-- Mostrar import de despeses de cada usuari per cada grup
SELECT idusuari, sumatotal, idgrup
FROM (
        SELECT idusuari, sum(contribucio) AS sumatotal, idgrup
        from despesa
            LEFT JOIN pagador ON pagador.iddespesa = despesa.id
        WHERE
            hapagat = true
        GROUP BY
            idgrup, idusuari
        ORDER BY idgrup
    )
/* WHERE idGrup = 100 -- opcionalment es pot filtrar per nomes un grup */