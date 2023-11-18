package ar.edu.unlam.Dominio;

import java.util.Objects;

public class Vendedor {

	private String dniEjemplo;
	private String nombre;

	public Vendedor(String dniEjemplo, String nombre) {
		this.dniEjemplo=dniEjemplo;
		this.nombre=nombre;
	}

	public String getDniEjemplo() {
		return dniEjemplo;
	}

	public void setDniEjemplo(String dniEjemplo) {
		this.dniEjemplo = dniEjemplo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dniEjemplo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(dniEjemplo, other.dniEjemplo) && Objects.equals(nombre, other.nombre);
	}

}
