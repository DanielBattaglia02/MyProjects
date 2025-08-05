package exam;

import entity.TestEJB;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface ExamBeanRemote 
{
    public List<TestEJB> cercaPerCognome(String cognome);
    public List<TestEJB> cercaTutti();
    public void rimuoviEsame(Long id);
    public void aggiornaVoto(Long id, String voto);   
}
