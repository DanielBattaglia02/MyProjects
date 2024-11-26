import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Registrazione implements Comparable<Registrazione>
{
    private String nome;
    private String cognome;
    private GregorianCalendar dataRegistrazione;

    public Registrazione(String nome, String cognome, GregorianCalendar dataRegistrazione)
    {
        this.nome = nome;
        this.cognome = cognome;

        try
        {
            controlloData(dataRegistrazione);
            this.dataRegistrazione = dataRegistrazione;
        }
        catch (BadDateException e)
        {
            e.printStackTrace();
        }
    }

    public void controlloData(GregorianCalendar g) throws BadDateException
    {
        GregorianCalendar g2 = new GregorianCalendar(2022, 2, 1);

        if(g.after(g2))
        {
            throw new BadDateException();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public GregorianCalendar getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(GregorianCalendar dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    @Override
    public String toString() {
        return "Registrazione{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataRegistrazione=" + dataRegistrazione.getTime() +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registrazione that = (Registrazione) o;
        return nome.equals(that.nome) && cognome.equals(that.cognome)/* &&
                dataRegistrazione.get(Calendar.YEAR) == that.dataRegistrazione.get(Calendar.YEAR) &&
                dataRegistrazione.get(Calendar.MONTH) == that.dataRegistrazione.get(Calendar.MONTH) &&
                dataRegistrazione.get(Calendar.DAY_OF_MONTH) == that.dataRegistrazione.get(Calendar.DAY_OF_MONTH)*/;
    }

    @Override
    public int compareTo(Registrazione o)
    {
        return this.cognome.compareTo(o.cognome);
    }

    public abstract boolean isInRitardo();

    public abstract double calcoloCosto();
}
