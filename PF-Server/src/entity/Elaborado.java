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
@Table(name="elaborados")
public class Elaborado extends Producto implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Column
	private float precioVenta;
	@Column(columnDefinition="decimal")
	private int porcentajeGanancia;
	@ManyToOne
	private Unidad unidad;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="compuestoDe",joinColumns=@JoinColumn(name="codProductoE"),inverseJoinColumns=@JoinColumn(name="codProductoSM"))
	private List<SemiElaborado>componentes;
	
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
	public List<SemiElaborado> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<SemiElaborado> componentes) {
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
