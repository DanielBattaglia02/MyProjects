package esame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("C:\\Users\\2joke\\IdeaProjects\\Programmi\\Prog3\\test\\src\\esame\\menu.txt");
        Scanner scanner = new Scanner(file);
        esame.Menu menu = new Menu();

        /***********************************lettura da file************************************/

        while(scanner.hasNext())
        {
            String pieTipo = scanner.nextLine();
            String nome = scanner.nextLine();

            String linea = scanner.nextLine();
            linea.replaceAll(" ", "");
            String[] ingredienti = linea.split(",");
            List<String> ing = Arrays.asList(ingredienti);

            double calorie = Double.parseDouble(scanner.nextLine());

            if(pieTipo.equalsIgnoreCase("pietanzacalda"))
            {
                int tempoC = Integer.parseInt(scanner.nextLine());
                double peso = Double.parseDouble(scanner.nextLine());

                menu.aggiungi(new PietanzaCalda(nome, ing, calorie, peso, tempoC));
            }
            else
            {
                String tipo = scanner.nextLine();

                menu.aggiungi(new PietanzaFredda(nome, ing, calorie, tipo));
            }
        }

        /***************************creazione tre ordinazioni***************************************/

        List<String> ingredienti2 = new ArrayList<>();
        ingredienti2.add("ing1");
        ingredienti2.add("ing2");
        ingredienti2.add("ing3");

        Ristorante ristorante = new Ristorante(menu);

        /***********ordinazione tavolo 1***************/

        PietanzaRichiesta p1 = new PietanzaRichiesta(new PietanzaCalda("pane", ingredienti2, 300, 100, 20),2);
        PietanzaRichiesta p2 = new PietanzaRichiesta(new PietanzaCalda("pasta", ingredienti2, 250, 500, 20),1);

        Ordinazione ordinazione1 = new Ordinazione(1);
        ordinazione1.aggiungiPietanza(p1);
        ordinazione1.aggiungiPietanza(p2);
        ristorante.aggiungi(ordinazione1);

        /***********ordinazione tavolo 2***************/

        PietanzaRichiesta p3 = new PietanzaRichiesta(new PietanzaCalda("pane2", ingredienti2, 3060, 950, 20),2);
        PietanzaRichiesta p4 = new PietanzaRichiesta(new PietanzaCalda("pasta2", ingredienti2, 2570, 800, 29),3);

        Ordinazione ordinazione2 = new Ordinazione(2);
        ordinazione2.aggiungiPietanza(p3);
        ordinazione2.aggiungiPietanza(p4);
        ristorante.aggiungi(ordinazione2);

        /***********ordinazione tavolo 3***************/

        PietanzaRichiesta p5 = new PietanzaRichiesta(new PietanzaCalda("pane3", ingredienti2, 3003, 2000, 20),2);
        PietanzaRichiesta p6 = new PietanzaRichiesta(new PietanzaCalda("pasta3", ingredienti2, 2500, 1000, 20),10);

        Ordinazione ordinazione3 = new Ordinazione(3);
        ordinazione3.aggiungiPietanza(p5);
        ordinazione3.aggiungiPietanza(p6);
        ristorante.aggiungi(ordinazione3);

        /**************************servire le ordinazioni***********************************/

        for(Ordinazione o: ristorante.getOrdinazioni())
        {
            for(int i=0; i<o.getPietanze().size(); i++)
            {
                o.setPietanzaServito(i);
            }
        }

        /**************************calcolo conto minimo************************************/

        double min = ristorante.getOrdinazioni().get(0).dammiConto();

        System.out.println("Questi sono i costi delle ordinazioni:\n" + "1: " + min);

        for(int i=1; i<ristorante.getOrdinazioni().size(); i++)
        {
            double costo = ristorante.getOrdinazioni().get(i).dammiConto();

            if(costo<min)
            {
                min = costo;
            }

            System.out.println((int)(i+1) + ": " + costo);
        }

        System.out.println("\nQuesto è il costo minimo: " + min);

        /**************modifica ordinazione tavolo 3 con nuova ordinazione***************/

        PietanzaRichiesta p7 = new PietanzaRichiesta(new PietanzaCalda("pane4", ingredienti2, 3003, 2, 20),10);
        PietanzaRichiesta p8 = new PietanzaRichiesta(new PietanzaCalda("pasta4", ingredienti2, 2500, 1, 20),10);

        Ordinazione ordinazione4 = new Ordinazione(4);
        ordinazione4.aggiungiPietanza(p7);
        ordinazione4.aggiungiPietanza(p8);
        ristorante.modifica(ordinazione3, ordinazione4);

        for(Ordinazione o: ristorante.getOrdinazioni())
        {
            System.out.println(o);
        }
    }
}
