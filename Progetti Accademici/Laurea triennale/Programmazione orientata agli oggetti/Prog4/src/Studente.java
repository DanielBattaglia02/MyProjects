import java.util.GregorianCalendar;
import java.util.Objects;

public class Studente extends Registrazione
{
    private String nomeUniversita;
    private String tipologia;   //triennale, magistrale, dottorato
    public Studente(String nome, String cognome, GregorianCalendar dataRegistrazione, String nomeUniversita, String tipologia)
    {
        super(nome, cognome, dataRegistrazione);
        this.nomeUniversita = nomeUniversita;
        this.tipologia = tipologia;
    }

    public boolean isInRitardo()
    {
        boolean b = false;
        GregorianCalendar g = new GregorianCalendar(2021, 11, 13);

        if(getDataRegistrazione().after(g))
        {
            b = true;
        }

        return b;
    }

    public double calcoloCosto()
    {
        double costo;

        GregorianCalendar g = new GregorianCalendar(2021, 11, 14);

        if(getDataRegistrazione().before(g))
        {
            costo = 250;
        }
        else
        {
            costo = 300;
        }

            return costo;
    }

    public String getNomeUniversita() {
        return nomeUniversita;
    }

    public void setNomeUniversita(String nomeUniversita) {
        this.nomeUniversita = nomeUniversita;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o))
        {
            return false;
        }

        Studente that = (Studente) o;
        return nomeUniversita.equals(that.getNomeUniversita()) && tipologia.equals(that.getTipologia());
    }

    @Override
    public String toString()
    {
        return super.toString() + "Studente{" +
                "nomeUniversita='" + nomeUniversita + '\'' +
                ", tipologia='" + tipologia + '\'' +
                '}';
    }
}
