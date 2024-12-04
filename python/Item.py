import os

class Item():
    def __init__(self,id:int,name:str,price:float):
        if id>0 and len(name)>1 and price>0.0:
            self._id=id
            self._name=name
            self._price=price
        else:
            os.close(-1)
    def getName(self):
        return self._name

    def getPrice(self):
        return self._price

    def getId(self):
        return self._id

    def __str__(self):
        return "Articolo: "+self.getName() + " Prezzo: "+str(self.getPrice())

    def __eq__(self, __value):
        if type(self)==type(__value):
            return self.getId()==__value.getId()

    def __hash__(self):
        return self._id*31;

    def __lt__(self,obj):
        return self._name<obj._name
def test():
    print("cAne")


#test()

#print("CANE")





