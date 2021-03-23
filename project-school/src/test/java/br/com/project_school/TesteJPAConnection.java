package br.com.project_school;

import org.junit.Test;

import br.com.project_school.connection.JPAConnection;

public class TesteJPAConnection {//Classe responsavel pelos testes de persistencia de dados
	
	
	@Test
	public void TesteConnection() {// Teste de conexão
		JPAConnection.getEntityManager();
		
		
	}
	
}
