import tkinter as tk

def on_button_click():
    print("Pulsante cliccato!")

def on_key_press(event):
    print(f"Tasto premuto: {event.char}")

def on_mouse_click(event):
    print(f"Clic del mouse a ({event.x}, {event.y})")

# Creazione della finestra principale
root = tk.Tk()
root.title("Gestione degli Eventi in Tkinter")

# Pulsante
button = tk.Button(root, text="Clicca qui!", command=on_button_click)
button.pack(pady=20)

# Etichetta
label = tk.Label(root, text="Premi un tasto o clicca nella finestra.")
label.pack(pady=10)

# Binding degli eventi
root.bind("<KeyPress>", on_key_press)  # Evento di pressione di un tasto
root.bind("<Button-1>", on_mouse_click)  # Clic sinistro del mouse

# Avvio del loop principale
root.mainloop()