@ECHO OFF
set /p PC= Quin pc vol fer? (PC1, per exemple)
set /P Mes= Quin mes vol fer? (01, per exemple)
set /P Any= Quin any vol fer? (2023, per exemple)

call %PC%.%mes%.%any%.BAT
ECHO EL VALOR DE CPU ES %CPU% 
ECHO EL VALOR DE CACHE 1 ES %CACHE1% 
ECHO EL VALOR DE CACHE 2 ES %CACHE2% 
ECHO EL VALOR DE CACHE 3 ES %CACHE3% 
ECHO EL VALOR DE RAM 1 ES %RAM1% 
ECHO EL VALOR DE RAM 2 ES %RAM2% 
ECHO EL VALOR DE HD 1 ES %HD1% 
ECHO EL VALOR DE HD 2 ES %HD2% 
ECHO EL VALOR DE TGRAFICA ES %TGRAFICA% 
ECHO EL VALOR DE TRED ES %TRED% 
ECHO EL VALOR DE USB 1 ES %USB1% 
ECHO EL VALOR DE USB 2 ES %USB2% 
ECHO EL VALOR DE USB 3 ES %USB3% 
ECHO EL VALOR DE DVD 1 ES %DVD1% 
ECHO EL VALOR DE DVD 2 ES %DVD2%
SET /A SUMA="%cpu%+%ram1%"
ECHO La suma de CPU i RAM1 es %suma%