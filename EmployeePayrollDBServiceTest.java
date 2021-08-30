package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class EmployeePayrollDBServiceTest {
    //we are checking the employee count Equals 4 = 4;
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
        Assert.assertEquals(3, employeePayrollDataList.size());
    }
    //we are checking the employee count NotSame 4 = 6;
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldNotMatchEmployeeCount() {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
        Assert.assertNotSame(6, employeePayrollDataList.size());
    }
}
