public class Noleggio {

    Veicolo v;
    int giorni;

    public Noleggio(Veicolo v, int giorni) {
        this.v = v;
        this.giorni = giorni;
    }

    public int getGiorni() {
        return giorni;
    }

    public Veicolo getVeicolo() {
        return v;
    }

    public double getTotale() {
        double tot = 0;
        tot += giorni * v.costo;
        return tot;
    }

    public String toString() {
        return String.format("[(%s,%d)]", v.getTarga(), giorni);
    }
}