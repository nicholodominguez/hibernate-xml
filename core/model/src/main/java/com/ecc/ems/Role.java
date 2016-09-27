package com.ecc.ems;

public class Role extends BaseEntity{
    private String name;
    
    public Role() {}
    
    public Role(int id, String name, boolean status) {
        super(id, status);
        this.name = name;    
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
