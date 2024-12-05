#!/bin/bash
startup(){
    clear
    iteracions=0
    echo > NombresProvats.txt
    title_screen
    inici
}

inici(){
    read -p "Tria un nom: " nom
    nombre=$(($((RANDOM))%100))
    check
}
check(){
    echo $resultat
    read -p "Tria un nombre: " intento

    # Check if the number has already been tried
    if grep -Fxq "$intento" NombresProvats.txt; then
        echo "Ja has provat aquest número! Intenta-ho amb un altre."
        check
    elif (($intento == $nombre)); then
        iteracions=$(($iteracions+1))
        echo "Enhorabona $nom, has guanyat en $iteracions intents!"
        echo "$nom ha guanyat amb $iteracions intents" >> Puntuacions.txt
        sortir
    elif (($intento > $nombre)); then
        echo "$intento" >> NombresProvats.txt
        echo "No! Més baix!"
        iteracions=$(($iteracions+1))
        check
    elif (($intento < $nombre)); then
        echo "$intento" >> NombresProvats.txt
        echo "No! Més alt!"
        iteracions=$(($iteracions+1))
        check
    else
        echo "Error: Entrada no vàlida."
    fi
}

sortir(){
    return
}
#!/bin/bash

# Function to display the title screen
# Gra6 CHATGPT
title_screen() {
    clear
    echo "#######################################################"
    echo "#                                                     #"
    echo "#         Benvingut a Endevina!                       #"
    echo "#                                                     #"
    echo "#     Hauràs d'endevinar un numero entre 0 i 100 !    #"
    echo "#                                                     #"
    echo "#######################################################"
    echo ""
    echo "Pitja Intro per entrar al joc..."
    read -r
}








echo INICI DEL JOC
echo 1. Iniciar
echo 2. Sortir
startup



