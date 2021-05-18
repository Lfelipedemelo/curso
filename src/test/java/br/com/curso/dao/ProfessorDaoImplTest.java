package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Endereco;
import br.com.curso.vo.Professor;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class ProfessorDaoImplTest {
	
	private Professor professor;
	private ProfessorDao dao;
	private Session sessao;

	
	public ProfessorDaoImplTest() {
		this.dao = new ProfessorDaoImpl();
	}

//	@Test
	public void testAlterar() {
		pesquisarProfessorBD();
		professor.setNome(gerarNome());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(professor, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Professor professorAlt = dao.pesquisarPorId(professor.getId(), sessao);
		sessao.close();
		assertEquals(professor.getNome(), professorAlt.getNome());
	}
	
//	@Test
	public void testSalvar() {
		EnderecoDaoImplTest enderecoDaoTest = new EnderecoDaoImplTest();
		Endereco enderecoTest = enderecoDaoTest.pesquisarEnderecoBD();
		
		professor = new Professor(gerarNome(), gerarEmail(), gerarTeleCelular()
				, enderecoTest);
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(professor, sessao);
		sessao.close();
		assertNotNull(professor.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarProfessorBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(professor, sessao);
		Professor professorExc = dao.pesquisarPorId(professor.getId(), sessao);
		sessao.close();
		assertNull(professorExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Professor where id = :id");
		consulta.setParameter("id", consulta);
	}

	@Test
	public void testPesquisarPorNome() {
		pesquisarProfessorBD();
		sessao = HibernateUtil.abrirSessao();
		List<Professor> professores = dao.pesquisarPorNome(professor.getNome(), sessao);
		sessao.close();
		assertTrue(professores.size() > 0);
	}
		
	public Professor pesquisarProfessorBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Professor");
		List<Professor> professores = consulta.list();
		sessao.close();
		
		if(professores.isEmpty()) {
			testSalvar();
		} else {
			professor = professores.get(0);
		}
		
		return professor;
	}
}