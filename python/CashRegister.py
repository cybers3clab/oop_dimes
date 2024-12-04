from Item import Item


class CashRegister:
    def __init__(self):
        self.total=0.0
        self.item_count=0
        self.item_list=[]

    def add_item(self, item:Item):
        self.item_list.append(item)
        self.total+=item.getPrice()
        self.item_count += 1

    def get_total(self):
        return self.total

    def get_count(self):
        return self.item_count

    def reset(self):
        self.total=0.0
        self.item_count=0
        self.item_list=[]

    def checkout(self):
        for el in self.item_list:
            print(el)
        self.reset()

    def __eq__(self, __value):
        if self.__class__==__value.__class__:
            return self.item_list.__eq__(__value.item_list)

    def __hash__(self):
        return self.item_list.__hash__()




