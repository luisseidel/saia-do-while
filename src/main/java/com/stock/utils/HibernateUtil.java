package com.stock.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    public static <T> SessionFactory getSessionFactory(T entity) {
        if (sessionFactory == null) {
            try {
            	
            	Configuration configuration = new Configuration();
            	Properties props = new Properties();

            	props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            	props.put(Environment.URL, "jdbc:mysql://localhost:3306/stock?serverTimezone=UTC");
            	props.put(Environment.USER, "root");
            	props.put(Environment.PASS, "");
            	props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            	props.put(Environment.SHOW_SQL, "true");
            	props.put(Environment.FORMAT_SQL, "true");
            	props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            	configuration.setProperties(props);
            	configuration.addAnnotatedClass(entity.getClass());
            	
            	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            	
            	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    
    public static <T> Session openSession(T entity) {
    	return getSessionFactory(entity).openSession();
    }
    
}