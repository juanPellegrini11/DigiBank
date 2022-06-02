package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.PAutomotor;

@Stateless
@LocalBean
public class PAutomotorDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<PAutomotor> obtenerTodos(){
		TypedQuery<PAutomotor> query = em.createQuery("SELECT a FROM PAutomotor a", PAutomotor.class);
		return query.getResultList();
	}
}
