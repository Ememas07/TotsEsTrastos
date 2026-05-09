
CREATE OR REPLACE FUNCTION public.omplirLog()
  RETURNS trigger
  LANGUAGE plpgsql 
AS $BODY$
BEGIN
  INSERT INTO LOG (datetime, oldrow,newrow)
  VALUES
  (NOW(),OLD::text, NEW::text);
  RETURN NULL;
END;
$BODY$

CREATE OR REPLACE TRIGGER omplirLog AFTER
INSERT OR UPDATE OR DELETE ON despesa
for each row
execute PROCEDURE PUBLIC.omplirLog();



CREATE OR REPLACE FUNCTION public.actualitzarImport()
    RETURNS trigger
    LANGUAGE plpgsql
AS $BODY$
BEGIN
UPDATE despesa set importPagat = (
    SELECT sum(contribucio) 
	FROM pagador 
	WHERE iddespesa = old.iddespesa
	AND hapagat='t') 
    WHERE despesa.id = old.iddespesa;
RETURN NULL;
END;
$BODY$;

CREATE OR REPLACE TRIGGER actualitzarImport AFTER
INSERT OR UPDATE OR DELETE ON pagador
for each row
execute PROCEDURE PUBLIC.actualitzarImport();



CREATE OR REPLACE FUNCTION public.arrodonirImport()
    RETURNS trigger
    LANGUAGE plpgsql
AS $BODY$
BEGIN
NEW.importpagat := arrodonir(NEW.importpagat,NEW.importtotal);
RETURN NEW;
END;
$BODY$;

CREATE OR REPLACE TRIGGER arrodonirImport
BEFORE UPDATE OF importpagat
ON despesa
FOR EACH ROW
execute PROCEDURE PUBLIC.arrodonirImport();