(:~ Obtenir els noms dels fets esdevinguts entre els anys 1900 i 2000. ~:)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")
for $hecho in $x/evolucion/hecho
where $hecho/fecha/anyo > 1900 and $hecho/fecha/anyo < 2000
return $hecho/nombre