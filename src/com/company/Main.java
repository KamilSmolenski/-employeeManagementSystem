package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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


        DefaultTableModel model = new DefaultTableModel(workers,headers);
        JTable table = new JTable(model);

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

        JButton btnAdd = new JButton("Nowy pracownik");










        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();

        panel2.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Dodaj pracownika");
                Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
                frame2.setSize(screenDim.width / 4, screenDim.height / 4);
                frame2.setLocation(screenDim.width / 4, screenDim.height / 4);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setVisible(true);

                JPanel addingNew= new JPanel();
                JPanel addingNewBtn= new JPanel();

                frame2.getContentPane().add(addingNew,BorderLayout.CENTER);
                frame2.getContentPane().add(addingNewBtn,BorderLayout.AFTER_LAST_LINE);


                JTextField name = new JTextField("Imię",20);
                JTextField lastName = new JTextField("Nazwisko",20);
                JTextField seniority = new JTextField("Staż pracy",20);
                JTextField salary = new JTextField("Wynagrodzenie",20);
                JTextField position = new JTextField("Stanowisko",20);

                addingNew.add(name);
                addingNew.add(lastName);
                addingNew.add(seniority);
                addingNew.add(salary);
                addingNew.add(position);

                JButton add = new JButton("Dodaj");
                addingNewBtn.add(add);

                name.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(name.getText().equals("Imię"))
                        name.setText("");
                    }
                });lastName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(lastName.getText().equals("Nazwisko"))
                        lastName.setText("");
                    }
                });seniority.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(seniority.getText().equals("Staż pracy"))
                        seniority.setText("");
                    }
                });salary.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(salary.getText().equals("Wynagrodzenie"))
                        salary.setText("");
                    }
                });position.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(position.getText().equals("Stanowisko"))
                        position.setText("");
                    }
                });

                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        model.addRow(new Object[]{
                                name.getText(),
                                lastName.getText(),
                                Integer.valueOf(seniority.getText()),
                                Integer.valueOf( salary.getText()),
                                position.getText()
                        });
                    }
                });


            }
        });








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
