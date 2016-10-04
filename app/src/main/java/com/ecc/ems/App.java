package com.ecc.ems;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

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
                    App.addEmployee(em);
                    break;
                case 2:
                    App.printEmployees(em);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 5);
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
        System.out.println("| Contact Management System  |");
        System.out.println("|----------------------------|");
        System.out.println("| [8] Add Contact            |");
        System.out.println("| [9] Edit Contact           |");
        System.out.println("| [0] Delete Contact         |");
        System.out.println("|----------------------------|");
        System.out.println("==============================");
        return InputValidator.getInputMenu(" Option: ", 5);
    }
    
    public static int printAddEmployeeMenu(Employee emp) {
        System.out.println("============================");
        System.out.println(" Employee Creation          ");
        System.out.println("============================");
        printEmployeeInfo(emp, true);
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 8);
    }
    
    public static void printEmployeeInfo(Employee emp, boolean isMenu) {
        List<String> empInfo = emp.stringify();
        for(int i = 0; i < empInfo.size(); i++){
            if(isMenu){
                System.out.print("[" + i + "] "); 
            }
            System.out.println(empInfo.get(i));    
        }
    }
    
    public static void addEmployee(EmployeeService es) {
        Employee emp;   
    }
    
    public static void printEmployees(EmployeeService es) {
        List<Employee> empList = es.listEmployee();
        
        if(empList != null){
            for(Employee emp : empList){
                App.printEmployeeInfo(emp, false);
            }
        }   
    }
}
