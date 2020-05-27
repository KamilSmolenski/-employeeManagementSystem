package com.company;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void createAndShowGUI() {


        String[] headers = {"Imię", "Nazwisko", "Staż pracy","Wynagrodzenie","Stanowisko"};
        Object[][] workers = {{"Ana", "Smith", Integer.valueOf(5),Integer.valueOf(10000),Position.MANAGER},
                {"Adam", "Miauczyński", Integer.valueOf(20),Integer.valueOf(2200),Position.SECOND_MANAGER},
                {"Jan", "Adam", Integer.valueOf(3),Integer.valueOf(6666),Position.PRODUCT_OWNER},
                {"Karol", "Zięba", Integer.valueOf(5),Integer.valueOf(8000),Position.SCRUM_MASTER},
                {"Jerzy", "Rutkowski", Integer.valueOf(1),Integer.valueOf(2300),Position.INTERN},
                {"Zenon", "Małysz", Integer.valueOf(15),Integer.valueOf(8500),Position.SENIOR_DEVELOPER},
                {"Wiktor", "Kowalski", Integer.valueOf(9),Integer.valueOf(6500),Position.DEVELOPER},
                {"Jakub" , "Nowak", Integer.valueOf(2),Integer.valueOf(4500),Position.JUNIOR_DEVELOPER},

        };


        DefaultTableModel model = new DefaultTableModel(workers,headers);
        JTable table = new JTable(model);

        table.setAutoCreateRowSorter(true);
        table.setEnabled(false);





        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());

        sorter.setComparator(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        });
        table.setRowSorter(sorter);
        sorter.setComparator(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        });
        table.setRowSorter(sorter);


        JButton btnAdd = new JButton("Nowy pracownik");
        JButton btnEdit = new JButton("Edytuj tabelę");
        JButton btnRemove= new JButton("Usuń");
        JButton btnSearch= new JButton("Wyszukaj");
        JButton btnFilter= new JButton("Filtruj po pensji");
        JButton btnSave= new JButton("Zapisz do pliku");
        JButton btnLoad= new JButton("Wczytaj z pliku");











        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();

        panel2.setLayout(new GridLayout(10,1,0,12));
        panel2.add(btnAdd);
        panel2.add(btnEdit);
        panel2.add(btnRemove);
        panel2.add(btnSearch);
        panel2.add(btnFilter);
        panel2.add(btnSave);
        panel2.add(btnLoad);


        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Dodaj pracownika");
                Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
                frame2.setSize(screenDim.width / 5, screenDim.height / 4);
                frame2.setLocation(screenDim.width / 4, screenDim.height / 4);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.setVisible(true);

                JPanel addingNew= new JPanel();
                JPanel addingNewBtn= new JPanel();

                frame2.getContentPane().add(addingNew,BorderLayout.CENTER);
                frame2.getContentPane().add(addingNewBtn,BorderLayout.AFTER_LAST_LINE);



                JTextField name = new JTextField("Imię",20);
                JTextField lastName = new JTextField("Nazwisko",20);
                JTextField seniority = new JTextField("Staż pracy",20);
                JTextField salary = new JTextField("Wynagrodzenie",20);
                JComboBox position = new JComboBox(Position.values());
                position.addActionListener(e1 -> { Position item = (Position)position.getSelectedItem();

                });

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

                    }
                });

                add.addActionListener(new ActionListener() {
                    boolean wrongDatas;
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        try{ model.addRow(new Object[]{
                               name.getText(),
                               lastName.getText(),
                               Integer.valueOf(seniority.getText()),
                               Integer.valueOf( salary.getText()),
                               position.getSelectedItem()
                       }

                       );
                            wrongDatas = false;}
                       catch(NumberFormatException exception){
                           JOptionPane.showMessageDialog(frame2,"Pole STAŻ PRACY  i WYNAGRODZENIE nie mogą zawierać znaków innych niż 0-9  ","Wprowadzono błędne dane", JOptionPane.INFORMATION_MESSAGE);
                            wrongDatas = true;
                        }

                        if(!wrongDatas){
                        System.out.println("Dodano");
                        JOptionPane.showMessageDialog(frame2,"Dodano nowego pracownika","Lista zostałą zaktualizowana", JOptionPane.INFORMATION_MESSAGE);
                        frame2.dispatchEvent(new WindowEvent(frame2, WindowEvent.WINDOW_CLOSING));}
                    }
                });


            }
        });

        AtomicBoolean isEditable = new AtomicBoolean(false);
        btnEdit.addActionListener(e -> {

            if(isEditable.get() == true){
                table.setEnabled(false);
                btnEdit.setText("Edytuj tabelę");
                isEditable.set(false);


            }else {
            table.setEnabled(true);
            btnEdit.setText("Wyłącz edycję");
            isEditable.set(true);}





        });

        btnRemove.addActionListener(e -> {
            int selected = 0;
            if (isEditable.get() == false) {
                JOptionPane.showMessageDialog(table, "Aby usunąć pracownika, włącz możliwość edycji tabeli, zaznacz rekord, który chcesz usunąć i ponownie kliknij USUŃ ", "Włącz tryb edycji", JOptionPane.WARNING_MESSAGE);
            } else {
                selected = table.getSelectedRow();
                ((DefaultTableModel) table.getModel()).removeRow(selected);
                JOptionPane.showMessageDialog(table,    table.getModel().getValueAt(selected,0) +" "+ table.getModel().getValueAt(selected,1 ) + " został/a usunięty/a.", "Pracownik usunięty", JOptionPane.WARNING_MESSAGE);
            }



        });

        btnSearch.addActionListener(e -> {
            JFrame searchFrame = new JFrame("Wyszukaj");
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            searchFrame.setSize(screenDim.width / 5, screenDim.height / 10);
            searchFrame.setLocation(screenDim.width / 4, screenDim.height / 4);
            searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            searchFrame.setVisible(true);

            JTextField searchField = new JTextField(15);
            JButton searchBtn = new JButton("Szukaj");
            JPanel searchPanel = new JPanel();
            searchPanel.add(searchField);
            searchPanel.add(searchBtn);
            searchFrame.getContentPane().add(searchPanel,BorderLayout.CENTER);

            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchField.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            search(searchField.getText());
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            search(searchField.getText());
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            search(searchField.getText());
                        }
                        public void search(String str) {
                            if (str.length() == 0) {
                                sorter.setRowFilter(null);
                            } else {
                                sorter.setRowFilter(RowFilter.regexFilter(str));
                            }
                        }
                    });
                }
            });

        });

        btnFilter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame filteringFrame = new JFrame("Filtruj po pensji");
                Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
                filteringFrame.setSize(screenDim.width / 5, screenDim.height / 4);
                filteringFrame.setLocation(screenDim.width / 4, screenDim.height / 4);
                filteringFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                filteringFrame.setVisible(true);

                JRadioButton greaterThan = new JRadioButton();
                greaterThan.setText("ponad");

                JRadioButton lessThan  = new JRadioButton();
                lessThan.setText("poniżej");
                lessThan.isSelected();

                ButtonGroup G = new ButtonGroup();
                lessThan.setFont(new Font("SansSerif",Font.ITALIC,18));
                greaterThan.setFont(new Font("SansSerif",Font.ITALIC,18));
                G.add(greaterThan);
                G.add(lessThan);

                JSlider slider = new JSlider(JSlider.HORIZONTAL,0,10000,5);
                slider.setPaintLabels(true);
                Dimension d = slider.getPreferredSize();
                slider.setPreferredSize(new Dimension(d.width + 100, d.height));

                JTextField sliderValue = new JTextField(""+ slider.getValue(),5);
                sliderValue.setFont(new Font("SansSerif",Font.BOLD,23));
                sliderValue.setEditable(true);
                sliderValue.setSize(200,10);
                slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        sliderValue.setText(""+((JSlider) e.getSource()).getValue());
                    }
                });

                JButton filterBtn = new JButton("Filtruj");



                JPanel filterPanel = new JPanel();
                JPanel filterPanel2 = new JPanel();
                JPanel filterPanel3 = new JPanel();

                filterPanel.add(greaterThan);
                filterPanel.add(lessThan);
                filterPanel2.add(slider);
                filterPanel2.add(sliderValue);
                filterPanel3.add(filterBtn);

                filteringFrame.getContentPane().add(filterPanel,BorderLayout.BEFORE_FIRST_LINE);
                filteringFrame.getContentPane().add(filterPanel2,BorderLayout.CENTER);
                filteringFrame.getContentPane().add(filterPanel3,BorderLayout.AFTER_LAST_LINE);


                    filterBtn.addActionListener(new ActionListener() {

                        boolean filter = true;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Number number = Integer.valueOf(sliderValue.getText());
                            int column = 3;

                            if (greaterThan.isSelected()){
                                if(filter)

                                    sorter.setRowFilter(RowFilter.numberFilter(
                                        RowFilter.ComparisonType.AFTER,number,column

                                ));
                            else
                                sorter.setRowFilter(null);
                                filter=!filter;


                            } else if (lessThan.isSelected()){
                                if(filter)
                                    sorter.setRowFilter(RowFilter.numberFilter(
                                            RowFilter.ComparisonType.BEFORE,number,column
                                    ));
                                else
                                    sorter.setRowFilter(null);
                                filter=!filter;


                            }else if(!greaterThan.isSelected() && !lessThan.isSelected()){
                                JOptionPane.showMessageDialog(table,"Nie zaznaczono ponad/poniżej","Określ kryteria filtrowania", JOptionPane.INFORMATION_MESSAGE);
                            }

                            if (filter) {
                                filterBtn.setText("Filtruj");
                            } else {
                                filterBtn.setText("Cofnij filtr");
                            }


                        }
                    });



            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("listaPracowników.txt");
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(file);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                for(int row = 0; row < table.getRowCount(); row++) {

                    for(int column = 0; column < table.getColumnCount(); column++) {
                        writer.print(table.getColumnName(column) + ": ");
                        writer.println(table.getValueAt(row, column));
                    }
                    writer.println(""); // Add line space
                }
                writer.close();

                JOptionPane.showMessageDialog(table,"Lista została zapisana w: " + file.getAbsolutePath(),"Zapisano", JOptionPane.INFORMATION_MESSAGE);
            }


        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



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

//       frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
