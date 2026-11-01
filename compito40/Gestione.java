import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Gestione {
    public static void main(String[] args) {
        List<Veicolo> veicoli = new ArrayList<Veicolo>();
        List<Cliente> clienti = new LinkedList<Cliente>();

        Map<Integer, Veicolo> trovaAuto = new HashMap<>();
        Map<Integer, Double> codTot = new HashMap<Integer, Double>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String targa = tok.nextToken();
                String modello = br.readLine();
                String marca = br.readLine();
                if (tipo.equals("auto")) {
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    int cilindrata = Integer.parseInt(tok.nextToken());
                    double capienza_bag = Double.parseDouble(tok.nextToken());
                    double costo = Double.parseDouble(br.readLine());
                    Auto a = new Auto(codice, tipo, targa, modello, marca, costo, cilindrata, capienza_bag);
                    veicoli.add(a);
                    trovaAuto.put(codice, a);

                } else {
                    String categoria = br.readLine();
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    int nposti = Integer.parseInt(tok.nextToken());
                    boolean vano_carico = Boolean.parseBoolean(tok.nextToken());
                    double costo = Double.parseDouble(br.readLine());
                    Furgone f = new Furgone(codice, tipo, targa, modello, marca, costo, categoria, nposti, vano_carico);
                    veicoli.add(f);
                    trovaAuto.put(codice, f);

                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        for (Veicolo v : veicoli) {
            System.out.println(v.toString());
        }
        System.out.println("---------------------");
        try {
            BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                String nome = tok.nextToken();
                String cognome = tok.nextToken();
                Cliente c = new Cliente(nome, cognome);
                line = br.readLine();
                tok = new StringTokenizer(line);
                while (tok.hasMoreElements()) {
                    int cod = Integer.parseInt(tok.nextToken());
                    int giorni = Integer.parseInt(tok.nextToken());
                    Veicolo v = trovaAuto.get(cod);
                    Noleggio n = new Noleggio(v, giorni);
                    c.addNoleggio(n);
                    double current = 0;

                    if (codTot.containsKey(cod)) {
                        current = codTot.get(cod);
                    }
                    codTot.put(cod, current + n.getTotale());
                }
                clienti.add(c);
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        for (Cliente c : clienti) {
            System.out.println(c.toString());
        }

        // PUNTO 5: stampe del totale dei noleggi
        System.out.println();
        int cod = Integer.parseInt(args[0]);
        double tot = codTot.get(cod);
        System.out.println(cod + " " + tot);
    }
}
