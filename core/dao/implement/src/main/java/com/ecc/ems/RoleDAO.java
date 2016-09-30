package com.ecc.ems;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria; 
import org.hibernate.criterion.Order;

import com.ecc.ems.Employee;
import java.util.List;
import java.util.Collection;

public class RoleDAO extends BaseDAO implements RoleDAOInterface<Role, Int>{
        
    public RoleDAO(SessionFactory factory){
        super(factory);
    }
}
