import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Gestione {
    public static void main(String[] args) {
        List<Veicolo> veicoli = new ArrayList<>();
        Map<Integer, Veicolo> getV = new HashMap<>();
        List<Cliente> clienti = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String sport = tok.nextToken();
                String marca = br.readLine();
                if (sport.equals("roulotte")) {
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    int peso = Integer.parseInt(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float larghezza = Float.parseFloat(tok.nextToken());
                    int posti_letto = Integer.parseInt(tok.nextToken());
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    String ver = tok.nextToken();
                    boolean veranda = false;
                    if (ver.equals("si")) {
                        veranda = true;
                    }
                    float costo_giorn = Float.parseFloat(tok.nextToken());
                    Roulotte r = new Roulotte(codice, sport, marca, lunghezza, larghezza, posti_letto, costo_giorn,
                            peso, veranda);
                    veicoli.add(r);
                    getV.put(codice, r);
                    br.readLine();
                } else {
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    float larghezza = Float.parseFloat(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    int potenza = Integer.parseInt(tok.nextToken());
                    int posti_letto = Integer.parseInt(tok.nextToken());
                    Caravan c = new Caravan(codice, sport, marca, lunghezza, larghezza, posti_letto, posti_letto,
                            potenza);
                    veicoli.add(c);
                    getV.put(codice, c);
                    br.readLine();
                }
                line = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        for (Veicolo v : veicoli) {
            System.out.println(v.toString());
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
            String line = br.readLine();
            while (line != null) {
                int codice = Integer.parseInt(line);
                String nome = br.readLine();
                String cognome = br.readLine();
                String indirizzo = br.readLine();
                Cliente c = new Cliente(codice, nome, cognome, indirizzo);
                line = br.readLine();
                while (line != null && !line.equals("")) {
                    StringTokenizer tok = new StringTokenizer(line);
                    int coidcev = Integer.parseInt(tok.nextToken());
                    int n_giorni = Integer.parseInt(tok.nextToken());
                    Veicolo v = getV.get(coidcev);
                    Noleggio n = new Noleggio(v, n_giorni);
                    c.addNoleggio(n);
                    line = br.readLine();
                }
                clienti.add(c);
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------");
        for (Cliente cliente : clienti) {
            System.out.println(cliente.toString());
        }

        Map<Veicolo, Float> incassi = new HashMap<>();
        for (Cliente c : clienti) {
            for (Noleggio n : c.getNoleggi()) {
                Float tot = incassi.get(n.getVeicolo());
                if (tot != null ){
                    incassi.put(n.getVeicolo(), tot + n.getTotale());
                } else {
                    incassi.put(n.getVeicolo(), n.getTotale());
                }
            }
        }
        for(Map.Entry<Veicolo,Float> e: incassi.entrySet()) {
            System.out.println(e.getKey().getCodice()+ " => "+e.getValue());
        }
    }
}
