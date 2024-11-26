package esame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Ordinazione
{
    private List<PietanzaRichiesta> pietanze;
    private final int tavolo;

    public Ordinazione(int tavolo)
    {
        this.pietanze = new ArrayList<>();
        this.tavolo = tavolo;
    }

    public void aggiungiPietanza(PietanzaRichiesta pietanzaRichiesta)
    {
        int index = cerca(pietanzaRichiesta);

        if(index!=-1)         //se è diverso da -1 significa che la pietanza è già stata richiesta
        {
            if(pietanze.get(index).getQuantita()<0)
            {
                throw new QuantitaException();
            }
            else if(!pietanze.get(index).isServita()) //se non è stata ancora servita, si modifica l'ordinazione
            {
                pietanze.get(index).setQuantita(pietanze.get(index).getQuantita() + pietanzaRichiesta.getQuantita());
            }
        }
        else
        {
            pietanze.sort(new Comparator<PietanzaRichiesta>() {
                @Override
                public int compare(PietanzaRichiesta o1, PietanzaRichiesta o2) {
                    return o1.compareTo(o2);
                }
            });

            pietanze.add(pietanzaRichiesta);
        }

    }

    public int cerca(PietanzaRichiesta p)
    {
        int index = -1;

        for(int i=0; i<pietanze.size(); i++)
        {
            if(pietanze.get(i).equals(p))
            {
                index = i;
                break;
            }
        }

        return index;
    }

    public List<PietanzaRichiesta> getPietanze()
    {
        return pietanze;
    }

    public List<PietanzaRichiesta> prossimePietanze()
    {
        List<PietanzaRichiesta> result = new ArrayList<>();

        for(PietanzaRichiesta p: pietanze)
        {
            if(p.isServita())
            {
                result.add(p);
            }
        }
        return pietanze;
    }

    public double dammiConto()
    {
        double result = 0;

        try
        {
            controlloPietanze();

            for(PietanzaRichiesta p: pietanze)
            {
                 result += (p.getPietanza().dammiCosto())*p.getQuantita();
            }
        }
        catch (InvalidCostException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public void controlloPietanze() throws InvalidCostException
    {
        for(PietanzaRichiesta p: pietanze)
        {
            if(!p.isServita())
            {
                throw new InvalidCostException();
            }
        }
    }

    public void setPietanzaServito(int i)
    {
        if(!pietanze.get(i).isServita())
        {
            pietanze.get(i).setServita(true);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordinazione that = (Ordinazione) o;
        return tavolo == that.tavolo && Objects.equals(pietanze, that.pietanze);
    }

    @Override
    public String toString() {
        return "Ordinazione{" +
                "pietanze=" + pietanze +
                ", tavolo=" + tavolo +
                '}';
    }
}
