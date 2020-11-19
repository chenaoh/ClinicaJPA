package com.chenao.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.chenao.aplicacion.JPAUtil;
import com.chenao.entidades.Persona;

public class PersonaDao {
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarPersona(Persona miPersona) {
		System.out.println("En registrar JPA llega:\n"+miPersona);
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miPersona);
			entityManager.getTransaction().commit();
			
			resp="Persona Registrada!";
			
		} catch (Exception e) {
			System.out.println("No se puede registrar la persona");
			e.printStackTrace();
			// org.hibernate.PersistentObjectException: detached entity passed to persist: com.chenao.entidades.Nacimiento
		}
	
		return resp;
	}
	
	public Persona consultarPersona(Long idPersona) {
	
		Persona miPersona=entityManager.find(Persona.class,idPersona);
		
		if (miPersona!=null) {
			return miPersona;
		}else {
			return null;
		}
		
	}
	
	public List<Persona> consultarListaPersonas() {
	
		List<Persona> listaPersonas=new ArrayList<Persona>();
		Query query=entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonas=query.getResultList();
		
		return listaPersonas;
	}
	
	public String actualizarPersona(Persona miPersona) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miPersona);
			entityManager.getTransaction().commit();
			
			resp="Persona Actualizada!";
			
		} catch (Exception e) {
			System.out.println("No se puede Actualizar la persona");
			e.printStackTrace();
		}
	
		return resp;
	}
	
	public String eliminarPersona(Persona miPersona) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			resp="Persona Eliminada!";
		} catch (Exception e) {
			//e.printStackTrace();
			resp="No se puede eliminar, verifique que no tenga mascotas asociadas";
			System.out.println(resp);		
		}		
		return resp;
	}

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
}
