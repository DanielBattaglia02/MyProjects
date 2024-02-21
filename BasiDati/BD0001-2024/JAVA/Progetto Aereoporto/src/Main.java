import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void main(String[] args)
    {
        Connessione connessione = new Connessione();

        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Progetto Aereoporto Battaglia-Vaiano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        frame.setVisible(true);

        /*
        |---------|
        |jpanel1  |
        |---------|
        |jpanel2  |
        |jpanel2_1|
        |jpanel2  |
        |---------|
        |jpanel3_0|
        |jpanel3_1|
        |jpanel3  |
        |---------|
        |jpanel4  |
        |jpanel4_1|
        |jpanel4  |
        |---------|
         */

        JPanel jpanel = new JPanel(new GridLayout(4, 1));
        JPanel jpanel1 = new JPanel(new BorderLayout());
        JPanel jpanel2 = new JPanel(new BorderLayout());
        JPanel jpanel2_1 = new JPanel();    //permette visualizzazione orizzontale
        JPanel jpanel3 = new JPanel(new BorderLayout());
        JPanel jpanel3_0 = new JPanel();    //permette visualizzazione orizzontale
        JPanel jpanel3_1 = new JPanel();    //permette visualizzazione orizzontale
        JPanel jpanel4 = new JPanel(new BorderLayout());
        JPanel jpanel4_1 = new JPanel();    //permette visualizzazione orizzontale

        frame.add(jpanel);
        jpanel.add(jpanel1);
        jpanel.add(jpanel2);
        jpanel.add(jpanel3);
        jpanel.add(jpanel4);

        jpanel2.add(jpanel2_1, BorderLayout.CENTER);
        jpanel3.add(jpanel3_0, BorderLayout.NORTH);
        jpanel3.add(jpanel3_1, BorderLayout.CENTER);
        jpanel4.add(jpanel4_1, BorderLayout.CENTER);

        //----------------------------------VISUALIZZAZIONE-------------------------------------------------

        JLabel label1 = new JLabel("VISUALIZZAZIONE AEREI");
        label1.setFont(new Font("Arial", Font.BOLD, 25));  // Imposta il font e lo stile del testo
        label1.setHorizontalAlignment(JLabel.CENTER);  // Allinea il testo al centro
        jpanel1.add(label1, BorderLayout.NORTH);  // Aggiunge il JLabel al pannello nord

            // Creazione del modello della tabella
        DefaultTableModel modelloTabella = new DefaultTableModel();

            // Aggiunta delle colonne al modello della tabella
        modelloTabella.addColumn("ID");
        modelloTabella.addColumn("ID_CompagniaAerea");
        modelloTabella.addColumn("Nome");
        modelloTabella.addColumn("Stato");
        modelloTabella.addColumn("Note_aereo");
        modelloTabella.addColumn("ID_Documentazione");
        modelloTabella.addColumn("Altezza");
        modelloTabella.addColumn("Larghezza");
        modelloTabella.addColumn("Lunghezza");
        modelloTabella.addColumn("Peso");
        modelloTabella.addColumn("Carico_Max");
        modelloTabella.addColumn("Num_Passeggeri");
        modelloTabella.addColumn("Num_Equipaggio");
        modelloTabella.addColumn("Num_Motori");
        modelloTabella.addColumn("Data_Costruzione");
        modelloTabella.addColumn("Luogo_Costruzione");
        modelloTabella.addColumn("Note_Documentazione");

            // Creazione della tabella con il modello
        JTable tabella = new JTable(modelloTabella);

            // Aggiunta della tabella a uno JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabella);
        jpanel1.add(scrollPane, BorderLayout.CENTER);

            //scrollbar sempre presente
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            //Impostazione dell'allineamento al centro per tutte le colonne
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tabella.getColumnCount(); i++)
        {
            tabella.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JButton btnVisualizza = new JButton("Visualizza aerei");
        jpanel1.add(btnVisualizza, BorderLayout.SOUTH);

            // Modifica solo l'altezza del JButton
        Dimension btnVisualizzaButtonSize = btnVisualizza.getPreferredSize();
        btnVisualizzaButtonSize.height = 40; // Imposta l'altezza desiderata
        btnVisualizza.setPreferredSize(btnVisualizzaButtonSize);

        btnVisualizza.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GestioneAzioni.visualizzaAerei(modelloTabella, connessione.getConnection());
            }
        });

        //----------------------------------INSERIMENTO-------------------------------------------------

        JLabel label2 = new JLabel("INSERIMENTO NUOVO AEREO");
        label2.setFont(new Font("Arial", Font.BOLD, 25));  // Imposta il font e lo stile del testo
        label2.setHorizontalAlignment(JLabel.CENTER);  // Allinea il testo al centro
        jpanel2.add(label2, BorderLayout.NORTH);  // Aggiunge il JLabel al pannello nord

        JLabel nome = new JLabel("Nome Aereo:");
        JTextField textNome = new JTextField(10);

        JLabel ca = new JLabel("Compagnia Aerea:");
        JComboBox <CompagniaAerea> comboBoxCa = new JComboBox<>();
        comboBoxCa.setBackground(Color.WHITE);
        GestioneAzioni.popolareComboBox(comboBoxCa, connessione.getConnection());

        JLabel stato = new JLabel("Stato:");
        JComboBox comboBoxStato = new JComboBox();
        comboBoxStato.setBackground(Color.WHITE);
        comboBoxStato.addItem("disponibile");
        comboBoxStato.addItem("indisponibile");

        JLabel note1 = new JLabel("Note Aereo:");
        JTextField textNote1 = new JTextField(10);

        JLabel altezza = new JLabel("Altezza(m):");
        JTextField textAltezza = new JTextField(10);

        JLabel lunghezza = new JLabel("Lunghezza(m):");
        JTextField textLunghezza = new JTextField(10);

        JLabel larghezza = new JLabel("Larghezza(m):");
        JTextField textLarghezza = new JTextField(10);

        JLabel peso = new JLabel("Peso(Kg):");
        JTextField textPeso = new JTextField(10);

        JLabel caricoMax = new JLabel("Carico Max(Kg):");
        JTextField textCaricoMax = new JTextField(10);

        JLabel numPass = new JLabel("Numero passegeri massimo:");
        JTextField textNumPass = new JTextField(10);

        JLabel numEq = new JLabel("Numero equipaggio massimo:");
        JTextField textNumEq = new JTextField(10);

        JLabel numMot = new JLabel("Numero motori:");
        JTextField textNumMot = new JTextField(10);

        JLabel data = new JLabel("Data costruzione(yyyy-mm-dd):");
        JTextField textData = new JTextField(10);

        JLabel luogo = new JLabel("Luogo di costruzione:");
        JTextField textLuogo = new JTextField(10);

        JLabel note2 = new JLabel("Note documentazione aereo:");
        JTextField textNote2 = new JTextField(10);

        jpanel2_1.add(nome);
        jpanel2_1.add(textNome);

        jpanel2_1.add(ca);
        jpanel2_1.add(comboBoxCa);

        jpanel2_1.add(stato);
        jpanel2_1.add(comboBoxStato);

        jpanel2_1.add(note1);
        jpanel2_1.add(textNote1);

        jpanel2_1.add(altezza);
        jpanel2_1.add(textAltezza);

        jpanel2_1.add(lunghezza);
        jpanel2_1.add(textLunghezza);

        jpanel2_1.add(larghezza);
        jpanel2_1.add(textLarghezza);

        jpanel2_1.add(peso);
        jpanel2_1.add(textPeso);

        jpanel2_1.add(caricoMax);
        jpanel2_1.add(textCaricoMax);

        jpanel2_1.add(numPass);
        jpanel2_1.add(textNumPass);

        jpanel2_1.add(numEq);
        jpanel2_1.add(textNumEq);

        jpanel2_1.add(numMot);
        jpanel2_1.add(textNumMot);

        jpanel2_1.add(data);
        jpanel2_1.add(textData);

        jpanel2_1.add(luogo);
        jpanel2_1.add(textLuogo);

        jpanel2_1.add(note2);
        jpanel2_1.add(textNote2);

        JButton btnInserisci = new JButton("Inserisci nuovo aereo");
        jpanel2.add(btnInserisci, BorderLayout.SOUTH);

            // Modifica solo l'altezza del JButton
        Dimension btnInserisciButtonSize = btnInserisci.getPreferredSize();
        btnInserisciButtonSize.height = 40; // Imposta l'altezza desiderata
        btnInserisci.setPreferredSize(btnInserisciButtonSize);

        btnInserisci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CompagniaAerea CompagniaSelezionata = (CompagniaAerea) comboBoxCa.getSelectedItem();
                String stato = (String) comboBoxStato.getSelectedItem();

                String note1 = textNote1.getText();
                if (note1.trim().isEmpty())
                {
                    note1=null;
                }

                String note2 = textNote2.getText();
                if (note2.trim().isEmpty())
                {
                    note2=null;
                }

                GestioneAzioni.InserisciAereo(textNome.getText(), CompagniaSelezionata.getId(), stato, note1, Double.parseDouble(textAltezza.getText()), Double.parseDouble(textLunghezza.getText()), Double.parseDouble(textLarghezza.getText()), Double.parseDouble(textPeso.getText()), Double.parseDouble(textCaricoMax.getText()), Integer.parseInt(textNumPass.getText()), Integer.parseInt(textNumEq.getText()), Integer.parseInt(textNumMot.getText()), textData.getText(), textLuogo.getText(), note2, connessione.getConnection());
            }
        });

        //----------------------------------MODIFICA-------------------------------------------------

        JLabel label3 = new JLabel("MODIFICA AEREO");
        label3.setFont(new Font("Arial", Font.BOLD, 25));
        label3.setHorizontalAlignment(JLabel.CENTER);
        jpanel3_0.add(label3);

        JLabel IDM = new JLabel("ID Aereo da modificare");
        JTextField textM = new JTextField(5);
        jpanel3_0.add(IDM);
        jpanel3_0.add(textM);

        JLabel nomeM = new JLabel("Nome Aereo:");
        JTextField textNomeM = new JTextField(10);

        JLabel caM = new JLabel("Compagnia Aerea:");
        JComboBox <CompagniaAerea> comboBoxCaM = new JComboBox<>();
        comboBoxCaM.setBackground(Color.WHITE);
        GestioneAzioni.popolareComboBox(comboBoxCaM, connessione.getConnection());

        JLabel statoM = new JLabel("Stato:");
        JComboBox comboBoxStatoM = new JComboBox();
        comboBoxStatoM.setBackground(Color.WHITE);
        comboBoxStatoM.addItem("disponibile");
        comboBoxStatoM.addItem("indisponibile");

        JLabel note1M = new JLabel("Note Aereo:");
        JTextField textNote1M = new JTextField(10);

        JLabel altezzaM = new JLabel("Altezza(m):");
        JTextField textAltezzaM = new JTextField(10);

        JLabel lunghezzaM = new JLabel("Lunghezza(m):");
        JTextField textLunghezzaM = new JTextField(10);

        JLabel larghezzaM = new JLabel("Larghezza(m):");
        JTextField textLarghezzaM = new JTextField(10);

        JLabel pesoM = new JLabel("Peso(Kg):");
        JTextField textPesoM = new JTextField(10);

        JLabel caricoMaxM = new JLabel("Carico Max(Kg):");
        JTextField textCaricoMaxM = new JTextField(10);

        JLabel numPassM = new JLabel("Numero passegeri massimo:");
        JTextField textNumPassM = new JTextField(10);

        JLabel numEqM = new JLabel("Numero equipaggio massimo:");
        JTextField textNumEqM = new JTextField(10);

        JLabel numMotM = new JLabel("Numero motori:");
        JTextField textNumMotM = new JTextField(10);

        JLabel dataM = new JLabel("Data costruzione(yyyy-mm-dd):");
        JTextField textDataM = new JTextField(10);

        JLabel luogoM = new JLabel("Luogo di costruzione:");
        JTextField textLuogoM = new JTextField(10);

        JLabel note2M = new JLabel("Note documentazione aereo:");
        JTextField textNote2M = new JTextField(10);

        jpanel3_1.add(nomeM);
        jpanel3_1.add(textNomeM);

        jpanel3_1.add(caM);
        jpanel3_1.add(comboBoxCaM);

        jpanel3_1.add(statoM);
        jpanel3_1.add(comboBoxStatoM);

        jpanel3_1.add(note1M);
        jpanel3_1.add(textNote1M);

        jpanel3_1.add(altezzaM);
        jpanel3_1.add(textAltezzaM);

        jpanel3_1.add(lunghezzaM);
        jpanel3_1.add(textLunghezzaM);

        jpanel3_1.add(larghezzaM);
        jpanel3_1.add(textLarghezzaM);

        jpanel3_1.add(pesoM);
        jpanel3_1.add(textPesoM);

        jpanel3_1.add(caricoMaxM);
        jpanel3_1.add(textCaricoMaxM);

        jpanel3_1.add(numPassM);
        jpanel3_1.add(textNumPassM);

        jpanel3_1.add(numEqM);
        jpanel3_1.add(textNumEqM);

        jpanel3_1.add(numMotM);
        jpanel3_1.add(textNumMotM);

        jpanel3_1.add(dataM);
        jpanel3_1.add(textDataM);

        jpanel3_1.add(luogoM);
        jpanel3_1.add(textLuogoM);

        jpanel3_1.add(note2M);
        jpanel3_1.add(textNote2M);

        JButton btnModifica = new JButton("Modifica aereo");
        jpanel3.add(btnModifica, BorderLayout.SOUTH);

            // Modifica solo l'altezza del JButton
        Dimension btnModificaButtonSize = btnModifica.getPreferredSize();
        btnModificaButtonSize.height = 40; // Imposta l'altezza desiderata
        btnModifica.setPreferredSize(btnModificaButtonSize);


        btnModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    /*controlliamo quali dati vogliono essere modificati e quali no.
                    Quelli che non devono essere cambiati saranno settati null.
                    Questo non vale per CompagniaAerea, stato e le due note*/
                String nome = textNomeM.getText();
                if (nome.trim().isEmpty())
                {
                    nome=null;
                }

                CompagniaAerea CompagniaSelezionata = (CompagniaAerea) comboBoxCaM.getSelectedItem();

                String stato = (String) comboBoxStatoM.getSelectedItem();

                String note1 = textNote1M.getText();
                if (note1.trim().isEmpty())
                {
                    note1=null;
                }

                String altezza = textAltezzaM.getText();
                if (altezza.trim().isEmpty())
                {
                    altezza=null;
                }

                String lunghezza = textLunghezzaM.getText();
                if (lunghezza.trim().isEmpty())
                {
                    lunghezza=null;
                }

                String larghezza = textLarghezzaM.getText();
                if (larghezza.trim().isEmpty())
                {
                    larghezza=null;
                }

                String peso = textPesoM.getText();
                if (peso.trim().isEmpty())
                {
                    peso=null;
                }

                String caricoMax = textCaricoMaxM.getText();
                if (caricoMax.trim().isEmpty())
                {
                    caricoMax=null;
                }

                String numPass = textNumPassM.getText();
                if (numPass.trim().isEmpty())
                {
                    numPass=null;
                }

                String numEq = textNumEqM.getText();
                if (numEq.trim().isEmpty())
                {
                    numEq=null;
                }

                String numMot = textNumMotM.getText();
                if (numMot.trim().isEmpty())
                {
                    numMot=null;
                }

                String data = textDataM.getText();
                if (data.trim().isEmpty())
                {
                    data=null;
                }

                String luogo = textLuogoM.getText();
                if (luogo.trim().isEmpty())
                {
                    luogo=null;
                }

                String note2 = textNote2M.getText();
                if (note2.trim().isEmpty())
                {
                    note2=null;
                }

                GestioneAzioni.modificaAereo( Integer.parseInt(textM.getText()), nome, CompagniaSelezionata.getId(), stato, note1, altezza, lunghezza, larghezza, peso, caricoMax, numPass, numEq, numMot, data, luogo, note2, connessione.getConnection());
             }
        });

        //----------------------------------ELIMINAZIONE-------------------------------------------------

        JLabel label4 = new JLabel("ELIMINAZIONE AEREO");
        label4.setFont(new Font("Arial", Font.BOLD, 25));
        label4.setHorizontalAlignment(JLabel.CENTER);
        jpanel4.add(label4, BorderLayout.NORTH);

        JLabel jLabelElimina = new JLabel("ID Aereo da eliminare");
        JTextField jTextFieldElimina = new JTextField(5);
        JButton btnElimina = new JButton("Elimina aereo");

            // Modifica solo l'altezza del JButton
        Dimension btnEliminaButtonSize = btnElimina.getPreferredSize();
        btnEliminaButtonSize.height = 40; // Imposta l'altezza desiderata
        btnElimina.setPreferredSize(btnEliminaButtonSize);

        jpanel4_1.add(jLabelElimina);
        jpanel4_1.add(jTextFieldElimina);
        jpanel4.add(btnElimina, BorderLayout.SOUTH);

        btnElimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GestioneAzioni.eliminaAereo(Integer.parseInt(jTextFieldElimina.getText()), connessione.getConnection());
            }
        });
    }
}