package com.ecc.ems;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

import com.ecc.ems.EmployeeManagement;
import com.ecc.ems.Employee;

public class App{
    public static void main(String args[]){
         
        EmployeeManagement em = new EmployeeManagement();
        int choice;
        
        do{
            choice = printMenu();
        
        }
    }
    
    public int printMenu(){
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
        System.out.print(" Option: ");
        
    
    }
}
