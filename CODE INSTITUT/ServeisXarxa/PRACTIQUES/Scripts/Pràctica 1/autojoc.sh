#!/bin/bash
startup(){
    clear
    iteracions=0
    echo > NombresProvats.txt
    upper=100
    lower=1
    title_screen
    inici
}

inici(){
    read -p "Tria un nom: " nom
    nombre=$(($((RANDOM))%100))
    median=$((($upper/2)+$lower)) | bc
    intento=$median
    check
}
check(){
    echo $resultat
    part1=$(($upper/2))
    median=$(($part1+$lower)) | bc
    echo part 1 es $part1
    echo lower es $lower
    echo median es $median
    echo intento es $intento
    intento=$median
    echo median 2 es $median
    # Check if the number has already been tried
    if grep -Fxq "300" NombresProvats.txt; then
        echo "Ja has provat aquest número! Intenta-ho amb un altre."
        echo $intento
        check
    elif (($intento == $nombre)); then
        iteracions=$(($iteracions+1))
        echo $intento
        intento=$median
        finalitzar
        sortir
    elif (($intento > $nombre)); then
        median=$((($upper/2) + $lower)) | bc
        intento=$median
        echo "$intento" >> NombresProvats.txt
        echo "No! Més baix!"
        upper=$intento
        iteracions=$(($iteracions+1))
        check
    elif (($intento < $nombre)); then
        median=$((($upper/2) + $lower)) | bc
        intento=$median
        echo "$intento" >> NombresProvats.txt
        echo "No! Més alt!"
        lower=$intento
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

cat PartSuperior.txt
cat MillorsPuntuacions.txt
cat PartInferior.txt

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
    echo "Pitja Intro per entrar al joc..."
    read -r
}








echo INICI DEL JOC
echo 1. Iniciar
echo 2. Sortir
startup



