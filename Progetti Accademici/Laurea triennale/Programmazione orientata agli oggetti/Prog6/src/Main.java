import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//funziona correttamente

/*scrittura data in un filetestuale e calcolo differenza tra due date*/
public class Main
{
    private GregorianCalendar dataInizio;
    GregorianCalendar dataFine;

    public static void main(String[] args) throws FileNotFoundException
    {
        Main main = new Main();

        main.dataInizio = new GregorianCalendar(2021, Calendar.FEBRUARY, 25);

        main.dataFine = new GregorianCalendar(2024, Calendar.JANUARY, 29);

        long diff = main.dataFine.getTimeInMillis() - main.dataInizio.getTimeInMillis();
        long anni = (long) (diff/(1000*60*60*24*365.25));
        long giorni = (long) (diff/(1000*60*60*24));

        System.out.println("Differenza anni: " + anni);
        System.out.println("Differenza giorni: " + giorni);

        File file = new File("prova.txt");
        PrintWriter printWriter = new PrintWriter(file);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data1 = simpleDateFormat.format(main.dataInizio.getTime());
        String data2 = simpleDateFormat.format(main.dataFine.getTime());

        printWriter.println(data1);
        printWriter.println(data2);

        printWriter.close();
    }
}