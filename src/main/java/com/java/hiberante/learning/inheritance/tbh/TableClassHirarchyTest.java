package com.java.hiberante.learning.inheritance.tbh;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.hiberante.learning.entity.Employee;
import com.java.hiberante.learning.util.DateUtils;
import com.java.hiberante.learning.util.HibernateUtil;

public class TableClassHirarchyTest {

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
        	
        	 Payment payment = new Payment();
			 payment.setPaymentId(1);
			 payment.setAmount(new BigDecimal(2000.00));
			 payment.setPaymentDate(DateUtils.stringToDate("8-09-2024"));	
			 
			 //session.saveOrUpdate(payment);
        	 
        	 CreditCard creditCard = new CreditCard();
			 //creditCard.setPaymentId(1);
        	 creditCard.setCreditCardType("VISA");
			 creditCard.setAmount(new BigDecimal(2000.00));
			 creditCard.setPaymentDate(DateUtils.stringToDate("8-09-2024"));	
			 
			 UPIPayment upiPayment = new UPIPayment();
			// upiPayment.setPaymentId(1);
			 upiPayment.setUpiPaymentType("Gpay");
			 upiPayment.setAmount(new BigDecimal(2000.00));
			 upiPayment.setPaymentDate(DateUtils.stringToDate("10-09-2024"));
			 WalletPayment walletPayment = new WalletPayment();
			// walletPayment.setPaymentId(1);
			 walletPayment.setWalletPaymentType("Paytm");
			 walletPayment.setAmount(new BigDecimal(4000.00));
			 walletPayment.setPaymentDate(DateUtils.stringToDate("12-09-2024"));
			 
			 session.saveOrUpdate(creditCard);
			 session.saveOrUpdate(upiPayment);
			 session.saveOrUpdate(walletPayment);
			 transaction.commit();
        	 
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
