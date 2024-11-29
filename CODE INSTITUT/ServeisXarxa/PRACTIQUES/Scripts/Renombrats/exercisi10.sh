#!/bin/bash
echo Comprovar contrassenya
contrassenya=bondia
echo -n Introdueix contrassenya
read input
if [ "$input" = "$contrassenya" ]; then
    echo contrassenya correcta 
else
    echo contrassenya incorrecta
fi