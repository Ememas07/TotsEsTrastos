REM XARXES
REM Professor Cristobal Mora
@echo OFF
COLOR 1A
CLS


:MENU
CLS
ECHO.
ECHO ******************************
ECHO  * SCRIPT XARXES   *
ECHO ***********************
ECHO.
ECHO 1.- Tria la tarjeta de xarxa en la qual treballadr
ECHO 2. - COnfiguracio IP, mascara de sunxarxa i porta d'enllac (ESTATICA)
ECHO 3.- Configurar la IP dibamica de la targeta de xarxa 
ECHO 4.- Configura els servidors dns preferits i alternatiu de manera ESTATICA
ECHO 5.- Configurar els servidors de dns de la targeta de xarxa de manera dinamica.
ECHO 6.- Configuracio de la targeta actual.
ECHO 7.- Fer ping a un host.
ECHO 8.- Fer tracert a un host.
ECHO 9.- Sortir
ECHO.
set /P opcio=Trii proces que realitzar:
ECHO
IF %opcio% equ 9 GOTO :SORTIR
IF %opcio% equ 8 GOTO :TRACER
IF %opcio% equ 7 GOTO :PING
IF %opcio% equ 6 GOTO :ACTUAL
IF %opcio% equ 5 GOTO :DNSDIN
IF %opcio% equ 4 GOTO :DNSEST
IF %opcio% equ 3 GOTO :IPDIN
IF %opcio% equ 2 GOTO :IPEST
IF %opcio% equ 1 GOTO :TRIAR
IF %opcio% equ 0 Cancelat per l'usuari
ECHO
:TRIAR
CLS
ECHO.
ECHO **********************
ECHO *Tarjetes de xarxa*
ECHO **********************
ECHO.
netsh interface show interface
set /p targeta= Elegeix la targeta amb la qual vols treballar:
//Amb aquesta opcio del bat podem triar la tarjeta de xarxa amb la qual treballar
CLS
goto :MENU
:IPEST
CLS
ECHO.
ECHO *************************
ECHO *Configuracio estatica*
ECHO *************************
ECHO.
set /P IP= Quina IP desitja posar? (tengui en conta que son 4 bytes separats per punts):
set /P MASCARA=Recordi que la mascara depen de la classe de la IP, introduiula aqui:
set /P Porta=posi la porta d'enllac del vostre router:
netsh interface ip set address %targeta% static %IP% %MASCARA% %PORTA%
PAUSE
netsh interface ip show config %targeta%
PAUSE
//Amb la seguent opcio ens ajuda a configurar manualment la ip, la mascara i la porta de enllac
CLS
goto :MENU
:IPDIN
CLS
ECHO.
ECHO **********************
ECHO *Configuracio dinamica*
ECHO **********************
ECHO.
netsh interface ip set address %targeta% DHCP
PAUSE
netsh interface ip show config %targeta%
//amb aquesta opcio la IP s'ens posa de forma automatica (DHCP)
CLS
goto :MENU
:DNSEST
CLS
ECHO.
ECHO **********************
ECHO *DNS ESTATICA*
ECHO **********************
ECHO.
set /P DNSPRIM= Introduesqui el DNS primari:
set /P DNSSECU= Introduesqui el DNS secundari:
netsh interface ip set dns %targeta% static %DNSPRIM% primary
netsh interface ip set dnsservers name=%targeta% address=%DNSSECU% validate=no index=2
PAUSE
netsh interface ip show config %targeta%
PAUSE
//amb aquesta opcio podem indicar manualment el DNS primari i el DNS secundari que volem ficar
CLS
GOTO :MENU
:DNSDIN
CLS
ECHO.
ECHO **********************
ECHO *DNS Dinamica*
ECHO **********************
ECHO.
netsh interface ip set dns %targeta% DHCP
PAUSE
netsh interface ip show config %targeta%
//amb aquesta opcio la IP es posa mode DHCP (automatica)
CLS
GOTO :MENU
:ACTUAL
CLS
ECHO.
ECHO **********************
ECHO *IP ACTUAL*
ECHO **********************
ECHO.
netsh interface ip show config %targeta%
PAUSE
ipconfig /all
PAUSE
//ens mostra la configuracio actual (ho he aplicat a tots els apartats per verificar els canvis)
CLS
GOTO :MENU
:PING
CLS
ECHO.
ECHO **********************
ECHO *PING *
ECHO **********************
ECHO.
set /P DEST= indiqui la adreca de desti on fer ping
ping %DEST%
PAUSE
netsh interface ip show config %targeta%
PAUSE
//AMB aquest comnado podem fer ping a una IP o un domini sense necessitat de picar la comanda
CLS
GOTO :MENU
:TRACER
CLS
ECHO.
ECHO **********************
ECHO *IP ACTUAL*
ECHO **********************
ECHO.
set /P DESTI= indiqui la adreca de desti on fer tracert
TRACERT %desti%
PAUSE
netsh interface ip show config %targeta%
PAUSE
// Amb aquest comando podem fer tracert a una ip o un domini sense necessitat de picar la comanda
CLS
GOTO :MENU
:SORTIR
CLS
ECHO.
ECHO **********************
ECHO *SORTIR*
ECHO **********************
ECHO.
set /P sss= Realment vol sortir? (s/n)
IF %sss% equ S GOTO :FI
IF %sss% equ s GOTO :FI
ECHO.
GOTO :MENU
:FI
CLS
EXIT





