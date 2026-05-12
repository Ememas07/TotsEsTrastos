(: Obtenir els noms dels contactes de la localitat "Solsona". Mostrar també la localitat. :)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes3\agenda.xml")
for $persona in $x/agenda/contactes/persona
where $persona/adreça/localitat = 'Solsona'
return $persona/nomCognoms/nom | $persona/adreça/localitat