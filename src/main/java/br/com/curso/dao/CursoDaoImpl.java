package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Curso;

public class CursoDaoImpl extends BaseDaoImpl<Curso, Long>
							implements CursoDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public Curso pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Curso) sessao.get(Curso.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> pesquisarPorNome(String nome, Session sessao) throws HibernateException {		
		Query consulta = sessao.createQuery("from Curso c left join fetch c.disciplinas"
				+ " where c.nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> pesquisarPorSigla(String sigla, Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from Curso c left join fetch c.disciplinas"
				+ " where c.sigla like :sigla");
		consulta.setParameter("sigla", "%" + sigla + "%");
		return consulta.list();
	}


}
