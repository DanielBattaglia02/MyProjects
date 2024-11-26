package esame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*non usare scanner.nextInt() per leggere gli interi*/
/*chiudere il printwriter per confermare la scrittura nel file*/
/*per lanciare correttamente le eccezioni, occorre scrivere adeguatamente il metodo equals*/

public class Main
{
    private List<Aereomobile> aereomobili;

    public Main()
    {
        this.aereomobili = new ArrayList<>();
    }

    public List<Aereomobile> getAereomobili() {
        return aereomobili;
    }

    public void controlloInserimentoAereomobile(Aereomobile a) throws AereomobileUgualeException
    {
        if(!aereomobili.isEmpty())
        {
            for(Aereomobile am:aereomobili)
            {
                if(am.equals(a))
                {
                    throw new AereomobileUgualeException();
                }
            }
        }
    }

    public void aggiungiAereomobile(Aereomobile a) throws AereomobileUgualeException
    {
        controlloInserimentoAereomobile(a);
        aereomobili.add(a);
    }

    public GregorianCalendar inserimentoData(String inputDate)
    {
        // Definizione del formato della data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        GregorianCalendar calendar = new GregorianCalendar();

        try
        {
            // Parsing della data inserita dall'utente
            Date date = dateFormat.parse(inputDate);

            calendar.setTime(date);
        }
        catch (ParseException e)
        {
            System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (dd/MM/yyyy).");
            System.exit(1);
        }

        return calendar;
    }


    public void scritturaFile(String pathname) throws FileNotFoundException
    {
        File file = new File(pathname);
        PrintWriter printWriter = new PrintWriter(file);

        for(Aereomobile aereomobile: aereomobili)
        {
            GregorianCalendar g1 = aereomobile.getDataUltimaRevisione();
            GregorianCalendar g2 = aereomobile.getDataPrenotazione();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            if(aereomobile instanceof Aereoplano)
            {
                Aereoplano a = (Aereoplano) aereomobile;

                printWriter.println("Aereoplano");

                String data1 = sdf.format(g1.getTime());
                String data2 = sdf.format(g2.getTime());
                printWriter.println(data1);
                printWriter.println(data2);

                printWriter.println(a.getNumPrenotazioni());
                printWriter.println(a.getModello());
                printWriter.println(a.getVolo());
                printWriter.println(a.getRotta());
                printWriter.println(a.getDurataVolo());
            }
            else
            {
                Elicottero e = (Elicottero) aereomobile;

                printWriter.println("Elicottero");

                String data1 = sdf.format(g1.getTime());
                String data2 = sdf.format(g2.getTime());
                printWriter.println(data1);
                printWriter.println(data2);

                printWriter.println(e.getNumPrenotazioni());
                printWriter.println(e.getDestinazione());
                printWriter.println(e.getCf());
            }
        }

        printWriter.close();    //questo assicura che i dati vengano scritti nel file
    }

    public void letturaDaFile() throws FileNotFoundException
    {
        File file = new File("C:\\Users\\2joke\\IdeaProjects\\Programmi\\Prog2\\test\\src\\esame\\aereomobili.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            String tipo = scanner.nextLine();
            String dataR = scanner.nextLine();
            GregorianCalendar g1 = inserimentoData(dataR);

            String dataP = scanner.nextLine();
            GregorianCalendar g2 = inserimentoData(dataP);

            int pr = Integer.parseInt(scanner.nextLine());

            if(tipo.equals("Elicottero"))
            {
                String dest = scanner.nextLine();
                String cf = scanner.nextLine();

                try
                {
                    aggiungiAereomobile(new Elicottero(g1, g2, pr, dest, cf));
                }
                catch (AereomobileUgualeException e)
                {
                    System.out.println(e);
                }
            }
            else    /*se è aereoplano*/
            {
                String modello = scanner.nextLine();
                String volo = scanner.nextLine();

                String linea1 = scanner.nextLine();
                String linea2 = linea1.replaceAll("[ \\[\\] ]","");
                String[] listaRotte = linea2.split(",");
                List<String> rotte = Arrays.asList(listaRotte);

                int durata = Integer.parseInt(scanner.nextLine());

                try
                {
                    aggiungiAereomobile(new Aereoplano(g1, g2, pr, modello, volo, rotte, durata));
                }
                catch (AereomobileUgualeException e)
                {
                    System.out.println(e);
                }
            }
        }

        for(Aereomobile a: aereomobili)
        {
            System.out.println(a + "\n");
        }

        scanner.close();
    }

    public List<Aereomobile> ricerca(String tipo)
    {
        List<Aereomobile> list = new ArrayList<>();

        if(tipo.equals("Aereoplano"))
        {
            for(Aereomobile a:aereomobili)
            {
                if(a instanceof Aereoplano)
                {
                    list.add(a);
                }

            }
        }
        else
        {
            for(Aereomobile a:aereomobili)
            {
                if(a instanceof Elicottero)
                {
                    list.add(a);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception, AereomobileUgualeException
    {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        System.out.println("Quanti aereomobili vuoi inserire?(un intero)");
        int dim = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<dim; i++)
        {
            System.out.println("Num" + (int)(i+1) + " - Vuoi inserire un aereoplano(digita 1) o un elicottero(digita 2)?");
            int scelta = Integer.parseInt(scanner.nextLine());

            System.out.print("Inserisci data ultima revisione(dd/MM/yyyy):");
            String d1 = scanner.nextLine();
            GregorianCalendar data1 = main.inserimentoData(d1);

            System.out.print("Inserisci data prenotazione(dd/MM/yyyy):");
            String d2 = scanner.nextLine();
            GregorianCalendar data2 = main.inserimentoData(d2);

            System.out.println("Inserisci numero di passeggeri prenotati per questo volo");
            int pas = Integer.parseInt(scanner.nextLine());

            if(scelta==1)
            {
                System.out.println("Inserisci modello");
                String mod = scanner.nextLine();

                System.out.println("Inserisci volo");
                String vol = scanner.nextLine();

                System.out.println("Inserisci durata volo:");
                int durVol = Integer.parseInt(scanner.nextLine());

                int dim2;

                do
                {
                    System.out.println("\nQuante tappe ci sono:");
                    dim2 = Integer.parseInt(scanner.nextLine());
                }
                while(!(dim2>0));

                List<String> tappe = new ArrayList<>();

                for(int j=0; j<dim2; j++)
                {
                    System.out.println("Inserisci tappa " + (int)(j+1) + ":");
                    tappe.add(scanner.nextLine());
                }

                try
                {
                    main.aggiungiAereomobile(new Aereoplano(data1, data2, pas, mod, vol, tappe, durVol));
                    System.out.println(main.aereomobili.get(i));

                }
                catch (AereomobileUgualeException exception)
                {
                    exception.printStackTrace();
                }
            }
            else
            {
                System.out.println("Inserisci destinazione");
                String dest = scanner.nextLine();

                System.out.println("Inserisci codice fiscale del proprietario");
                String cf = scanner.nextLine();

                try
                {
                    main.aggiungiAereomobile(new Elicottero(data1, data2, pas, dest, cf));
                }
                catch (AereomobileUgualeException exception)
                {
                    exception.printStackTrace();
                }
            }
        }

        /*--------------------SCRITTURA NEL FILE------------------------------*/

        System.out.println("\nVuoi memorizzare questi dati in un file?(si/no)");
        String scelta = scanner.nextLine();

        if(scelta.equalsIgnoreCase("si"))
        {
            String pathname = "C:\\Users\\2joke\\IdeaProjects\\Programmi\\Prog2\\test\\src\\esame\\aereomobili.txt";
            main.scritturaFile(pathname);
        }

        for(Aereomobile a: main.aereomobili)
        {
            System.out.println(a);
        }

        scanner.close();

/*
        String inputDate = "20/02/2020";
        // Definizione del formato della data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar calendar = new GregorianCalendar();

        try
        {
            // Parsing della data inserita dall'utente
            Date date = dateFormat.parse(inputDate);

            calendar.setTime(date);
        }
        catch (ParseException e)
        {
            System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (dd/MM/yyyy).");
            System.exit(1);
        }

        Elicottero e = new Elicottero(calendar, calendar, 1, "1", "1");
        Elicottero e1 = new Elicottero(calendar, calendar, 1, "1", "1");

        try
        {
            main.aggiungiAereomobile(e);
            main.aggiungiAereomobile(e1);
        }
        catch(AereomobileUgualeException exception)
        {
        }
        */
    }
}
