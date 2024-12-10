#!/bin/bash
echo INICI DEL JOC
startup

startup(){
    clear
    iteracions=0
    echo > NombresProvats.txt
    title_screen
    inici
}
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
inici(){
    read -p "Tria un nom: " nom
    nom=$(echo $nom | tr -d ' ')
    nombre=$(($((RANDOM))%100))
    check
}
check(){
    read -p "Tria un nombre: " intento

    # Check if the number has already been tried
    if grep -Fxq "$intento" NombresProvats.txt; then
        echo "Ja has provat aquest número! Intenta-ho amb un altre."
        check
    elif (($intento == $nombre)); then
        iteracions=$(($iteracions+1))
        finalitzar
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
finalitzar(){
echo "Enhorabona $nom, has guanyat en $iteracions intents!"
echo "#                       $nom - $iteracions                      #" >> Puntuacions.txt
echo "Taula de guanyadors:"
# Create a temporary file to store the best score for the user
best_score=$(grep -w $nom Puntuacions.txt | sort | head -n 1)
# Check if the user already has an entry in MillorsPuntuacions.txt
if grep -q -w "$nom" MillorsPuntuacions.txt; then
# If the user exists, update their entry only if the current score is better
grep -v -w "$nom" MillorsPuntuacions.txt > MillorsPuntuacions.tmp
echo "$best_score" >> MillorsPuntuacions.tmp
mv MillorsPuntuacions.tmp MillorsPuntuacions.txt
else
# If the user does not exist, just add their best score
echo "$best_score" >> MillorsPuntuacions.txt
fi
part_superior
cat MillorsPuntuacions.txt
part_inferior
}
part_superior(){
    echo "#######################################################"
    echo "#                                                     #"
}
part_inferior(){
    echo "#                                                     #"
    echo "#######################################################"
}
sortir(){
    return
}
