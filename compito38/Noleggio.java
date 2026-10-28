public class Noleggio {
    Veicolo v;
    int n_giorni;

    public Noleggio(Veicolo v, int n_giorni){
        this.v =v;
        this.n_giorni=n_giorni;
    }

    public float getTotale(){
        return v.getCosto()*n_giorni;
    }

    public Veicolo getVeicolo(){
        return  v;
    }

    public String toString(){
        return String.format("(%d,%d)",this.v.getCodice(),n_giorni );
    }
}
