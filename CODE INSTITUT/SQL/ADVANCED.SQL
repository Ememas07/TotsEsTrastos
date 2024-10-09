


/*

INDEX -> indexa tots es valors de sa columna per fer mes via a l'hora de cercar


CREATE INDEX idx_name ON marcmas.users(name)
CREATE UNIQUE INDEX idx_name ON marcmas.users(name)
CREATE INDEX idx_name ON marcmas.users(name, surname)

DROP INDEX idx_name ON users -> borra


TRIGGER -> disparador automàtic

CREATE TRIGGER tg_email
AFTER UPDATE ON users
FOR EACH ROW
BEGIN
    IF OLD.email <> NEW.email THEN
        INSERT INTO email_history(user_id, email)
        VALUES(OLD.user_id, OLD.email);
    END IF;
END;

VIEWS -> vistas de taules
cREATE VIEW v_allusers AS
SELECT name, age
FROM users
WHERE age >=18;
STORED PROCEDURES -> query a favoritos

CREATE PROCEDURE p_allusers()
BEGIN
SELECT * FROM ainamariaferriol.users;
SELECT * FROM ciro.users;
END


CREATE PROCEDURE p_age_users(IN AGE1 INT)

BEGIN
    select * from users where age=age1;
END;


TRANSACTION (N/A)
executar en bloc, comprovar que tot estigui bé per no liarla
per poder fer un rollback
-> start transaction
-> query blah blah
-> rollback torna enrere
-> commit tira per envant

Concurrencia -> no poder tenir dos usuaris canviant el mateix valor a un moment

CONNECTORS python



*/