(:~ Obtenir nom, descripció i autors dels fets succeïts abans de 1900 però sense incloure la data d'aquests. ~:)
for $hecho in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes2\UD7_CPE_2.xml")/evolucion/hecho
where $hecho/fecha/anyo < 1900
return ($hecho/nombre, $hecho/descripcion, $hecho/autor)