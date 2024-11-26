package esame;

public class PietanzaRichiesta implements Comparable<PietanzaRichiesta>
{
    private Pietanza pietanza;
    private int quantita;
    private boolean servita;    //false che non è ancora servita, true che è stata servita

    public PietanzaRichiesta(Pietanza pietanza, int quantita)
    {
        this.pietanza = pietanza;
        this.quantita = quantita;
        servita = false;
    }

    @Override
    public int compareTo(PietanzaRichiesta o)
    {
        return this.pietanza.dammiNome().compareTo(o.pietanza.dammiNome());
    }

    public boolean isServita()
    {
        return servita;
    }

    public void setServita(boolean servita)
    {
        this.servita = servita;
    }

    public Pietanza getPietanza()
    {
        return pietanza;
    }

    public void setQuantita(int quantita)
    {
        this.quantita = quantita;
    }

    public int getQuantita()
    {
        return quantita;
    }

    @Override
    public String toString() {
        return "PietanzaRichiesta{" +
                "pietanza=" + pietanza +
                ", quantita=" + quantita +
                ", servita=" + servita +
                '}';
    }
}
