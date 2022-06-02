package com.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.enumerados.Clase;
import com.enumerados.Moneda;

@Entity
@Table(name="C_VISTA")
@PrimaryKeyJoinColumn(name="idProducto")
public class CVista extends Producto{
	
	private String tipoCuenta;
	private Moneda moneda;
	private int limMax;
	public CVista() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CVista(long idProducto, String nombreProducto, int montoMaximo, Clase clase, List<Segmento> segmento) {
		super(idProducto, nombreProducto, montoMaximo, clase, segmento);
		// TODO Auto-generated constructor stub
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Moneda getMoneda() {
		return moneda;
	}
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	public int getLimMax() {
		return limMax;
	}
	public void setLimMax(int limMax) {
		this.limMax = limMax;
	}
	
	
}
