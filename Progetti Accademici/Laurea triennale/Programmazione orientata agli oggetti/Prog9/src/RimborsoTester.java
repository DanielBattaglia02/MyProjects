import java.util.GregorianCalendar;
import java.util.Random;

public class RimborsoTester
{
    public static void main(String[] args) {
        GestorePagamenti Carrefour = new GestorePagamenti("Carrefour", 1);

        GregorianCalendar oggi = new GregorianCalendar();
        String[] piattaforme = {"piattaforma1", "piattaforma2", "piattaforma3", "piattaforma4"};
        String[] nomi = {"nome1", "nome2", "nome3", "nome4"};
        Random random = new Random();

        /*pagamentionline non rimborsabili*/
        for (int i = 0; i < 5; i++) {
            GregorianCalendar newData = new GregorianCalendar();
            newData.add(GregorianCalendar.DAY_OF_MONTH, -(31 + i));

            PagamentoOnline pagamentoOnline = new PagamentoOnline(random.nextDouble() * 40, newData, i, piattaforme[random.nextInt(4)]);

            try {
                Carrefour.aggiungiPagamenti(pagamentoOnline);
                System.out.println(pagamentoOnline + "\n-----------------------------------------\n");
            } catch (PagamentoException e) {
                e.printStackTrace();
                i--;
            }
        }

        System.out.println("\n**************************************\n");

        /*pagamentionline rimborsabili*/
        for (int i = 5; i < 10; i++) {
            GregorianCalendar newData = new GregorianCalendar();
            newData.add(GregorianCalendar.DAY_OF_MONTH, -(2 + i));

            PagamentoOnline pagamentoOnline = new PagamentoOnline(random.nextDouble() * 40, newData, i, piattaforme[random.nextInt(4)]);

            try {
                Carrefour.aggiungiPagamenti(pagamentoOnline);
                System.out.println(pagamentoOnline + "\n-----------------------------------------\n");
            } catch (PagamentoException e) {
                e.printStackTrace();
                i--;
            }
        }

        System.out.println("\n**************************************\n");

        /*pagamentiinnegozio non rimborsabili*/
        for (int i = 10, j = 0; i < 15; i++, j++) {
            GregorianCalendar newData = new GregorianCalendar();
            newData.add(GregorianCalendar.DAY_OF_MONTH, -(11 + j));

            PagamentoInNegozio pagamentoInNegozio = new PagamentoInNegozio(random.nextDouble() * 40, newData, nomi[random.nextInt(4)]);

            try {
                Carrefour.aggiungiPagamenti(pagamentoInNegozio);
                System.out.println(pagamentoInNegozio + "\n-----------------------------------------\n");
            } catch (PagamentoException e) {
                e.printStackTrace();
                i--;
            }
        }

        System.out.println("\n**************************************\n");

        /*pagamentiinnegozio rimborsabili*/
        for (int i = 15, j = 0; i < 20; i++, j++)
        {
            GregorianCalendar newData = new GregorianCalendar();
            newData.add(GregorianCalendar.DAY_OF_MONTH, -(2 + j));

            PagamentoInNegozio pagamentoInNegozio = new PagamentoInNegozio(random.nextDouble() * 100, newData, nomi[random.nextInt(4)]);

            try {
                Carrefour.aggiungiPagamenti(pagamentoInNegozio);
                System.out.println(pagamentoInNegozio + "\n-----------------------------------------\n");
            } catch (PagamentoException e) {
                e.printStackTrace();
                i--;
            }
        }


        /*******************************simulazione rimborsi***********************************/

        for(int i=0; i<6; i++)
        {
            int num = random.nextInt(6);

            try
            {
                Carrefour.rimborsaPagamento(num);
                System.out.println("\n- " + i + " - " + num + "\n");
            }
            catch(PagamentoNonRimborsabileException e)
            {
                e.printStackTrace();
                i--;
            }
        }
    }
}
