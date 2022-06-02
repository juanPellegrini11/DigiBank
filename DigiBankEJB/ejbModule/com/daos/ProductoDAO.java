package com.daos;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entidades.PAutomotor;
import com.entidades.Producto;

@Stateless
@LocalBean
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void actualizarProducto(Producto producto) throws SQLException{
		this.em.merge(producto);
	}
	
	public List<Producto> obtenerTodos(){
		TypedQuery<Producto> query = em.createQuery("SELECT a FROM Producto a", Producto.class);
		return query.getResultList();
	}
	
	public Boolean existe2(String nombre) {
		try {		
			Query q = em.createQuery("SELECT u FROM Producto u WHERE u.nombreProducto LIKE :nombre", Producto.class);
			q.setParameter("nombre", nombre);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public boolean existe(String nombre){
		try {
			TypedQuery<Producto> query = em.createQuery("SELECT t FROM Producto t WHERE t.nombreProducto = :nombre", Producto.class);
			query.setParameter("nombre", nombre);
			Producto prodReturn = query.getSingleResult();
			if (prodReturn == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}  
	
	public List<Producto> obtenerTipoProducto(String tipo){
		TypedQuery<Producto> query = this.em.createNamedQuery("SELECT a FROM " + tipo + " a", Producto.class);
		return query.getResultList();
	}
	
	public List<Producto> obtenerPorSegmento(String segmento){
		TypedQuery<Producto> query = this.em.createNamedQuery("SELECT a FROM Producto a WHERE a.segmento LIKE :segmento", Producto.class)
				.setParameter("segmento", segmento);
		return query.getResultList();
	}
	
	public List<PAutomotor> obtenerPAutoTipo(String tipo){
		TypedQuery<PAutomotor> query = em.createQuery("SELECT a FROM PAutomotor a WHERE a.tipoVe LIKE :tipo", PAutomotor.class)
				.setParameter("pautomotor", tipo);
		return query.getResultList();
	}
	
}
