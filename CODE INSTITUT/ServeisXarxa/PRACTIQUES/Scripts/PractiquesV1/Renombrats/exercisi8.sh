#!/bin/bash
echo Quin es el mes alt?
echo -n Numero 1?
read n1
echo -n Numero 2?
read n2
echo -n Numero 3?
read n3
if (($n3 > $n2)); then
    if (($n3 > $n1)); then
        echo $n3 és el major
    else
        echo $n1 és el major
    fi
elif (($n2 > $n1)); then
    echo $n2 és el major
elif (($n1 > $n2)); then
    echo $n1 és el major
else
    echo tots són iguals
fi