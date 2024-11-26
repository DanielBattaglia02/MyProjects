import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Random;

public class InterfacciaGraficaRegistrazione
{
    static Registrazioni registro = new Registrazioni();

    public static void main(String[] args)  /*allargare la finestra a schermo intero*/
    {
        JFrame jframe = new JFrame();
        jframe.setTitle("Registrazioni");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setSize(300, 300);
        jframe.setVisible(true);

        /****************************pannello di generazioNe**********************************************/

        JPanel jPanel1 = new JPanel();
        jframe.add(BorderLayout.NORTH, jPanel1);

        JLabel jLabel = new JLabel("Registrazioni");
        JTextField jTextField = new JTextField();
        jTextField.setColumns(10);
        JButton jButton1 = new JButton("Genera");
        jPanel1.add(jLabel);
        jPanel1.add(jTextField);
        jPanel1.add(jButton1);

        /*****************************text area***************************************************************/

        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jframe.add(BorderLayout.CENTER, jScrollPane);

        /******************************pannello per i pulsanti inferiori*********************************/

        JPanel jPanel2 = new JPanel(new GridLayout(2,1));
        jframe.add(BorderLayout.SOUTH, jPanel2);

        /*****************************pannello per gli incassi******************************************/

        JPanel jPanel3 = new JPanel();
        jPanel2.add(jPanel3);

        JButton jButton2 = new JButton("Totale incasso");
        jPanel3.add(jButton2);

        /*****************************pannello l'incasso di una tipologia******************************************/

        JPanel jPanel4 = new JPanel();
        jPanel2.add(jPanel4);

        JComboBox jComboBox = new JComboBox<>();
        jComboBox.setBackground(Color.white);
        jComboBox.addItem("Studente");
        jComboBox.addItem("Membro");
        jComboBox.addItem("NonMembro");
        JButton jButton3 = new JButton("Incasso");
        jPanel4.add(jComboBox);
        jPanel4.add(jButton3);

        /**********************************bottoni***********************************/

        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int num = Integer.parseInt(jTextField.getText());

                generazione( num, registro, jTextArea);
            }
        };

        jButton1.addActionListener(actionListener1);

        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                totaleIncasso(registro, jTextArea);
            }
        };

        jButton2.addActionListener(actionListener2);

        ActionListener actionListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                incasso(registro, (String)jComboBox.getSelectedItem(),jTextArea);
            }
        };

        jButton3.addActionListener(actionListener3);



    }

    public static void generazione(int dim, Registrazioni reg, JTextArea jt)
    {
        for(int i=1; i<=dim; i++)
        {
            GregorianCalendar g = new GregorianCalendar();
            Random random = new Random();

            if(i%2==0)
            {
                g.set(GregorianCalendar.YEAR, 2021);
                g.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
                g.set(GregorianCalendar.DAY_OF_MONTH, random.nextInt(31) + 1);
                reg.aggiungiRegistrazione(new Studente(new String("nome"+i), "d ", g, "d ", "d "));

            }
            else if(i%5==0)
            {
                g.set(GregorianCalendar.YEAR, 2022);
                g.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
                g.set(GregorianCalendar.DAY_OF_MONTH, random.nextInt(31) + 1);
                reg.aggiungiRegistrazione(new Membro(new String("nome"+i), "g ", g, " g", i));

            }
            else
            {
                g.set(GregorianCalendar.YEAR, 2022);
                g.set(GregorianCalendar.MONTH, GregorianCalendar.FEBRUARY);
                g.set(GregorianCalendar.DAY_OF_MONTH, random.nextInt(28) + 1);
                reg.aggiungiRegistrazione(new NonMembro(new String("nome"+i), "g", g, " g"));
            }
        }

        jt.append("Generate " + dim + " registrazioni.\n");

        for(Registrazione r: reg.getRegistrazioni())
        {
            jt.append("\n" + r);
        }
    }

    public static void totaleIncasso(Registrazioni reg, JTextArea jt)
    {
        double totale = reg.dammiTotale();

        jt.append("\nTotale incasso: " + totale);
    }

    public static void incasso(Registrazioni reg, String tipo, JTextArea jt)
    {
        double totale = reg.dammiTotalePerTipoPartecipante(tipo);

        jt.append("\nTotale incasso di " + tipo + " : " + totale);
    }
}
