public class Veicolo {
    int codice;
    String sport;
    String marca;
    float lunghezza;
    float larghezza;
    int posti_letto;
    float costo_giorn;

    public Veicolo(int codice, String sport, String marca, float lunghezza, float larghezza, int posti_letto,
            float costo_giorn) {
        this.codice = codice;
        this.sport = sport;
        this.marca = marca;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.posti_letto = posti_letto;
        this.costo_giorn = costo_giorn;
    }

    public float getCosto() {
        return costo_giorn;
    }

    public int getCodice() {
        return codice;
    }

    public String toString() {
        return String.format("%10s %d %15s %15s %15s %d", sport, codice, marca, larghezza, lunghezza, posti_letto);
    }
}