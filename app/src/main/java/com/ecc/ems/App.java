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
                    List<Employee> empList = em.listEmployee();
                    App.printEmployees(empList, false);
                    break;
                case 3:
                    emp = App.searchEmployee(em, "edit");
                    
                    //App.editEmployee(empId);
                    break;
                case 4:
                    //emp = App.searchEmployee("delete");
                    
                    //App.editEmployee(empId);
                    break;
                case 5:
                    Role role = new Role();
                    
                    App.addNewRoleType(em, role);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
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
        System.out.println("[8] Save");
        System.out.println("[9] Cancel");
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
        Set<Contact> contactsInput;
        Set<Role> rolesInput;
        Double gwaInput;
        int choice = 1;
        Integer empId = emp.getId();
        
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
                    if(empId == null){
                        System.out.println("Can't add contacts. Save the employee info first.");
                        continue;
                    }
                    contactsInput = emp.getContacts() == null ? new HashSet<Contact>() : emp.getContacts();
                    contactsInput = App.contactsMenu(contactsInput, empId);
                    if(contactsInput != null){
                        emp.setContacts(contactsInput);
                    }
                    break;
                case 7:
                    if(empId == null){
                        System.out.println("Can't add roles. Save the employee info first.");
                        continue;
                    }
                    rolesInput = emp.getRoles() == null ? new HashSet<Role>() : emp.getRoles();
                    rolesInput = App.rolesMenu(em, rolesInput, empId);
                    if(rolesInput != null){
                        emp.setRoles(rolesInput);
                    }
                    break;
                case 8:
                    emp.setStatus(true);
                    em.addEmployee(emp);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 9 && choice != 8 );
           
    }
    
    public static void printEmployees(List<Employee> empList, boolean isMenu) {
        int i = 1;
        
        System.out.println();
        
        if(empList != null){
            for(Employee emp : empList){
                System.out.println("============================");
                if(isMenu){
                    System.out.print("[" + i + "] ");
                }
                System.out.println("Employee " + i++);
                System.out.println("============================");
                App.printEmployeeInfo(emp, false);
                System.out.println();
            }
        }
        else{
            System.out.println("No employee found.");
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
        } while (choice != 6 && choice != 7);
        
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
        } while (choice != 6 && choice != 7);
        
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
    
    public static Set contactsMenu(Set contactsInput, int empId){
        int choice = 1;   
        int i; 
        Contact contactInput;
        String input;
        
        do{    
            choice = printContactsMenu(contactsInput);
            switch(choice) {
                case 1:
                    contactsInput = addNewContact(contactsInput, empId);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return contactsInput;
                case 5:
                    return null;
            }
        } while (choice != 4 && choice != 5);
        
        return null;
    }
    
    public static int printContactsMenu(Set<Contact> contactsInput){        
        List<String> contactInfo = new ArrayList<String>();
         
        for(Contact contact : contactsInput){
            contactInfo.add(contact.stringify());    
        } 
        System.out.println();
        System.out.println("============================");
        System.out.println(" Contacts");
        System.out.println("============================");
        for(String info : contactInfo){
            System.out.println(info);
        }
        System.out.println("----------------------------");
        System.out.println("[1] Add");
        System.out.println("[2] Edit");
        System.out.println("[3] Delete");
        System.out.println("[4] Save");
        System.out.println("[5] Cancel");
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 5);
    }
    
    public static Set addNewContact(Set contactsInput, int empId){
        int choice = 1;
        Contact newContact;
        String newContactStr;
        
        do{    
            choice = addNewContactMenu(contactsInput);
            switch(choice) {
                case 1:
                    newContactStr = InputValidator.getInputMobile();
                    newContact = new Contact("Mobile", newContactStr, empId, true);
                    
                    if(contactsInput.contains(newContact)){
                        System.out.println("Contact already exists");
                        continue;
                    }
                    
                    contactsInput.add(newContact);
                    break;
                case 2:
                    newContactStr = InputValidator.getInputEmail();
                    newContact = new Contact("Email", newContactStr, empId, true);
                    
                    if(contactsInput.contains(newContact)){
                        System.out.println("Email already exists");
                        continue;
                    }
                    
                    contactsInput.add(newContact);
                    break;
                case 3:
                    newContactStr = InputValidator.getInputPhone();
                    newContact = new Contact("Phone", newContactStr, empId, true);
                    
                    if(contactsInput.contains(newContact)){
                        System.out.println("Phone already exists");
                        continue;
                    }
                    
                    contactsInput.add(newContact);
                    break;
                case 4:
                    return contactsInput;
                case 5:
                    return null;
            }
        } while (choice != 4 && choice != 5);
        
        return null; 
    }
    
    public static int addNewContactMenu(Set<Contact> contactsInput){  
    
        List<String> contactInfo = new ArrayList<String>();
        
        for(Contact contact : contactsInput){
            contactInfo.add(contact.stringify());    
        }
         
        System.out.println();
        System.out.println("============================");
        System.out.println(" Contacts");
        System.out.println("============================");
        for(String info : contactInfo){
            System.out.println(info);
        }
        System.out.println("----------------------------");
        System.out.println("[1] Add Mobile");
        System.out.println("[2] Add Email");
        System.out.println("[3] Add Phone");
        System.out.println("[4] Save");
        System.out.println("[5] Back");
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 5);
    
    }
    
    public static Employee searchEmployee(EmployeeService es, String type) {
        List<Employee> empList;
        Employee temp = null;
        int i = 1, choice = 1;
        String input;
        
        input = InputValidator.getInputStr("Enter name of employee to " + type + ": ", 30);
        empList = es.searchEmployeeByName(input);
        if(empList.size() > 1){
            App.printEmployees(empList, true);
            choice = InputValidator.getInputMenu(" Enter the employee no. to be " + type + "ed: ", empList.size());
        }
        else if(empList.size() == 0){
            System.out.println("No employee found.");
            return temp;
        }
        temp = empList.get(choice-1);
        
        switch(type){
            case "edit":
                App.editEmployee(es, temp);
                break;
        }
        
        return temp;
    }
    
    public static Set rolesMenu(EmployeeService es, Set rolesInput, int empId){
        int choice = 1;   
        int i; 
        Role roleInput;
        String input;
        Set<Role> temp = null;
        
        do{    
            choice = printRolesMenu(rolesInput);
            switch(choice) {
                case 1:
                    temp = addNewRole(es, rolesInput, empId);
                    rolesInput = temp == null ? rolesInput : temp;
                    break;
                case 2:
                    break;
                case 3:
                    return rolesInput;
                case 4:
                    return null;
            }
        } while (choice != 3 && choice != 4);
        
        return null;
    }
    
    public static int printRolesMenu(Set<Role> rolesInput){        
        List<String> roleInfo = new ArrayList<String>();
         
        for(Role role : rolesInput){
            roleInfo.add(role.getName());    
        } 
        System.out.println();
        System.out.println("============================");
        System.out.println(" Roles");
        System.out.println("============================");
        for(String info : roleInfo){
            System.out.println(info);
        }
        System.out.println("----------------------------");
        System.out.println("[1] Add");
        System.out.println("[2] Delete");
        System.out.println("[3] Save");
        System.out.println("[4] Cancel");
        System.out.println("----------------------------");
        return InputValidator.getInputMenu(" Option: ", 4);
    }
    
    public static Set addNewRole(EmployeeService es, Set<Role> rolesInput, int empId){
        int choice = 1;
        Contact newRole;
        List<Role> availableRoles = null;
        int i = 1;
        
        availableRoles = es.getAvailableRoles(rolesInput);
         
        System.out.println();
        System.out.println("============================");
        System.out.println(" Current Roles");
        System.out.println("============================");
        
        for(Role role : rolesInput){
            System.out.println("\t" + role.getName());
        }
        
        System.out.println("----------------------------");
        System.out.println(availableRoles);
        
        if(availableRoles != null){
            for(Role role : availableRoles){
                System.out.println("[" + i++ + "] " + role.getName());
            }
        }
        
        System.out.println("[" + i++ + "] Cancel");
        System.out.println("----------------------------");
        choice = InputValidator.getInputMenu(" Add what role: ", i-1);
        if(choice != i-1){
            rolesInput.add(availableRoles.get(choice-1));
            return rolesInput;
        }
        
        return null;
    }
    
    public static void addNewRoleType(EmployeeService es, Role role){
        List<Role> allRoles = es.listRoles();
        
        System.out.println();
        System.out.println("============================");
        System.out.println(" Current Roles");
        System.out.println("============================");
        printRoles(allRoles, false);
        System.out.println("----------------------------");
        //CONTINUE HERE
    }
    
    public static void printRoles(List<Role> roles, boolean isMenu){
        int i = 1;
        
        for(Role role : roles){
            if(isMenu){
                System.out.print("[" + i++ + "] ");
            }
            System.out.println(role.getName());
        }
    
    }
}
