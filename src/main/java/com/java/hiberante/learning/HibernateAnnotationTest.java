package com.java.hiberante.learning;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.hiberante.learning.entity.Customer;
import com.java.hiberante.learning.model.Product;
import com.java.hiberante.learning.util.HibernateUtil;

public class HibernateAnnotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory sessionFactory = null;
         Session session = null;
         Transaction transaction = null;
         try {
        	//  Create SessionFactory from hibernate.cfg.xml
        	 sessionFactory= HibernateUtil.getSessionFactory();
        	// create new session object by invoking openSession() on sessionFactory object
        	 session = sessionFactory.openSession();
        	 
        	 // begin transaction 
        	 transaction =session.beginTransaction();
        	 // product object created
				
				/*
				 * Customer c= new Customer(); //c.setCustomerId(1);
				 * c.setCustomerName("Nikhitha"); c.setCustomerEmail("nikhitha@gmail.com");
				 * c.setAddress("US"); session.save(c);
				 */
				 
        	 
				
				
				  Query query = session.createQuery(" select c from   Customer c"); //
				  List<Customer> list = query.list(); for(Customer c:list) { //
				  System.out.println("customer Details:"+c); }
				 
				  
				
				 
				 //transaction.commit();
			 
			 
             
        	 
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
            // sessionFactory.close();
            
         }

	}
}
