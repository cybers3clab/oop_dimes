import sys
import os

def cesare_transform(text, shift):
    """Applica la trasformazione di Cesare al testo."""
    result = []
    for char in text:
        if char.isalpha():  # Solo lettere
            base = ord('A') if char.isupper() else ord('a')
            result.append(chr((ord(char) - base + shift) % 26 + base))
        else:
            # Mantiene invariati i caratteri non alfabetici
            result.append(char)
    return ''.join(result)

def main():
    if len(sys.argv) != 4:
        print("Uso: python codifica_cesare.py <-e|-d> <file_input> <file_output>")
        sys.exit(1)

    mode = sys.argv[1]
    input_file = sys.argv[2]
    output_file = sys.argv[3]
    shift = 3  # Spostamento fisso

    if mode not in ('-e', '-d'):
        print("Errore: usa -e per cifrare o -d per decifrare.")
        sys.exit(1)

    if not os.path.exists(input_file):
        print(f"Errore: il file {input_file} non esiste.")
        sys.exit(1)

    # Decidi se invertire lo spostamento per la decodifica
    if mode == '-d':
        shift = -shift

    try:
        # Leggi il contenuto del file di input
        with open(input_file, 'r', encoding='utf-8') as f:
            content = f.read()

        # Applica la trasformazione di Cesare
        transformed_content = cesare_transform(content, shift)

        # Scrivi il risultato nel file di output
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write(transformed_content)

        print(f"{'Cifratura' if mode == '-e' else 'Decifratura'} completata. File salvato in: {output_file}")
    except Exception as e:
        print(f"Errore: {e}")
        sys.exit(1)

if __name__ == "__main__":
    main()
