package soggiorno;

import entity.Soggiorno;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface SoggiornoBeanRemote 
{
    public List<Soggiorno> cercaPerDestinazione(String d);
    public List<Soggiorno> cercaPagati();
    public Soggiorno cercaPerId(Long id);
    public void rimuoviSoggiorno(String d);
    public void creaSoggiorno(Soggiorno s);
    public void modificaSoggiorno(Long id, String stato);   
}
