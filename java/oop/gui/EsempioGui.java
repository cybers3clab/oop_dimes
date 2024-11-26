package oop.gui;

import javax.swing.*;
import java.awt.event.*;

public class EsempioGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Esempio di GUI");
        JPanel panel = new JPanel();
        JButton button = new JButton("Cliccami!");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hai cliccato il pulsante!");
            }
        });

        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}