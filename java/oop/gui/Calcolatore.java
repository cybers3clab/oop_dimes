package oop.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcolatore {
    private JFrame frame;
    private JTextField display;
    private StringBuilder input;

    public Calcolatore() {
        frame = new JFrame("Calcolatore");
        display = new JTextField();
        input = new StringBuilder();
        createUI();
    }

    private void createUI() {
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")) {
                input.setLength(0);  // Reset input
                display.setText("");
            } else if (command.equals("=")) {
                try {
                    double result = evaluate(input.toString());
                    display.setText(String.valueOf(result));
                    input.setLength(0);  // Clear input after evaluation
                } catch (Exception ex) {
                    display.setText("Errore");
                }
            } else {
                input.append(command);
                display.setText(input.toString());
            }
        }
    }

    private double evaluate(String expression) {
        // Logica di valutazione dell'espressione
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double nextNumber = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += nextNumber;
                    break;
                case "-":
                    result -= nextNumber;
                    break;
                case "*":
                    result *= nextNumber;
                    break;
                case "/":
                    if (nextNumber != 0) {
                        result /= nextNumber;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calcolatore::new);
    }
}