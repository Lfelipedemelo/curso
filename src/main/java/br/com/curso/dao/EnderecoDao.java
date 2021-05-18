package br.com.curso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.curso.vo.Endereco;

public interface EnderecoDao extends BaseDao<Endereco, Long> {
	
	List<Endereco> pesquisarPorLogradouro(String logradouro, Session sessao) throws HibernateException;
}
