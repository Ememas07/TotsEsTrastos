#!/bin/bash
startup(){
    read -p "Fins a quin numero vols que arribi?" mesalt
    read -p "Quantes vegades vols executar el programa? " executions
    echo > TaulaIntentosAUTO.txt
    clear
    upper=$(($mesalt-1))
    lower=0
    iteracions=0
    intents="" # Variable per guardar tots els intents
    title_screen
    for ((i=1; i<=executions; i++)); do
        echo "Execució $i..."
        echo > NombresProvats.txt
        upper=$(($mesalt-1))
        lower=0
        iteracions=0
        intents=""
        inici
    done
}

inici(){
    nom=IA
    nombre=$(($((RANDOM))%$mesalt))
    check
    
}
check(){
    intento=$(((lower + upper) / 2))
    if [[ -z $intents ]]; then
        intents="$intento"
    else
        intents="$intents,$intento"
    fi
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
        upper=$((intento - 1))
        iteracions=$(($iteracions+1))
        check
    elif (($intento < $nombre)); then
        echo "$intento" >> NombresProvats.txt
        lower=$((intento + 1))
        iteracions=$(($iteracions+1))
        check
    else
        echo "Error: Entrada no vàlida."
    fi
}

sortir(){
    return
}
finalitzar(){
    echo "Enhorabona $nom, has guanyat en $iteracions intents!"

    # Afegim la línia al fitxer
    printf "%s - %d iteracions a %d, entre 0 i %d\n" "$intents" "$iteracions" "$nombre" "$mesalt" >> TaulaIntentosAUTO.txt

    # Ordenar i mostrar en bloc
    echo "#######################################################"
    echo "#   Resultats ordenats fins ara:                     #"
    echo "-------------------------------------------------------"
    printf "%-50s %-15s %-30s\n" "Intents" "Iteracions" "Descripció"

    # Processar i mostrar amb awk (més ràpid)
    sort -t'-' -k2n TaulaIntentosAUTO.txt | awk -F' - | iteracions a |, entre ' '
    BEGIN { printf "%-50s %-15s %-30s\n", "Intents", "Iteracions", "Descripció" }
    {
        printf "%-50s %-15s %-30s\n", $1, $2 " iteracions", "a " $3 ", entre " $4
    }'

    echo "#######################################################"
}


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
}








echo INICI DEL JOC
startup



