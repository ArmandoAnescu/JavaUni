public class Caravan extends Veicolo {
    int potenza;

    public Caravan(int codice, String sport, String marca, float lunghezza,float larghezza, int posti_letto,float costo_giorn, int potenza) {
        super(codice, sport, marca, lunghezza, larghezza, posti_letto, costo_giorn);
        this.potenza=potenza;
    }

    public String toString(){
        return super.toString()+String.format(" %10s %10s %10s %d %.2f","-","-"," ",potenza,this.getCosto());
    }
}
