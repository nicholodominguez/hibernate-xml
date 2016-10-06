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
        int choice, int empId;
        
        do{
            choice = App.printMenu();
            switch(choice) {
                case 1:
                    Employee emp = new Employee();
                    emp.setName(new Name());
                    emp.setAddress(new Address());
                    
                    App.editEmployee(emp);
                    break;
                case 2:
                    App.printEmployees(em);
                    break;
                case 3:
                    emp = App.searchEmployee("edit");
                    
                    App.editEmployee(empId);
                    break;
                case 4:
                    emp = App.searchEmployee("delete");
                    
                    App.editEmployee(empId);
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
    
    public static void printAddEmployeeMenu(Employee emp) {
        System.out.println("============================");
        System.out.println(" Employee Creation          ");
        System.out.println("============================");
        printEmployeeInfo(emp, true);
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 8);
    }
    
    public static void printEmployeeInfo(Employee emp, boolean isMenu) {
        List<String> empInfo = emp.stringify();
        Set<Contact> empContactInfo = emp.getContacts();
        Set<Role> empRoleInfo = emp.getRoles();
        int i = 1;
        
        for(; i < empInfo.size(); i++){
            if(isMenu){
                System.out.print("[" + i + "] "); 
            }
            System.out.println(empInfo.get(i));    
        }
        
        if(isMenu){
            System.out.print("[" + i++ + "] "); 
        }
        System.out.println("Contacts:");
        for(Contact contact : empContactInfo){
            System.out.println("\t" + contact.getContactType() + ": " + contact.getContactDetails());  
        }
        
        if(isMenu){
            System.out.print("[" + i++ + "] "); 
        }
        System.out.println("Roles :");
        for(Role role : empRoleInfo){
            System.out.println("\t" + role.getName());  
        }
        
    }
    
    public static void editEmployee(EmployeeService es) {
        Name nameInput;
        Address addressInput;
        int choice = 0;
        
        do{
            choice = App.printAddEmployeeMenu(emp);
            switch(choice) {
                case 1:
                    nameInput = App.nameMenu(emp.getName());
                    emp.setName(nameInput);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 0);
           
    }
    
    public static void printEmployees(EmployeeService es) {
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
                    // CONTINUE HERE
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
                    break;
                case 7:
                    
                    break;
            }
        } while (choice != 7);
    }
    
    public static int printNameMenu(Name name){
        int i = 0;
         
        nameInfo = name.stringify();
        System.out.println("============================");
        System.out.println(" Name");
        System.out.println("============================");
        for(String info : name.stringify()){
            System.out.println("[" + i++ + "] " + info);
        }
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
