import java.util.LinkedList;
import java.util.List;

public class Cliente {
    int codice;
    String nome;
    String cognome;
    String indirizzo;
    List<Noleggio> noleggi;

    public Cliente(int codice,String nome,String cognome,String indirizzo){
        this.codice =codice;
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        noleggi=new LinkedList<>();
    }

    public void addNoleggio(Noleggio n)
    {
        noleggi.add(n);
    }

    public List<Noleggio> getNoleggi(){
        return noleggi;
    }

    public String toString(){
        return String.format("%d %10s %10s %15s %s",codice,cognome,nome,indirizzo,noleggi.toString());
    }

}
