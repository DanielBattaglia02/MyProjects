package populator;

import entity.TestEJB;
import exam.ExamBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.time.LocalDate;

@Singleton
@LocalBean
@Startup
public class PopulatorDB {

    @Inject
    private ExamBean ejb;
    
    public TestEJB e1, e2, e3;

    // Il metodo @PostConstruct viene eseguito subito dopo la creazione del singleton
    @PostConstruct
    public void popolaDB() {
        // Creazione delle consegne
        TestEJB e1 = new TestEJB("Francesco", "Abbate", LocalDate.of(2025, 1, 20), "28");
        TestEJB e2 = new TestEJB ("Giovanni", "Alfano", LocalDate.of(2025, 2, 10), "22");
        TestEJB e3= new TestEJB ("Lorenzo", "Carpentieri", LocalDate.of(2025, 3, 1), "26");
        
        // Popolamento del database
        ejb.creaEsame(e1);
        ejb.creaEsame(e2);
        ejb.creaEsame(e3);
    }

    // Il metodo @PreDestroy viene eseguito subito prima che il singleton venga distrutto
    @PreDestroy
    public void eliminaDB() {
        // Rimozione delle consegne
        ejb.rimuoviEsame(e1);
        ejb.rimuoviEsame(e2);
        ejb.rimuoviEsame(e3);
    }
}
