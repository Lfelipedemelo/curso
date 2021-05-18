package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Professor;

public interface ProfessorDao extends BaseDao<Professor, Long> {
	
	List<Professor> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
	List<Professor> pesquisarDisciplinas(Long id, Session sessao) throws HibernateException;
}
