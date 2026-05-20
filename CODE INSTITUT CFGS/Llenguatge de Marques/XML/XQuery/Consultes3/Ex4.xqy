(: Obtenir els noms del titular i els seus contactes ordenats amb el format: cognoms, nom i un per fila. :)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes3\agenda.xml")
for $persona in $x/agenda//nomCognoms
return <contacte>
{$persona/cognoms/string()}
{$persona/nom/string()}
</contacte>