import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame();
        JPanel jPanel0 = new JPanel(new GridLayout(2,2));
        JPanel jPanel1 = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JPanel jPanel4 = new JPanel(new BorderLayout());

        jPanel0.add(jPanel1);
        jPanel0.add(jPanel2);
        jPanel0.add(jPanel3);
        jPanel0.add(jPanel4);
        jFrame.add(jPanel0);
        jFrame.setVisible(true);

        JTextArea jTextArea1 = new JTextArea();
        JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
        JTextArea jTextArea2 = new JTextArea();
        JScrollPane jScrollPane2 = new JScrollPane(jTextArea2);
        JTextArea jTextArea3 = new JTextArea();
        JScrollPane jScrollPane3 = new JScrollPane(jTextArea3);
        JTextArea jTextArea4 = new JTextArea();
        JScrollPane jScrollPane4 = new JScrollPane(jTextArea4);

        jPanel1.add(BorderLayout.CENTER, jScrollPane1);
        jPanel2.add(BorderLayout.CENTER, jScrollPane2);
        jPanel3.add(BorderLayout.CENTER, jScrollPane3);
        jPanel4.add(BorderLayout.CENTER, jScrollPane4);

        JLabel jLabel1 = new JLabel("prova1");
        JLabel jLabel2 = new JLabel("prova2");
        JLabel jLabel3 = new JLabel("prova3");
        JLabel jLabel4 = new JLabel("prova4");

        jPanel1.add(BorderLayout.NORTH, jLabel1);
        jPanel2.add(BorderLayout.NORTH, jLabel2);
        jPanel3.add(BorderLayout.NORTH, jLabel3);
        jPanel4.add(BorderLayout.NORTH, jLabel4);

        JButton jButton1 = new JButton("prova1");
        JButton jButton2 = new JButton("prova2");
        JButton jButton3 = new JButton("prova3");
        JButton jButton4 = new JButton("prova4");

        jPanel1.add(BorderLayout.SOUTH, jButton1);
        jPanel2.add(BorderLayout.SOUTH, jButton2);
        jPanel3.add(BorderLayout.SOUTH, jButton3);
        jPanel4.add(BorderLayout.SOUTH, jButton4);
    }
}