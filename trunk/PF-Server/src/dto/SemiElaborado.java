package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class SemiElaborado extends Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private double costoProduccion;
	private Unidad unidad;
	private ArrayList<MateriaPrima> materiales;
	
	public double getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public ArrayList<MateriaPrima> getMateriales() {
		return materiales;
	}
	public void setMateriales(ArrayList<MateriaPrima> materiales) {
		this.materiales = materiales;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(costoProduccion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SemiElaborado other = (SemiElaborado) obj;
		if (Double.doubleToLongBits(costoProduccion) != Double
				.doubleToLongBits(other.costoProduccion))
			return false;
		return true;
	}
}
