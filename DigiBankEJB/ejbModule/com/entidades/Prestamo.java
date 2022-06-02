package com.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.enumerados.Clase;

@Entity
@Table(name="PRESTAMO")
@PrimaryKeyJoinColumn(name="idProducto")
public class Prestamo extends Producto{

	private int valorCuota;
	@Min(12)
	@Max(240)
	private int cantidadCuotas;
	
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prestamo(long idProducto, String nombreProducto, int montoMaximo, Clase clase, List<Segmento> segmento) {
		super(idProducto, nombreProducto, montoMaximo, clase, segmento);
		// TODO Auto-generated constructor stub
	}
	
	public int getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(int valorCuota) {
		this.valorCuota = valorCuota;
	}
	public int getCantidadCuotas() {
		return cantidadCuotas;
	}
	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	
	
	
}
