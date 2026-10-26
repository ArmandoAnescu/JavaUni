public class Sommelier extends Impiegato {
    int ore_sett;
    double costo_ora;
    String specialit;

    public Sommelier(int codice, String nome, int ore_sett, String specialit, double costo_ora) {
        super(codice, nome);
        this.ore_sett = ore_sett;
        this.specialit = specialit;
        this.costo_ora = costo_ora;
    }

    public String toString() {
        return super.toString() + String.format("%d %s %f ",ore_sett, specialit, costo_ora);
    }
}
