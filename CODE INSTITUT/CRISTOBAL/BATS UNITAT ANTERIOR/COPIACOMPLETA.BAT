set /P nom=NOM del backup (amb ext)
set /P ruta=ruta de l'empresa
set /P destinacio=on vols mandar el zip?
CD %ruta%
pkzipC -span -fast -recurse -add -path -attributes=all %nom% 
xcopy %nom% %destinacio% /i
del %nom% 
ECHO Copia completada, està a %destinacio%
PAUSE
COPIESSEGURETAT.BAT