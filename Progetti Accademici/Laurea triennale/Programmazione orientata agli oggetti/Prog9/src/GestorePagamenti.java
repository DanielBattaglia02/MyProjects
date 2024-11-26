import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class GestorePagamenti implements Serializable
{
    public GestorePagamenti(String nomeNegozio, int percentuale)
    {
        this.nomeNegozio = nomeNegozio;
        this.percentualeCommissione = percentuale;
        this.pagamenti = new ArrayList<>();
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }

    public List<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(List<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    public int getPercentuale() {
        return percentualeCommissione;
    }

    public void setPercentuale(int percentuale) {
        this.percentualeCommissione = percentuale;
    }

    public void aggiungiPagamenti(Pagamento p) throws PagamentoException
    {
        if(!pagamenti.isEmpty())
        {
            for(Pagamento p2: pagamenti)
            {
                if(p2 instanceof PagamentoOnline)
                {
                    PagamentoOnline p3 = (PagamentoOnline) p2;

                    if(p3.equals(p))
                    {
                        throw new PagamentoException();
                    }
                }
                else if(p2 instanceof PagamentoInNegozio)
                {
                    PagamentoInNegozio p3 = (PagamentoInNegozio) p2;

                    if(p3.equals(p))
                    {
                        throw new PagamentoException();
                    }
                }
            }
        }

        double commissione = (p.getImporto()*percentualeCommissione)/100;
        p.setImporto(p.getImporto()+commissione);
        pagamenti.add(p);
    }

    public void rimborsaPagamento(int i) throws PagamentoNonRimborsabileException
    {
        GregorianCalendar oggi = new GregorianCalendar();
        long diff = oggi.getTimeInMillis() - pagamenti.get(i).getIstante().getTimeInMillis();
        int giorni = (int)(diff/1000*60*60*24);

        if(pagamenti.get(i) instanceof PagamentoOnline)
        {
            PagamentoOnline p = (PagamentoOnline) pagamenti.get(i);

            if(giorni>p.getTerminiRimborso())
            {
                throw new PagamentoNonRimborsabileException();
            }
            else
            {
                p.rimborsa();
            }

        }
        else if(pagamenti.get(i) instanceof PagamentoInNegozio)
        {
            PagamentoInNegozio p = (PagamentoInNegozio) pagamenti.get(i);

            if(giorni>p.getTerminiRimborso())
            {
                throw new PagamentoNonRimborsabileException();
            }
            else
            {
                p.rimborsa();
            }
        }
    }

    private String nomeNegozio;
    private List<Pagamento> pagamenti;
    private int percentualeCommissione;
}
