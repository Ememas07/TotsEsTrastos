#!/bin/bash
startup(){
    clear
    upper=99
    lower=0
    iteracions=0
    echo > NombresProvats.txt
    title_screen
    inici
}

inici(){
    nom=IA
    nombre=$(($((RANDOM))%100))
    check
}
check(){
    echo $resultat
    intento=$(((lower + upper) / 2))
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
        upper=$((intento - 1))
        iteracions=$(($iteracions+1))
        check
    elif (($intento < $nombre)); then
        echo "$intento" >> NombresProvats.txt
        echo "No! Més alt!"
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
}








echo INICI DEL JOC
echo 1. Iniciar
echo 2. Sortir
startup



