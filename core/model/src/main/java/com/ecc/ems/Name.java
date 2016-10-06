package com.ecc.ems;

public class Name{
    private String firstname;
    private String middlename;
    private String lastname;
    private String suffix;
    private String title;
    
    public Name() {}
    
    public Name(String firstname, String middlename, String lastname, String suffix, String title) {    
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.suffix = suffix;
        this.title = title;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getMiddlename() {
        return middlename;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getFullname() {
        return this.getTitle() + " " + this.getFirstname() + " " + this.getMiddlename() + " " + this.getLastname() + ", " + this.getSuffix(); 
    }
    
    public List stringify(){
        ArrayList<String> list = new ArrayList();
	    
	    list.add("Title: " + this.getTitle());
	    list.add("Firstname: " + this.getFirstname());
	    list.add("Middlename: " + this.getMiddlename());
	    list.add("Lastname: " + this.getLastname());
	    list.add("Suffix: " + this.getMiddlename());	
        
        return list;
    }
}
