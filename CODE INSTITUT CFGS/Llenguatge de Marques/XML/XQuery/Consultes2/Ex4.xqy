(:~ Obtenir els noms dels autors i els fets en els quals van participar 2 persones. ~:)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")
for $hecho in $x/evolucion/hecho
where count($hecho/autor) = 2
return ($hecho/autor,$hecho/nombre)