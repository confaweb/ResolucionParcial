package ar.edu.unlam.Dominio;

import java.util.ArrayList;
import java.util.Objects;

import ar.edu.unlam.Exception.VendibleInexistenteException;

public class Tienda {
	private String cuitTienda1;
	private String nombreTienda1;
	private ArrayList<Producto> productos;

	public Tienda(String cuitTienda, String nombreTienda) {
		this.cuitTienda1 = cuitTienda;
		this.nombreTienda1 = nombreTienda;
		this.productos = new ArrayList<Producto>();
	}

	public String getCuitTienda() {
		return cuitTienda1;
	}

	public void setCuitTienda(String cuitTienda) {
		this.cuitTienda1 = cuitTienda;
	}

	public String getNombreTienda() {
		return nombreTienda1;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda1 = nombreTienda;
	}

	public Boolean agregarProducto(Producto producto) throws VendibleInexistenteException {
		Boolean seAgrego = false;
		if (!(producto.getCodigo() == null))
			seAgrego = productos.add(producto);
		else
			throw new VendibleInexistenteException();
		return seAgrego;
	}

	public Producto getVendible(String codigo) {
		return getVendible(codigo);
	}
	public Integer getStock(Producto producto) {
		
		return producto.getStock();
	}
	
	
		public Integer agregarStock(Producto producto, Integer cantidad) throws VendibleInexistenteException {
			Integer stock = producto.getStock();
			if (agregarProducto( producto) == true)
				stock += cantidad;
			else
				throw new VendibleInexistenteException();
			return stock;
		}
		
			
			
		
	
	

	@Override
	public int hashCode() {
		return Objects.hash(cuitTienda1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tienda other = (Tienda) obj;
		return Objects.equals(cuitTienda1, other.cuitTienda1);
	}

	



}
