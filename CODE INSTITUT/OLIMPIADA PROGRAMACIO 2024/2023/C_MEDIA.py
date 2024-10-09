
numero=input()
llist=list(numero)
llista=sorted(llist)
result,rest=divmod(llista.__len__(),2)
if(rest==0 ):
    menor=llista[result-1]
    major=llista[result]
    median=int(major)+int(menor)
    print(int(median) /2)
else:
    print("odd")






print(llista)