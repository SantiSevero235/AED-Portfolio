package uy.edu.ucu.aed.pd3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester {
    private JFrame frame;
    private JComboBox<String> comboBox;
    private ArrayListComboBoxModel model;

    public Tester(String[] args) {
        frame = new JFrame("ArrayListComboBoxModel Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        model = new ArrayListComboBoxModel();
        for (String arg : args) {
            model.addElement(arg);
        }

        comboBox = new JComboBox<>(model);
        frame.add(comboBox, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newItem = JOptionPane.showInputDialog("Enter new item:");
                if (newItem != null && !newItem.trim().isEmpty()) {
                    model.addElement(newItem);
                }
            }
        });
        panel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemToRemove = (String) comboBox.getSelectedItem();
                if (itemToRemove != null) {
                    model.removeElement(itemToRemove);
                }
            }
        });
        panel.add(removeButton);

        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tester(args);
    }
}

// Para compilar y ejecutar el código, use los siguientes comandos en la terminal:
//
// Compilación:
// javac src/main/java/uy/edu/ucu/aed/pd3/*.java
//
// Ejecución:
// java -cp src/main/java uy.edu.ucu.aed.pd3.Tester Jim Joe Mary
