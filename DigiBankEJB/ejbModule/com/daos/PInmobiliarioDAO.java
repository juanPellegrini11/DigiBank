package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.PInmobiliario;


@Stateless
@LocalBean
public class PInmobiliarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<PInmobiliario> obtenerTodos(){
		TypedQuery<PInmobiliario> query = em.createQuery("SELECT a FROM PInmobiliario a", PInmobiliario.class);
		return query.getResultList();
	}
}
