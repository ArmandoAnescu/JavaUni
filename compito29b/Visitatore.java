import java.util.LinkedList;
import java.util.List;


public class Visitatore {
    int codice;
    String nome;
    List<Servizio> servizi;

    public Visitatore(int codice,String nome){
        this.codice=codice;
        this.nome =nome;
        servizi = new LinkedList<Servizio>();
    }

    public double totale(){
        double tot=0;
        for (Servizio s : servizi) {
            Impiegato i = s.getImpiegato();
            tot+=s.getOre()*i.getCosto();
        }
        return tot;
    }

    public void addServizio(Servizio s){
        servizi.add(s);
    }

    public String toString(){
        return String.format("%d %s %6.2f", codice,nome,totale());
    }
}
