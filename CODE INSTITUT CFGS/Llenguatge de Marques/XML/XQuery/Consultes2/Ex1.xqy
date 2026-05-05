(: Obtenir tots els noms dels fets en l'evolució de la informàtica. :)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")
return $x/evolucion/hecho/nombre