public class prova {
}

public class MainForm extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JCheckBox checkBox;
    private JTextArea textArea;
    private JButton button;

    public MainForm() {
        setTitle("Form Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // JLabel
        label = new JLabel("Enter text:");
        add(label);

        // JTextField
        textField = new JTextField();
        add(textField);

        // JCheckBox
        checkBox = new JCheckBox("Enable TextArea");
        checkBox.addActionListener(this);
        add(checkBox);

        // JTextArea
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // JButton
        button = new JButton("Submit");
        button.addActionListener(this);
        add(button);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBox) {
            textArea.setEditable(checkBox.isSelected());
        } else if (e.getSource() == button) {
            String inputText = textField.getText();
            textArea.append(inputText + "\n");
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        MainForm form = new MainForm();
        form.setVisible(true);
    }
}

    String selectedOption = (String) comboBox.getSelectedItem();
    A

            ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

// Rimuove l'elemento al secondo indice
        lista.remove(1);

        System.out.println(lista); // Output: [Elemento 1, Elemento 3]

// Rimuove l'elemento "Elemento 3"
        lista.remove("Elemento 3");

        System.out.println(lista); // Output: [Elemento 1]
