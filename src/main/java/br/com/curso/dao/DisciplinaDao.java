package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Disciplina;

public interface DisciplinaDao extends BaseDao<Disciplina, Long> {
	
	List<Disciplina> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
	List<Disciplina> pesquisarPorEmail(String email, Session sessao) throws HibernateException;
}
