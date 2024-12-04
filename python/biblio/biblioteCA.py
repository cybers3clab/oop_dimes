class Libro:
    def __init__(self, titolo, autore, genere, anno_pubblicazione):
        self.titolo = titolo
        self.autore = autore
        self.genere = genere
        self.anno_pubblicazione = anno_pubblicazione
        self.disponibile = True  # Inizialmente il libro è disponibile

    def __str__(self):
        return f"Titolo: {self.titolo}, Autore: {self.autore}, Genere: {self.genere}, Anno: {self.anno_pubblicazione}, Disponibile: {'Sì' if self.disponibile else 'No'}"


class Biblioteca:
    def __init__(self):
        self.catalogo = []  # Lista per memorizzare i libri
        self.prestiti = {}  # Dizionario per gestire i prestiti

    def aggiungi_libro(self, libro):
        """Aggiungi un libro al catalogo"""
        self.catalogo.append(libro)
        print(f"Libro aggiunto: {libro}")

    def cerca_libro(self, titolo=None, autore=None):
        """Cerca libri per titolo o autore"""
        risultati = set()
        for libro in self.catalogo:
            if (titolo and titolo.lower() in libro.titolo.lower()) or \
               (autore and autore.lower() in libro.autore.lower()):
                risultati.add(libro)
        return risultati

    def ordina_catalogo_per_titolo(self):
        """Ordina il catalogo per titolo"""
        self.catalogo.sort(key=lambda libro: libro.titolo.lower())
        print("Catalogo ordinato per titolo.")

    def ordina_catalogo_per_anno(self):
        """Ordina il catalogo per anno di pubblicazione (decrescente)"""
        self.catalogo.sort(key=lambda libro: libro.anno_pubblicazione, reverse=True)
        print("Catalogo ordinato per anno di pubblicazione.")

    def visualizza_catalogo(self):
        """Visualizza tutti i libri nel catalogo"""
        if not self.catalogo:
            print("Il catalogo è vuoto.")
        for libro in self.catalogo:
            print(libro)

    def presta_libro(self, libro, persona):
        """Gestisci il prestito di un libro"""
        if libro.disponibile:
            libro.disponibile = False
            self.prestiti[libro] = persona
            print(f"Libro prestato: {libro} a {persona}")
        else:
            print(f"Il libro '{libro.titolo}' non è disponibile.")

    def restituisci_libro(self, libro):
        """Restituisci un libro al catalogo"""
        if libro in self.prestiti:
            libro.disponibile = True
            del self.prestiti[libro]
            print(f"Libro restituito: {libro}")
        else:
            print(f"Il libro '{libro.titolo}' non era stato prestato.")


# Esempio di utilizzo
if __name__ == "__main__":
    biblioteca = Biblioteca()

    # Creazione di libri
    libro1 = Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy", 1954)
    libro2 = Libro("Dune", "Frank Herbert", "Sci-Fi", 1965)
    libro3 = Libro("1984", "George Orwell", "Distopia", 1949)

    # Aggiunta dei libri alla biblioteca
    biblioteca.aggiungi_libro(libro1)
    biblioteca.aggiungi_libro(libro2)
    biblioteca.aggiungi_libro(libro3)

    # Visualizza il catalogo
    print("\nCatalogo completo:")
    biblioteca.visualizza_catalogo()

    # Cerca un libro per titolo
    print("\nCerca per titolo 'Dune':")
    risultati = biblioteca.cerca_libro(titolo="Dune")
    for libro in risultati:
        print(libro)

    # Ordina il catalogo per titolo
    biblioteca.ordina_catalogo_per_titolo()
    print("\nCatalogo dopo ordinamento per titolo:")
    biblioteca.visualizza_catalogo()

    # Ordina il catalogo per anno di pubblicazione
    biblioteca.ordina_catalogo_per_anno()
    print("\nCatalogo dopo ordinamento per anno:")
    biblioteca.visualizza_catalogo()

    # Presta un libro
    biblioteca.presta_libro(libro1, "Mario Rossi")

    # Visualizza il catalogo dopo il prestito
    print("\nCatalogo dopo il prestito:")
    biblioteca.visualizza_catalogo()

    # Restituisci un libro
    biblioteca.restituisci_libro(libro1)

    # Visualizza il catalogo dopo la restituzione
    print("\nCatalogo dopo la restituzione:")

    biblioteca.visualizza_catalogo()
