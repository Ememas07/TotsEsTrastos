(:~ Obtenir el nom del fet, l'autor i les referències, en l'arxiu referencias.xml, d'aquells fets que en tinguin. ~:)
for $hecho in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")/evolucion/hecho
for $ref in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\referencies.xml")/referencias/entrada
where $ref/nombre = $hecho/nombre
return ($hecho/nombre, $hecho/autor, $ref/url)