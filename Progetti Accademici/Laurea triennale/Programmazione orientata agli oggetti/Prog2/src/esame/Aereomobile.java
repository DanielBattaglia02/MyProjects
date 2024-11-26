package esame;

import java.io.File;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Aereomobile
{
    public Aereomobile()
    {
        dataUltimaRevisione = new GregorianCalendar();
        dataPrenotazione = null;
        numPrenotazioni = 0;
    }
    public Aereomobile(GregorianCalendar data1, GregorianCalendar data2, int numP)
    {
        dataUltimaRevisione = data1;
        dataPrenotazione = data2;
        numPrenotazioni = numP;
    }

    public GregorianCalendar getDataUltimaRevisione() {
        return dataUltimaRevisione;
    }

    public GregorianCalendar getDataPrenotazione()
    {
        return dataPrenotazione;
    }

    public int getNumPrenotazioni() {
        return numPrenotazioni;
    }

    public void setDataUltimaRevisione(GregorianCalendar dataUltimaRevisione) {
        this.dataUltimaRevisione = dataUltimaRevisione;
    }

    public void setDataPrenotazione(GregorianCalendar dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public void setNumPrenotazioni(int numPrenotazioni)
    {
        this.numPrenotazioni = numPrenotazioni;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aereomobile that = (Aereomobile) o;
        return numPrenotazioni == that.numPrenotazioni &&
                dataUltimaRevisione.get(Calendar.YEAR) == that.dataUltimaRevisione.get(Calendar.YEAR) &&
                dataUltimaRevisione.get(Calendar.MONTH) == that.dataUltimaRevisione.get(Calendar.MONTH) &&
                dataUltimaRevisione.get(Calendar.DAY_OF_MONTH) == that.dataUltimaRevisione.get(Calendar.DAY_OF_MONTH) &&
                dataPrenotazione.get(Calendar.YEAR) == that.dataPrenotazione.get(Calendar.YEAR) &&
                dataPrenotazione.get(Calendar.MONTH) == that.dataPrenotazione.get(Calendar.MONTH) &&
                dataPrenotazione.get(Calendar.DAY_OF_MONTH) == that.dataPrenotazione.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString()
    {
        return  "dataUltimaRevisione=" + dataUltimaRevisione.getTime() +
                ", dataPrenotazione=" + dataPrenotazione.getTime() +
                ", numPrenotazioni=" + numPrenotazioni;
    }

    public boolean isExpired(GregorianCalendar data)
    {
        boolean b = false;

        long milliseconds1 = dataUltimaRevisione.getTimeInMillis();
        long milliseconds2 = data.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long anni = (long)(diff / (365.25 * 24 * 60 * 60 * 1000));

        if(anni>3)
        {
            b = true;
        }

        return b;
    }

    private GregorianCalendar dataUltimaRevisione;
    private GregorianCalendar dataPrenotazione;
    private int numPrenotazioni;
}
