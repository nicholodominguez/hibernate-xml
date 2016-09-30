package com.ecc.ems;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import com.ecc.ems.Employee;
import java.util.List;
import java.util.Collection;

public interface RoleDAOInterface extends BaseDAOInterface<Role, Integer>{
    
}
