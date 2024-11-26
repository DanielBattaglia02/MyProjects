package esame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class InterfacciaGrafica
{
    public static void main(String[] args)
    {
        InterfacciaGrafica interfacciaGrafica = new InterfacciaGrafica();
        Main main = new Main();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setTitle("Aereomobili");

        JPanel jPanel = new JPanel();
        frame.add(BorderLayout.NORTH, jPanel);

        JLabel jLabel = new JLabel("Scegli tipologia");
        jPanel.add(jLabel);

        JComboBox jComboBox = new JComboBox<>();
        jComboBox.setBackground(Color.WHITE);
        jComboBox.addItem("Aereoplano");
        jComboBox.addItem("Elicottero");
        jPanel.add(jComboBox);

        JButton jButton = new JButton("Seleziona");
        jPanel.add(jButton);

        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        frame.add(jScrollPane);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    main.letturaDaFile();
                }
                catch(FileNotFoundException exception)
                {
                    System.out.println(exception);
                }

                String scelta = (String)jComboBox.getSelectedItem();

                List<Aereomobile> list = main.ricerca(scelta);

                for(Aereomobile a: list)
                {
                    jTextArea.append("\n" + a);
                }
            }
        };

        jButton.addActionListener(actionListener);
    }
}
