@ECHO OFF
setlocal enableDelayedExpansion
set /p PC1= Quin pc vol mirar? (1, per exemple)
set /P Mes= Quin mes vol acabar? (01, per exemple)
set /P Any= Quin any vol fer? (2023, per exemple)
SET MITJA=0
SET PCFINAL=%PC1%
SET PC1=1
SET MESFINAL= %MES%
SET MES=1
:loop
REN PC%PC1%.0%mes%.%any%.BAT PC%PC1%.0%mes%.%any%.TXT 



ECHO HE FET PC%PC1%.0%mes%.%any%.BAT
SET /A MES="%MES%+1"
SET /A MITJA="%MITJA%+1"
if %MES% GTR %MESFINAL% goto :checkpc
goto loop


:checkpc
SET MES=1
SET /A PC1="%PC1%+1"
if %pc1% GTR %PCFINAL% goto :exitloop
goto loop
:exitloop
