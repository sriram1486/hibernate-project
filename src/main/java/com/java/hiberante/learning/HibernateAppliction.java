package com.java.hiberante.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.hiberante.learning.model.Product;
import com.java.hiberante.learning.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HibernateAppliction 
{
    public static void main( String[] args ) {
        
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
        	 Product product = new Product(); // transient state
      		 product.setProductId(1);
             product.setProductName("HP Laptop");
     		 product.setDescription(" I5 Processor");
             product.setProductprice(70000.00);
             //perform some operations[create,update,delete,read] on session
             session.save(product);//persist state
             //commit the transaction
        	 Product product1=(Product)session.load(Product.class, 3);
        	 System.out.println(" before update Prodcut information Is:"+product1);
        	 product1.setProductprice(75000);
        	 session.save(product1);
        	 System.out.println(" before update Prodcut information Is:"+product1);
        	 Product product2=(Product)session.load(Product.class, 3);
        	 System.out.println(" before update Prodcut information Is:"+product1);
        	 
        	 //session.delete(product2);
        	 System.out.println("Is session open"+session.isOpen());
           // transaction.commit();
            //session.clear();//closed or detached
            System.out.println("Is session open"+session.isOpen());
            //Session session1= sessionFactory.openSession();
           // transaction =session1.beginTransaction() ;		
            //Product product3=(Product)session1.load(Product.class, 3);
       	 //System.out.println(" prodcut3 update Prodcut information Is:"+product3);
        	 
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
