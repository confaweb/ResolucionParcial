package ar.edu.unlam.Dominio;

import java.util.Objects;

public class Venta {

	private String numTicket;
	private String cuitcliente;
	private String nombtreCliente;
	private Cliente cliente=new Cliente( cuitcliente ,  nombtreCliente);
	private String nombreVendedir;
	private String dniVendedor;
	private Vendedor vendedor=new Vendedor(dniVendedor, nombreVendedir);
	private String codigoProducto;
	private String descripcion;
	private double precio;
	private Producto producto=new Producto( codigoProducto,  descripcion,  precio);

	public Venta(String numTicket, Cliente cliente, Vendedor vendedor) {
		this.numTicket=numTicket;
		this.cliente=cliente;
		this.vendedor=vendedor;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getCuitcliente() {
		return cuitcliente;
	}

	public void setCuitcliente(String cuitcliente) {
		this.cuitcliente = cuitcliente;
	}

	public String getNombtreCliente() {
		return nombtreCliente;
	}

	public void setNombtreCliente(String nombtreCliente) {
		this.nombtreCliente = nombtreCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombreVendedir() {
		return nombreVendedir;
	}

	public void setNombreVendedir(String nombreVendedir) {
		this.nombreVendedir = nombreVendedir;
	}

	public String getDniVendedor() {
		return dniVendedor;
	}

	public void setDniVendedor(String dniVendedor) {
		this.dniVendedor = dniVendedor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numTicket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(numTicket, other.numTicket);
	}

}
