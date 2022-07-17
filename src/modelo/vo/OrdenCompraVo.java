package modelo.vo;

import java.util.*;

public class OrdenCompraVo {

    private int id;
    private int idCliente;
    private Date fecha; 
    private List<ProductoVo> productos = new ArrayList<>(); 
    
    private OrdenCompraVo(int idCliente) {
    	this.idCliente = idCliente;
    }
    
    private OrdenCompraVo(int idCliente, Date fecha) {
    	this.idCliente = idCliente;
    	this.fecha = fecha;
    }

    private OrdenCompraVo(int idCliente, Date fecha, List<ProductoVo> productos) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.productos = productos;
    }
    
    private OrdenCompraVo(int id, int idCliente, Date fecha, List<ProductoVo> productos) {
    	this.id = id;
    	this.idCliente = idCliente;
    	this.fecha = fecha;
    	this.productos = productos;
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

    public Date getFecha() {
		return this.fecha;
	}
    
    public void setFecha(Date fecha) {
    	this.fecha = fecha;
    }

	public List<ProductoVo> getProductos() {
		return this.productos;
	}

	public void setProductos(List<ProductoVo> productos) {
		this.productos = productos;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdenCompra numero: ").append(this.id);
        sb.append(" {");
        sb.append("IdCliente: ").append(this.idCliente);
        sb.append(", Productos: ").append(this.productos);
        sb.append(", fecha: ").append(this.fecha);
        sb.append('}');
        return sb.toString();
    }

}
