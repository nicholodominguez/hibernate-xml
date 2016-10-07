package com.ecc.ems;

import java.util.List;
import java.util.ArrayList;

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
        String result = "";
        
        if(this.getTitle() != null){
	        result = result.concat(this.getTitle());
	    }
	    
	    if(this.getFirstname() != null){
	        result = result.concat(" ").concat(this.getFirstname());
	    }
	    
	    if(this.getMiddlename() != null){
	        result = result.concat(" ").concat(this.getMiddlename());
	    }
	    
	    if(this.getLastname() != null){
	        result = result.concat(" ").concat(this.getLastname());
	    }
	    
	    if(this.getSuffix() != null){
	        result = result.concat(", ").concat(this.getSuffix());
	    }
	    
	    return result;
    }
    
    public List<String> stringify(){
        ArrayList<String> list = new ArrayList();
	    
	    if(this.getTitle() != null){
	        list.add("Title: " + this.getTitle());
	    }
	    else{
	        list.add("Title: ");
	    }
	    
	    if(this.getFirstname() != null){
	        list.add("Firstname: " + this.getFirstname());
	    }
	    else{
	        list.add("Firstname: ");
	    }
	    
	    if(this.getMiddlename() != null){
	        list.add("Middlename: " + this.getMiddlename());
	    }
	    else{
	        list.add("Middlename: ");
	    }
	    
	    if(this.getLastname() != null){
	        list.add("Lastname: " + this.getLastname());
	    }
	    else{
	        list.add("Lastname: ");
	    }
	    
	    if(this.getSuffix() != null){
	        list.add("Suffix: " + this.getSuffix());	
        }
        else{
            list.add("Suffix: ");
        }
        
        return list;
    }
}
