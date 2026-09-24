-- Active: 1744015454928@@127.0.0.1@33700@activitat69
create TABLE persona (
    id_persona int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(100) null,
    email varchar(100) null
);

drop table persona_log;

create TABLE persona_log (
    datahora DATETIME,
    accio varchar(100),
    nom varchar(100) null,
    email varchar(100) null,
    id_persona int null,
    PRIMARY KEY (datahora, id_persona)
)

CREATE trigger triggerInserts BEFORE
INSERT
    ON persona FOR each row
INSERT
    persona_log (
        datahora,
        accio,
        nom,
        email,
        id_persona
    )
SELECT CURRENT_TIMESTAMP(),"I", persona.nom, persona.email, persona.id_persona
from persona;

CREATE trigger triggerUpdates BEFORE
UPDATE
    ON persona FOR each row
INSERT
    persona_log (
        datahora,
        accio,
        nom,
        email,
        id_persona
    )
SELECT CURRENT_TIMESTAMP(),"U", persona.nom, persona.email, persona.id_persona 
from persona;

CREATE trigger triggerDeletes BEFORE
DELETE
    ON persona FOR each row
INSERT
    persona_log (
        datahora,
        accio,
        nom,
        email,
        id_persona
    )
SELECT CURRENT_TIMESTAMP(),"D", persona.nom, persona.email, persona.id_persona 
from persona;