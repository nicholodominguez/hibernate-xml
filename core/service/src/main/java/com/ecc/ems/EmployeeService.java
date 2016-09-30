package com.ecc.ems;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ecc.ems.EmployeeDAO;
import com.ecc.ems.RoleDAO;
import com.ecc.ems.Employee;

public class EmployeeService{
    
    private SessionFactory factory;
    private EmployeeDAO emDao;
    private RoleDAO roleDao;
    private String FILEPATH = "/home/ecc/Desktop/Training/09-26/ems/infra/build-tools/src/main/resources/hibernate.cfg.xml";
    private File configFile = new File(FILEPATH);
    
    public EmployeeManagement(){
        try{
            Configuration config = new Configuration().configure(configFile);
            //Configuration config = new Configuration().configure("/infra/src/main/resources/persistence/ems.cfg.xml");
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            factory = config.buildSessionFactory(registry);
            emDao = new EmployeeDAO(factory);
            roleDao = new RoleeDAO(factory);
        }
        catch(HibernateException e){
            System.out.println("Initial creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public String addEmployee(Employee emp){
        emDao.persist(emp);
        return response;
    }
    
    public List listEmployee(){
        List<Employee> empList = null;
        
        empList = emDao.findAll();
        return empList;
    }
    
    public List listEmployeeByLastname(boolean ascending){
        List<Employee> empList = null;
        
        empList = emDao.sortByLastname(ascending);
        return empList;
    }
    
    public List listEmployeeByDateHired(boolean ascending){
        List<Employee> empList = null;
        
        empList = emDao.sortByDateHired(ascending);
        return empList;
    }
    
    public List listEmployeeByGwa(boolean ascending){
        List<Employee> empList = null;
        
        empList = emDao.sortByGwa(ascending);
        return empList;
    }
    
    public void deleteEmployee(Employee emp){
        emDao.delete(emp);
    }

}
