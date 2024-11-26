import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Pagamento implements Rimborsabile, Serializable
{
    public Pagamento(double importo, GregorianCalendar istante)
    {
        if(importo<=0)
        {
            throw new PagamentoNegativoException();
        }
        this.importo = importo;
        this.istante = istante;
    }

    public double getImporto() {
        return importo;
    }

    public GregorianCalendar getIstante() {
        return istante;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public void setIstante(GregorianCalendar istante)
    {
        this.istante.set(GregorianCalendar.YEAR, istante.get(GregorianCalendar.YEAR));
        this.istante.set(GregorianCalendar.MONTH, istante.get(GregorianCalendar.MONTH));
        this.istante.set(GregorianCalendar.DAY_OF_MONTH, istante.get(GregorianCalendar.DAY_OF_MONTH));
        this.istante.set(GregorianCalendar.HOUR_OF_DAY, istante.get(GregorianCalendar.HOUR_OF_DAY));
        this.istante.set(GregorianCalendar.MINUTE, istante.get(GregorianCalendar.MINUTE));
        this.istante.set(GregorianCalendar.SECOND, istante.get(GregorianCalendar.SECOND));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return getIstante().get(GregorianCalendar.YEAR)==pagamento.getIstante().get(GregorianCalendar.YEAR)
                && getIstante().get(GregorianCalendar.MONTH)==pagamento.getIstante().get(GregorianCalendar.MONTH)
                && getIstante().get(GregorianCalendar.DAY_OF_MONTH)==pagamento.getIstante().get(GregorianCalendar.DAY_OF_MONTH)
                && getIstante().get(GregorianCalendar.HOUR_OF_DAY)==pagamento.getIstante().get(GregorianCalendar.HOUR_OF_DAY)
                && getIstante().get(GregorianCalendar.MINUTE)==pagamento.getIstante().get(GregorianCalendar.MINUTE)
                && getIstante().get(GregorianCalendar.SECOND)==pagamento.getIstante().get(GregorianCalendar.SECOND);
    }

    @Override
    public abstract void rimborsa();

    @Override
    public String toString() {
        return "\nPagamento{" +
                "importo=" + importo +
                ", istante=" + istante.getTime() +
                '}';
    }

    private double importo;
    private GregorianCalendar istante;
}
