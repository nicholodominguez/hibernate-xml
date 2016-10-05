package com.ecc.ems;

public class Contact extends BaseEntity{
    protected String type;
    
    public Contact() {}
    
    public Contact(String type, boolean status) {
        super(status);
        this.type = type;    
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
