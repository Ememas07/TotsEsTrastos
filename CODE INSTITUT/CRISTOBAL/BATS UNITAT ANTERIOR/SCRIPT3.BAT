@echo off
title Division de dos numeros
set/p uno=Escriba el numerador
:denominador
set/p dos=Escriba el denominador
if %dos%==0 (goto nosepuede) else (goto dividir)
:nosepuede
echo El denominador no puede ser cero.
goto denominador
:dividir
set/a tres=%uno%/%dos%
echo El resultado de %uno%/%dos% es %tres%
pause>nul
ALTRESPROGRAMES.BAT