#!/bin/bash

startup(){
    read -p "Choose an option: " start
if (( $start == 1 )); then
    inici

elif (($start == 2)); then
    sortir
fi
}

inici(){
    read -p "What's your name? " nom
    nombre=$(($((RANDOM))%100))
    check    
}

check(){
    echo $resultat
    read -p "Choose a number: " intento
    if (($intento == $nombre)); then
        echo Congratulations $nom, you won!
        sortir

    elif (($intento > $nombre)); then
        echo The number you inserted is higher than the solution.
        check
    elif (($intento < $nombre)); then
        echo The number you inserted is lower than the solution.
        check
    else
        echo error
    fi
}

sortir(){
    return
}
echo GAME STARTUP
echo 1. Start
echo 2. Exit
startup


