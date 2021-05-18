package br.com.curso.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.curso.vo.Professor;

public class ProfessorDaoImpl extends BaseDaoImpl<Professor, Long>
							implements ProfessorDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Professor pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Professor) sessao.get(Professor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> pesquisarPorNome(String nome,Long idProfessor, Session sessao) throws HibernateException {
		Query consulta = sessao.createQuery("from Disciplina d, Professor p where p.nome like :nome and d.id_professor = :idProfessor");
		consulta.setParameter("nome", "%" + nome + "%");
		consulta.setParameter("idProfessor", idProfessor);
		
		if(consulta.list().size() < 1) {
			consulta = sessao.createQuery("from Professor where nome like :nome");
			consulta.setParameter("nome", "%" + nome + "%");		
		}
		return consulta.list();
	}

}
