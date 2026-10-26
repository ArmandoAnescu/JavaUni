public class Guida extends Impiegato{
    long telefono;
    boolean inglese;
    int app_sett;

    public Guida(int codice,String nome,long telefono,boolean inglese,int app_sett,
    double costo_ora){
        super(codice, nome,costo_ora);
        this.telefono =telefono;
        this.inglese =inglese;
        this.app_sett =app_sett;
    }

    public double getCosto(){
        return costo_ora;
    }

    public String toString(){
        return super.toString()+String.format("%d %b %d %f ",telefono,inglese,app_sett,costo_ora);
    }
}
