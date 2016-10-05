package com.ecc.ems;

class BaseEntity{
    protected int id;
    protected boolean status;
    
    public BaseEntity() {}
    
    public BaseEntity(boolean status) {
        this.status = status;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus(){
        return status;
    }
}
