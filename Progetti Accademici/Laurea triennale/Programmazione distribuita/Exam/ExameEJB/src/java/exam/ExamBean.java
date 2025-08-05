package exam;

import entity.TestEJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ExamBean implements ExamBeanRemote {
    @Inject
    EntityManager em;
    
    public void rimuoviEsame(Long id) {
        em.createNamedQuery("CANCELLA_PER_ID").setParameter("id", id).executeUpdate();
    }
    
    public void creaEsame(TestEJB e) {
        em.persist(e);
    }

    public void aggiornaVoto(Long id, String voto) {
        em.createNamedQuery("AGGIORNA_VOTO").setParameter("id", id).setParameter("voto", voto).executeUpdate();
    }
    
    public void rimuoviEsame(TestEJB e)
    {
        em.remove(em.merge(e));
    }
    
    public TestEJB cercaPerId(Long id) 
    {
        return em.find(TestEJB.class, id);
    }
    

    @Override
    public List<TestEJB> cercaPerCognome(String cognome) {
                TypedQuery<TestEJB> query;
        query = em.createNamedQuery("CERCA_PER_COGNOME", TestEJB.class);
        query.setParameter("cognome", cognome);  // Passa il parametro cognome
        return query.getResultList();
    }

    @Override
    public List<TestEJB> cercaTutti() {
                TypedQuery<TestEJB> query = em.createNamedQuery("CERCA_TUTTI", TestEJB.class);
        return query.getResultList();
    }

}
