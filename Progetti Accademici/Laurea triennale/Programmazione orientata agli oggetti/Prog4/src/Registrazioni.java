import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Registrazioni
{
    private List<Registrazione> registrazioni;

    public Registrazioni()
    {
        this.registrazioni = new ArrayList<>();
    }

    public void aggiungiRegistrazione(Registrazione r)
    {
        boolean b = controlloInserimento(r);

        if(!b)
        {
            registrazioni.sort(new Comparator<Registrazione>() {
                @Override
                public int compare(Registrazione o1, Registrazione o2)
                {
                    return o1.compareTo(o2);
                }
            });

            registrazioni.add(r);
        }
    }

    public boolean controlloInserimento(Registrazione r)
    {
        boolean b = false;

        if(!registrazioni.isEmpty())
        {
            for(Registrazione r2: registrazioni)
            {
                if(r2.equals(r))
                {
                    b = true;

                    throw new RegistrationException();
                }
            }
        }

        return b;
    }

    public double dammiTotale()
    {
        double totale = 0;

        for (Registrazione r: registrazioni)
        {
            totale += r.calcoloCosto();
        }

        return totale;
    }

    public double dammiTotalePerTipoPartecipante(String tipo)
    {
        double totale = 0;

        try
        {
            controlloTipo(tipo);

            for(Registrazione r: registrazioni)
            {
                if(r.getClass().getName().equals(tipo))
                {
                    totale += r.calcoloCosto();
                }
            }
        }
        catch(InvalidParameterException e)
        {
            e.printStackTrace();
        }

        return totale;
    }

    public void controlloTipo(String t) throws InvalidParameterException
    {
        if( (!t.equalsIgnoreCase("Studente")) && (!t.equalsIgnoreCase("Membro")) && (!t.equalsIgnoreCase("NonMembro")) )
        {
            throw new InvalidParameterException();
        }
    }

    /*se x=0 si indica le registrazioni non in ritardi, 1 quelli in ritardo*/
    public double dammiTotalePerTipoRegistrazione(int x)
    {
        double totale = 0;

        try
        {
            controlloStato(x);

            for(Registrazione r: registrazioni)
            {
                if(x==1)    //quelli in ritardo
                {
                    if(r.isInRitardo())
                    {
                        totale += r.calcoloCosto();
                    }
                }
                else
                {
                    if(!r.isInRitardo())
                    {
                        totale += r.calcoloCosto();
                    }
                }
            }
        }
        catch(InvalidParameterException e)
        {
            e.printStackTrace();
        }

        return totale;
    }

    public void controlloStato(int n) throws InvalidParameterException
    {
        if( n!=1 && n!=0 )
        {
            throw new InvalidParameterException();
        }
    }

    public Registrazione cerca(String cognome)
    {
        Registrazione registrazione = null;

        for(Registrazione r: registrazioni)
        {
            if(r.getCognome().equals(cognome))
            {
                registrazione = r;

                break;
            }
        }

        return registrazione;
    }

    public List<Registrazione> getRegistrazioni() {
        return registrazioni;
    }

    @Override
    public String toString() {
        return "Registrazioni{" +
                "registrazioni=" + registrazioni +
                '}';
    }
}
