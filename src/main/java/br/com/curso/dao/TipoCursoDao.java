package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Eixo;
import br.com.curso.vo.TipoCurso;

public interface TipoCursoDao extends BaseDao<TipoCurso, Long> {
	
	List<TipoCurso> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
	List<TipoCurso> pesquisarTodos(Session sessao) throws HibernateException;
}
