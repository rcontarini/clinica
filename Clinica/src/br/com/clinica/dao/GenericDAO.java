package br.com.clinica.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.clinica.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade){
		
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = openSession.beginTransaction();
			openSession.save(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			
			throw e;
		} finally {
			openSession.close();
		}
	}
	
	public List<Entidade> listar(){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		
		try {
			Criteria consulta = openSession.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			openSession.close();
		}
	}
	
	public Entidade buscarPorCRP(String crp){
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.eq("crp", crp));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		
	}
	
	public Entidade buscar(Long codigo){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		
		try {
			Criteria consulta = openSession.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			
			throw e;
		} finally {
			openSession.close();
		}
	}
	
	public void excluir(Entidade entidade){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = openSession.beginTransaction();
			openSession.delete(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		}finally {
			openSession.close();
		}
	}
	
	public void editar (Entidade entidade){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = openSession.beginTransaction();
			openSession.update(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			
			throw e;
		} finally {
			openSession.close();
		}
	}
	
	public void merge(Entidade entidade){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = openSession.beginTransaction();
			openSession.merge(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		} finally {
			openSession.close();
		}
	}

}
