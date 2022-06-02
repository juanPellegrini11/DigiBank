package com.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.enumerados.Clase;
import com.enumerados.TipoVehiculo;

@Entity
@Table(name="P_AUTOMOTOR")
@PrimaryKeyJoinColumn(name="idProducto")
public class PAutomotor extends Prestamo{

	private TipoVehiculo tipoVe;

	public PAutomotor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PAutomotor(long idProducto, String nombreProducto, int montoMaximo, Clase clase, List<Segmento> segmento) {
		super(idProducto, nombreProducto, montoMaximo, clase, segmento);
		// TODO Auto-generated constructor stub
	}

	public TipoVehiculo getTipoVe() {
		return tipoVe;
	}

	public void setTipoVe(TipoVehiculo tipoVe) {
		this.tipoVe = tipoVe;
	}
	
	
}
