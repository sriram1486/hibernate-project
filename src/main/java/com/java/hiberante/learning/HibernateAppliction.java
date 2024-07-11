package com.java.hiberante.learning;

import java.util.List;

import org.hibernate.Query;
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
      		 product.setProductId(3);
             product.setProductName("Dell Laptop");
     		 product.setDescription(" I7 Processor");
             product.setProductprice(83000.00);
             //perform some operations[create,update,delete,read] on session
             //session.saveOrUpdate(product);//persist state
             //transaction.commit();
             
			/*
			 * Product p =(Product)session.get(Product.class, 1);
			 * System.out.println("Product data is p:::"+p);
			 * 
			 * //session.evict(p); Product p1 =(Product)session.get(Product.class, 1);
			 * System.out.println("Product data is p1:::"+p1); session.evict(p1); Product p2
			 * =(Product)session.get(Product.class, 1);
			 * System.out.println("Product data is p2:::"+p2);
			 */
             /*session.clear();//detached
			 session = sessionFactory.openSession();
			 transaction =session.beginTransaction();
			 product =(Product)session.get(Product.class,product.getProductId() );
			 product.setDescription("I7 Processor with windows 11");
			 session.merge(product);
			 transaction.commit();
             
			 System.out.println("Product data is p:::"+product);*/
            Query namedQuery=session.getNamedQuery("GET_ALL_PRODUCTS");
            
             List<Product> productList=namedQuery.list();
             for(Product p:productList) {
            	 System.out.println(p);
	             
             }
             
             Query namedQuery1=session.getNamedQuery("GET_PRODUCT_ID");
             List<Product> productList1=namedQuery1.list();
             for(Product p1:productList1) {
            	 System.out.println(p1);
	             
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
            // sessionFactory.close();
            
         }

    }
}
