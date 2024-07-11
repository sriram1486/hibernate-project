package com.java.hiberante.learning;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.hiberante.learning.entity.Employee;
import com.java.hiberante.learning.util.DateUtils;
import com.java.hiberante.learning.util.HibernateUtil;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory sessionFactory = null;
         Session session = null;
         Transaction transaction = null;
         try {
        	//Create SessionFactory from hibernate.cfg.xml
        	 sessionFactory= HibernateUtil.getSessionFactory();
        	//create new session object by invoking openSession() on sessionFactory object
        	 session = sessionFactory.openSession();
        	 // begin transaction 
        	 transaction =session.beginTransaction();
        	 //create employee object
        	 Employee emp= new Employee();
        	 emp.setEmployeeId(7876);
        	 emp.setEmployeeName("ADAMS");
        	 emp.setJob("CLERK");
			 emp.setMgr(new BigDecimal(7788));
			 emp.setHiredate(DateUtils.stringToDate("8-9-1981"));
			 emp.setSalary(new BigDecimal(1500));
			 emp.setCommission(new BigDecimal(0.00));
			 emp.setDeptId(30);
			 //session.saveOrUpdate(emp);	
             //transaction.commit();
			 
			 Query query = session.getNamedQuery("getEmployees");
			 List<Employee> list = query.list();
			 for(Employee e:list) {
				 System.out.println(e);
			 }
        
			 Query query1 = session.getNamedQuery("getEmployeeBySalary");
			 query1.setParameter("salary", new BigDecimal(50000.00));
			 List<Employee> list1 = query1.list();
			 for(Employee e1:list1) {
				 System.out.println(e1);
			 }
        	 
         } catch(Exception e) {
        	 if (transaction != null) {
                 // Rollback the transaction in case of an error
                 try {
                     transaction.rollback();
                     System.out.println("Transaction is rolled back");
                 } catch (RuntimeException rollbackException) {
                     System.out.println("Failed to roll back the transaction");
                     rollbackException.printStackTrace();
                 }
             }
             e.printStackTrace();
         } finally {
             // Close the session
             //session.close();
             //Close the sessionFactory
            //sessionFactory.close();
            
         }

    }

}
