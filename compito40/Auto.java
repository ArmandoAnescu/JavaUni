public class Auto extends Veicolo{
    int cilindrata;
    double capienza_bag;

    public Auto(int codice, String tipo, String targa, String modello, String marca,double costo,int cilindrata,double capienza_bag) {
        super(codice, tipo, targa, modello, marca, costo);
        this.cilindrata=cilindrata;
        this.capienza_bag=capienza_bag;
    }

    public String toString(){
        return super.toString()+String.format("%d %.2f m^3 %s %s ",cilindrata,capienza_bag,"-","-");
    }
}
