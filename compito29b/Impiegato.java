public class Impiegato {
    int codice;
    String nome;
    double costo_ora;
    
    public Impiegato(int codice,String nome,double costo_ora){
        this.codice=codice;
        this.nome=nome;
        this.costo_ora =costo_ora;
    }
    
    public int getCodice(){
        return codice;
    }

    public double getCosto(){
        return costo_ora; 
    }

    public String toString(){
        return String.format("%d %s ", codice,nome);
    }
}