package jms;

import javax.naming.*;
import jakarta.jms.*;
import entity.TestEJB;
import exam.ExamBeanRemote;
import jakarta.ejb.*;

@MessageDriven(mappedName = "jms/MyTopic")
public class ExamJMSMDB implements MessageListener {
    @EJB
    private ExamBeanRemote examBean;

    @Override
    public void onMessage(Message msg) {
        System.out.println("New message received");
        try {
            TestEJB e = msg.getBody(TestEJB.class);
            Long id = e.getId();
            String voto = e.getVoto();
            
            examBean.aggiornaVoto(id, voto);
            System.out.println("Updated exam ID " + id + " with new vote: " + voto);
            
            if ("18".equals(voto)) {
                System.out.println("Impegnati di più");
            }
        } catch (JMSException ex) {
            System.out.println("Error in onMessage(): " + ex.getMessage());
        }
    }
}
