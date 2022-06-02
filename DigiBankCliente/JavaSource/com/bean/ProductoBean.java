package com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.component.api.UIData;

import com.daos.ProductoDAO;
import com.entidades.Producto;
import com.entidades.Segmento;
import com.enumerados.Clase;



@Named("producto")
@ManagedBean
@SessionScoped

public class ProductoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private ProductoDAO productoDAO;
	
	private long idProducto;
	private String nombreProducto;
	private int montoMaximo;
	private Clase clase;
	private List<Segmento> segmentos;
	private UIData dtListado;
	private List<Producto> listaProductos;
	private String segmento;
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getMontoMaximo() {
		return montoMaximo;
	}
	public void setMontoMaximo(int montoMaximo) {
		this.montoMaximo = montoMaximo;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public List<Segmento> getSegmentos() {
		return segmentos;
	}
	
	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}
	
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public UIData getDtListado() {
		return dtListado;
	}
	public void setDtListado(UIData dtListado) {
		this.dtListado = dtListado;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	

	public List<Producto> obtenerProducto(){
		listaProductos = null;
		listaProductos = productoDAO.obtenerTodos();
		return listaProductos;
	}
	
	public void actualizarProducto(Producto producto) {
		Boolean success = true;
			success = productoDAO.existe(producto.getNombreProducto());
			if(success == false) {
				try {
					productoDAO.actualizarProducto(producto);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito","Nombre actualizado correctamente"));
			        PrimeFaces.current().ajax().update("formX:messages", "formX");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo modificar", "Producto ya existente"));
	        PrimeFaces.current().ajax().update("formX:messages");
	        }
	}
	
}
