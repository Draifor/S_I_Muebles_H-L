package modelo.vo;

import java.util.*;

public class VentaVo {

	private int id;
	private int idCliente;
	private List<ProductoVo> productos;
	private double precio;
	private Date fecha;
	private int idOrden;

	public VentaVo(int idCliente, List<ProductoVo> productos, double precio, Date fecha, int idOrden) {
		this.idCliente = idCliente;
		this.productos = productos;
		this.precio = precio;
		this.fecha = fecha;
		this.idOrden = idOrden;
	}

	public int getId() {
		return this.id;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public List<ProductoVo> getProductos() {
		return this.productos;
	}

	public void setProductos(List<ProductoVo> productos) {
		this.productos = productos;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Venta{");
		sb.append("IdVenta: ").append(this.id);
		sb.append(", IdCliente: ").append(this.idCliente);
		sb.append(", refProducto: ").append(this.productos);
		sb.append(", precio: ").append(this.precio);
		sb.append(", IdFactura: ").append(this.idOrden);
		sb.append('}');
		return sb.toString();
	}
}
