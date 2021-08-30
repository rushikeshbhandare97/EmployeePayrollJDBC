package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 
 * Ability to create a payroll service
 * database and have java program
 * connect to database
 */
public class EmployeePayrollDBService {
    //main method
    public static void main(String[] args) {
        System.out.println("welcome to JDBC Connection");
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String username = "root";
        String password = "Database@1234";

        Connection connection = null;
        try {
            System.out.println("connecting to database : "+ jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection to the Database Successfully! :" + connection);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            System.out.println(driverList.nextElement());
        }
    }
}
