import java.util.GregorianCalendar;

public class Auto extends Automezzo
{
    public Auto(String marca, String modello, int cavalli, String targa, String stato, GregorianCalendar dataPrestito)
    {
        super(marca, modello, cavalli, targa, stato, dataPrestito);
    }

    @Override
    public double reso()
    {
        long giorni = conteggioGiorni();
        double costo = (3.0*cavalli)*giorni;
        setStato("disponibile");

        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Auto{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cavalli=" + cavalli +
                ", targa='" + targa + '\'' +
                "} ";
    }
}
