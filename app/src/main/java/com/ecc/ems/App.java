package com.ecc.ems;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Set;

import com.ecc.ems.EmployeeService;
import com.ecc.ems.Employee;
import com.ecc.ems.Name;
import com.ecc.ems.Address;
import com.ecc.ems.Contact;
import com.ecc.ems.Role;
import com.ecc.ems.InputValidator;

public class App{
    public static void main(String args[]) {
         
        EmployeeService em = new EmployeeService();
        int choice;
        
        do{
            choice = App.printMenu();
            switch(choice) {
                case 1:
                    Employee emp = new Employee();
                    
                    App.editEmployee(em, emp);
                    break;
                case 2:
                    App.printEmployees(em);
                    break;
                case 3:
                    //emp = App.searchEmployee("edit");
                    
                    //App.editEmployee(empId);
                    break;
                case 4:
                    //emp = App.searchEmployee("delete");
                    
                    //App.editEmployee(empId);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 8);
    }
    
    public static int printMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("|----------------------------|");
        System.out.println("| Employee Management System |");
        System.out.println("|----------------------------|");
        System.out.println("| [1] Add Employee           |");
        System.out.println("| [2] List Employee          |");
        System.out.println("| [3] Edit Employee          |");
        System.out.println("| [4] Delete Employee        |");
        System.out.println("|                            |");
        System.out.println("|----------------------------|");
        System.out.println("| Role Management System     |");
        System.out.println("|----------------------------|");
        System.out.println("| [5] Add Role               |");
        System.out.println("| [6] Edit Role              |");
        System.out.println("| [7] Delete Role            |");
        System.out.println("|                            |");
        System.out.println("|----------------------------|");
        System.out.println("| [8] Exit                   |");
        System.out.println("==============================");
        return InputValidator.getInputMenu(" Option: ", 8);
    }
    
    public static int printAddEmployeeMenu(Employee emp) {
        System.out.println();
        System.out.println("============================");
        System.out.println(" Employee Creation          ");
        System.out.println("============================");
        printEmployeeInfo(emp, true);
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 9);
    }
    
    public static void printEmployeeInfo(Employee emp, boolean isMenu) {
        List<String> empInfo = emp.stringify();
        Set<Contact> empContactInfo = emp.getContacts();
        Set<Role> empRoleInfo = emp.getRoles();
        int i = 1;
        
        System.out.println();
        for(; i <= empInfo.size(); i++){
            if(isMenu){
                System.out.print("[" + i + "] "); 
            }
            System.out.println(empInfo.get(i-1));    
        }
        
        if(isMenu){
            System.out.print("[" + i++ + "] "); 
        }
        System.out.println("Contacts:");
        
        if(empContactInfo != null){
            for(Contact contact : empContactInfo){
                System.out.println("\t" + contact.getContactType() + ": " + contact.getContactDetails());  
            }
        }
        
        if(isMenu){
            System.out.print("[" + i++ + "] "); 
        }
        System.out.println("Roles :");
        if(empRoleInfo != null){
            for(Role role : empRoleInfo){
                System.out.println("\t" + role.getName());  
            }
        }
    }
    
    public static void editEmployee(EmployeeService em, Employee emp) {
        Name nameInput;
        Address addressInput;
        Date dateInput;
        String strInput;
        Double gwaInput;
        int choice = 1;
        
        do{
            choice = App.printAddEmployeeMenu(emp);
            switch(choice) {
                case 1:
                    nameInput = emp.getName() == null ? new Name() : emp.getName();
                    nameInput = App.nameMenu(nameInput);
                    if(nameInput != null){
                        emp.setName(nameInput);
                    }
                    break;
                case 2:
                    addressInput = emp.getAddress() == null ? new Address() : emp.getAddress();
                    addressInput = App.addressMenu(addressInput);
                    if(addressInput != null){
                        emp.setAddress(addressInput);
                    }
                    break;
                case 3:
                    dateInput = InputValidator.getInputDate("Enter birthdate (yyyy-mm-dd): ");
                    if(dateInput != null){
                        emp.setBdate(dateInput);
                    }
                    break;
                case 4:
                    gwaInput = InputValidator.getInputDouble("Enter GWA: ");
                    emp.setGwa(gwaInput);
                    break;
                case 5:
                    dateInput = InputValidator.getInputDate("Enter date hired (yyyy-mm-dd): ");
                    if(dateInput != null){
                        emp.setDateHired(dateInput);
                    }
                    break;
                case 6:
                    // CONTINUE ADD CONTACT
                    break;
                case 7:
                    break;
                case 8:
                    em.addEmployee(emp);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 9);
           
    }
    
    public static void printEmployees(EmployeeService es) {
        List<Employee> empList = es.listEmployee();
        int i = 1;
        
        System.out.println();
        if(empList != null){
            for(Employee emp : empList){
                System.out.println("----------------------------");
                System.out.println("Employee " + i++);
                System.out.println("----------------------------");
                App.printEmployeeInfo(emp, false);
                System.out.println("----------------------------");
            }
        }   
    }
    
    /* int choice: 1 - title, 2 - firstname, 3 - middlename, 4 - lastname,  5 - suffix */
    public static Name nameMenu(Name name){
        int choice = 1;   
        int i; 
        List<String> nameInfo;
        String input;
        
        do{    
            choice = printNameMenu(name);
            switch(choice) {
                case 1:
                    input = InputValidator.getInputName(choice);
                    name.setTitle(input);
                    break;
                case 2:
                    input = InputValidator.getInputName(choice);
                    name.setFirstname(input);
                    break;
                case 3:
                    input = InputValidator.getInputName(choice);
                    name.setMiddlename(input);
                    break;
                case 4:
                    input = InputValidator.getInputName(choice);
                    name.setLastname(input);
                    break;
                case 5:
                    input = InputValidator.getInputName(choice);
                    name.setSuffix(input);
                    break;
                case 6:
                    return name;
                case 7:
                    return null;
            }
        } while (choice != 7);
        
        return null;
    }
    
    public static int printNameMenu(Name name){
        int i = 1;
         
        List<String> nameInfo = name.stringify();
        System.out.println();
        System.out.println("============================");
        System.out.println(" Name");
        System.out.println("============================");
        for(String info : nameInfo){
            System.out.println("[" + i++ + "] " + info);
        }
        System.out.println("[" + i++ + "] Save");
        System.out.println("[" + i++ + "] Cancel");
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 7);
    
    }
    
    /* int choice: 1 - street, 2 - brgy, 3 - municipality, 4 - country,  5 - zipcode */
    public static Address addressMenu(Address address){
        int choice = 1;   
        int i; 
        List<String> addressInfo;
        String input;
        
        do{    
            choice = printAddressMenu(address);
            switch(choice) {
                case 1:
                    input = InputValidator.getInputStr("Enter street: ", 30);
                    address.setStreet(input);
                    break;
                case 2:
                    // CONTINUE HERE
                    input = InputValidator.getInputStr("Enter brgy: ", 30);
                    address.setBrgy(input);
                    break;
                case 3:
                    input = InputValidator.getInputStr("Enter municipality: ", 30);
                    address.setMunicipality(input);
                    break;
                case 4:
                    input = InputValidator.getInputStr("Enter country: ", 30);
                    address.setCountry(input);
                    break;
                case 5:
                    input = InputValidator.getInputStr("Enter zipcode: ", 30);
                    address.setZipcode(input);
                    break;
                case 6:
                    return address;
                case 7:
                    return null;
            }
        } while (choice != 7);
        
        return null;
    }
    
    public static int printAddressMenu(Address address){
        int i = 1;
         
        List<String> addressInfo = address.stringify();
        System.out.println();
        System.out.println("============================");
        System.out.println(" Address");
        System.out.println("============================");
        for(String info : addressInfo){
            System.out.println("[" + i++ + "] " + info);
        }
        System.out.println("[" + i++ + "] Save");
        System.out.println("[" + i++ + "] Cancel");
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 7);
    
    }
    
    /*public static Employee searchEmployees(String type) {
        List<Employee> empList = es.listEmployee();
        int i = 1;
        
        if(empList != null){
            for(Employee emp : empList){
                System.out.println("----------------------------");
                System.out.println("Employee " + i++);
                System.out.println("----------------------------");
                App.printEmployeeInfo(emp, false);
                System.out.println("----------------------------");
            }
        }   
    }*/
}
