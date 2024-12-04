from CashRegister import CashRegister
from Item import Item


class CassaSupermercato(CashRegister):



    def __init__(self, nome_supermercato):
        super().__init__()
        self.nome_supermercato=nome_supermercato

    def checkout(self):
        print(self.nome_supermercato)
        print("\n")
        totale=super().get_total()
        self.item_list.sort()

        #for el in self.item_list:
        #    print(el)
        super().checkout()

        print("\n")
        print("Totale: "+str(totale))
        print("\n")
        print("Grazie per avere acquistato da noi!")


i=Item(1,"aa",0.5)
i2=Item(2,"ba",0.5)
i3=Item(3,"bb",0.5)
i4=Item(4,"cc",1.0)
i5=Item(5,"cd",2.0)

ca=CassaSupermercato("Esselunga")

ca.add_item(i)
ca.add_item(i2)
ca.add_item(i3)
ca.add_item(i)
ca.add_item(i5)
ca.add_item(i3)
ca.add_item(i4)
ca.checkout()

ca.checkout()
