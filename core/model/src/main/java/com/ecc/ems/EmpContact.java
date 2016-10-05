package com.ecc.ems;

public class EmpContact extends Contact{
    private String details;
    
    public EmpContact() {}
    
    public EmpContact(String type, String details, boolean status) {
        super(type, status);
        this.details = details;    
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public String stringfy(){
        return super.getType() + ": " + this.getDetails();
    }
}
