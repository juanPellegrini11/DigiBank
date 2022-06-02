package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.entidades.CVista;
import com.entidades.PAutomotor;
import com.entidades.PInmobiliario;
import com.entidades.Producto;

@Named
@ViewScoped
public class CrudView implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Producto> Productos;
    private List<CVista> cuentas;
    private List<PAutomotor> pAutomotores;
    private List<PInmobiliario> pInmobiliarios;
    private Producto selectedProducto;

    private List<Producto> selectedProductos;
    private List<CVista> selectedCuentas;
    private List<PAutomotor> selectedPAutomotores;
    private List<PInmobiliario> selectedPinmobiliarios;
    private Boolean visible;
    private List<String> tiposAuto;
	
    @Inject
    private ProductoBean productoBean;

    @PostConstruct
    public void init() {
    	this.Productos = productoBean.obtenerProducto();
 //       this.Productos = this.productoBean.getClonedProductos(100);
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public List<Producto> getSelectedProductos() {
        return selectedProductos;
    }

    public void setSelectedProductos(List<Producto> selectedProductos) {
        this.selectedProductos = selectedProductos;
    }

    public void openNew() {
        this.selectedProducto = new Producto();
    }
    
    public void actualizaProducto(){
    	productoBean.actualizarProducto(this.selectedProducto);
    }

    public boolean hasSelectedProductos() {
        return this.selectedProductos != null && !this.selectedProductos.isEmpty();
    }

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<CVista> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CVista> cuentas) {
		this.cuentas = cuentas;
	}

	public List<CVista> getSelectedCuentas() {
		return selectedCuentas;
	}

	public void setSelectedCuentas(List<CVista> selectedCuentas) {
		this.selectedCuentas = selectedCuentas;
	}

	public List<PAutomotor> getpAutomotores() {
		return pAutomotores;
	}

	public void setpAutomotores(List<PAutomotor> pAutomotores) {
		this.pAutomotores = pAutomotores;
	}

	public List<PAutomotor> getSelectedPAutomotores() {
		return selectedPAutomotores;
	}

	public void setSelectedPAutomotores(List<PAutomotor> selectedPAutomotores) {
		this.selectedPAutomotores = selectedPAutomotores;
	}

	public List<PInmobiliario> getpInmobiliarios() {
		return pInmobiliarios;
	}

	public void setpInmobiliarios(List<PInmobiliario> pInmobiliarios) {
		this.pInmobiliarios = pInmobiliarios;
	}

	public List<PInmobiliario> getSelectedPinmobiliarios() {
		return selectedPinmobiliarios;
	}

	public void setSelectedPinmobiliarios(List<PInmobiliario> selectedPinmobiliarios) {
		this.selectedPinmobiliarios = selectedPinmobiliarios;
	}

	public List<String> getTiposAuto() {
		return tiposAuto;
	}

	public void setTiposAuto(List<String> tiposAuto) {
		this.tiposAuto = tiposAuto;
	}
	
}