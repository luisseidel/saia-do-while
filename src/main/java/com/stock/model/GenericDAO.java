package com.stock.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.validation.annotation.Validated;

import com.stock.model.type.TransactionType;
import com.stock.utils.HibernateUtil;

public abstract class GenericDAO<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = 4537346584918634683L;
	private Class<T> clasz;
	private T entity;
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
		Session session = HibernateUtil.openSession(entity);
		
		try {
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
            e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public T findById(Long id) {
		Session session = HibernateUtil.openSession(entity);
		
		try {
			Criteria crit = session.createCriteria(getClasz());
			crit.add(Restrictions.idEq(id));
			return (T) crit.uniqueResult();
			
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public abstract List<T> findByExample(T entity);
	
	public Class<T> getClasz() {
		return clasz;
	}
	
	public void setClasz(Class<T> clazz) {
		this.clasz = clazz;
	}
	
	public T getEntity() {
		return entity;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
}
