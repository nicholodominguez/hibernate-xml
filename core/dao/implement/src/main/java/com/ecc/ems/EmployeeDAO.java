package com.ecc.ems;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria; 
import org.hibernate.criterion.Order;

import com.ecc.ems.Employee;
import com.ecc.ems.EmployeeDAOInterface;
import com.ecc.ems.BaseDAO;
import java.util.List;
import java.util.Collections;

public class EmployeeDAO extends BaseDAO<Employee, Integer> implements EmployeeDAOInterface{
    
    private Criteria crit;
    
    public EmployeeDAO(SessionFactory factory) {
        super(factory, Employee.class);
    }
    
    public List<Employee> sortByLastname(boolean ifAscending){
        
        List<Employee> entities = null;
        this.currentSession = factory.openSession();
	    crit = this.currentSession.createCriteria(Employee.class);
	    
	    if(ifAscending){
	        crit.addOrder( Order.asc("lastname") );    
	    }
	    else{
	        crit.addOrder( Order.desc("lastname") );
	    }
	    
	    try{
            this.currentTransaction = this.currentSession.beginTransaction();
            entities = crit.list();
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }    
	    
	    return entities;
    }
    
    public List<Employee> sortByDateHired(boolean ifAscending){
        
        List<Employee> entities = null;
        this.currentSession = factory.openSession();
	    crit = this.currentSession.createCriteria(Employee.class);
	    
	    if(ifAscending){
	        crit.addOrder( Order.asc("date_hired") );    
	    }
	    else{
	        crit.addOrder( Order.desc("date_hired") );
	    }
	    
	    try{
            this.currentTransaction = this.currentSession.beginTransaction();
            entities = crit.list();
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }    
	    
	    return entities;
    
    }
    
    public List<Employee> sortByGwa(boolean ifAscending){
    
        List<Employee> entities = null;
        this.currentSession = factory.openSession();
	    
	    try{
            this.currentTransaction = this.currentSession.beginTransaction();
            entities = (List<Employee>) this.currentSession.createQuery("from Employee").list();
            if (ifAscending){
                Collections.sort(entities);
            }
            else{
                Collections.sort(entities, Collections.reverseOrder());
            }
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }    
	    
	    return entities;
    }
}
