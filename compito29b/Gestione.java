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
        List<Impiegato> imp = new ArrayList<Impiegato>();
        List<Visitatore> c = new ArrayList<Visitatore>();
        Map<Integer, Impiegato> codDip = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("impiegati.txt"));
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String nome = br.readLine();
                line = br.readLine();
                tok = new StringTokenizer(line);
                if (tipo.equals("sommelier")) {
                    int ore_sett = Integer.parseInt(tok.nextToken());
                    double costo_ora = Double.parseDouble(tok.nextToken());
                    String specialita = br.readLine();
                    Sommelier s = new Sommelier(codice, nome, ore_sett, specialita, costo_ora);
                    imp.add(s);
                    codDip.put(codice, s);
                } else {
                    long telefono = Long.parseLong(tok.nextToken());
                    boolean inglese = Boolean.parseBoolean(tok.nextToken());
                    int app_sett = Integer.parseInt(tok.nextToken());
                    double costo_ora = Double.parseDouble(tok.nextToken());
                    Guida g = new Guida(codice, nome, telefono, inglese, app_sett, costo_ora);
                    imp.add(g);
                    codDip.put(codice, g);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        for (Impiegato impiegato : imp) {
            System.out.println(impiegato.toString());
        }
        System.out.println("---------------------");
        try {
            BufferedReader br = new BufferedReader(new FileReader("visitatori.txt"));
            String line = br.readLine();
            while (line != null) {
                int codice = Integer.parseInt(line);
                String nome = br.readLine();
                Visitatore v = new Visitatore(codice, nome);
                line = br.readLine();

                while (line != null && !line.equals("")) {
                    StringTokenizer tok = new StringTokenizer(line);

                    int cod_dip = Integer.parseInt(tok.nextToken());
                    double ore = Double.parseDouble(tok.nextToken());

                    Impiegato i = codDip.get(cod_dip);
                    Servizio s = new Servizio(ore, i);
                    v.addServizio(s);
                    line = br.readLine();
                }
                c.add(v);
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        for (Visitatore visitatore : c) {
            System.out.println(visitatore.toString());
        }
    }
}
