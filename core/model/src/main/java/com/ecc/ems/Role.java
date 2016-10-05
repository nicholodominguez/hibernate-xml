package com.ecc.ems;

public class Role extends BaseEntity{
    protected String name;
    
    public Role() {}
    
    public Role(String name, boolean status) {
        super(status);
        this.name = name;    
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
