package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Disciplina;

public class DisciplinaDaoImpl extends BaseDaoImpl<Disciplina, Long>
							implements DisciplinaDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Disciplina pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Disciplina) sessao.get(Disciplina.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from Disciplina where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> pesquisarPorEmail(String email, Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from Professor p, Disciplina d where p.email like :email");
		consulta.setParameter("email","%" + email + "%");
		return consulta.list();
	}
}
