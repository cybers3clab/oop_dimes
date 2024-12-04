import tkinter as tk
from tkinter import messagebox

def on_button_click():
    user_input = entry.get()
    if checkbox_var.get():
        messagebox.showinfo("Informazione", f"Hai scritto: {user_input}")
    else:
        messagebox.showinfo("Errore", f"Non hai accettato i termini")
# Creazione della finestra principale
root = tk.Tk()
root.title("Esempio di Widget Tkinter")

# Etichetta
label = tk.Label(root, text="Benvenuto nell'esempio di Tkinter!")
label.pack(pady=10)

# Campo di immissione
entry = tk.Entry(root)
entry.pack(pady=5)

# Pulsante
button = tk.Button(root, text="Clicca qui!", command=on_button_click)
button.pack(pady=5)

# Casella di controllo
checkbox_var = tk.BooleanVar()
checkbox = tk.Checkbutton(root, text="Accetta i termini", variable=checkbox_var)
checkbox.pack(pady=5)

# Casella di testo
text_area = tk.Text(root, height=5, width=30)
text_area.pack(pady=10)
text_area.insert(tk.END, "Questa è una casella di testo.\nPuoi scrivere qui.")

# Pulsante per chiudere
exit_button = tk.Button(root, text="Esci", command=root.quit)
exit_button.pack(pady=10)

# Avvio del loop principale
root.mainloop()