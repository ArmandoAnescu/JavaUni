import java.util.LinkedList;
import java.util.List;

public class Cliente {
    String nome,cognome;
    List <Noleggio> noleggi;

    public Cliente(String nome,String cognome){
        this.nome=nome;
        this.cognome=cognome;
        this.noleggi=new LinkedList<Noleggio>();
    }

    public void addNoleggio(Noleggio n){
        noleggi.add(n);
    }
    
    public double getTotale(){
        double tot=0;
        for (Noleggio noleggio : noleggi) {
            tot+=noleggio.getTotale();
        }
        return tot;
    }

    public String toString(){
        return String.format("%10s %10s %.2f %d %s",nome,cognome,this.getTotale(),noleggi.size(),noleggi.toString());
    }
}
