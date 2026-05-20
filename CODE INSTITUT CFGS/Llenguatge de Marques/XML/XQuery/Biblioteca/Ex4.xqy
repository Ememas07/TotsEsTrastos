let $x := doc("C:\Users\Marc Mas\Documents\Code\CODE INSTITUT CFGS\Llenguatge de Marques\XML\XQuery\biblioteca.xml")
order by $x/biblioteca/libro/numPaginas
return $x/biblioteca/libro/titulo
