package com.ecc.ems;

public class Address{
    private String street;
    private String brgy;
    private String municipality;
    private String zipcode;
    private String country;
    
    public Address() {}
    
    public Address(String street, String brgy, String municipality, String zipcode, String country) {    
        this.street = street;
        this.brgy = brgy;
        this.municipality = municipality;
        this.zipcode = zipcode;
        this.country = country;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getBrgy() {
        return brgy;
    }
    
    public String getMunicipality() {
        return municipality;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public void setBrgy(String brgy) {
        this.brgy = brgy;
    }
    
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String toString() {
        return this.street + ", " + this.brgy + ", " + this.municipality + ", " + this.zipcode + ", " + this.country;
    
    }
}
