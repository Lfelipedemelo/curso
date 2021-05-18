package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Curso;

public interface CursoDao extends BaseDao<Curso, Long> {
	
	List<Curso> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
	List<Curso> pesquisarPorSigla(String sigla, Session sessao) throws HibernateException;
}
