/* 
Crear:
Rols           Permisos
Admin   ->  Tots Per Tot
Dev     ->  Tots a BBDD "test"
escriu   ->  Crear Taules, Atributs i Registres a BD Test
Read    ->  Llegir Taueles, Atributs i Registres a BD Test


Usuaris                Rol
Admin@localhost     Admin
Dev@Ipcompany       Dev
escriu@Ipcompany     escriu
Read@Ipcompany      Read

4Users@AnyIP        Un menys
Admin@AnyIP         Dev
Dev@AnyIP           escriu
escriu@AnyIP         Read
Read@AnyIP          Read (o res)


Connectar amb 
Consola MySQL
DBeaver / SQLWorkbench
PhPMyAdmin
*/
CREATE DATABASE test;

/* USE test; */

CREATE TABLE test (
    id int PRIMARY key AUTO_INCREMENT,
    name VARCHAR(30) not null llinatge VARCHAR(30) not null
)

INSERT INTO `test` VALUES (1, 'Marc', 'mas');

INSERT INTO `test` VALUES (2, 'Test', 'test');

INSERT INTO `test` VALUES (3, 'ton pare', 'no te nas');

INSERT INTO `test` VALUES (4, 'Bon dia');

CREATE ROLE admin;

CREATE USER admin @localhost;

CREATE USER admin @10.0.3.20;

SET PASSWORD FOR admin = PASSWORD ('hola');

SET PASSWORD FOR admin @localhost = PASSWORD ('hola');

SET PASSWORD FOR admin @10.0.3.20 = PASSWORD ('hola');

CREATE ROLE dev;

CREATE USER dev;

CREATE USER dev @localhost;

CREATE USER dev @10.0.3.20;

SET PASSWORD FOR dev = PASSWORD ('holadev');

SET PASSWORD FOR dev @localhost = PASSWORD ('holadev');

SET PASSWORD FOR dev @10.0.3.20 = PASSWORD ('holadev');

CREATE ROLE escriu;

CREATE USER escriu;

CREATE USER escriu @10.0.3.20;

CREATE USER escriu @localhost;

SET PASSWORD FOR escriu = PASSWORD ('holaescriu');

SET PASSWORD FOR escriu @localhost = PASSWORD ('holaescriu');

SET PASSWORD FOR escriu @10.0.3.20 = PASSWORD ('holaescriu');

CREATE ROLE llegir;

CREATE USER llegir @'%';

CREATE USER llegir @10.0.3.20;

CREATE USER llegir @localhost;

SET PASSWORD FOR llegir = PASSWORD ('holallegir');

SET PASSWORD FOR llegir @10.0.3.20 = PASSWORD ('holallegir');

SET PASSWORD FOR llegir @localhost = PASSWORD ('holallegir');

REVOKE ALL ON *.* FROM admin;

REVOKE ALL ON *.* FROM admin @'%';

REVOKE ALL ON *.* FROM admin @localhost;

REVOKE ALL ON *.* FROM admin @10.0.3.20;

REVOKE ALL ON *.* FROM dev;

REVOKE ALL ON *.* FROM dev @'%';

REVOKE ALL ON *.* FROM dev @localhost;

REVOKE ALL ON *.* FROM dev @10.0.3.20;

REVOKE ALL ON *.* FROM escriu;

REVOKE ALL ON *.* FROM escriu @'%';

REVOKE ALL ON *.* FROM escriu @localhost;

REVOKE ALL ON *.* FROM escriu @10.0.3.20;

REVOKE ALL ON *.* FROM llegir;

REVOKE ALL ON *.* FROM llegir @'%';

REVOKE ALL ON *.* FROM llegir @localhost;

REVOKE ALL ON *.* FROM llegir @10.0.3.20;

GRANT ALL on *.* TO admin;

GRANT ALL on *.* TO admin @localhost;

GRANT ALL on test.* TO admin @10.0.3.20;

GRANT ALL on test.* TO dev;

GRANT ALL on test.* TO dev @localhost;

Grant SELECT, CREATE, ALTER, INSERT on test.* TO dev @10.0.3.20;

Grant SELECT, CREATE, ALTER, INSERT on test.* TO escriu @localhost;

Grant SELECT, CREATE, ALTER, INSERT on test.* TO escriu @10.0.3.20;

Grant SELECT, ALTER, INSERT on test.* TO escriu;

Grant SELECT, ALTER, INSERT on test.* TO escriu @'%';

GRANT INSERT on test.* to dev @'%';

Grant SELECT on test.* TO llegir;

Grant SELECT on test.* TO llegir @'%';

Grant SELECT on test.* TO llegir @localhost;

Grant SELECT on test.* TO llegir @10.0.3.20;