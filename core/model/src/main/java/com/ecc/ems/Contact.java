package com.ecc.ems;

import java.util.List;

public class Contact extends BaseEntity{
    private String contactType;
    private String contactDetails;
    private int empId;
    
    public Contact() {}
    
    public Contact(String contactType, String contactDetails, int empId, boolean status) {
        super(status);
        this.contactType = contactType;
        this.empId = empId;
        this.contactDetails = contactDetails;    
    }
    
    public String getContactType() {
        return contactType;
    }
    
    public String getContactDetails() {
        return contactDetails;
    }
    
    public int getEmpId() {
        return empId;
    }
    
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    public String stringify(){
        return "\t" + this.contactType + ": " + this.contactDetails; 
    }
}
