package com.bridgelabz;
import java.time.LocalDate;
//creating a class
public class EmployeePayrollData {
    //variables
    public int id;
    public String name;
    public double basicPay;
    public LocalDate start;
//creating a constructor
    public EmployeePayrollData(int id, String name, double basic_pay, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.basicPay = basic_pay;
        this.start = startDate;
    }
} 
