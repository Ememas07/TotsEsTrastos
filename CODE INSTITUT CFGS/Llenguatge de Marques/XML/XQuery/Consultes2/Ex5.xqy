(:~ Obtenir el nom dels fets juntament amb el número d'autors de cada llibre. ~:)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")
for $hecho in $x/evolucion/hecho
return ($hecho/nombre,count($hecho/autor))