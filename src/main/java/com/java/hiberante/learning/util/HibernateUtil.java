package com.java.hiberante.learning.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration; 
  
public class HibernateUtil { 
    private static final SessionFactory sessionFactory 
        = buildSessionFactory(); 
    @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() 
    { 
        try { 
            // We need to create the SessionFactory from 
            // hibernate.cfg.xml 
            return new Configuration() 
                .configure() 
                .buildSessionFactory(); 
            //return new AnnotationConfiguration() 
             //       .configure() 
             //       .buildSessionFactory();
        } 
        catch (Throwable ex) { 
            // Make sure you log the exception, as it might 
            // be swallowed 
            // In case of any exception, it has to be 
            // indicated here 
            System.err.println( 
                "SessionFactory creation failed." + ex); 
            throw new ExceptionInInitializerError(ex); 
        } 
    } 
    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    } 
    public static void shutdown() 
    { 
        // Close caches and connection pools 
        getSessionFactory().close(); 
    } 
}