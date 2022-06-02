package com.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SEGMENTO")
public class Segmento {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idSegmento;
	private String nombreSegmento;
	@ManyToMany(mappedBy = "segmento")
	private List<Producto> productos;
	
	
	public Segmento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Segmento(long idSegmento, String nombreSegmento) {
		super();
		this.idSegmento = idSegmento;
		this.nombreSegmento = nombreSegmento;
	}

	public long getIdSegmento() {
		return idSegmento;
	}

	public void setIdSegmento(long idSegmento) {
		this.idSegmento = idSegmento;
	}

	public String getNombreSegmento() {
		return nombreSegmento;
	}

	public void setNombreSegmento(String nombreSegmento) {
		this.nombreSegmento = nombreSegmento;
	}
	
	
}
