import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

//funziona correttamente

/*generare n interi,double,stringhe,date*/
public class Main4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("INSERISCI UN NUMERO: ");
        int dim = Integer.parseInt(scanner.nextLine());

        Random random = new Random();

        String nome = "elemento";
        GregorianCalendar g1 = new GregorianCalendar(2022, 00, 1);
        GregorianCalendar g2 = new GregorianCalendar(2023, 11, 29);
        GregorianCalendar g3 = new GregorianCalendar();

        for(int i=0; i<dim; i++)
        {
            int numero = random.nextInt(101);   //da 0 a 100

            double dec = random.nextDouble();

            nome += i;

            g3 = (GregorianCalendar) g1.clone();

            int giorni = Main4.calcoloGiorni(g1, g2);

            int giorni2 = random.nextInt(giorni+1);

            g3.add(Calendar.DAY_OF_YEAR, giorni2);

            System.out.println("INTERO: " + numero);
            System.out.println("DOUBLE: " + dec);
            System.out.println("STRINGA: " + nome);
            System.out.println("DATA: " + g3.getTime() + "\n");
        }

    }

    public static int calcoloGiorni(GregorianCalendar d1, GregorianCalendar d2)
    {
        long diff = d2.getTimeInMillis() - d1.getTimeInMillis();
        int giorni = (int) (diff/(1000*60*60*24));

        return giorni;
    }
}
