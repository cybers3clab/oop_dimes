package oop.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWidgetsExample {

    public static void main(String[] args) {
        // Crea la finestra principale (JFrame)
        JFrame frame = new JFrame("Esempio con i principali widget di Swing");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea il pannello principale (JPanel) con layout BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Creazione dei componenti
        JLabel label = new JLabel("Benvenuto nell'esempio di Java Swing!");
        JTextField textField = new JTextField("Scrivi qualcosa...");
        JButton button = new JButton("Clicca qui");
        JComboBox<String> comboBox = new JComboBox<>(new String[] {"Opzione 1", "Opzione 2", "Opzione 3"});
        JCheckBox checkBox = new JCheckBox("Accetta termini e condizioni");
        JRadioButton radioButton1 = new JRadioButton("Opzione A");
        JRadioButton radioButton2 = new JRadioButton("Opzione B");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        JList<String> list = new JList<>(new String[] {"Item 1", "Item 2", "Item 3"});
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Layout per i componenti
        JPanel northPanel = new JPanel();
        northPanel.add(label);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));
        centerPanel.add(textField);
        centerPanel.add(button);
        centerPanel.add(comboBox);
        centerPanel.add(checkBox);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        southPanel.add(radioPanel);
        southPanel.add(list);

        // Aggiungi i componenti al pannello principale
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);

        // Aggiungi il JTextArea nella parte centrale con scroll
        panel.add(scrollPane, BorderLayout.EAST);

        // Aggiungi il pannello principale al JFrame
        frame.add(panel);

        // Azione del pulsante
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                String selectedCombo = (String) comboBox.getSelectedItem();
                boolean isChecked = checkBox.isSelected();
                String selectedRadio = radioButton1.isSelected() ? "Opzione A" : (radioButton2.isSelected() ? "Opzione B" : "Nessuna opzione");
                String selectedList = list.getSelectedValue();

                // Mostra un messaggio con i risultati
                JOptionPane.showMessageDialog(frame,
                        "Testo inserito: " + inputText + "\n" +
                                "Opzione scelta: " + selectedCombo + "\n" +
                                "CheckBox: " + (isChecked ? "Accettato" : "Non accettato") + "\n" +
                                "RadioButton selezionato: " + selectedRadio + "\n" +
                                "Elemento selezionato nella lista: " + selectedList);
            }
        });

        // Mostra la finestra
        frame.setVisible(true);
    }
}