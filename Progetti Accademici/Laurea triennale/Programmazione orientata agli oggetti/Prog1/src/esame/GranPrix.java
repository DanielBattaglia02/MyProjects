package esame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GranPrix
{
    public GranPrix(int numGiri, double kmUnGiro, int numCurve, int numRettilinei)
    {
        this.numGiri = numGiri;
        this.kmUnGiro = kmUnGiro;
        this.numCurve = numCurve;
        this.numRettilinei = numRettilinei;
        auto = new ArrayList<>();
    }

    public int getNumGiri() {
        return numGiri;
    }

    public int getNumRettilinei() {
        return numRettilinei;
    }

    public int getNumCurve() {
        return numCurve;
    }

    public double getKmUnGiro() {
        return kmUnGiro;
    }

    public List<Autovettura> getAuto() {
        return auto;
    }

    public void controlloInserimento(Autovettura a2)
    {
        for(Autovettura a1: auto)
        {
            if(a1.equals(a2))
            {
                throw new InsertionException();
            }
        }
    }

    public void aggiungi(Autovettura a)
    {
        controlloInserimento(a);
        this.auto.add(a);

        auto.sort(new Comparator<Autovettura>()
        {
            @Override
            public int compare(Autovettura o1, Autovettura o2)
            {
                return Integer.compare(o2.getNumCavalli(), o1.getNumCavalli());
            }
        });
    }

    public void avviaMotori()
    {
        for(Autovettura a:auto)
        {
            a.start();
        }
    }

    public void pitStop(int i)
    {
        Autovettura a = this.auto.get(i);
        a.setTempoImpiegato(2); //aumenta di 2 minuti il tempo impiegato attuale
    }

    public void effettuaGiro()
    {
        if(!auto.isEmpty())
        {
            for(Autovettura a: auto)
            {
                if(a instanceof Benzina)
                {
                    Benzina a2 = (Benzina) a;
                    double t = a2.getTempoGiro(this.kmUnGiro, this.numCurve, this.numRettilinei);
                    a2.setTempoImpiegato(t);
                }
                else if(a instanceof Ibride)
                {
                    Ibride a2 = (Ibride) a;
                    double t = a2.getTempoGiro(this.kmUnGiro, this.numCurve, this.numRettilinei);
                    a2.setTempoImpiegato(t);
                }
                else if (a instanceof Elettriche)
                {
                    Elettriche a2 = (Elettriche) a;
                    double t = a2.getTempoGiro(this.kmUnGiro, this.numCurve, this.numRettilinei);
                    a2.setTempoImpiegato(t);
                }
            }
        }
    }

    @Override
    public String toString()
    {
        auto.sort(new Comparator<Autovettura>()
        {
            @Override
            public int compare(Autovettura o1, Autovettura o2)
            {
                return Double.compare(o1.getTempoImpiegato(), o2.getTempoImpiegato());
            }
        });

        return "\n1 - " + auto.get(0) + "\n2 - " + auto.get(1) + "\n3 - " + auto.get(2) +
                "\n3 - " + auto.get(3) + "\n5 - " + auto.get(4) + "\n6 - " + auto.get(5);
    }

    private int numGiri;
    private double kmUnGiro;
    private int numCurve;
    private int numRettilinei;
    private List<Autovettura> auto;

    public static void main (String[] args)
    {
        GranPrix grandPrix = new GranPrix(30, 7, 8, 5);

        Benzina a1 = new Benzina("AUDI A1", 90);
        grandPrix.aggiungi(a1);

        Benzina a2 = new Benzina("AUDI A2", 120);
        grandPrix.aggiungi(a2);

        Ibride a3 = new Ibride("FERRARI", 400);
        grandPrix.aggiungi(a3);

        Ibride a4 = new Ibride("LAMBORGHINI", 300);
        grandPrix.aggiungi(a4);

        Elettriche a5 = new Elettriche("TESLA", 200);
        grandPrix.aggiungi(a5);

        Elettriche a6 = new Elettriche("TESLA 2", 300);
        grandPrix.aggiungi(a6);

        for(int i=0; i<grandPrix.numGiri; i++)
        {
            grandPrix.avviaMotori();
            grandPrix.effettuaGiro();
            System.out.print("\n" + grandPrix.auto.get(0));
            System.out.print("\n" + grandPrix.auto.get(1));

            for(int j=0; j<grandPrix.auto.size(); j++)
            {
                grandPrix.pitStop(j);
            }
        }

            /*sottraiamo 2 per rimuovere il pitsotp finale che non c'è*/
        for(int j=0; j<grandPrix.auto.size(); j++)
        {
            grandPrix.auto.get(j).setTempoImpiegato(-2);
        }

        System.out.println(grandPrix);
    }
}
