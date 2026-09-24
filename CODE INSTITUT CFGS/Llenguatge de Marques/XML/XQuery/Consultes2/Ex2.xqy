(:~ Obtenir tots els noms dels fets en l'evolució de la informàtica ocorreguts a partir de 1800. ~:)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")
for $hecho in $x/evolucion/hecho
where $hecho/fecha/anyo > 1800
return $hecho