package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Professor;
import br.com.curso.vo.Curso;
import br.com.curso.vo.Disciplina;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class DisciplinaDaoImplTest {
	
	private Disciplina disciplina;
	private DisciplinaDao dao;
	private Session sessao;

	
	public DisciplinaDaoImplTest() {
		this.dao = new DisciplinaDaoImpl();
	}

//	@Test
	public void testAlterar() {
		pesquisarDisciplinaBD();
		disciplina.setNome(gerarDisciplina());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(disciplina, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Disciplina disciplinaAlt = dao.pesquisarPorId(disciplina.getId(), sessao);
		sessao.close();
		assertEquals(disciplina.getNome(), disciplinaAlt.getNome());
	}
	
//	@Test
	public void testSalvar() {
		ProfessorDaoImplTest professorDaoTest = new ProfessorDaoImplTest();
		Professor professorTest = professorDaoTest.pesquisarProfessorBD();
		CursoDaoImplTest cursoDaoTest = new CursoDaoImplTest();
		Curso cursoTest = cursoDaoTest.pesquisarCursoBD();
		
		disciplina = new Disciplina(gerarDisciplina(), gerarHora(5), professorTest, cursoTest);
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(disciplina, sessao);
		sessao.close();
		assertNotNull(disciplina.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarDisciplinaBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(disciplina, sessao);
		Disciplina disciplinaExc = dao.pesquisarPorId(disciplina.getId(), sessao);
		sessao.close();
		assertNull(disciplinaExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Disciplina where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	public void testPesquisarPorNome() {
		pesquisarDisciplinaBD();
		sessao = HibernateUtil.abrirSessao();
		List<Disciplina> disciplinas = dao.pesquisarPorNome(disciplina.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(disciplinas.size() > 0);
	}
	
//	@Test
	public void pesquisarPorEmail() {
		pesquisarDisciplinaBD();
		sessao = HibernateUtil.abrirSessao();
		List<Disciplina> disciplinas = dao.pesquisarPorEmail(disciplina.getProfessor().getEmail(), sessao);
		sessao.close();
		assertTrue(disciplinas.size() > 0);
	}
	
	public Disciplina pesquisarDisciplinaBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Disciplina");
		List<Disciplina> disciplinas = consulta.list();
		sessao.close();
		
		if(disciplinas.isEmpty()) {
			testSalvar();
		} else {
			disciplina = disciplinas.get(0);
		}
		
		return disciplina;
	}
}