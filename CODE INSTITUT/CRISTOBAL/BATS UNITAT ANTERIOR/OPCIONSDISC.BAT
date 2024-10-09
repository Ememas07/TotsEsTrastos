ECHO OPCIONS DE DISCO
:MENU

ECHO 1.- Escanetjar Disco Dur
ECHO 2.- Visualitzar arbre de directori
ECHO 3.- Crear estructura concreta de subdirectoris
ECHO 4.- Eliminar estructura concreta de subdirectoris
ECHO 5.- Crear algunes carpetes amb una sola ordre
ECHO 6.- Crear 100 carpetes amb una sola ordre
ECHO 7.- Esborrar 100 carpetes amb una sola ordre
ECHO 8.- Visualitzar Prompt (HELP)
ECHO 9.- Visualitzar contingut de 1 fitxer
ECHO 10.- Cercar "Cadena" a 1 arxiu
ECHO 11.- Imprimpir 1 o varis fitxers
ECHO 12.- Cercar arxius a qualsevol unitat
ECHO 13.- Tornar
set /P opcio=Trii proces que realitzar:
ECHO
IF %opcio% equ 13 GOTO :TORNAR
IF %opcio% equ 12 GOTO :CERCARQUALSEVOLUNIT
IF %opcio% equ 11 GOTO :IMPRIMIR
IF %opcio% equ 10 GOTO :CERCARCADENA
IF %opcio% equ 9 GOTO :VISUFITXER
IF %opcio% equ 8 GOTO :VISUHELP
IF %opcio% equ 7 GOTO :BORR100CAR
IF %opcio% equ 6 GOTO :CREA100CAR
IF %opcio% equ 5 GOTO :CREARVARIESCARP
IF %opcio% equ 4 GOTO :BORRARESTR
IF %opcio% equ 3 GOTO :CREARESTR
IF %opcio% equ 2 GOTO :VISUALITZARTREE
IF %opcio% equ 1 GOTO :ESCANEAR
IF %opcio% equ 0 Cancelat per l'usuari

:ESCANEAR
XEQUET.BAT
CLS
goto :MENU

:VISUALITZARTREE
TREE c:\
PAUSE
CLS
goto :MENU
:CREARESTR
ARBREDIRECTORI.bat
tree
PAUSE
CLS
goto :MENU
:BORRARESTR
ELIMINARDIRECTORIS.BAT
PAUSE
CLS
goto :MENU
:CREARVARIESCARP
CREARCARPETES.BAT
CLS
goto :MENU
:CREA100CAR
CREAR100CARP.BAT
CLS
goto :MENU
:BORR100CAR
BORRAR100CARP.BAT
CLS
goto :MENU
:VISUHELP
PROMPT /?
CLS
goto :MENU
:VISUFITXER
MIRAFITXERS.BAT
CLS
goto :MENU
:CERCARCADENA
CERCARCADENA.BAT
CLS
goto :MENU
:IMPRIMIR
IMPRIMIR.BAT
CLS
goto :MENU
:CERCARQUALSEVOLUNIT
CERCAFITXERS.BAT
CLS
goto :MENU
:TORNAR
MENU.BAT
CLS

