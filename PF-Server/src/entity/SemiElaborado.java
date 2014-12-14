package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="semiElaborados")
public class SemiElaborado extends Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="costo")
	private double costoProduccion;
	@ManyToOne
	private Unidad unidad;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="materialSemi",joinColumns=@JoinColumn(name="codProducto"),inverseJoinColumns=@JoinColumn(name="codMaterial"))
	private List<MateriaPrima> materiales;
	
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
	public List<MateriaPrima> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MateriaPrima> materiales) {
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
