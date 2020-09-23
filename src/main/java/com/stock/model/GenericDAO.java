package com.stock.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.validation.annotation.Validated;

import com.stock.model.hibernate.HibernateUtil;
import com.stock.model.type.TransactionType;

public abstract class GenericDAO<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = 4537346584918634683L;
	private Class<T> clasz;
	private TransactionType transactionType;
	
	protected GenericDAO () {}
	
	protected GenericDAO(Class<T> clazz) {
		this();
		this.clasz = clazz;
	}
	
	public void insert(@Validated T entity) {
		transactionType = TransactionType.INSERT;
		getTransaction(transactionType, entity);
	}
	
	public void update(@Validated T entity) {
		transactionType = TransactionType.UPDATE;
		getTransaction(transactionType, entity);
	}
	
	public void delete(T entity) {
		transactionType = TransactionType.DELETE;
		getTransaction(transactionType, entity);
	}
	
	public void getTransaction(TransactionType transactionType, T entity) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			
	        if (transactionType == TransactionType.INSERT) {
	        	session.save(entity);
	        } else if (transactionType == TransactionType.UPDATE) {
	        	session.merge(entity);
	        } else if (transactionType == TransactionType.DELETE) {
	        	session.remove(entity);
	        }
	        
	        transaction.commit();
	        session.flush();
	        
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
			HibernateUtil.shutdown();
            e.printStackTrace();
		}
	}
	
	public T findById(Long id) {
		Transaction transaction = null;
		T result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			
			String query = String.format("from %s", getClasz().getName());
			
			result = (T) session.createQuery(query, getClasz().getClass()).getSingleResult();
			
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		return result;
	}
	
	public List<T> findAll() {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> result = new ArrayList<>();
		
		try {
			transaction = session.beginTransaction();
			
			String query = String.format("from %s", getClasz().getName());
			
			result = (List<T>) session.createQuery(query).list();
			
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		return result;
	}
	
	public Class<T> getClasz() {
		return clasz;
	}
	
	public void setClasz(Class<T> clazz) {
		this.clasz = clazz;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
}
