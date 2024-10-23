
class Counter:
    def getValue(self):
        return self._value
    def click(self):
        self._value=self._value+1
    def reset(self):
        self._value=0
    def __init__(self):
        self._value=0

