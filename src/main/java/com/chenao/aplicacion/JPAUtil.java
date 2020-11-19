package com.chenao.aplicacion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class JPAUtil {
	
	public JPAUtil() {
		System.out.println("En el constructor de JPAUtil");
	}

	private static final String UNIDAD_DE_PERSISTENCIA="PruebaHibernate";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		System.out.println("En Factory en el proyecto 2: "+factory);
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
			System.out.println("Factory en el if: "+factory);
		}

		return factory;
	}
	
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
			factory=null;
		}
	}
	
}
