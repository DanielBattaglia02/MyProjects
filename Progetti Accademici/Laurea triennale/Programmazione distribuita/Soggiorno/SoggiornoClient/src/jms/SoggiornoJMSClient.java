package jms;

import entity.Soggiorno;
import javax.naming.*;
import jakarta.jms.*;
import soggiorno.SoggiornoBeanRemote;

public class SoggiornoJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination d = (Destination) ctx.lookup("jms/javaee7/Topic");
        JMSContext jc = cf.createContext();
        
        SoggiornoBeanRemote ejbRemote = (SoggiornoBeanRemote) ctx.lookup("java:global/SoggiornoEJB/SoggiornoBean!soggiorno.SoggiornoBeanRemote");
        
        Soggiorno newS = new Soggiorno();
        newS.setId(3L);
        newS.setStato("PAGATO");
        
        ObjectMessage objMsg = jc.createObjectMessage(newS);
        jc.createProducer().send(d, objMsg);
        System.out.println("Messaggio di aggiornamento inviato!");
    }  
}