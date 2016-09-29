package com.ecc.ems;

import java.util.Date;
import java.util.List;
import com.ecc.ems.Name;
import com.ecc.ems.Address;

public class Employee extends BaseEntity implements Comparable<Employee>{
    private Name name;
    private Address address;
    private Date bdate;
    private double gwa;
    private Date dateHired;
    private List roles;
    
    public Employee() {}
    
    public Employee(int id, Address address, Date bdate, double gwa, Date dateHired, List roles, boolean status) {
        super(id, status);
        this.address = address;
        this.bdate = bdate;
        this.gwa = gwa;
        this.dateHired = dateHired;    
        this.roles = roles;    
    }
    
    public Name getName() {
        return name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public Date getbdate() {
        return bdate;
    }
    
    public double getGwa() {
        return gwa;
    }
    
    public Date getDateHired() {
        return dateHired;
    }
    
    public List getRoles() {
        return roles;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void setbdate(Date bdate) {
        this.bdate = bdate;
    }
    
    public void setGwa(double gwa) {
        this.gwa = gwa;
    }
    
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
    
    public void setRoles(List roles) {
        this.roles = roles;
    }
    
    public double compareTo(Employee compareEmp) {
		double compareGwa = ((Employee) compareEmp).getGwa();
		return (this.getGwa - compareGwa);
	}
}
