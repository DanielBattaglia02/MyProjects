import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.Random;

public class GuiTester extends JFrame
{
    GuiTester()
    {
            /************************interfaccia**********************/
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        JPanel jPanel = new JPanel();

        JButton jButton = new JButton("Salva");

        jPanel.add(jButton);

        add(BorderLayout.CENTER, jScrollPane);
        add(BorderLayout.SOUTH, jPanel);

            /*****************************generazione**********************/
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

        double somma = 0;
       for(int i=0; i<Carrefour.getPagamenti().size(); i++)
       {
           jTextArea.append("\n(" + i + ") " + Carrefour.getPagamenti().get(i));
           somma+=Carrefour.getPagamenti().get(i).getImporto();
       }

        jTextArea.append("\nSOMMA = " + somma);
       System.out.println("\nSOMMA = " + somma);

            /**********************action listener pulsante*****************/
        class SalvaListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("esame");
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new FileOutputStream(file));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    out.writeObject(Carrefour);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    out.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println("\n-------Salvati---------");
            }
        }

        ActionListener salvaListener = new SalvaListener();
        jButton.addActionListener(salvaListener);
    }

    public static void main(String[] args)
    {
        JFrame jFrame = new GuiTester();
        jFrame.setSize(300, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
