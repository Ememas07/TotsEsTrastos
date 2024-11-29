#!/bin/bash
echo -n Numero 1?
read n1
echo -n Numero 2?
read n2
a=$((n1+n2))
b=$((n1-n2))
c=$((n1*n2))
echo la suma es $a, la resta es $b, la multiplicacio es $c