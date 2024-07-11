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
			// Create SessionFactory from hibernate.cfg.xml
			sessionFactory = HibernateUtil.getSessionFactory();
			// create new session object by invoking openSession() on sessionFactory object
			session = sessionFactory.openSession();
			// begin transaction
			transaction = session.beginTransaction();
			// product object created

			// create customer
			Customer c = new Customer();
			// c.setCustomerId(1);
			c.setCustomerName("Nikhitha");
			c.setCustomerEmail("nikhitha@gmail.com");
			c.setAddress("US");
			session.save(c);
			// transaction.commit();
			// fetch customer info without selected fields from table[Customer]
			/*Query query = session.createQuery(" from Customer ");
			// query.setParameter("customerId", 1);//
			List<Customer> list = query.list();
			for (Customer cust : list) {
				System.out.println("customerId::" + cust.getCustomerId());
				System.out.println("customerName::" + cust.getCustomerName());
				System.out.println("customerEmail::" + cust.getCustomerName());
			}*/

			// fetch customer info with selected
			// fields[customerId,CustomerName,CustomerEmail] from table[Customer]
			/*Query selectedFieldsQuery = session
					.createQuery("select c.customerId,c.customerName, c.customerEmail from  Customer c where c.customerId=1 or c.customerName='Nikhitha'");
			// query.setParameter("customerId", 1);//
			List<Object[]> objList = selectedFieldsQuery.list();

			for (Object[] obj : objList) {

				Integer customerId = (Integer) obj[0];
				String customerName = (String) obj[1];
				String customerEmail = (String) obj[2];

				System.out.println("customerId::" + customerId);
				System.out.println("customerName::" + customerName);
				System.out.println("customerEmail::" + customerEmail);

			}*/
			
			//native query create sqlQuery
			
			Query sqlQuery= session.createSQLQuery("select * from customer_details");
			List<Object[]> list = sqlQuery.list();
			for (Object[]  obj: list) {
				System.out.println("customerId::" +obj[0]) ;
				System.out.println("customerName::" +obj[1]);
				System.out.println("customerEmail::" + obj[2]);
			}

			// transaction.commit();

		} catch (Exception e) {
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
			session.close();
			// Close the sessionFactory
			sessionFactory.close();

		}

	}
}
