public class Guida extends Impiegato{
    long telefono;
    boolean inglese;
    int app_sett;
    double costo_ora;

    public Guida(int codice,String nome,long telefono,boolean inglese,int app_sett,
    double costo_ora){
        super(codice, nome);
        this.telefono =telefono;
        this.inglese =inglese;
        this.app_sett =app_sett;
        this.costo_ora =costo_ora;
    }

    public String toString(){
        return super.toString()+String.format("%d %b %d %f ",telefono,inglese,app_sett,costo_ora);
    }
}
