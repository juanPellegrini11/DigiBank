package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.CVista;


@Stateless
@LocalBean
public class CuentaVistaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<CVista> obtenerTodos(){
		TypedQuery<CVista> query = em.createQuery("SELECT a FROM CVista a", CVista.class);
		return query.getResultList();
	}
	
	public List<CVista> obtenerporTipo(String tipo){
		TypedQuery<CVista> query = em.createQuery("SELECT u FROM CVista u WHERE u.tipoCuenta LIKE :tipo", CVista.class)
				.setParameter("tipo", tipo);
		return query.getResultList();
	}
}
