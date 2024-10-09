REM MOSTRAR.BAT

REM ========================
:INICIO
@ECHO OFF
REM 
CLS
IF "%1"==""  GOTO :AJUDA
REM ================================

REM ================================
:RUTINA
REM MOSTRAR UN FITXER QUALSEVOL
IF "%1"=="FI" GOTO :TORNAR
TYPE %1
REM =====================

REM =====================
REM CODIS DE SORTIDA de TYPE  :
IF ERRORLEVEL 2 GOTO :E2 
IF ERRORLEVEL 1 GOTO :E1 
IF ERRORLEVEL 0 GOTO :E0 
GOTO :FI

REM CODIS DE SORTIDA
:E2
ECHO "Error E2------------------------------------."
GOTO :PAUSAS
:E1
ECHO "ERROR : El fitxer especificat no s'ha trobat."
GOTO :PAUSAS
:E0
ECHO "OK : s'ha trobat el fitxer."
GOTO :PAUSAS
REM ==============================

REM =============================
:AJUDA
CLS
REM Ahora si hem de detallar de cara a l'usuari.
ECHO.
ECHO Programa   =       MOSTRAR.BAT
ECHO Sintaxis   =       MOSTRAR fitxer.extensio
ECHO Exemples   =       MOSTRAR DOC1.TXT
ECHO                    MOSTRAR DOC2.TXT
ECHO                    MOSTRAR DOC2.TXT
ECHO Sortir     =       MOSTRAR FI
ECHO Comentaris =       Visualitza "cadena de texte" dins 1 fitxer
ECHO.
ECHO.
ECHO.
GOTO :FI
REM =============================================







REM ======================================================
:TORNAR

REM UNO.BAT
REM ======================================================
:FI
REM ======================================================
