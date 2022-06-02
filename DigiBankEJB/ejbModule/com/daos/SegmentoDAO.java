package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Segmento;

@Stateless
@LocalBean
public class SegmentoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Segmento> obtenerTodos(){
		TypedQuery<Segmento> query = em.createQuery("SELECT a FROM Segmento a", Segmento.class);
		return query.getResultList();
	}
}
