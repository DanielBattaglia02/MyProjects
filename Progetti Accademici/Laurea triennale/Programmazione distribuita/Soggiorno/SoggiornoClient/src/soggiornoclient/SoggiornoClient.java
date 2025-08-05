/*
ALCUNE NOTE:
aggiungere in properties/run questa stringa : --add-opens java.base/java.lang=ALL-UNNAMED
*/

package soggiornoclient;

import entity.Soggiorno;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import soggiorno.SoggiornoBeanRemote;

public class SoggiornoClient 
{
    public static void main(String[] args) throws NamingException
    {
        Context ctx = new InitialContext();
        SoggiornoBeanRemote sbr = (SoggiornoBeanRemote) ctx.lookup("java:global/SoggiornoEJB/SoggiornoBean!soggiorno.SoggiornoBeanRemote");
        
        List<Soggiorno> resultList = sbr.cercaPagati();
        System.out.println("Lista soggiorni:");
        
        for(Soggiorno result: resultList)
        {
            System.out.println(result.toString());
        }
        
        sbr.rimuoviSoggiorno("Rodi");
        
        Soggiorno newS = new Soggiorno("Gallo G.", "Cuba", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 30), "PAGATO");
        sbr.creaSoggiorno(newS);
        
        sbr.modificaSoggiorno(3L, "PAGATO");
        
        resultList = sbr.cercaPagati();
        System.out.println("Lista soggiorni aggiornati:");
        
        for(Soggiorno result: resultList)
        {
            System.out.println(result.toString());
        }
    }
}