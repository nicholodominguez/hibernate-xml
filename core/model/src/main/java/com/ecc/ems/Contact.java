package com.ecc.ems;

public class Contact extends BaseEntity{
    private String type;
    
    public Contact() {}
    
    public Contact(int id, String type, boolean status) {
        super(id, status);
        this.type = type;    
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
