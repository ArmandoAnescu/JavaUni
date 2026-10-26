public class Servizio {
    Impiegato i;
    double ore_serv;

    public Servizio(double ore_serv,Impiegato i) {
        this.ore_serv=ore_serv;
        this.i=i;
    }

    public double getOre(){
        return ore_serv;
    }

    public Impiegato getImpiegato(){
        return i;

    }
}
