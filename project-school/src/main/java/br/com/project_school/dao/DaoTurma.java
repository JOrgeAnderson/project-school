package br.com.project_school.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.project_school.connection.JPAConnection;
import br.com.project_school.model.Turma;

public class DaoTurma<E> extends DaoGeneric<Turma>{

	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager = JPAConnection.getEntityManager();

	public void deleteTurmaById(Turma turma) throws Exception{
		
		Object id = JPAConnection.getPrimaryKey(turma);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager
				.createNativeQuery(
						"delete from turma_turno " + " where turmas_id =" + id)
				.executeUpdate(); // faz delete
		transaction.commit();// grava alteração no banco
		
	}
	
	
	
}
