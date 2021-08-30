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
    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa");
        Assert.assertTrue(result);
    }
}
