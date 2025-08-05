/*
NOTE:
1. All'interno del mio scritto non ho codificato la seguente classe, ovvero il terzo punto del secondo esercizio.
2. La classe `SoggiornoJMSClient2` è un client JMS che si sottoscrive ad un Topic e riceve messaggi in modo asincrono.
3. La connessione è configurata per usare una sottoscrizione duratura, il che significa che i messaggi inviati al Topic durante il periodo in cui il client è offline verranno recapitati non appena il client sarà online.
*/

package jms;

import entity.Soggiorno;
import javax.naming.*;
import jakarta.jms.*;

public class SoggiornoJMSClient2 {
    public static void main(String[] args) throws NamingException, JMSException, Exception {
        Context ctx = new InitialContext();

        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Topic topic = (Topic) ctx.lookup("jms/javaee7/Topic");

        // Creazione della connessione JMS, configurando un Client ID per la sottoscrizione duratura
        try (JMSContext jc = cf.createContext()) {
            // Imposta un Client ID univoco per consentire la sottoscrizione duratura
            jc.setClientID("SoggiornoSubscriber");

            // Creazione del consumer con una sottoscrizione duratura
            JMSConsumer consumer = jc.createDurableConsumer(topic, "SoggiornoSubscription");

            // Configurazione di un MessageListener per ricevere i messaggi in modo asincrono
            consumer.setMessageListener(message -> {
                try {
                    
                    if (message instanceof ObjectMessage) 
                    {
                        ObjectMessage objMsg = (ObjectMessage) message;
                        Soggiorno soggiorno = (Soggiorno) objMsg.getObject();

                        System.out.println("Messaggio ricevuto: " + soggiorno.getStato());
                    }
                } catch (JMSException e) {
                    e.printStackTrace(); 
                }
            });

            // Mantieni il client in esecuzione per ricevere messaggi finché l'utente non preme ENTER
            System.out.println("In attesa di messaggi... Premi ENTER per uscire.");
            System.in.read(); // Blocco in attesa di un input da parte dell'utente

            consumer.close();
            jc.unsubscribe("SoggiornoSubscription");
        }
    }
}
