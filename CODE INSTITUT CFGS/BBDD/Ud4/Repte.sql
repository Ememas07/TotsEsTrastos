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
    name VARCHAR(30) not null
)

CREATE ROLE admin;

CREATE USER admin @localhost;

SET PASSWORD FOR admin = PASSWORD ('hola');

SET PASSWORD FOR admin @localhost = PASSWORD ('hola');

CREATE ROLE dev;

CREATE USER dev;

SET PASSWORD FOR dev = PASSWORD ('holadev');

CREATE USER dev @10.0.3.20;

SET PASSWORD FOR dev @10.0.3.20 = PASSWORD ('holadev');

CREATE ROLE `escriu`;

CREATE USER `escriu`;

SET PASSWORD FOR 'escriu' = PASSWORD ('holaescriu');

CREATE USER escriu @10.0.3.20;

CREATE USER `escriu` @`10.0.3.20` IDENTIFIED
WITH
    mysql_native_password;

SET PASSWORD FOR 'escriu@10.0.3.20' = PASSWORD ('holaescriu');

CREATE ROLE `read`;

CREATE USER `read`;

CREATE USER `read@10.0.3.20`;

SET PASSWORD FOR 'read' = PASSWORD ('holaread');

SET PASSWORD FOR 'read@10.0.3.20' = PASSWORD ('holaread');

REVOKE ALL ON *.* FROM admin;
REVOKE ALL ON *.* FROM dev;
REVOKE ALL ON *.* FROM escriu;
REVOKE ALL ON *.* FROM read;
REVOKE ALL ON *.* FROM admin@10.0.3.20;
REVOKE ALL ON *.* FROM dev@10.0.3.20;
REVOKE ALL ON *.* FROM escriu@10.0.3.20;
REVOKE ALL ON *.* FROM read@10.0.3.20;

GRANT ALL on *.* TO admin;

GRANT ALL on test.* TO admin@10.0.3.20;

GRANT ALL on test.* TO dev;

Grant CREATE on test.* TO dev@10.0.3.20;

REVOKE ALL on *.* FROM `escriu`;

Grant CREATE on test.* TO `escriu`;

Revoke ALL on *.* from `read`;

Grant USAGE on test.* TO `escriu@10.0.3.20`;
Grant USAGE on test.* TO `read`;