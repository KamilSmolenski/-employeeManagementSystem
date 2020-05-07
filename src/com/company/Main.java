package com.company;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Comparator;

public class Main {
    public static void createAndShowGUI() {

        String[] headers = {"Imię", "Nazwisko", "Staż pracy","Wynagrodzenie","Stanowisko"};
        Object[][] workers = {{"Ana", "Smith", Integer.valueOf(19),Integer.valueOf(2000),"paź"},
                {"Alex", "Jones", Integer.valueOf(25),Integer.valueOf(223000),"paź"},
                {"Peggy", "Carter", Integer.valueOf(32),Integer.valueOf(2994000),"paź"},
                {"Pgy", "Cter", Integer.valueOf(32),Integer.valueOf(2990),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(12),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(124),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(126),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(222),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(212222),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29300),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(23),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(233900),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(2000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(24000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(29324000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(4000),"paź"},
                {"Pey", "Car", Integer.valueOf(32),Integer.valueOf(500),"paź"},
        };

        JTable table = new JTable(workers, headers);
        table.setAutoCreateRowSorter(true);
        table.setEnabled(false);




        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        int column = 3;
        sorter.setComparator(column, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        });
        table.setRowSorter(sorter);

        JButton btnAdd = new JButton("+");

        JButton btnAdd2 = new JButton("2+");








        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();

        panel2.add(btnAdd);

        panel2.add(btnAdd2);







        JFrame frame = new JFrame("Lista Pracowników");
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenDim.width / 2, screenDim.height / 2);
        frame.setLocation(screenDim.width / 4, screenDim.height / 4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.getContentPane().add(panel2,BorderLayout.LINE_START);

//        frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
