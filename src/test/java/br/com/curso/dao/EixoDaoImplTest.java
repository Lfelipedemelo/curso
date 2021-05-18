package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Eixo;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class EixoDaoImplTest {
	
	private Eixo eixo;
	private EixoDao dao;
	private Session sessao;

	
	public EixoDaoImplTest() {
		this.dao = new EixoDaoImpl();
	}


//	@Test
	public void testAlterar() {
		pesquisarEixoBD();
		eixo.setNome(gerarNomeEixo());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(eixo, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Eixo eixoAlt = dao.pesquisarPorId(eixo.getId(), sessao);
		sessao.close();
		assertEquals(eixo.getNome(), eixoAlt.getNome());
	}
	
	@Test
	public void testSalvar() {
		eixo = new Eixo(gerarNomeEixo(),gerarCaracter(15));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(eixo, sessao);
		sessao.close();
		assertNotNull(eixo.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarEixoBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(eixo, sessao);
		Eixo eixoExc = dao.pesquisarPorId(eixo.getId(), sessao);
		sessao.close();
		assertNull(eixoExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Eixo where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	public void testPesquisarPorNome() {
		pesquisarEixoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Eixo> eixos = dao.pesquisarPorNome(eixo.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(eixos.size() > 0);
	}
	
//	@Test
	public void testPesquisarTodos() {
		pesquisarEixoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Eixo> eixos = dao.pesquisarTodos(sessao);
		sessao.close();
		assertTrue(eixos.size() > 0);
	}
	
	public Eixo pesquisarEixoBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Eixo");
		List<Eixo> eixos = consulta.list();
		sessao.close();
		
		if(eixos.isEmpty()) {
			testSalvar();
		} else {
			eixo = eixos.get(0);
		}
		
		return eixo;
}

}