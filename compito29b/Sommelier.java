public class Sommelier extends Impiegato {
    int ore_sett;
    String specialit;

    public Sommelier(int codice, String nome, int ore_sett, String specialit, double costo_ora) {
        super(codice, nome,costo_ora);
        this.ore_sett = ore_sett;
        this.specialit = specialit;
    }
    
    public double getCosto(){
        return costo_ora;
    }

    public String toString() {
        return super.toString() + String.format("%d %s %f ",ore_sett, specialit, costo_ora);
    }
}
