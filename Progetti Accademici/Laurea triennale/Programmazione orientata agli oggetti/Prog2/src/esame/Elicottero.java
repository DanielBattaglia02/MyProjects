package esame;

import java.util.GregorianCalendar;

public class Elicottero extends Aereomobile
{

    public Elicottero()
    {
        super();
        destinazione = null;
        cf = null;
    }

    public Elicottero(GregorianCalendar data1, GregorianCalendar data2, int numP, String destinazione, String cf)
    {
        super(data1, data2, numP);
        this.destinazione = destinazione;
        this.cf = cf;
    }

    @Override
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            Elicottero that = (Elicottero) o;
            return destinazione.equals(that.destinazione) && cf.equals(that.cf);
        }
        else
        {
            return false;
        }
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getCf() {
        return cf;
    }

    @Override
    public String toString()
    {
        return  super.toString() +
                "destinazione='" + destinazione +
                ", cf='" + cf;
    }

    private String destinazione;
    private String cf;
}
