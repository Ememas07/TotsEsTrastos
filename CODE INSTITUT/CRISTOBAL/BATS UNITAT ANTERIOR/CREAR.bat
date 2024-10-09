REM CREAR.BAT
REM Crear subdirectoris.

REM =====================
:INICI
@ECHO OFF
ECHO CREAR.BAT
CLS
IF "%1"=="" GOTO :AJUDA

:RUTINA
REM Crea Subdirectoris (n parameteres).
IF "%1"=="" GOTO :FI
IF "%1"=="FI" GOTO :TORNAR
IF "%1"=="fi" GOTO :TORNAR
IF "%1"=="Fi" GOTO :TORNAR
IF "%1"=="fI" GOTO :TORNAR
IF "%1"=="*" GOTO :TORNAR
MKDIR %1
SHIFT



REM =====================
:PAUSAS
REM PAUSE
GOTO :RUTINA
REM ==================

REM =====================

:AJUDA
REM Ahora si hem de detallar de cara a l'usuari.
ECHO.
ECHO Programa   =       CREAR.BAT
ECHO Sintaxis   =       CREAR [SUBDIR]
ECHO Ejemples   =       CREAR SUBDIR1
ECHO                    CREAR SUBDIR2
ECHO                    CREAR SUBDIR1 SUBDIR2 
ECHO.
ECHO Sortir     =       CREAR FI
ECHO                    CREAR SUBDIR1 SUBDIR2 FI
ECHO                    CREAR SUBDIR1 SUBDIR2 *
ECHO Comentaris =       Crea subdirectoris, de de on esteim.
ECHO.
ECHO.
ECHO.
GOTO :FI
REM ============================

REM ===========================
:TORNAR
REM 
ECHO TORNAR
REM Posar enllac tornada
REM ===========================

REM ===========================
:FI
CLS
DIR
REM ===========================




