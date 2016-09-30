package com.ecc.ems;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

import com.ecc.ems.EmployeeManagement;
import com.ecc.ems.Employee;
import com.ecc.ems.Name;
import com.ecc.ems.Address;
import com.ecc.ems.Contact;
import com.ecc.ems.Roles;
import com.ecc.ems.InputValidator;

public class App{
    public static void main(String args[]) {
         
        EmployeeManagement em = new EmployeeManagement();
        int choice;
        
        do {
            choice = printMenu();
            switch(choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    public int printMenu() {
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
        System.out.println("| Contact Management System  |");
        System.out.println("|----------------------------|");
        System.out.println("| [8] Add Contact            |");
        System.out.println("| [9] Edit Contact           |");
        System.out.println("| [0] Delete Contact         |");
        System.out.println("|----------------------------|");
        System.out.println("==============================");
        return InputValidator.getInputMenu(" Option: ", 4);
    }
    
    public int printAddEmployeeMenu(Employee emp) {
        System.out.println("============================");
        System.out.println(" Employee Creation          ");
        System.out.println("============================");
        printEmployeeInfo(emp, true);
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 8);
    }
    
    public void printEmployeeInfo(Employee emp, boolean isMenu) {
        Name name;
        Address address;
        Contact contact;
        Roles roles;
        int i = 1;
        
        switch(i) {
            
        
        
        }
        
    }
    
    public void addEmployee() {
        Employee emp;
        
        
    
    }
}
