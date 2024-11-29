#!/bin/bash
echo Quin es el mes alt?
echo -n Numero 1?
read n1
echo -n Numero 2?
read n2
if (( $n1 > $n2 )); then
    echo n1 és major
else
    echo n2 és major
fi