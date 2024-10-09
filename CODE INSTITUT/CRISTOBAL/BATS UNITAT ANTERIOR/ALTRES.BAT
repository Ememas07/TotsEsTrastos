:MENUS
ECHO 1.- Calculadora de Windows.
ECHO 2.- Paint.
ECHO 3.- Notepad.
ECHO 4.- Lliure Office Writer
ECHO 5.- Lliure Office Base
ECHO 6.- Lliure Office Calc
ECHO 7.- Anar a Youtube
ECHO 8.- Anar a la tenda PC-BOX
ECHO 9.- Sortir

set /P opcio=Trii programa
IF %opcio% equ 1 GOTO :CALC
IF %opcio% equ 2 GOTO :PAINT
IF %opcio% equ 3 GOTO :NOTEPAD
IF %opcio% equ 4 GOTO :OFFICEWRITER
IF %opcio% equ 5 GOTO :OFFICEBASE
IF %opcio% equ 6 GOTO :OFFICECALC
IF %opcio% equ 7 GOTO :YOUTUBE
IF %opcio% equ 8 GOTO :PCBOX
IF %opcio% equ 9 GOTO :EXIT

:CALC
calc
CLS
goto :MENUS
:PAINT
MSPAINT
CLS
goto :MENUS
:NOTEPAD
NOTEPAD
CLS
goto :MENUS
:OFFICEWRITER
C:\Program Files\LibreOffice\program\swriter.exe
CLS
goto :MENUS
:OFFICEBASE
C:\Program Files\LibreOffice\program\sbase.exe
CLS
goto :MENUS
:OFFICECALC
C:\Program Files\LibreOffice\program\scalc.exe
CLS
goto :MENUS
:YOUTUBE
start https://youtube.com
CLS
goto :MENUS
:PCBOX
start https://pcbox.com
CLS
goto :MENUS
:EXIT
MENU.BAT