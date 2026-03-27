-- Active: 1744015454928@@127.0.0.1@33700@centreFormacio
INSERT poble (nom) VALUES ('Maria de la salut');

INSERT poble (nom) VALUES ('Sineu');

INSERT poble (nom) VALUES ('Lloret');

INSERT poble (nom) VALUES ('Lloseta');

INSERT poble (nom) VALUES ('Lluc');

INSERT poble (nom) VALUES ('Palma');

INSERT poble (nom) VALUES ('Inca');

INSERT poble (nom) VALUES ('Manacor');

INSERT poble (nom) VALUES ('Ariany');

INSERT poble (nom) VALUES ('Petra');

INSERT poble (nom) VALUES ('Esporles');

INSERT poble (nom) VALUES ('Selva');

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "14587289A",
        "Marc",
        "Mas",
        '2007-02-15',
        1
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "14587458B",
        "Pere",
        "Munar",
        '2007-05-23',
        1
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "04051378E",
        "Ashley",
        "Dreijer",
        '2007-09-09',
        7
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "04691297F",
        "Rokiow",
        "Bum",
        '2011-03-16',
        3
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "78102913G",
        "Juan",
        "Antonio",
        '1979-11-13-',
        6
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "14895278C",
        "Mateu",
        "Ripoll",
        '2003-03-03',
        8
    );

INSERT
    alumnes (
        dni,
        nom,
        llinatge1,
        dataNaixement,
        poble
    )
VALUES (
        "15863210D",
        "Joan Pere",
        "Gelabert",
        '2008-11-02',
        4
    );

INSERT departament (nom) VALUES ('Matematiques');

INSERT departament (nom) VALUES ('Fisica');

INSERT departament (nom) VALUES ('Quimica');

INSERT departament (nom) VALUES ('Biologia');

INSERT departament (nom) VALUES ('Informatica');

INSERT departament (nom) VALUES ('Tecnologia');

INSERT departament (nom) VALUES ('Angles');

INSERT departament (nom) VALUES ('Alemany');

INSERT
    cicleFormatiu (sigles, nom)
VALUES (
        'DAM',
        'Desenvolupament Aplicacions Multiplataforma'
    );

INSERT
    cicleFormatiu (sigles, nom)
VALUES (
        'DAW',
        'Desenvolupament Aplicacions Web'
    );

INSERT
    cicleFormatiu (sigles, nom)
VALUES (
        'ASIX',
        'Administracio de Sistemes Informàtics en Xarxa'
    );

INSERT
    cicleFormatiu (sigles, nom)
VALUES (
        'EAN',
        'Enginyeria AeroNautica'
    );

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES ('Programacio', 200, 1, 'DAM');

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES (
        'Bases de Dades',
        300,
        0,
        'DAM'
    );

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES (
        'Sistemes informatics',
        400,
        1,
        'DAW'
    );

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES (
        'Sistemes informatics II',
        150,
        0,
        'DAM'
    );

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES ('Xarxes Web', 600, 1, 'ASIX');

INSERT
    assignatura (
        nom,
        numeroHores,
        esBilingue,
        `cicleFormatiu`
    )
VALUES (
        'Simulacio de fluids',
        300,
        0,
        'ASIX'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '15987538D',
        'Joan',
        'Miralles',
        'Jorda',
        'Matematiques'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '79423487I',
        'Ana',
        'Gomez',
        'Tugores',
        'Alemany'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '43928334F',
        'Jaume',
        'Ramirez',
        'Bauza',
        'Angles'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '64379087G',
        'Mateu',
        'Fernandez',
        'Busquets',
        'Biologia'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '12486478C',
        'Pere',
        'Saste',
        'Heredia',
        'Quimica'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '42924384E',
        'Daniel',
        'Sampol',
        'Sastre',
        'Angles'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '06472894A',
        'Bernat',
        'Martorell',
        'Jorda',
        'Informatica'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '68437246H',
        'Raimundo',
        'Ribot',
        'Rigo',
        'Matematiques'
    );

INSERT INTO
    `professor` (
        `dni`,
        `nom`,
        `llinatge1`,
        `llinatge2`,
        `departament`
    )
VALUES (
        '12345678B',
        'Macia',
        'Bartomeu',
        'Llabres',
        'Informatica'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '12345678B',
        'Bases de Dades',
        '2024-2025'
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '14587289A',
        'Bases de Dades',
        '2025-2026',
        7
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '14587289A',
        'Programacio',
        '2025-2026',
        9
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '14587289A',
        'Sistemes informatics',
        '2025-2026',
        8
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '14587458B',
        'Sistemes informatics II',
        '2025-2026',
        6
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '4051378E',
        'Xarxes Web',
        '2027-2028',
        10
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '4051378E',
        'Simulacio de Fluids',
        '2026-2027',
        5
    );

INSERT INTO
    `alumnesAssignatures` (
        `alumne`,
        `assignatura`,
        `any`,
        `nota`
    )
VALUES (
        '15863210D',
        'Simulacio de Fluids',
        '2026-2027',
        7
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '12345678B',
        'Bases de Dades',
        '2024-2025'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '79423487I',
        'Programacio',
        '2025-2026'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '64379087G',
        'Sistemes Informatics',
        '2022-2023'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '12486478C',
        'Xarxes Web',
        '2019-2020'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '42924384E',
        'Sistemes Informatics II',
        '2015-2016'
    );

INSERT INTO
    `professorsAssignatures` (
        `professor`,
        `assignatura`,
        `any`
    )
VALUES (
        '06472894A',
        'Simulacio de fluids',
        '2021-2022'
    );