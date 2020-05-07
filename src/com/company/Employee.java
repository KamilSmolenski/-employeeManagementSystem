//package com.company;
//
//import javax.swing.table.DefaultTableModel;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//public class Employee {
//    String getSeniorityinYears() throws ParseException {
//
//        SimpleDateFormat myDateFormat= new SimpleDateFormat("dd-MM-yyyy");
//
//        long startWorkDateStamp = myDateFormat.parse(this.startWorkDate).getTime();
//        long nowDate = new Date().getTime();
//
//        long seniorityStampToYears = (nowDate - startWorkDateStamp)/1000/60/60/24/30/12;
//
//
//
//        if(seniorityStampToYears<1){return "<1";}
//        else{
//            return ""+ seniorityStampToYears;}
//
//    }
//
//
//    public static void addEmployee(String name, String lastName, String seniority, String salary, Employee.Position position)  {
//        DefaultTableModel model = (DefaultTableModel) Main.table.getModel();
//        model.addRow(new Object[]{name, lastName, seniority,salary,position});
//    }
//
//    String firstName;
//    String lastName;
//    String startWorkDate;
//    String seniority;
//    double salary;
//    Position position;
//
//    public Employee(String firstName, String lastName,   String startWorkDate, double salary, Position position) throws ParseException {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.startWorkDate = startWorkDate;
//        this.salary = salary;
//        this.position = position;
//    }
//
//
//
//    public enum Position{
//        JUNIOR_DEVELOPER, DEVELOPER,SENIOR_DEVELOPER, SCRUM_MASTER, PRODUCT_OWNER,SECOND_PROJECT_MANAGER, PROJECT_MANAGER;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getStartWorkDate() {
//        return startWorkDate;
//    }
//
//    public void setStartWorkDate(String startWorkDate) {
//        this.startWorkDate = startWorkDate;
//    }
//
//
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
//}
