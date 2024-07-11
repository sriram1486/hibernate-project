package com.java.hiberante.learning;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.hiberante.learning.model.Product;
import com.java.hiberante.learning.util.HibernateUtil;

public class HibernateHQLQueryTest {

	public static void main(String[] args) {
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
       	 
       	 
       	 Query query= session.createQuery("select p.productId from Product p");
       	 
	   	 List<Product> productList = query.list();
	   	 System.out.println("productList list size is:"+productList.size());
	   	 System.out.println("********************");
	   	 
	   	 for(Product p :productList) {
	   		 System.out.println(p);
	   	 }
	   	 System.out.println("********************");
			/*
			 * Query query= session.
			 * createQuery("select p from Product p where p.productprice > :productprice");
			 * query.setParameter("productprice",80000.0); List<Product> productList =
			 * query.list();
			 * System.out.println("productList list size is:"+productList.size());
			 * System.out.println("********************");
			 * 
			 * for(Product p :productList) {
			 * 
			 * 
			 * System.out.println(p);
			 * 
			 * } System.out.println("********************");
			 */
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
