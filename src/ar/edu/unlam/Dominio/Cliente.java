package ar.edu.unlam.Dominio;

import java.util.Objects;

public class Cliente {

	private String cuitEjemplo;
	private String nombre;

	public Cliente(String cuitEjemplo, String nombre) {
		this.cuitEjemplo=cuitEjemplo;
		this.nombre=nombre;
	}

	public String getCuitEjemplo() {
		return cuitEjemplo;
	}

	public void setCuitEjemplo(String cuitEjemplo) {
		this.cuitEjemplo = cuitEjemplo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuitEjemplo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuitEjemplo, other.cuitEjemplo);
	}

}
