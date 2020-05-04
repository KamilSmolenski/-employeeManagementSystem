package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

public class Main {



    public static void main(String[] args) throws ParseException {



        Employee no1 = new Employee("Jan","Kowalski","27-03-2020",10000, Employee.Position.JUNIOR_DEVELOPER);
        Employee no2 = new Employee("Adam","Miauczyński","15-07-1991",2222, Employee.Position.SECOND_PROJECT_MANAGER);
        System.out.println(no1.getSeniorityinYears());
        System.out.println(no2.getSeniorityinYears());


}};
