/*
ALCUNE NOTE:
ho dovuto cambiare la versione del persistence.xml in 3.0;
ho cambiato jdk da 23 a 21;
*/

package soggiorno;

import entity.Soggiorno;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class SoggiornoBean implements SoggiornoBeanRemote 
{
    @Inject
    EntityManager em;
    
    @Override
    public List<Soggiorno> cercaPerDestinazione(String d) 
    {
        TypedQuery<Soggiorno> query;
        query = em.createNamedQuery("CERCA_PER_DESTINAZIONE", Soggiorno.class);
        query.setParameter("destinazione", d);
        return (List<Soggiorno>) query.getResultList();
    }
    
    @Override
    public List<Soggiorno> cercaPagati() 
    {
        TypedQuery<Soggiorno> query;
        query = em.createNamedQuery("CERCA_PAGATI", Soggiorno.class);
        return (List<Soggiorno>) query.getResultList();
    }
    
    @Override
    public Soggiorno cercaPerId(Long id) 
    {
        TypedQuery<Soggiorno> query;
        query = em.createNamedQuery("CERCA_PER_ID", Soggiorno.class);
        query.setParameter("id", id);
        return (Soggiorno) query.getSingleResult();
    }
    
    @Override
    public void creaSoggiorno(Soggiorno s) {
        em.persist(s);
    }
    
    @Override
    public void rimuoviSoggiorno(String d) {
        em.createNamedQuery("RIMUOVI_SOGGIORNO").setParameter("destinazione", d).executeUpdate();
    }
    
    @Override
    public void modificaSoggiorno(Long id, String stato) {
        em.createNamedQuery("MODIFICA_SOGGIORNO").setParameter("id", id).setParameter("stato", stato).executeUpdate();
    }
}
