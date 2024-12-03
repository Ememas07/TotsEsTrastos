#!/bin/bash
startup(){
    read -p "Tria una opció: " start
if (( $start == 1 )); then
    iteracions=0
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
        iteracions=$(($iteracions+1))
        echo Enhorabona $nom, has guanyat en $iteracions Intents!
        echo $nom Ha guanyat amb $iteracions intents >> Puntuacions.txt
        sortir

    elif (($intento > $nombre)); then
        echo No! Més baix!
        iteracions=$(($iteracions+1))
        check
    elif (($intento < $nombre)); then
        echo No! Més alt!
        iteracions=$(($iteracions+1))
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