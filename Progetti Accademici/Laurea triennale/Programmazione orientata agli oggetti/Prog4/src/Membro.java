import java.util.GregorianCalendar;

public class Membro extends Registrazione
{
    private String nomeAzienda;
    private int numeroTessera;

    public Membro(String nome, String cognome, GregorianCalendar dataRegistrazione, String nomeAzienda, int numeroTessera) {
        super(nome, cognome, dataRegistrazione);
        this.nomeAzienda = nomeAzienda;
        this.numeroTessera = numeroTessera;
    }

    public boolean isInRitardo()
    {
        boolean b = false;
        GregorianCalendar g = new GregorianCalendar(2021, 11, 18);

        if(getDataRegistrazione().after(g))
        {
            b = true;
        }

        return b;
    }

    public double calcoloCosto()
    {
        double costo;

        GregorianCalendar g = new GregorianCalendar(2021, 11, 19);

        if(getDataRegistrazione().before(g))
        {
            costo = 500;
        }
        else
        {
            costo = 550;
        }

        return costo;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public boolean equals(Object o)
    {
        if(!super.equals(o))
        {
            return false;
        }

        Membro that = (Membro) o;
        return nomeAzienda.equals(that.nomeAzienda) && numeroTessera == that.numeroTessera;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Membro{" +
                "nomeAzienda='" + nomeAzienda + '\'' +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}
