package br.com.clinica.test;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import br.com.clinica.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		openSession.close();
		HibernateUtil.getSessionfactory().close();
	}

}
