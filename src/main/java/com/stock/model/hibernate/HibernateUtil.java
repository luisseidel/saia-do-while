package com.stock.model.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.stock.model.entities.Empresa;


public class HibernateUtil<T> {

    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            	
            	Configuration configuration = new Configuration();
            	Properties props = new Properties();

            	props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            	props.put(Environment.URL, "jdbc:mysql://localhost:3306/stock?serverTimezone=UTC");
            	props.put(Environment.USER, "root");
            	props.put(Environment.PASS, "spA2w@yajEv2");
            	props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            	props.put(Environment.SHOW_SQL, "true");
            	props.put(Environment.FORMAT_SQL, "true");
            	props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            	configuration.setProperties(props);
            	
            	configuration.addAnnotatedClass(Empresa.class);
            	
            	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            	
            	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    /**
     * Close the conection
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
    
}