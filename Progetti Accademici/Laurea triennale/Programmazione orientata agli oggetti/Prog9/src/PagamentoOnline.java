import java.util.GregorianCalendar;
import java.util.Objects;

public class PagamentoOnline extends Pagamento
{
    public PagamentoOnline(double importo, GregorianCalendar istante, int ID, String piattaforma) {
        super(importo, istante);
        this.ID = ID;
        this.piattaforma = piattaforma;
    }

    public int getID() {
        return ID;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getTerminiRimborso()
    {
        return terminiRimborso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PagamentoOnline that = (PagamentoOnline) o;
        return ID == that.ID;
    }

    @Override
    public void rimborsa()
    {
        ID=0;

            /*genero la nuova data da assegnare*/
        GregorianCalendar newData = new GregorianCalendar();
        setIstante(newData);
    }

    @Override
    public String toString() {
        return "\n-PagamentoOnline{" +
                "ID=" + ID +
                ", piattaforma='" + piattaforma + '\'' +
                "} " + super.toString();
    }

    private int ID;
    private String piattaforma;
    private static final int terminiRimborso = 30;
}
