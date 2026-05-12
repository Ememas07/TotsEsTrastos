(: Obtenir tots els noms dels contactes del titular juntament amb els seus telèfons. :)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes3\agenda.xml")
return $x/agenda/contactes//nom | $x/agenda/contactes//telefons