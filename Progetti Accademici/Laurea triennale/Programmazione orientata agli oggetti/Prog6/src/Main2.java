import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//funziona correttamente

/*lettura data da file testuale*/
public class Main2
{
    private GregorianCalendar dataInizio;
    GregorianCalendar dataFine;

    public static void main(String[] args) throws FileNotFoundException
    {
        Main main = new Main();

        File file = new File("prova.txt");
        Scanner scanner = new Scanner(file);

        String linea1 = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar d1 = new GregorianCalendar();

        try
        {
            Date date1 = simpleDateFormat.parse(linea1);
            d1.setTime(date1);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        String linea2 = scanner.nextLine();
        GregorianCalendar d2 = new GregorianCalendar();

        try
        {
            Date date2 = simpleDateFormat.parse(linea2);
            d2.setTime(date2);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println("data1: " + d1.getTime());
        System.out.println("data2: " + d2.getTime());

        scanner.close();
    }
}
