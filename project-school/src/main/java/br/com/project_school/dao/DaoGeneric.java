package br.com.project_school.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.project_school.connection.JPAConnection;

public class DaoGeneric<E> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager = JPAConnection.getEntityManager();
	
	/*MÉTODO PARA SALVAR DADOS EM UMA TABELA/ENTIDADE*/
	public void insertEntity(E entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
	}
	
	/*ATUALIZA DADOS DE UMA TABELA/ENTIDADE*/
	public E updateEnity(E entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E insertEntity = entityManager.merge(entity);
		transaction.commit();
		
		return insertEntity;
	}
	
	/*PESQUISANDO UMA ENTIDADE E TRAZENDO SEU ID.*/
	@SuppressWarnings("unchecked")
	public E searchEntity(E entity) {
		
		Object id = JPAConnection.getPrimaryKey(entity);
		
		E e = (E) entityManager.find(entity.getClass(), id);
		
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public E searchEntity(Long id, Class<E> entity) {
		entityManager.clear();
		
		E e = (E) entityManager.createQuery("from "+ entity.getSimpleName() + " where id = " + id).getSingleResult();
		
		return e;
	}
	
	public void deleteById(E entity) throws Exception{
		
		Object id = JPAConnection.getPrimaryKey(entity);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.createNativeQuery("delete from " + entity.getClass()
										.getSimpleName().toLowerCase() 
										+ " where id = " + id).executeUpdate();
		
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> entityList(Class<E> entity){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> list = entityManager.createQuery("from " + entity.getName()).getResultList();
		
		transaction.commit();
		
		return list;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}