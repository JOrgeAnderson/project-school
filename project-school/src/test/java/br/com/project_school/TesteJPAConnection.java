package br.com.project_school;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import br.com.project_school.connection.JPAConnection;
import br.com.project_school.dao.DaoGeneric;
import br.com.project_school.dao.DaoTurma;
import br.com.project_school.model.Administrador;
import br.com.project_school.model.Aluno;
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


	/* INSERINDO SERIES NO BANCO DE DADOS */
	@Test
	public void insertSerie() {
		DaoGeneric<Serie> daoSerie = new DaoGeneric<Serie>();
		
		/*6° Ano Fundamental */
		Serie serie6Ano = new Serie();
		serie6Ano.setNome("6° Ano - Fundamental");
		
		/*7° Ano Fundamental */
		Serie serie7Ano = new Serie();
		serie7Ano.setNome("7° Ano - Fundamental");
		
		/*8° Ano Fundamental */
		Serie serie8Ano = new Serie();
		serie8Ano.setNome("8° Ano - Fundamental");
		
		/*9° Ano Fundamental */
		Serie serie9Ano = new Serie();
		serie9Ano.setNome("9° Ano - Fundamental");

		/*1° Ano Médio */
		Serie serie1Medio = new Serie();
		serie1Medio.setNome("1° Ano - Médio");

		/*2° Ano Médio */
		Serie serie2Medio = new Serie();
		serie2Medio.setNome("2° Ano - Médio");

		/*3° Ano Médio */
		Serie serie3Medio = new Serie();
		serie3Medio.setNome("3° Ano - Médio");
		

		daoSerie.insertEntity(serie6Ano);
		daoSerie.insertEntity(serie7Ano);
		daoSerie.insertEntity(serie8Ano);
		daoSerie.insertEntity(serie9Ano);
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

		/*----------------------------------------------------------*/
		Serie serie6F = new Serie();
		serie6F.setId(14L);

		Turno turnoManha6F = new Turno();
		turnoManha6F.setId(6L);
		
		Turma turmaManha6 = new Turma();
		turmaManha6.setTurma("601-A");
		turmaManha6.setSerie(serie6F);
		
		List<Turno> turnos6FM = new ArrayList<Turno>();
		
		turnos6FM.add(turnoManha6F);
		turmaManha6.setTurnos(turnos6FM);

		/*----------------------------------------------------------*/

		daoTurma.insertEntity(turmaManha6);

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
	public void deleteTurma() throws Exception {
		DaoTurma<Turma> daoGeneric = new DaoTurma<Turma>();
		
		Turma turma = daoGeneric.searchEntity(12L, Turma.class);
		
		daoGeneric.deleteTurmaById(turma);
		daoGeneric.deleteById(turma);
		
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
	public void updateProfessor() {
		DaoGeneric<Professor> daoProfessor = new DaoGeneric<Professor>();
		DaoGeneric<Turma> daoTurma = new DaoGeneric<Turma>();
		
		Professor professor = daoProfessor.searchEntity(2L, Professor.class);
		Turma turma = daoTurma.searchEntity(9L, Turma.class);
		
		List<Turma> turmaEdit = new ArrayList<Turma>();
		turmaEdit.add(turma);
		
		professor.setTurmas(turmaEdit);
		
		professor = daoProfessor.updateEnity(professor);
		
		
		
	}
	
	@Test
	public void insertAluno() {
		DaoGeneric<Aluno> daoAluno = new DaoGeneric<Aluno>();
		DaoGeneric<Serie> daoSerie = new DaoGeneric<Serie>();
		
		Serie serie = daoSerie.searchEntity(5L, Serie.class);
		Aluno aluno = new Aluno();
		
		Random n = new Random();
		
		int matricula = n.nextInt(100000);
		
		aluno.setNome("Jorge Anderson Lopes Ribeiro");
		aluno.setRg("63728392-1");
		aluno.setCpf("999.232.928.89");
		aluno.setEmail("anderson.teste@email.com");
		aluno.setMatricula(String.valueOf(matricula));
		aluno.setNomeMae("Maria Rose");
		aluno.setLogin("anderson.ribeiro");
		aluno.setSenha("school123");
		aluno.setSerie(serie);
		
		daoAluno.insertEntity(aluno);
		
	}
	
	@Test
	public void updateAluno() {
		DaoGeneric<Aluno> daoAluno = new DaoGeneric<Aluno>();
		
		Aluno aluno = daoAluno.searchEntity(19L, Aluno.class);
		
		Random n = new Random();
		
		int matricula = n.nextInt(100000);
		
		aluno.setMatricula("SC"+String.valueOf(matricula));
		
		aluno = daoAluno.updateEnity(aluno);
	}
	
}
