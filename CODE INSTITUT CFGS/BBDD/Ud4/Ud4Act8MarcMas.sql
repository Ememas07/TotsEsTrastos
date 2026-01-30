/* 
1. Donar d'alta aquests departaments:
Informàtica, a la població de Sineu, amb codi 50
Compres, a la població de Manacor, amb codi 60
Personal, a la població de Inca, amb codi 70
Serveis mèdics, amb codi 80, pendent d'ubicar
*/
INSERT INTO dept VALUES (50, 'INFORMÀTICA', 'SINEU');

INSERT INTO dept VALUES (60, 'COMPRES', 'MANACOR');

INSERT INTO dept VALUES (70, 'PERSONAL', 'INCA');

INSERT INTO dept VALUES (80, 'SERVEIS MÈDICS', '');

/*
2. Donar d'alta un empleat amb codi 7935, de cognom ‘GOTERA', de professió ‘PSICÒLEG',
assignat al departament de ‘SERVEIS MÈDICS' i dependent directament del ‘PRESIDENT' de la
companyia, que sabem que té codi d'empleat 7839.
*/

INSERT INTO
    EMP
VALUES (
        7935,
        'GOTERA',
        'PSICÒLEG',
        7839,
        '1981-11-09',
        390000,
        NULL,
        80
    );

-- 3. Ubicar el departament ‘SERVEIS MÈDICS' a la ciutat de ‘VALÈNCIA'.

UPDATE dept set `LOC` = 'VALENCIA' where `DEPT_NO` = 80