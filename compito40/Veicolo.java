public class Veicolo {
    int codice;
    String tipo;
    String targa;
    String modello;
    String marca;
    protected double costo;

    public Veicolo(int codice, String tipo, String targa, String modello, String marca,double costo) {
        this.codice = codice;
        this.tipo = tipo;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.costo=costo;
    }

    public String getTarga()
	{
		return targa;
	}
	
    public int getCod()
	{
		return codice;
	}

    public double getCosto(){
        return costo;
    }
    
    public String toString(){
        return String.format("%10s %10s %d %10s %10s %6.2f",tipo, targa,codice,modello,marca,costo);
    }

}
