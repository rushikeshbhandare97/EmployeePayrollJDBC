package com.bridgelabz;
import java.time.LocalDate;
import java.util.Objects;

//creating a class
public class EmployeePayrollData {
    //variables
    public int id;
    public String name;
    public double basicPay;
    public double salary;
    public LocalDate start;
//creating a constructor
    public EmployeePayrollData(int id, String name, double basic_pay, LocalDate startDate) {
    // creating a constructor
    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.basicPay = basic_pay;
        this.salary = salary;
        this.start = startDate;
    }
    @Override
    public String toString() {
        return "EmployeePayrollData{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + ", startDate="
                + start + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name);
    }
} 
