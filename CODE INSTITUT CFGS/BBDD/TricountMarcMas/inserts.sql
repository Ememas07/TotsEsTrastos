
DO $$
DECLARE
    domains text[] := ARRAY['gmail.com', 'hotmail.com', 'icloud.com', 'mail.com', 'outlook.com', 'yahoo.com'];
BEGIN
    -- 1. Cleanup existing data
    TRUNCATE TABLE pagador, log, despesa, usuariGrup, grup, usuari CASCADE;

    -- 2. Use a CTE to generate Users and use those results for child tables
    -- This ensures we don't have FK mismatches
    WITH inserted_users AS (
        INSERT INTO usuari (correu, nom, llinatge1, llinatge2, IBAN, alias)
        SELECT 
            'user' || i || '@' || domains[floor(random() * 6 + 1)], 
            'Nom' || i, 
            'Llinatge' || i, 
            CASE WHEN i % 4 = 0 THEN 'Segon' || i ELSE NULL END,
            ROW('ES', (21000000000000 + i)::bigint)::iban,
            'alias' || i
        FROM generate_series(1, 100) AS i
        RETURNING correu
    ),
    inserted_groups AS (
        INSERT INTO grup (descripcio, dataCreacio)
        SELECT 'Grup ' || i, NOW() - (i || ' days')::interval
        FROM generate_series(1, 100) AS i
        RETURNING id
    ),
    -- Link every user to a group (1 user per group for the 100 rows)
    link_users AS (
        INSERT INTO usuariGrup (idUsuari, idGrup)
        SELECT u.correu, g.id
        FROM (SELECT correu, row_number() OVER () as rn FROM inserted_users) u
        JOIN (SELECT id, row_number() OVER () as rn FROM inserted_groups) g ON u.rn = g.rn
    )
    -- Create the expenses
    INSERT INTO despesa (idGrup, pagadorOriginal, dataDespesa, descripcio, categoria, importTotal, importPagat)
    SELECT 
        g.id, 
        u.correu, 
        NOW() - (random() * 100 || ' hours')::interval,
        'Despesa Generada ' || g.id,
        (ARRAY['Viatges', 'Sopars', 'Material', 'Altres'])[floor(random() * 4 + 1)],
        (random() * 150 + 20)::numeric::money,
        0::numeric::money
    FROM (SELECT id, row_number() OVER () as rn FROM inserted_groups) g
    JOIN (SELECT correu, row_number() OVER () as rn FROM inserted_users) u ON g.rn = u.rn;

    -- 3. Populate pagador (3 participants per expense)
    -- We select from the already inserted rows to guarantee existence
    INSERT INTO pagador (idDespesa, idUsuari, contribucio, haPagat)
    SELECT 
        d.id,
        u.correu,
        (d.importTotal::numeric / 3)::numeric::money,
        (random() > 0.5)
    FROM despesa d
    CROSS JOIN LATERAL (
        SELECT correu FROM Usuari ORDER BY random() LIMIT 3
    ) u;
END $$;