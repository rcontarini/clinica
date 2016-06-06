package br.com.clinica.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try {
			// Cria um sessionfactory a partir do hibernate.cfg.xml
			
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
		    SessionFactory sessionFactory =	configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
			
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
