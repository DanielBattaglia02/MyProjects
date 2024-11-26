import java.util.GregorianCalendar;
import java.util.Objects;

public class PagamentoInNegozio extends Pagamento
{
    public PagamentoInNegozio(double importo, GregorianCalendar istante, String nomeCassiere) {
        super(importo, istante);
        this.nomeCassiere = nomeCassiere;
    }

    public String getNomeCassiere() {
        return nomeCassiere;
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
        PagamentoInNegozio that = (PagamentoInNegozio) o;
        return nomeCassiere.equals(that.nomeCassiere);
    }

    @Override
    public void rimborsa()
    {
        this.nomeCassiere = "nuovocassiere";
        double importoNegativo = getImporto()*(-1);
    }

    @Override
    public String toString() {
        return "\n-PagamentoInNegozio{" +
                "nomeCassiere='" + nomeCassiere + '\'' +
                "} " + super.toString();
    }

    private String nomeCassiere;
    private static final int terminiRimborso = 10;
}
