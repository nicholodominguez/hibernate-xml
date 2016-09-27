package com.ecc.ems;

import com.ecc.ems.Employee;
import java.util.List;

public interface EmployeeManagementDAO{
    public String addEmployee(Employee emp);
    public List listEmployee();

}
