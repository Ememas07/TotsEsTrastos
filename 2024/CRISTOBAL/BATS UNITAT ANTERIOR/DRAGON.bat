@echo off
color 2
:hola
cls
echo.
echo.
type 2.txt
echo.
echo.
@timeout /t 3
cls
echo.
echo.
type 1.txt
echo.
echo.
@timeout /t 1
goto hola