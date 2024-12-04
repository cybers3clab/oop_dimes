import tkinter as tk
def saluta():
    print("Ciao!")
root = tk.Tk()
button = tk.Button(root, text="Cliccami!", command=saluta)
button.pack()
root.mainloop()