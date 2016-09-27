package com.ecc.ems;

public class EmpAttribute extends BaseEntity{
    private int attrId;
    
    public EmpAttribute() {}
    
    public EmpAttribute(int empId, int attrId, boolean status) {
        super(empId, status);
        this.attrId = attrId;
    }
    
    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }
}
