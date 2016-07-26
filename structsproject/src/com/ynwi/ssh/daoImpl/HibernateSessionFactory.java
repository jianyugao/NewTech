package com.ynwi.ssh.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
	 private static final String CFG_FILE_LOCATION = "/Hibernate.cfg.xml";  
	  
	    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();  
	  
	    private static final Configuration cfg = new Configuration()  
	            .configure();  
	  
	    private static ServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
	  
	    private static ServiceRegistry registry;  
	  
	    private static SessionFactory sessionFactory;  
	  
	    public static Session currentSession() throws HibernateException {  
	        Session session = threadLocal.get();  
	  
	        if (session == null || session.isOpen() == false) {  
	  
	            if (sessionFactory == null) {  
	                try {  
	                    //registry = builder.buildServiceRegistry();  
	                    sessionFactory = cfg.buildSessionFactory(builder); 
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	  
	            session = sessionFactory.openSession();  
	            threadLocal.set(session);  
	  
	        }  
	  
	        return session;  
	    }  
	  
	    public static void closeSession() throws HibernateException {  
	        Session session = threadLocal.get();  
	        threadLocal.set(null);  
	        if (session != null) {  
	            session.close();  
	        }  
	    }  
}
