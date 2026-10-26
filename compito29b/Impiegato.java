public class Impiegato {
    int codice;
    String nome;
    public Impiegato(int codice,String nome){
        this.codice=codice;
        this.nome=nome;
    }
    
    public String toString(){
        return String.format("%d %s ", codice,nome);
    }
}