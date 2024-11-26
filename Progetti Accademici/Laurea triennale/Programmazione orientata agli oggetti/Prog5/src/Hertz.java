import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Hertz
{
    private List<Automezzo> automezzi;

    public Hertz(List<Automezzo> automezzi)
    {
        automezzi = new ArrayList<>();
    }

    public Automezzo dammiAutomezzoPerTarga(String targa) //che ricerca un automezzo in base alla targa
    {
        Automezzo a = null;

        for(Automezzo a2: automezzi)
        {
            if(a2.getTarga().equalsIgnoreCase(targa))
            {
                a = a2;

                break;
            }
        }

        return a;
    }

    public List<Automezzo> dammiAutomezziPerModello(String modello) //che ricerca gli automezzi di un certo modello
    {
        List<Automezzo> at = new ArrayList<>();

        for(Automezzo at2: automezzi)
        {
            if(at2.getModello().equals(modello))
            {
                at.add(at2);
            }
        }

        return at;
    }

    public List<Automezzo> dammiAutomezziInPrestito() //che restituisce tutti gli automezzi in prestito
    {
        List<Automezzo> at = new ArrayList<>();

        for(Automezzo at2: automezzi)
        {
            if(at2.getStato().equalsIgnoreCase("prestato"))
            {
                at.add(at2);
            }
        }

        return at;
    }

    /*che effettua il prestito di un auto in base alla targa. Nel caso in cui la targa non è presente
    tra gli automezzi della compagnia viene lanciata
    l’eccezione non controllata TargaException*/

    public void effettuaPrestito(String targa)
    {
        Automezzo a = dammiAutomezzoPerTarga(targa);

        if(a!=null)
        {
            a.prestito(new GregorianCalendar(2024, 0, 26));
        }
        else
        {
            throw new TargaException();
        }
    }

    /*che effettua il prestito di un auto in base alla targa.
    Nel caso in cui la targa non è presente tra gli automezzi della compagnia viene lanciata
    l’eccezione non controllata TargaException. Nel caso in cui l’automezzo non è nello
    stato prestato viene lanciata l’eccezione controllata PrestitoException.*/
    public double effettuaReso(String targa) throws PrestitoException
    {
        double costo = 0;

        try
        {
            Automezzo a = dammiAutomezzoPerTarga(targa);

            if(a!=null)
            {
                controlloStato(a);
                costo = a.reso();
            }
            else
            {
                throw new PrestitoException();
            }
        }
        catch (PrestitoException e)
        {
            e.printStackTrace();
        }

        Automezzo a = dammiAutomezzoPerTarga(targa);

        return costo;
    }

    public void controlloStato(Automezzo a) throws PrestitoException
    {
        if(a.getStato().equalsIgnoreCase("disponibile"))
        {
            throw new PrestitoException();
        }
    }
}
