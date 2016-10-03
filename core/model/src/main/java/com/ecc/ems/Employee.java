package com.ecc.ems;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.Comparable;

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
    
    public Date getBdate() {
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
    
    public void setBdate(Date bdate) {
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
    
    public int compareTo(Employee compareEmp) {
		double compareGwa = ((Employee) compareEmp).getGwa();
		return (int)(this.getGwa() - compareGwa);
	}
	
	public List<String> stringify() {
	    DateFormat df = new SimpleDateFormat("MMM/dd/yyyy");
	    ArrayList<String> list = new ArrayList();
	    
	    list.add("Name: " + this.name.getFullname());
	    list.add("Address: " + this.address.toString());
	    list.add("Birthdate: " + df.format(this.getBdate()));
        list.add("GWA: " + String.valueOf(this.getGwa()));	
        list.add("Date Hired: " + df.format(this.getDateHired()));	
        
        return list;
	}
}
