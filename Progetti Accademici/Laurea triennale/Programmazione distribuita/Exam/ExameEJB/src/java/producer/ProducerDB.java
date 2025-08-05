package producer;

import jakarta.enterprise.inject.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProducerDB 
{
    @Produces
    @PersistenceContext(unitName = "ExameEJBPU")
    EntityManager em;
}
