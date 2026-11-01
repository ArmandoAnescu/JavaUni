public class Furgone extends Veicolo{
    String categoria;
    int nposti;
    boolean vano_carico;
     public Furgone(int codice, String tipo, String targa, String modello, String marca,double costo,String categoria,int nposti, boolean vano_carico) {
        super(codice, tipo, targa, modello, marca, costo);
        this.categoria=categoria;
        this.nposti=nposti;
        this.vano_carico=vano_carico;
    }

    public String toString(){
        return super.toString()+String.format(" %s %s %10s %d %b","-","-",categoria,nposti,vano_carico);
    }
}
