(: Obtenir tots els noms dels contactes del titular que tenen telèfon fix. :)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes3\agenda.xml")
for $persona in $x/agenda/contactes/persona
where $persona//fix
return $persona//nom