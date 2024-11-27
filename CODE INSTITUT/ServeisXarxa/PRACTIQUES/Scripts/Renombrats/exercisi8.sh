#!/bin/bash
echo Son multiples?
if (( $(($1 % $2))==0 )); then
    echo $1 i $2 son multiples
else
    echo $1 i $2 No son multiples
fi