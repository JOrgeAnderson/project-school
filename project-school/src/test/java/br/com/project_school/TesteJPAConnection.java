package br.com.project_school;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.project_school.connection.JPAConnection;
import br.com.project_school.dao.DaoGeneric;
import br.com.project_school.dao.DaoTurma;
import br.com.project_school.model.Administrador;
import br.com.project_school.model.Professor;
import br.com.project_school.model.Serie;
import br.com.project_school.model.Turma;
import br.com.project_school.model.Turno;

public class TesteJPAConnection {// Classe responsavel pelos testes de persistencia de dados


	@Test
	public void TesteConnection() {// Teste de conexão
		JPAConnection.getEntityManager();

	}

	/* INSERINDO ADM NO BANCO DE DADOS */
	@Test
	public void insertAdm() {
		DaoGeneric<Administrador> daoAdministrador = new DaoGeneric<Administrador>();

		Administrador administrador = new Administrador();

		administrador.setLogin("admin");
		administrador.setSenha("admin123");

		daoAdministrador.insertEntity(administrador);

	}

	/* INSERINDO PROFESSOR NO BANCO DE DADOS */
	@Test
	public void insertProfessor() {
		DaoGeneric<Professor> daoProfessor = new DaoGeneric<Professor>();

		Professor professor = new Professor();

		professor.setCpf("672.378.983-00");
		professor.setEmail("EdivanGomes9902@email.com");
		professor.setMatricula("SH1111");
		professor.setNome("Edivan Gomes da Costa");
		professor.setRg("2819283892");

		daoProfessor.insertEntity(professor);
	}

	/* INSERINDO SERIES NO BANCO DE DADOS */
	@Test
	public void insertSerie() {
		DaoGeneric<Serie> daoSerie = new DaoGeneric<Serie>();

		Serie serie1 = new Serie();
		serie1.setNome("1° Ano - Médio");

		Serie serie2 = new Serie();
		serie2.setNome("2° Ano - Médio");

		Serie serie3 = new Serie();
		serie3.setNome("3° Ano - Médio");

		daoSerie.insertEntity(serie1);
		daoSerie.insertEntity(serie2);
		daoSerie.insertEntity(serie3);
	}

	/* INSERINDO TURNOS NO BANCO DE DADOS */
	@Test
	public void insertTurno() {

		DaoGeneric<Turno> DaoTurno = new DaoGeneric<Turno>();

		Turno turnoManha = new Turno();
		turnoManha.setTurno("MANHÃ");

		Turno turnoTarde = new Turno();
		turnoTarde.setTurno("TARDE");

		Turno turnoNoite = new Turno();
		turnoNoite.setTurno("NOITE");

		DaoTurno.insertEntity(turnoManha);
		DaoTurno.insertEntity(turnoTarde);
		DaoTurno.insertEntity(turnoNoite);
	}

	/* INSERINDO TURMAS NO BANCO DE DADOS */
	@Test
	public void insertTurma() {
		DaoGeneric<Turma> daoTurma = new DaoGeneric<Turma>();
		Serie serie1M = new Serie();
		serie1M.setId(3L);

		Turma turmaA1 = new Turma();
		turmaA1.setTurma("101-A");
		turmaA1.setSerie(serie1M);

		Turno turnoManhaA1 = new Turno();
		turnoManhaA1.setId(6L);
		List<Turno> turnos = new ArrayList<Turno>();
		turnos.add(turnoManhaA1);
		turmaA1.setTurnos(turnos);

		/*----------------------------------------------------------*/

		Turma turmaA2 = new Turma();
		turmaA2.setTurma("102-B");
		turmaA2.setSerie(serie1M);

		Turno turnoManhaA2 = new Turno();
		turnoManhaA2.setId(6L);
		List<Turno> turnos2 = new ArrayList<Turno>();
		turnos2.add(turnoManhaA2);
		turmaA2.setTurnos(turnos2);

		/*----------------------------------------------------------*/

		Turma turmaA3 = new Turma();
		turmaA3.setTurma("103-C");
		turmaA3.setSerie(serie1M);

		Turno turnoManhaA3 = new Turno();

		turnoManhaA3.setId(6L);

		List<Turno> turnos3 = new ArrayList<Turno>();

		turnos3.add(turnoManhaA3);
		turmaA3.setTurnos(turnos3);

		
		/*----------------------------------------------------------*/
		
		Turma turmaA4 = new Turma();
		turmaA4.setTurma("104-D");
		turmaA4.setSerie(serie1M);
		
		Turno turnoManhaA4 = new Turno();
		
		turnoManhaA4.setId(6L);
		
		List<Turno> turnos4 = new ArrayList<Turno>();
		
		turnos4.add(turnoManhaA4);
		turmaA4.setTurnos(turnos4);

		daoTurma.insertEntity(turmaA4);

		/*----------------------------------------------------------*/

		/*
		 * Turma turmaB1 = new Turma(); turmaB1.setTurma("201-A");
		 * 
		 * Turma turmaB2 = new Turma(); turmaB2.setTurma("202-B");
		 * 
		 * Turma turmaB3 = new Turma(); turmaB3.setTurma("203-C");
		 * 
		 * Turma turmaC1 = new Turma(); turmaC1.setTurma("301-A");
		 * 
		 * Turma turmaC2 = new Turma(); turmaC2.setTurma("302-B");
		 * 
		 * Turma turmaC3 = new Turma(); turmaC3.setTurma("303-C");
		 */

	}
	
	@Test
	public void updateTurma() {
		DaoGeneric<Turma> daoGeneric = new DaoGeneric<Turma>();
		DaoGeneric<Turno> daoTurno = new DaoGeneric<Turno>();
		
		Turma turma = daoGeneric.searchEntity(12L, Turma.class);
		Turno turno = daoTurno.searchEntity(6L, Turno.class);
		
		
		List<Turno> turnosEdit = new ArrayList<Turno>();
		turnosEdit.add(turno);
		
		turma.setTurnos(turnosEdit);

		
		turma = daoGeneric.updateEnity(turma);
		
	}
	
	@Test
	public void deleteTurma() throws Exception {
		DaoTurma<Turma> daoGeneric = new DaoTurma<Turma>();
		
		Turma turma = daoGeneric.searchEntity(12L, Turma.class);
		
		daoGeneric.deleteTurmaById(turma);
		
	}
	
	@Test
	public void listTurmas() {
		DaoTurma<Turma> daoTurma = new DaoTurma<Turma>();
		
		List<Turma> turmas = daoTurma.entityList(Turma.class);
		
		for (Turma turma : turmas) {
			System.out.println(turma.getTurma());
			System.out.println("-------------------------");
		}
		
	}
}
