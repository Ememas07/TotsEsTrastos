(:~ 3. Obtenir els noms de tots els plats inclosos en la carta. ~:)
for $x in doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes1\cartamenus.xml")
return $x/carta/platos/*/*/nombre