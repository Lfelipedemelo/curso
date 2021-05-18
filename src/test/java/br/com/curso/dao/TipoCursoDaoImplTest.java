package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Eixo;
import br.com.curso.vo.TipoCurso;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class TipoCursoDaoImplTest {
	
	private TipoCurso tipoCurso;
	private TipoCursoDao dao;
	private Session sessao;

	
	public TipoCursoDaoImplTest() {
		this.dao = new TipoCursoDaoImpl();
	}


//	@Test
	public void testAlterar() {
		pesquisarTipoCursoBD();
		tipoCurso.setNome(gerarTipoCurso());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(tipoCurso, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		TipoCurso tipoCursoAlt = dao.pesquisarPorId(tipoCurso.getId(), sessao);
		sessao.close();
		assertEquals(tipoCurso.getNome(), tipoCursoAlt.getNome());
	}
	
//	@Test
	public void testSalvar() {
		tipoCurso = new TipoCurso(gerarTipoCurso(),gerarCaracter(15));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(tipoCurso, sessao);
		sessao.close();
		assertNotNull(tipoCurso.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarTipoCursoBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(tipoCurso, sessao);
		TipoCurso tipoCursoExc = dao.pesquisarPorId(tipoCurso.getId(), sessao);
		sessao.close();
		assertNull(tipoCursoExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from TipoCurso where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	public void testPesquisarPorNome() {
		pesquisarTipoCursoBD();
		sessao = HibernateUtil.abrirSessao();
		List<TipoCurso> tipoCursos = dao.pesquisarPorNome(tipoCurso.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(tipoCursos.size() > 0);
	}
	
//	@Test
	public void testPesquisarTodos() {
		pesquisarTipoCursoBD();
		sessao = HibernateUtil.abrirSessao();
		List<TipoCurso> tipoCursos = dao.pesquisarTodos(sessao);
		sessao.close();
		assertTrue(tipoCursos.size() > 0);
	}
	
	public TipoCurso pesquisarTipoCursoBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from TipoCurso");
		List<TipoCurso> tipoCursos = consulta.list();
		sessao.close();
		
		if(tipoCursos.isEmpty()) {
			testSalvar();
		} else {
			tipoCurso = tipoCursos.get(0);
		}
		
		return tipoCurso;
}

}