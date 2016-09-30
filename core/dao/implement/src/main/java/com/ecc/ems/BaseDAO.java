package com.ecc.ems;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public BaseDAO implements BaseDAOInterface<T, Id>{
    
    protected SessionFactory factory;
    protected Session currentSession;
    protected Transaction currentTransaction;
    
    public BaseDAO(SessionFactory factory) {
        this.factory = factory;    
    }
    
    public void persist(T entity) {
        this.currentSession = factory.openSession();
        
        try{
            this.currentTransaction = this.currentSession.beginTransaction();
            this.currentSession.persist(entity);
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }
    }
    
    public T findById(Id id) {
        T entity = null;
        this.currentSession = factory.openSession();
        
        try{
            this.currentTransaction = this.currentSession.beginTransaction();
            entity = (T) this.currentSession.get(T.class, id);
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }
        
        return entity;
    }
    
    public List<T> findAll(String query) {
        List<T> entities = null;
        this.currentSession = factory.openSession();
        
	    
	    try{
            this.currentTransaction = this.currentSession.beginTransaction();
            entities = (List<T>) this.currentSession.createQuery(query).list();
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
    
    public void delete(T entity){
        this.currentSession = factory.openSession();
        
        try{
            this.currentTransaction = this.currentSession.beginTransaction();
            this.currentSession.delete(entity);
            this.currentTransaction.commit();
        }catch (HibernateException e) {
            if (this.currentTransaction != null) {
                this.currentTransaction.rollback();
            }
        }finally {
            this.currentSession.close();
        }   
    }

}
