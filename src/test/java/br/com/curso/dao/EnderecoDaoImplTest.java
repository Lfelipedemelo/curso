package br.com.curso.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.curso.vo.Endereco;

import static org.junit.Assert.*;
import static util.GeradorUtil.*;

import java.util.List;



public class EnderecoDaoImplTest {
	
	private Endereco endereco;
	private EnderecoDao dao;
	private Session sessao;

	
	public EnderecoDaoImplTest() {
		this.dao = new EnderecoDaoImpl();
	}


//	@Test
	public void testAlterar() {
		pesquisarEnderecoBD();
		endereco.setLogradouro(gerarLogradouro());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(endereco, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Endereco enderecoAlt = dao.pesquisarPorId(endereco.getId(), sessao);
		sessao.close();
		assertEquals(endereco.getLogradouro(), enderecoAlt.getLogradouro());
	}
	
	@Test
	public void testSalvar() {
		endereco = new Endereco(gerarCep(), gerarLogradouro(), gerarBairro()
				,gerarCidade(), gerarUF(), gerarComplemento());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(endereco, sessao);
		sessao.close();
		assertNotNull(endereco.getId());
	}

//	@Test
	public void testExcluir() {
		pesquisarEnderecoBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(endereco, sessao);
		Endereco enderecoExc = dao.pesquisarPorId(endereco.getId(), sessao);
		sessao.close();
		assertNull(enderecoExc);
		
	}

//	@Test
	public void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Endereco where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	public void testPesquisarPorLogradouro() {
		pesquisarEnderecoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Endereco> enderecos = dao.pesquisarPorLogradouro(endereco.getLogradouro().substring(0, 3), sessao);
		sessao.close();
		assertTrue(enderecos.size() > 0);
	}
	
	public Endereco pesquisarEnderecoBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Endereco");
		List<Endereco> enderecos = consulta.list();
		sessao.close();
		
		if(enderecos.isEmpty()) {
			testSalvar();
		} else {
			endereco = enderecos.get(0);
		}
		
		return endereco;
}

}