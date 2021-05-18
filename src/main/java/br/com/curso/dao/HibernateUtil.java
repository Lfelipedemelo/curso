package br.com.curso.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.curso.vo.Curso;
import br.com.curso.vo.Disciplina;
import br.com.curso.vo.Eixo;
import br.com.curso.vo.Endereco;
import br.com.curso.vo.Professor;
import br.com.curso.vo.TipoCurso;

public class HibernateUtil {

    private static final SessionFactory sessionFactory; //singleton
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Professor.class);
            cfg.addAnnotatedClass(Eixo.class);
            cfg.addAnnotatedClass(TipoCurso.class);
            cfg.addAnnotatedClass(Curso.class);
            cfg.addAnnotatedClass(Disciplina.class);

            

            cfg.configure("/br/com/curso/dao/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abrirSessao() {
        return sessionFactory.openSession();
    }
}
