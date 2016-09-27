package com.ecc.ems;

class BaseEntity{
    private int id;
    private boolean status;
    
    public BaseEntity() {}
    
    public BaseEntity(int id, boolean status) {
        this.id = id;
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
