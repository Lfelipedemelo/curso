package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Curso;
import br.com.curso.vo.Eixo;
import br.com.curso.vo.TipoCurso;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class CursoDaoImplTest {
	
	private Curso curso;
	private CursoDao dao;
	private Session sessao;

	
	public CursoDaoImplTest() {
		this.dao = new CursoDaoImpl();
	}


//	@Test
	public void testAlterar() {
		pesquisarCursoBD();
		curso.setNome(gerarCurso());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(curso, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Curso cursoAlt = dao.pesquisarPorId(curso.getId(), sessao);
		sessao.close();
		assertEquals(curso.getNome(), cursoAlt.getNome());
	}
	
//	@Test
	public void testSalvar() {
		EixoDaoImplTest eixoDao = new EixoDaoImplTest();
		TipoCursoDaoImplTest tipoCursoDao = new TipoCursoDaoImplTest();
		Eixo eixo = eixoDao.pesquisarEixoBD();
		TipoCurso tipoCurso = tipoCursoDao.pesquisarTipoCursoBD();
		
		
		curso = new Curso(gerarCurso(), gerarCaracter(2), gerarHora(5),eixo, tipoCurso);
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(curso, sessao);
		sessao.close();
		assertNotNull(curso.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarCursoBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(curso, sessao);
		Curso cursoExc = dao.pesquisarPorId(curso.getId(), sessao);
		sessao.close();
		assertNull(cursoExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Curso where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	public void testPesquisarPorNome() {
		pesquisarCursoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Curso> cursos = dao.pesquisarPorNome(curso.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(cursos.size() > 0);
	}

	@Test
	public void pesquisarPorSigla() {
		pesquisarCursoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Curso> cursos = dao.pesquisarPorSigla(curso.getSigla(), sessao);
		sessao.close();
		assertTrue(cursos.size() > 0);
	}
	
	public Curso pesquisarCursoBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Curso");
		List<Curso> cursos = consulta.list();
		sessao.close();
		
		if(cursos.isEmpty()) {
			testSalvar();
		} else {
			curso = cursos.get(0);
		}
		
		return curso;
	}
	

}