package uy.edu.ucu.aed.pd3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Tester {
    private JFrame frame;
    private SortedListModel model;
    private JList<String> list;
    private JButton printButton;

    public Tester(String[] args) {
        frame = new JFrame("Sorted List Model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        model = new SortedListModel();
        for (String arg : args) {
            model.addElement(arg);
        }

        list = new JList<>(model);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        printButton = new JButton("Print Elements");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printAction();
            }
        });
        panel.add(printButton);
        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void printAction() {
        Iterator<String> iterator = model.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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
// java -cp src/main/java uy.edu.ucu.aed.pd3.Tester One Two Three Four Five Six Seven Eight Nine Ten
