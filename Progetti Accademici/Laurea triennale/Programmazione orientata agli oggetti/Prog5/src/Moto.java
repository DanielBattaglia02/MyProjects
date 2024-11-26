import java.util.Calendar;
import java.util.GregorianCalendar;

public class Moto extends Automezzo
{
    private static final double settimanale = 20;
    private static final double weekend = 30;

    public Moto(String marca, String modello, int cavalli, String targa, String stato, GregorianCalendar dataPrestito) {
        super(marca, modello, cavalli, targa, stato, dataPrestito);
    }

    @Override
    public double reso()
    {
        long giorni = conteggioGiorni();

        double costo;

        if(getDataPrestito().get(Calendar.DAY_OF_MONTH) == Calendar.SUNDAY)
        {
            costo = settimanale*giorni;
        }
        else
        {
            costo = weekend*giorni;
        }

        setStato("disponibile");

        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Moto{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cavalli=" + cavalli +
                ", targa='" + targa + '\'' +
                "} ";
    }
}
