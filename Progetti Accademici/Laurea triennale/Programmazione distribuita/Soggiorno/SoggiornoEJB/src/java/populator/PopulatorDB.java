package populator;

import entity.Soggiorno;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.time.LocalDate;
import soggiorno.SoggiornoBean;

@Singleton
@LocalBean
@Startup
public class PopulatorDB {

    @Inject
    private SoggiornoBean sb;
    
    public Soggiorno s1, s2, s3, s4;

    @PostConstruct
    public void popolaDB() 
    {
        s1 = new Soggiorno("Esposito E.", "Isole Canarie", LocalDate.of(2025, 3, 5), LocalDate.of(2025, 3, 13), "NON PAGATO");
        s2 = new Soggiorno("Ferrari F.", "Sardegna", LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 15), "NON PAGATO");
        s3 = new Soggiorno("Rossi R.", "Maldive", LocalDate.of(2025, 2, 16), LocalDate.of(2025, 2, 28), "NON PAGATO");
        s4 = new Soggiorno("Bianchi B.", "Rodi", LocalDate.of(2025, 3, 29), LocalDate.of(2025, 4, 7), "NON PAGATO");
        
        // Popolamento del database
        sb.creaSoggiorno(s1);
        sb.creaSoggiorno(s2);
        sb.creaSoggiorno(s3);
        sb.creaSoggiorno(s4);
    }
}
