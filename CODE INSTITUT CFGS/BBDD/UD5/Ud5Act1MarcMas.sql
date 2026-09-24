-- Tots pilots espanyols
SELECT * FROM drivers WHERE nationality ="Spanish";

-- Espanyols i britànics
SELECT * FROM drivers WHERE nationality = "Spanish" OR nationality = "British";

-- Nom i Llinatges concatenats de tots els pilots
SELECT CONCAT(first_name,last_name) FROM drivers;

-- Nacionalitats distintes
SELECT DISTINCT nationality FROM drivers;