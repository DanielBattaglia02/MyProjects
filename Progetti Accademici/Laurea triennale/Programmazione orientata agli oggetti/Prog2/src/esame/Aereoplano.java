package esame;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Aereoplano extends Aereomobile
{

    public Aereoplano(String modello)
    {
        super();
        this.modello = modello;
        volo = null;
        rotta = new ArrayList<>();
        durataVolo = 0;
    }

    public Aereoplano(GregorianCalendar data1, GregorianCalendar data2, int numP, String modello, String volo, List<String> rotta, int durataVolo)
    {
        super(data1, data2, numP);
        this.modello = modello;
        this.volo = volo;
        this.rotta = rotta;
        this.durataVolo = durataVolo;
    }

    @Override
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            Aereoplano that = (Aereoplano) o;
            return durataVolo == that.durataVolo && modello.equals(that.modello) && volo.equals(that.volo) && rotta == that.rotta;
        }
        else
        {
            return false;
        }
    }

    public String getModello() {
        return modello;
    }

    public String getVolo() {
        return volo;
    }

    public List<String> getRotta() {
        return rotta;
    }

    public int getDurataVolo() {
        return durataVolo;
    }

    @Override
    public String toString()
    {
        return  super.toString() +
                "modello='" + modello + '\'' +
                ", volo='" + volo + '\'' +
                ", rotta=" + rotta +
                ", durataVolo=" + durataVolo;
    }

    private String modello;
    private String volo;
    private List<String> rotta;
    private int durataVolo;
}
