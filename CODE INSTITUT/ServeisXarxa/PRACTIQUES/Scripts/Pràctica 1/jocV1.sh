#!/bin/bash
# Pantalla on es pot iniciar/sortir del joc.
# Pantalla on es demana el nom del jugador.
# Comença partida
# El programa genera un nombre 'pensat' entre 0 i 100.
# L'usuari escriu un nombre 'x' entre 1 i 99.
# El programa contesta si és més alt o més baix del nombre 'pensat'.
# El programa compara si 'x' és igual a 'pensat'.
# Si x=pensat segueix al següent punt
# Sino: pasa al punt 2
# Pantalla Continuar o acabar.
startup(){
    read -p "Tria una opció: " start
if (( $start == 1 )); then
    inici

elif (($start == 2)); then
    sortir
fi
}

inici(){
    read -p "Tria un nom: " nom
    nombre=$(($((RANDOM))%100))
    check    
}

check(){
    echo $resultat
    read -p "Tria un nombre: " intento
    if (($intento == $nombre)); then
        echo Enhorabona $nom, has guanyat!
        sortir

    elif (($intento > $nombre)); then
        echo El nombre és més alt que el teu.
        check
    elif (($intento < $nombre)); then
        echo El nombre és més baix que el teu.
        check
    else
        echo error
    fi
}

sortir(){
    return
}
echo INICI DEL JOC
echo 1. Iniciar
echo 2. Sortir
startup


