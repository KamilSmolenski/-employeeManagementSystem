package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main extends JFrame {


        public Main()   {

            initComponents();
    }
    public static void initComponents()  {
          JFrame mainFrame = new JFrame("Lista Pracowników");
          Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
          mainFrame.setSize(screenDim.width/2,screenDim.height/2);
          mainFrame.setLocation(screenDim.width/4,screenDim.height/4);
          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          mainFrame.setVisible(true);

        String[] columns = {"Imię", "Nazwisko","Staż pracy", "Wynagrodzenie","Stanowisko"};
        Object[][] items ={
                {"Jan","Kowalski","2","5000","Junior"},
                {"Jan","Kowalski","4","3000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","Kowalski","5","7000","Junior"},
                {"Jan","KoZA","5","7000","Junior"},

        };



        JTable table = new JTable(items,columns);
        table.setEnabled(false);

        JScrollPane  scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) ;

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(table.getTableHeader(),BorderLayout.CENTER);
//        panel.add(table,BorderLayout.CENTER);
        panel.add(scrollPane,BorderLayout.CENTER);

        mainFrame.setContentPane(panel);

        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }





    public static void main(String[] args)  {
            new Main();







//
//        ITERATOR WYSWIETLAJACY PO KOLEJI NP IMIONA
//
//        Iterator<Employee> employeeIterator = listofEmployers.iterator();
//        while (employeeIterator.hasNext()){
//            System.out.println(employeeIterator.next().getFirstName());
//        }
            ///
        //// to Samo tylko, że szybciej
//        for(Employee e :listofEmployers){
//            System.out.println(e.getLastName());
//        }


}};
