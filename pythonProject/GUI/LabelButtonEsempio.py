import tkinter as tk
def on_click():
    print("Pulsante cliccato!")
root = tk.Tk()
label = tk.Label(root, text="Benvenuto!")
label.pack()
button = tk.Button(root, text="Clicca qui", command=on_click)
button.pack()
entry = tk.Entry(root)
entry.pack()
text = tk.Text(root)
text.pack()

root.mainloop()