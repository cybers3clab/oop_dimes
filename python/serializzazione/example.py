import pickle

# Definizione della classe Persona
class Persona:
    def __init__(self, nome, eta, email):
        self.nome = nome
        self.eta = eta
        self.email = email

    def __repr__(self):
        return f"Persona(nome='{self.nome}', età={self.eta}, email='{self.email}')"

# Creazione di un'istanza di Persona
persona = Persona("Alice", 25, "alice@example.com")

# Serializzazione dell'oggetto Persona
with open("persona.pkl", "wb") as file:
    pickle.dump(persona, file)
print(f"Oggetto Persona serializzato e salvato su 'persona.pkl': {persona}")

# Deserializzazione dell'oggetto Persona
with open("persona.pkl", "rb") as file:
    persona_caricata = pickle.load(file)

print("Oggetto Persona deserializzato con successo:")
print(persona_caricata)

# Verifica che l'oggetto originale e quello deserializzato siano equivalenti
print("\nGli oggetti sono equivalenti:", persona.__dict__ == persona_caricata.__dict__)

persone = [
    Persona("Alice", 25, "alice@example.com"),
    Persona("Bob", 30, "bob@example.com"),
    Persona("Carol", 22, "carol@example.com")
]


