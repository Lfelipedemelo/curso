package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Endereco;

public class EnderecoDaoImpl extends BaseDaoImpl<Endereco, Long>
							implements EnderecoDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public Endereco pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Endereco) sessao.get(Endereco.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> pesquisarPorLogradouro(String logradouro, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from Endereco where logradouro like :logradouro");
		consulta.setParameter("logradouro", "%" + logradouro + "%");
		return consulta.list();
	}


}
