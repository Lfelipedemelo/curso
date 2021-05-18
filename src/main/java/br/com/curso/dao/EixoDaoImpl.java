package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Eixo;

public class EixoDaoImpl extends BaseDaoImpl<Eixo, Long>
							implements EixoDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public Eixo pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Eixo) sessao.get(Eixo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Eixo> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from Eixo where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}

	@Override
	public List<Eixo> pesquisarTodos(Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from Eixo");
		return consulta.list();
	}


}
