package examclient;

import entity.TestEJB;
import exam.ExamBeanRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ExamClient 
{
    public static void main(String[] args) throws NamingException
    {
        Context ctx = new InitialContext();
        ExamBeanRemote ejbRemote = (ExamBeanRemote) ctx.lookup("java:global/ExameEJB/ExamBean!exam.ExamBeanRemote");
        
        List<TestEJB> resultList = ejbRemote.cercaTutti();
        System.out.println("Lista esami");
        
        for(TestEJB result: resultList)
        {
            System.out.println(result);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserire cognome: ");
        String cognome = scan.nextLine();
        
        resultList = ejbRemote.cercaPerCognome(cognome);
        System.out.println("Lista esami");
        
        for(TestEJB result: resultList)
        {
            System.out.println(result);
        }
    }
}