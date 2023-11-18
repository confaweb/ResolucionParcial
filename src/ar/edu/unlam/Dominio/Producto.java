package ar.edu.unlam.Dominio;

import java.util.Objects;

public class Producto implements Vendible {

	private String codigoProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;

	public Producto(String codigoProducto, String descripcion, double precio) {
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
	}

	@Override
	public String getCodigo() {
		return this.codigoProducto;
	}

	@Override
	public String getNombre() {	
		return this.descripcion;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigoProducto, other.codigoProducto);
	}
	
	

}
