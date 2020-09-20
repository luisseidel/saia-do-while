package com.stock.model;

import java.io.Serializable;

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
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
			
            e.printStackTrace();
		}
	}
	
	public T findById(Long id) {
		Transaction transaction = null;
		T result = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			
			result = session.createQuery(String.format("from %s", getClass().getName()), getClasz()).getSingleResult();
			
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
			
            e.printStackTrace();
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
