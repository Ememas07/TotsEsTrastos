@ECHO OFF
REM Professor Cristobal Mora
CLS

REM CORREU.BAT
REM ____________________________________________________________
REM Fitxer per lots : Examina si ha arribat nou correu.
REM En cas afirmatiu : avisa a l'usuari, i copia els fitxers que han arribat
REM cap el seu subdirectori personal.
REM ______________________________________________________________________________

REM CORREU.BAT
@ECHO OFF
REM CLS
REM CD C:\CORREU\MAIL

:RUTINA
ECHO Comprovant correu,esperi un moment.
REM XCOPY C:\CORREU\MAIL\*.* C:\CORREU\USU1
COPY C:\CORREU\MAIL\*.* C:\CORREU\USU1\
IF ERRORLEVEL 1 GOTO :UNO
IF ERRORLEVEL 0 GOTO :CERO


REM 0 Los archivos fueron copiados sine rror.
REM 1 No se encontraron archivos para copiar.


:UNO
ECHO No s'han trobat fitxers per copiar.
ECHO No hi ha correu pendent.
GOTO :FIN

:CERO
ECHO Proces de copia realitzat correctament.
ECHO Has rebut correu.
ECHO.
ECHO Esborrant fitxers redundants.
MD C:\CORREU\MAIL\BASURA
MOVE C:\CORREU\MAIL\*.* C:\CORREU\MAIL\BASURA
CD C:\CORREU\MAIL\BASURA 
DEL *.*
CD ..
RD BASURA
REM Cada un, que posi el Subdirectori de tornada
CD C:\MAS\CODE\2024\CRISTOBAL

GOTO :FIN
:FIN
ECHO Comprovacio de correu finalitzada.
PAUSE
:TORNAR
REM UBO.BAT
REM El vostre fitxer de Retorn.

REM ________________________________________________




REM Esquema 
REM Excepte el SUbdirectori BASURA, els altres Subdirectoris s enten que existeixen
REM
REM            _________                                             __________
REM           |CORREU   |                                           | CORREU   |
REM            _________                                             __________
REM               |                                    _________________ |_______________
REM               |                                    |                 |               |
REM               |                                    |                 |               |
REM           __________                             ______           _______        
REM           | MAIL    |  1) Copiam de MAIL a USU1 | USU1 |          |USU2  |        .../...
REM            _________                             ________         _______ 
REM               |
REM               |
REM               |
REM           ___________
REM           | BASURA   |         2) Movem de MAIL a BASURA, i esborram.
REM            __________

REM https://www.tuinformaticafacil.com/sistemas-operativas/windows/comando-xcopy


