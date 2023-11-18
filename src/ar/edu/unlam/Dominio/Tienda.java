package ar.edu.unlam.Dominio;

import java.util.ArrayList;
import java.util.Objects;

import ar.edu.unlam.Exception.ClienteInexistenteException;
import ar.edu.unlam.Exception.StockInsuficienteException;
import ar.edu.unlam.Exception.VendedorInexistenteException;
import ar.edu.unlam.Exception.VendibleInexistenteException;
import ar.edu.unlam.Exception.VentaInexistenteException;

public class Tienda {
	private String cuitTienda1;
	private String nombreTienda1;
	private ArrayList<Producto> productos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Venta> libroVentas;

	public Tienda(String cuitTienda, String nombreTienda) {
		this.cuitTienda1 = cuitTienda;
		this.nombreTienda1 = nombreTienda;
		this.productos = new ArrayList<Producto>();
		this.clientes = new ArrayList<Cliente>();
		this.vendedores = new ArrayList<Vendedor>();
		this.libroVentas = new ArrayList<Venta>();
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

	public Boolean agregarProducto(Producto producto) {
		Boolean seAgrego = false;
		if (!(producto.getCodigo() == null))
			seAgrego = productos.add(producto);
		return seAgrego;
	}
	/*
	 * public Vendible getVendible(String codigo) throws
	 * VendibleInexistenteException { // Check if the vendible with the given code
	 * exists for (Vendible vendible : listaDeVendibles) { if
	 * (vendible.getCodigo().equals(codigo)) { return vendible; } }
	 * 
	 * // If the vendible is not found, throw an exception throw new
	 * VendibleInexistenteException("Vendible not found with code: " + codigo); }
	 */

	public Producto getVendible(String codigo) throws VendibleInexistenteException {
		for (Producto producto : productos)
			if (producto.getCodigo().equals(codigo))
				return producto;
		throw new VendibleInexistenteException("Producto Inexistente en lista");
	}

	public Integer getStock(Producto producto) {

		return producto.getStock();
	}

	public Integer agregarStock(Producto producto, Integer cantidad) throws VendibleInexistenteException {

		if (this.productos.contains(producto)) {
			producto.setStock(producto.getStock() + cantidad);
			return producto.getStock();
		}

		else
			throw new VendibleInexistenteException("Producto Inexistente en lista");

	}

	public Boolean agregarVendedor(Vendedor vendedor) {
		return vendedores.add(vendedor);

	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {
		for (Vendedor vendedor : vendedores)
			if (vendedor.getDniEjemplo().equals(dniEjemplo))
				return vendedor;
		throw new VendedorInexistenteException("El cliente no esta en el listado");
	}

	public Boolean agregarCliente(Cliente cliente) {
		return clientes.add(cliente);

	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {
		for (Cliente cliente : clientes)
			if (cliente.getCuitEjemplo().equals(cuitEjemplo))
				return cliente;
		throw new ClienteInexistenteException("El cliente no esta en el listado");
	}

	public void agregarVenta(Venta ticket) {
		libroVentas.add(ticket);

	}

	public void agregarProducto(Producto producto, Integer stockInicial) throws VendibleInexistenteException {
		if (this.productos.contains(producto))
			producto.setStock(stockInicial);
		throw new VendibleInexistenteException("Producto no disponible para la venta");
	}
	
	public Venta agregarProductoAVenta(String numTicket, Producto producto, Integer cantidadVendida) throws VentaInexistenteException, StockInsuficienteException {
		for(Venta ticket:libroVentas)
			if(ticket.getNumTicket().equals(numTicket)&& checkStock(producto, cantidadVendida)==true) {
				ticket.setProducto(producto);
				actualizarStock(producto,cantidadVendida);
				
				return ticket;
			}
				
			throw new VentaInexistenteException("La venta no existe. Primero debe generar una venta para agregar un producto a la misma");
	}
	private Integer actualizarStock(Producto producto, Integer cantidadVendida) {
		Integer stockActual=producto.getStock()-cantidadVendida;
		return stockActual;
		
	}

	private boolean checkStock(Producto producto,Integer cantidadVendida) throws StockInsuficienteException{
		Boolean stockSuficiente=false;
		if(producto.getStock()>=cantidadVendida) {
			stockSuficiente=true;
			return stockSuficiente;
		}
			
		throw new StockInsuficienteException("Stock insuficiente para cantidad solicitada");
		
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
