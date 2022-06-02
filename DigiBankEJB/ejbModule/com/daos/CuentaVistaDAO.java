package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.CVista;
import com.entidades.Segmento;
import com.enumerados.Clase;
import com.enumerados.Moneda;


@Stateless
@LocalBean
public class CuentaVistaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<CVista> obtenerTodos(){
		TypedQuery<CVista> query = em.createQuery("SELECT a FROM CVista a", CVista.class);
		return query.getResultList();
	}
	
	public void nuevaCuenta (String nombreProducto, Clase clase, List<Segmento> segmento, String tipoCuenta, Moneda moneda, int limMax){
		CVista c =new CVista();
		c.setNombreProducto(nombreProducto);
		c.setClase(clase);
		c.setSegmento(segmento);
		c.setTipoCuenta(tipoCuenta);
		c.setMoneda(moneda);
		c.setLimMax(limMax);
		c.setMontoMaximo(limMax);
		try{
			this.em.persist(c);
		}catch(Exception e){
		}
	}
	
	public List<CVista> obtenerporTipo(String tipo){
		TypedQuery<CVista> query = em.createQuery("SELECT u FROM CVista u WHERE u.tipoCuenta LIKE :tipo", CVista.class)
				.setParameter("tipo", tipo);
		return query.getResultList();
	}
}
