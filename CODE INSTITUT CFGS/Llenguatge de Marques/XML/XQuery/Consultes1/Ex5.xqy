(:~ 5. Obtenir els noms dels menús que inclouen les espirals bolonyesa. ~:)
let $x := doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes1\cartamenus.xml")
for $platos in $x/carta/platos/*/*
where $platos/nombre = "Espirales boloñesa"
return $platos/menu