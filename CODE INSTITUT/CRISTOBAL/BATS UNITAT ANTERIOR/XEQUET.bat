REM XEQUET.BAT
@ECHO OFF
COLOR 1A
CLS
CHKDSK %1 /F
REM Codis de Sortida de CHKDSK
IF ERRORLEVEL 255 GOTO :E255
IF ERRORLEVEL 254 GOTO :E254
IF ERRORLEVEL 4 GOTO :E4
IF ERRORLEVEL 3 GOTO :E3
IF ERRORLEVEL 2 GOTO :E2
IF ERRORLEVEL 1 GOTO :E1
IF ERRORLEVEL 0 GOTO :E0
GOTO :Fi
:E255
ECHO "CHKDSK ha trobat errors i no els he corregit"
GOTO :PAUSAS
:E254
ECHO "CHKDSK ha trobat errors i els ha corregit tots"
GOTO :PAUSAS
:E4
ECHO "L'usuari ha interromput l'analizi físic"
GOTO :PAUSAS
:E3
ECHO "L0usuari ha interromput l'analisi logic"
GOTO :PAUSAS
:E2
ECHO "Interromput CHKDSK per error intern"
GOTO :PAUSAS
:E1
ECHO "Sintaxis correcte"
GOTO :PAUSAS
:E0
ECHO "CHKDSK Realitzat correctament"
GOTO :Pausas
REM ---------
GOTO :PAUSAS 
REM ----------
:PAUSAS
PAUSE
CLS
GOTO :AJUDA
REM ---------
:AJUDA
REM Detallam de cara a I 'usuari
ECHO.
ECHO Programa = XEOUET.BAT
ECHO Sintaxis = XEQUET [UNITAT]
ECHO Exemples = XEQUET A:
ECHO            XEQUET B:
ECHO            XEQUET C:
ECHO Sortire = XEQUET Fl
ECHO Comentaris = Escanetja totalment una unitat
ECHO.
ECHO.
ECHO.
GOTO :FI
REM ----------
REM ----------
:TORNAR
REM UNO
REM -----------
REM -----------
:fi
PAUSE
REM opcionsdiscs.bat