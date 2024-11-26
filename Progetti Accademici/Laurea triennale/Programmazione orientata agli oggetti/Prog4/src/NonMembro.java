import java.util.GregorianCalendar;
import java.util.Objects;

public class NonMembro extends Registrazione
{
    private String nomeAzienda;

    public NonMembro(String nome, String cognome, GregorianCalendar dataRegistrazione, String nomeAzienda) {
        super(nome, cognome, dataRegistrazione);
        this.nomeAzienda = nomeAzienda;
    }

    public boolean isInRitardo()
    {
        boolean b = false;
        GregorianCalendar g = new GregorianCalendar(2021, 11, 20);

        if(getDataRegistrazione().after(g))
        {
            b = true;
        }

        return b;
    }

    public double calcoloCosto()
    {
        double costo;

        GregorianCalendar g = new GregorianCalendar(2021, 11, 21);

        if(getDataRegistrazione().before(g))
        {
            costo = 600;
        }
        else
        {
            costo = 650;
        }

        return costo;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonMembro nonMembro = (NonMembro) o;
        return Objects.equals(nomeAzienda, nonMembro.nomeAzienda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAzienda);
    }

    @Override
    public String toString()
    {
        return super.toString() + "NonMembro{" +
                "nomeAzienda='" + nomeAzienda + '\'' +
                '}';
    }
}
