REM BUSCAF1.BAT
REM Opcio O - Cercar arxois en HD, o qualsevol Unitat
@ECHO OFF
CLS
IF "%1"=="" GOTO :AYUDA

:RUTINA
REM Cerca fitxer o fitxers en Disc Dur / o Unitat.
IF "%1"=="FIN" GOTO :VOLVER
IF "%1"=="fin" GOTO :VOLVER
DIR %1\%2 /S
PAUSE
REM Codis de Sortida de DIR, no en te.

:AYUDA
REM Ahora si hem de detallar de cara a l'usuari.
ECHO.
ECHO Programa   =       BUSCAFI.BAT
ECHO Sintaxis   =       BUSCAFI Unitat Fitxer/s
ECHO Exemples   =       BUSCAFI C: WIN.INI
ECHO                    BUSCAFI A: *.BAT
ECHO                    BUSCAFI B: *.COM
ECHO Sortir     =       BUSCAFI FIN
ECHO Comentaris =       Cerca fitxer o fitxers en Disco dur / o Unitat.
GOTO :FIN

:VOLVER
UNO

:FIN