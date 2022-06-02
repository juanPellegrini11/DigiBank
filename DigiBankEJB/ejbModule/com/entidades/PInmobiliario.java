package com.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.enumerados.Clase;
import com.enumerados.TipoInmueble;

@Entity
@Table(name="P_INMOBILIARIO")
@PrimaryKeyJoinColumn(name="idProducto")
public class PInmobiliario extends Prestamo{

	private TipoInmueble tipoInm;

	public PInmobiliario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PInmobiliario(long idProducto, String nombreProducto, int montoMaximo, Clase clase,
			List<Segmento> segmento) {
		super(idProducto, nombreProducto, montoMaximo, clase, segmento);
		// TODO Auto-generated constructor stub
	}

	public TipoInmueble getTipoInm() {
		return tipoInm;
	}

	public void setTipoInm(TipoInmueble tipoInm) {
		this.tipoInm = tipoInm;
	}
	
}
