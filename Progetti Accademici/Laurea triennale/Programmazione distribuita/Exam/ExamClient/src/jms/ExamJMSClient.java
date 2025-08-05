package jms;

import javax.naming.*;
import jakarta.jms.*;
import entity.TestEJB;
import exam.ExamBeanRemote;
import java.time.LocalDate;

public class ExamJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/MyConnectionFactory");
        Destination d = (Destination) ctx.lookup("jms/MyTopic");
        JMSContext jc = cf.createContext();
        
        ExamBeanRemote ejbRemote = (ExamBeanRemote) ctx.lookup("java:global/ExameEJB/ExamBean!exam.ExamBeanRemote");
        
        Long idEsame = 1L; // ID dell'esame da aggiornare
        String nuovoVoto = "29"; // Nuovo voto
        
        TestEJB esame = new TestEJB();
        esame.setId(idEsame);
        esame.setVoto(nuovoVoto);
        
        ObjectMessage objMsg = jc.createObjectMessage(esame);
        jc.createProducer().send(d, objMsg);
        System.out.println("Messaggio di aggiornamento inviato!");
    }  
}