package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Eixo;

public interface EixoDao extends BaseDao<Eixo, Long> {
	
	List<Eixo> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
	List<Eixo> pesquisarTodos(Session sessao) throws HibernateException;
}
