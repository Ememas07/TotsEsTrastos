ALTER TABLE persons

SELECT * FROM persons
/*
ALTER TABLE persons
ADD surname VARCHAR(150)
RENAME COLUMN surname TO description
MODIFY COLUMN description VARCHAR(250)
DROP COLUMN description;


CREATE table persons (
    id INT ,
    name VARCHAR(100),
    age INT,
    email VARCHAR(50),
    created DATE
);
Crear taula

CREATE table persons2 (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATE
);
Valors not null (obligatoris) a id i name

CREATE table persons3 (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATETIME
    UNIQUE(id)
);
Valor unic de id, perque nomes hi hagui cada id una vegada

CREATE table persons4 (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATETIME,
    UNIQUE(id),
    PRIMARY KEY(id)
);
Unique + Primary key -> ID, només una ID per cada un, clau primaria 

CREATE table persons5 (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATETIME,
    UNIQUE(id),
    PRIMARY KEY(id),
    CHECK(age>=18)
);
Ens asseguram que age sempre serà +=18

CREATE table persons6 (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UNIQUE(id),
    PRIMARY KEY(id),
    CHECK(age>=18)
);
DEFAULT = si no posam valor, se posara aquest, current_timestamp = hora actual

CREATE table persons7 (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    created DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UNIQUE(id),
    PRIMARY KEY(id),
    CHECK(age>=18)
);

auto_increment = perque la id se incrementi automaticaments




















CREATE DATABASE test; crea :)

DROP DATABASE test; borra :(

CREATE TABLE

DROP TABLE

INSERT INTO users (name, surname ) VALUES ('Paco','Perez')

UPDATE users SET age = '21', init_date = '2023-10-12' WHERE user_id = 10;

DELETE FROM users WHERE user_id= 10;

*/
