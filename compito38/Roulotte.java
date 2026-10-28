public class Roulotte extends Veicolo{
    int peso;
    boolean veranda;

    public Roulotte (int codice, String sport, String marca, float lunghezza,float larghezza, int posti_letto,float costo_giorn,int peso,boolean veranda) {
        super(codice, sport, marca, lunghezza, larghezza, posti_letto, costo_giorn);
        this.peso =peso;
        this.veranda =veranda;
    }

    public String toString(){
        return super.toString()+String.format(" %d %b %10s %6.2f", peso,veranda,"-",this.getCosto());
    }
}
