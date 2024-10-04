set /P nom=NOM del backup (amb ext)
set /P ruta=ruta de les copies?
set /P destino=ruta on vols extraurarles
CD %ruta%
xcopy %nom% %destino% /I
del %nom%
cd %destino%
pkzipC -extract -dir=current %nom%
del %nom%
ECHO backup completat
PAUSE
COPIESSEGURETAT.BAT