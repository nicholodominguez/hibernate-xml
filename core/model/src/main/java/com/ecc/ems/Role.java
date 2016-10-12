package com.ecc.ems;

import java.util.Set;
import com.ecc.ems.Employee;

public class Role extends BaseEntity{
    protected String name;
    protected Set<Employee> employees;
    
    public Role() {}
    
    public Role(String name, boolean status) {
        super(status);
        this.name = name;    
    }
    
    public String getName() {
        return name;
    }
    
    public Set<Employee> getEmployees() {
        return employees;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
