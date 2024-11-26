import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

//funzona correttamente

/*generare una data tra 1 dicembre 2021 e 20 febbraio 2022*/
public class Main3
{
    public static void main(String[] args)
    {
        GregorianCalendar d1 = new GregorianCalendar(2021, 11, 1);
        GregorianCalendar d2 = new GregorianCalendar(2022, 01, 20);
        GregorianCalendar d3 = (GregorianCalendar) d1.clone();

        long diff = d2.getTimeInMillis() - d1.getTimeInMillis();
        int giorni = (int) (diff/(1000*60*60*24));
        System.out.println("Differenza in giorni: " + giorni);

        for(int i=0; i<20; i++)
        {
            d3 = (GregorianCalendar) d1.clone();
            Random random = new Random();
            int n = random.nextInt(giorni+1); // genera un numero tra 0 e giorni incluso
            System.out.println("\nGiorni generati da aggiungere: " + n);

            d3.add(Calendar.DAY_OF_YEAR, n );
            System.out.println("data finale: " + d3.getTime());
        }
    }
}
