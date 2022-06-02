package com.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.enumerados.Clase;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="PRODUCTO")
public class Producto {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idProducto")
	private long idProducto;
	@Column(unique=true)
	private String nombreProducto;
	private int montoMaximo;
	private Clase clase;
	@ManyToMany
	@JoinTable(
			  name = "PRODUCTO_SEGMENTO", 
			  joinColumns = @JoinColumn(name = "idProducto"), 
			  inverseJoinColumns = @JoinColumn(name = "idSegmento"))
	private List<Segmento> segmento;
	
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Producto(long idProducto, String nombreProducto, int montoMaximo, Clase clase, List<Segmento> segmento) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.montoMaximo = montoMaximo;
		this.clase = clase;
		this.segmento = segmento;
	}
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
	public List<Segmento> getSegmento() {
		return segmento;
	}
	public void setSegmento(List<Segmento> segmento) {
		this.segmento = segmento;
	}
	
	@Override
    public Producto clone() {
        return new Producto(getIdProducto(), getNombreProducto(), getMontoMaximo(), getClase(), getSegmento());
    }

	public String getSegmentos() {
		String segmentos = "";
		for(Segmento s: this.segmento) {
			if(segmentos.equals("")) {
				segmentos = s.getNombreSegmento();
			}else {
				segmentos = segmentos + ", " + s.getNombreSegmento();
			}
		}
		return segmentos;
	}
}
