package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee {


    String firstName;
    String lastName;
    String startWorkDate;
    int seniority;
    double salary;
    Position position;

    public Employee(String firstName, String lastName,   String startWorkDate, double salary, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startWorkDate = startWorkDate;
        this.salary = salary;
        this.position = position;
    }

     String getSeniorityinYears() throws ParseException {
        SimpleDateFormat myDateFormat= new SimpleDateFormat("dd-MM-yyyy");

        long startWorkDateStamp = myDateFormat.parse(this.startWorkDate).getTime();
         long nowDate = new Date().getTime();

         long seniority = (nowDate - startWorkDateStamp)/1000/60/60/24/30/12;

         if(seniority<1){return "<1";}
         else{
            return ""+ seniority;}

     }

    public enum Position{
        JUNIOR_DEVELOPER, DEVELOPER,SENIOR_DEVELOPER, SCRUM_MASTER, PRODUCT_OWNER,SECOND_PROJECT_MANAGER, PROJECT_MANAGER;
    }


}
