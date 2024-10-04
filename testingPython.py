Noms = ["Marc", "Pere"]
Approval=input("vols continuar? ")
while Approval=="si":
   
    print("Noms acceptats:",Noms)

    

    nombre=input("Com te noms?")
    if nombre in Noms:
        print("hola",nombre)
    else:
        llista=input("No sé qui ets,voldires afegir-te a la llista?")
        if  llista=="Si":
            Noms.append(nombre)
            print("ja està")
            print("la llista ara és:",Noms)
        else:
            print("val")
    Approval=input("vols continuar? ")
        