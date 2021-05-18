package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Eixo;
import br.com.curso.vo.TipoCurso;

public class TipoCursoDaoImpl extends BaseDaoImpl<TipoCurso, Long>
							implements TipoCursoDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public TipoCurso pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (TipoCurso) sessao.get(TipoCurso.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCurso> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from TipoCurso where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}

	@Override
	public List<TipoCurso> pesquisarTodos(Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from TipoCurso");
		return consulta.list();
	}
}
