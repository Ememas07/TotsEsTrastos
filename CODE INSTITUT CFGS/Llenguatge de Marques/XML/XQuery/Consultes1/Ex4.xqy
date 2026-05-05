(:~ 4. Obtenir els noms de los menús el preu dels quals és menor de 20 €. ~:)
let $x := doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\Consultes1\cartamenus.xml")
for $menu in $x/carta/menus/menu
where $menu/precio < 20
return $menu/nombre