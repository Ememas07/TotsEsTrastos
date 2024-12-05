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
    avg_time=$((total_time / total_execucions))  # Mitjana de temps
    avg_iteracions=$((total_iteracions / total_execucions)) # Mitjana de iteracions
    echo "#######################################################"
    echo "Mitjana de temps de execució: $avg_time ms"
    echo "Mitjana de iteracions: $avg_iteracions"
    echo "#######################################################"
}

inici(){
    nom=IA
    nombre=$(($((RANDOM))%$mesalt))
    start_time=$(date +%s%3N)  # Temps d'inici en milisegons    
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
    end_time=$(date +%s%3N)  # Temps final en milisegons
    execution_time=$((end_time - start_time))   
    clear
    echo "Enhorabona $nom, has guanyat en $iteracions intents!"

    # Afegir la línia al fitxer amb format fix, incloent el temps d'execució
    printf "%s - %d iteracions a %d, entre 0 i %d, Temps: %d ms\n" "$intents" "$iteracions" "$nombre" "$mesalt" "$execution_time" >> TaulaIntentosAUTO.txt

    # Ordenar el fitxer per iteracions i mostrar en temps real
    echo "#######################################################"
    echo "#   Resultats ordenats per iteracions:               #"
    echo "-------------------------------------------------------"

    # Primer, imprimeix els títols de les columnes
    printf "%-50s %-15s %-30s %-15s\n" "Intents" "Iteracions" "Descripció" "Temps"

    total_time=$((total_time + execution_time))  # Sumar el temps d'execució
    total_iteracions=$((total_iteracions + iteracions))  # Sumar les iteracions
    total_execucions=$((total_execucions + 1))  # Incrementar el nombre d'execucions
    # Ordena i mostra amb awk: ordenar per iteracions (a la segona columna)
    sort -t'-' -k2n TaulaIntentosAUTO.txt | while IFS=" - " read -r intents iteracions_descripcio
    do
        # Separar la descripció de les iteracions i el número final
        iteracions=$(echo "$iteracions_descripcio" | cut -d' ' -f1)
        descripcio=$(echo "$iteracions_descripcio" | sed 's/^[^a-zA-Z0-9]*//')
        
        # Mostrar amb format d'amplada fixa
        printf "%-50s %-15s %-30s %-15s\n" "$intents" "$iteracions iteracions" "$descripcio" "$execution_time ms"
    done

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



