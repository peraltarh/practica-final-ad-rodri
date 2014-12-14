package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Elaborado extends Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private float precioVenta;
	private int porcentajeGanancia;
	private Unidad unidad;
	private ArrayList<Producto>componentes;
	
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public ArrayList<Producto> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Producto> componentes) {
		this.componentes = componentes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + porcentajeGanancia;
		result = prime * result + Float.floatToIntBits(precioVenta);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elaborado other = (Elaborado) obj;
		if (porcentajeGanancia != other.porcentajeGanancia)
			return false;
		if (Float.floatToIntBits(precioVenta) != Float
				.floatToIntBits(other.precioVenta))
			return false;
		return true;
	}
}
