package esame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class InterfacciaGrafica
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Gran Prix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Larghezza x Altezza

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane pane = new JScrollPane(area);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Numero autovetture: ");
        JTextField text = new JTextField();
        text.setColumns(10); // Imposta il numero di colonne (larghezza)
        JButton button = new JButton("Simula");

        panel.add(label);
        panel.add(text);
        panel.add(button);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(pane);
        frame.setVisible(true);

        GranPrix grandPrix = new GranPrix(30, 7, 8, 5);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int numAuto = Integer.parseInt(text.getText());

                InterfacciaGrafica.casuale(numAuto, grandPrix);
                InterfacciaGrafica.gara(grandPrix);
                InterfacciaGrafica.classifica(grandPrix, area);

                System.out.println(grandPrix);

            }
        };

        button.addActionListener(listener);
    }

    public static void casuale(int dim, GranPrix gp)
    {
        for(int i=0; i<dim; i++)
        {
            Random random = new Random();
            int num = random.nextInt(201) + 100;

            if(i%2==0)
            {
                Benzina b = new Benzina(autoCasuali[i], num);
                gp.aggiungi(b);
            }
            else if(i%5==0)
            {
                Ibride ib = new Ibride(autoCasuali[i], num);
                gp.aggiungi(ib);
            }
            else
            {
                Elettriche e = new Elettriche(autoCasuali[i], num);
                gp.aggiungi(e);
            }
        }
    }

    public static void gara(GranPrix grandPrix)
    {
        for(int i=0; i<grandPrix.getNumGiri(); i++)
        {
            grandPrix.avviaMotori();
            grandPrix.effettuaGiro();

            for(int j=0; j<grandPrix.getAuto().size(); j++)
            {
                grandPrix.pitStop(j);
            }
        }

            /*sottraiamo 2 per rimuovere il pitsotp finale che non c'è*/
        for(int j=0; j<grandPrix.getAuto().size(); j++)
        {
            grandPrix.getAuto().get(j).setTempoImpiegato(-2);
        }
    }

    public static void classifica(GranPrix grandPrix, JTextArea a)
    {
        for(int j=1; j<=grandPrix.getAuto().size(); j++)
        {
            a.append("\n" + j + " - " + grandPrix.getAuto().get(j).getNome());
        }
    }


    public static String[] autoCasuali = {"mercedes 1", "mercedes 2",
                            "audi 1", "audi 2",
                            "bmw 1", "bmw2",
                            "ferrari 1", "ferrari 2"};
}
