package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 
 * Ability to create a payroll service
 * database and have java program
 * connect to database
 * Ability for Employee Payroll
 * Service to retrieve the Employee
 * Payroll from the Database
 */
public class EmployeePayrollDBService {
    //main method
    public static void main(String[] args) {
        System.out.println("welcome to JDBC Connection");
    // connecting with mysql throw port number and database name
    public Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String username = "root";
        String password = "Password@1234";

/**
 * Check if the Driver Class is available for the java
 * program
 * Check all the drivers registered with the jdbc driver
 * Check if the database connection to payroll_service
 * mysql DB is established
 */
        Connection connection = null;
        try {
            System.out.println("connecting to database : "+ jdbcURL);
            System.out.println("connecting to database : " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection to the Database Successfully! :" + connection);
            Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver Loaded");
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        listDrivers();
        return connection;
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            System.out.println(driverList.nextElement());
            Driver driverClass = driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }

    /**
     *
     * @return Using JDBC read the employee payroll data from the
     * database
     */
    public ArrayList<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM employee_payroll";
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double BasicPay = resultSet.getDouble("salary");
                //Add Start Data to EmployeePayroll Class and ensure backward compatibility
                LocalDate startDate = resultSet.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, BasicPay, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}
