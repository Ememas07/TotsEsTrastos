@echo off
@rem Conocer sistema operativo
set SISTEMA=Windows_NT
IF %OS% EQU %SISTEMA% (
echo Usas Windows
systeminfo
) ELSE (
echo Estas en un SO distinto a Windows
)
@pause
ALTRESPROGRAMES.BAT