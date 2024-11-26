package esame;
public class Autovettura
{
    public Autovettura(String nome, int numCavalli)
    {
        this.nome = nome;
        this.numCavalli = numCavalli;
        this.tempoImpiegato = 0.0;
        this.stato = false;
    }

    public String getNome()
    {
        return nome;
    }

    public int getNumCavalli()
    {
        return numCavalli;
    }

    public double getTempoImpiegato()
    {
        return tempoImpiegato;
    }

    public Boolean getStato()
    {
        return stato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumCavalli(int numCavalli) {
        this.numCavalli = numCavalli;
    }

    public void setTempoImpiegato(double tempoImpiegato) {
        this.tempoImpiegato = this.tempoImpiegato + tempoImpiegato;
    }

    private void setStato(Boolean stato) {
        this.stato = stato;
    }

    public Boolean equals(Autovettura a)
    {
        Boolean b = false;

        if(this.getClass() == a.getClass())
        {
            if(this.getNome() == a.getNome() && this.getNumCavalli() == a.getNumCavalli())
            {
                b = true;
            }
        }

        return b;
    }

    protected void verificaStato(Boolean stato) throws AutoSpentaException
    {
        if(!stato)
        {
            throw new AutoSpentaException();
        }
    }

    public void start()
    {
        setStato(true);
    }

    public void stop()
    {
        setStato(false);
    }

    @Override
    public String toString() {
        return "Autovettura{" +
                "nome='" + nome + '\'' +
                ", numCavalli=" + numCavalli +
                ", tempoImpiegato=" + tempoImpiegato +
                ", tipo=" + getClass() +
                '}';
    }

    private String nome;
    private int numCavalli;
    private double tempoImpiegato; //in minuti
    private Boolean stato;  //true indica accesa e false spenta
}
