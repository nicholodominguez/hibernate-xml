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

import com.ecc.ems.EmployeeManagementDAO;
import com.ecc.ems.Employee;

public class EmployeeManagement implements EmployeeManagementDAO{
    
    private SessionFactory factory;
    private String FILEPATH = "/home/ecc/Desktop/Training/09-26/ems/infra/build-tools/src/main/resources/hibernate.cfg.xml";
    private File configFile = new File(FILEPATH);
    
    public EmployeeManagement(){
        try{
            Configuration config = new Configuration().configure(configFile);
            //Configuration config = new Configuration().configure("/infra/src/main/resources/persistence/ems.cfg.xml");
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            factory = config.buildSessionFactory(registry);
        }
        catch(HibernateException e){
            System.out.println("Initial creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public String addEmployee(Employee emp){
        Session session = factory.openSession();
        Transaction tx = null;
        String response = null;
        
        try{
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
            response = "Employee successfully added."; 
        }catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
        
        return response;
    }
    
    public List listEmployee(){
        Session session = factory.openSession();
        Transaction tx = null;
        List empList = null;
        String response = null;
        
        try{
            tx = session.beginTransaction();
            empList = session.createQuery("FROM employee").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
        
        return empList;
    }
    
    public int printMenu(){
        
    
    
    }

}
