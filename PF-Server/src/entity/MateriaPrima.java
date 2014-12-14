package entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="materiales")
public class MateriaPrima implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codMaterial")
	private String codigo;
	@Column
	private String descripcion;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="unCompra")
	private Unidad unidadCompra;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="unUso")
	private Unidad unidadUso;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Unidad getUnidadCompra() {
		return unidadCompra;
	}
	public void setUnidadCompra(Unidad unidadCompra) {
		this.unidadCompra = unidadCompra;
	}
	public Unidad getUnidadUso() {
		return unidadUso;
	}
	public void setUnidadUso(Unidad unidadUso) {
		this.unidadUso = unidadUso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MateriaPrima other = (MateriaPrima) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
}
