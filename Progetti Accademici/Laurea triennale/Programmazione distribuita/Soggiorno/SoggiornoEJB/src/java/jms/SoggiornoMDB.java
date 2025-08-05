package jms;

import entity.Soggiorno;
import jakarta.jms.*;
import jakarta.ejb.*;
import soggiorno.SoggiornoBean;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class SoggiornoMDB implements MessageListener {
    @EJB
    private SoggiornoBean sb;

    @Override
    public void onMessage(Message msg) {
        System.out.println("Nuovo messaggio ricevuto");
        try {
            Soggiorno s = msg.getBody(Soggiorno.class);
            Long id = s.getId();
            String stato = s.getStato();
            
            sb.modificaSoggiorno(id, stato);
            System.out.println("Aggiornamento Soggiorno ID " + id + " a stato: " + stato);
            
            if ("PAGATO".equals(stato)) 
            {
                System.out.println("Nuovo pagamento per il soggiorno " + id);
            }
        } catch (JMSException ex) {
            System.out.println("Error in onMessage(): " + ex.getMessage());
        }
    }
}
