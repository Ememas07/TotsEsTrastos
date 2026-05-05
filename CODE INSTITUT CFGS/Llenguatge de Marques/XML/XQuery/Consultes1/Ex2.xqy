(:~ 2. Obtenir els noms dels menús disponibles. Utilitzant LET. ~:)
let $x := doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes1\cartamenus.xml")
return $x/carta/menus/menu/nombre