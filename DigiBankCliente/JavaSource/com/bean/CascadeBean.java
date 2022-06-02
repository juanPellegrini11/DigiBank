package com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.daos.CuentaVistaDAO;
import com.daos.PAutomotorDAO;
import com.daos.PInmobiliarioDAO;
import com.daos.ProductoDAO;
import com.daos.SegmentoDAO;
import com.entidades.CVista;
import com.entidades.PAutomotor;
import com.entidades.PInmobiliario;
import com.entidades.Producto;
import com.entidades.Segmento;

@Named("cascadeBean")
@ManagedBean
@SessionScoped
public class CascadeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private SegmentoDAO segmentoDAO;
	@EJB
	private ProductoDAO productoDAO;
	@EJB
	private PAutomotorDAO pAutomotorDAO;
	@EJB
	private PInmobiliarioDAO pInmobiliarioDAO;
	@EJB
	private CuentaVistaDAO cuentaVistaDAO;
	
	private List<Producto> productos;
	private List<PAutomotor> pAutomotores;
	private List<PInmobiliario> pInmobiliarios;
	private List<CVista> cVistas;
	private List<Segmento> segmentos;
	private List<String> tiposAuto;
	
	private String selection;
	private List<SelectItemGroup> groups;
	private List<SelectItem> productosSelect;
	private Boolean aVisible;
	private Boolean iVisible;
	private Boolean cVisible;
	private Boolean ccVisible;
	private Boolean visible = true;
	
	@PostConstruct
	public void init() {
		productosSelect = new ArrayList<>();
		SelectItemGroup group1 = new SelectItemGroup("Préstamos");
		SelectItemGroup group2 = new SelectItemGroup("Cuentas Vistas");
	    
		segmentos = segmentoDAO.obtenerTodos();
		SelectItem[] selGroups = new SelectItem[segmentos.size()];
		int i =0;
		for(Segmento seg : segmentos) {
			selGroups[i] = new SelectItem(seg.getNombreSegmento());
			i++;
		}
		
		SelectItem option0 = new SelectItem("Todos");
		SelectItem option11 = new SelectItem(" Automotor");
        SelectItem option12 = new SelectItem(" Inmobiliario");
        SelectItem option21 = new SelectItem(" Caja de Ahorro");
        SelectItem option22 = new SelectItem(" Cuenta Corriente");
        
	    group1.setSelectItems(new SelectItem[]{option11, option12});
	    group2.setSelectItems(new SelectItem[]{option21, option22});

	    productosSelect.add(option0);
	    productosSelect.add(group1);
	    productosSelect.add(group2);
	    }
		
		public void onItemSelect(SelectEvent event) {
			String param = (String) event.getObject();
			if(param.equals(" Automotor")) {
				aVisible = true;
				visible = false;
				cVisible = false;
				iVisible = false;
				ccVisible = false;
				pAutomotores = pAutomotorDAO.obtenerTodos();
			}
			else if(param.equals(" Inmobiliario")) {
				visible = false;
				cVisible = false;
				aVisible = false;
				iVisible = true;
				ccVisible = false;
				pInmobiliarios = pInmobiliarioDAO.obtenerTodos();
			}
			else if(param.equals(" Caja de Ahorro")) {
				cVisible=true;
				visible = false;
				aVisible = false;
				iVisible = false;
				ccVisible = false;
				cVistas = cuentaVistaDAO.obtenerporTipo("Caja de ahorro");
			}
			
			else if(param.equals(" Cuenta Corriente")) {
				cVisible = false;
				ccVisible = true;
				visible = false;
				aVisible = false;
				iVisible = false;
				cVistas = cuentaVistaDAO.obtenerporTipo("Cuenta corriente");
			}else {
				visible = true;
				cVisible = false;
				ccVisible = false;
				aVisible = false;
				iVisible = false;
				productos = productoDAO.obtenerTodos();
			}
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Listado de Productos", (String) event.getObject());
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
		
		public void actualizarProducto(RowEditEvent<Producto> event) {
			Boolean success = true;
			success = productoDAO.existe(event.getObject().getNombreProducto());
			if(success == false) {
					try {
						productoDAO.actualizarProducto(event.getObject());
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nombre actualizado correctamente"));
						this.productos = productoDAO.obtenerTodos();
				        PrimeFaces.current().ajax().update("formX:messages", "formX");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto ya existente"));
				PrimeFaces.current().ajax().update("formX:messages", "formX");
	        }

	    }

		public SegmentoDAO getSegmentoDAO() {
			return segmentoDAO;
		}

		public void setSegmentoDAO(SegmentoDAO segmentoDAO) {
			this.segmentoDAO = segmentoDAO;
		}

		public List<Segmento> getSegmentos() {
			return segmentos;
		}

		public void setSegmentos(List<Segmento> segmentos) {
			this.segmentos = segmentos;
		}

		public String getSelection() {
			return selection;
		}

		public void setSelection(String selection) {
			this.selection = selection;
		}

		public List<SelectItemGroup> getGroups() {
			return groups;
		}

		public void setGroups(List<SelectItemGroup> groups) {
			this.groups = groups;
		}

		public List<SelectItem> getProductosSelect() {
			return productosSelect;
		}

		public void setProductosSelect(List<SelectItem> productosSelect) {
			this.productosSelect = productosSelect;
		}

		public Boolean getaVisible() {
			return aVisible;
		}

		public void setaVisible(Boolean aVisible) {
			this.aVisible = aVisible;
		}

		public Boolean getiVisible() {
			return iVisible;
		}

		public void setiVisible(Boolean iVisible) {
			this.iVisible = iVisible;
		}

		public Boolean getcVisible() {
			return cVisible;
		}

		public void setcVisible(Boolean cVisible) {
			this.cVisible = cVisible;
		}

		public Boolean getVisible() {
			return visible;
		}

		public void setVisible(Boolean visible) {
			this.visible = visible;
		}

		public List<CVista> getcVistas() {
			return cVistas;
		}

		public void setcVistas(List<CVista> cVistas) {
			this.cVistas = cVistas;
		}

		public List<PAutomotor> getpAutomotores() {
			return pAutomotores;
		}

		public void setpAutomotores(List<PAutomotor> pAutomotores) {
			this.pAutomotores = pAutomotores;
		}

		public List<PInmobiliario> getpInmobiliarios() {
			return pInmobiliarios;
		}

		public void setpInmobiliarios(List<PInmobiliario> pInmobiliarios) {
			this.pInmobiliarios = pInmobiliarios;
		}

		public Boolean getCcVisible() {
			return ccVisible;
		}

		public void setCcVisible(Boolean ccVisible) {
			this.ccVisible = ccVisible;
		}

		public List<String> getTiposAuto() {
			return tiposAuto;
		}

		public void setTiposAuto(List<String> tiposAuto) {
			this.tiposAuto = tiposAuto;
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
		
		public List<Producto> obtenerProducto(){
			productos = null;
			productos = productoDAO.obtenerTodos();
			System.out.println(productos.get(0).getNombreProducto());
			return productos;
		}
	
		private String segmento;
		public void setSegmento(String segmento) {
			this.segmento = segmento;
		}

		public String getSegmento() {
			segmento = "";
			for(Segmento s: this.segmentos) {
				if(segmento.equals("")) {
					segmento = s.getNombreSegmento();
				}else {
					segmento = segmento + ", " + s.getNombreSegmento();
				}
			}
			return segmento;
		}
	    
}
