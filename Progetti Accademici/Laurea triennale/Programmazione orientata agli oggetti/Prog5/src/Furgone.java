import java.util.GregorianCalendar;

public class Furgone extends Automezzo
{
    private static final double costoFiat = 30;
    private static final double costoCitroen = 35;
    private static final double costoFord = 40;

    public Furgone(String marca, String modello, int cavalli, String targa, String stato, GregorianCalendar dataPrestito) {
        super(marca, modello, cavalli, targa, stato, dataPrestito);
    }

    @Override
    public double reso()
    {
        long giorni = conteggioGiorni();
        double costo;

        switch (getMarca())
        {
            case "ford":

                costo = costoFord*giorni;
                break;

            case "fiat":

                costo = costoFiat*giorni;
                break;

            default:

                costo = costoCitroen*giorni;
                break;
        }

        setStato("disponibile");

        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Furgone{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cavalli=" + cavalli +
                ", targa='" + targa + '\'' +
                "} ";
    }
}
