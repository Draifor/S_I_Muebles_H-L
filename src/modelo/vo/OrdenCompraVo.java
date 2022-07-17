package modelo.vo;

import java.util.*;

public class OrdenCompraVo {

    private int id;
    private int idCliente;
    private List<ProductoVo> productos; 
    private List<DiseñoVo> diseños; 
    private Date fecha; 
    private boolean completada;
    private boolean ventaEfectiva;

	public OrdenCompraVo(int idCliente, Date fecha, boolean completada, boolean ventaEfectiva) {
    	this.idCliente = idCliente;
    	this.fecha = fecha;
    	this.completada = completada;
    	this.ventaEfectiva = ventaEfectiva;
    }
	
	public OrdenCompraVo(int id, int idCliente, Date fecha, boolean completada, boolean ventaEfectiva) {
		this(idCliente, fecha, completada, ventaEfectiva);
		this.id = id;
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
	
	public List<DiseñoVo> getDiseños() {
		return this.diseños;
	}
	
	public void setDiseños(List<DiseñoVo> diseños) {
		this.diseños = diseños;
	}

	public boolean isCompletada() {
		return this.completada;
	}
	
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	
	public boolean isVentaEfectiva() {
		return this.ventaEfectiva;
	}
	
	public void setVentaEfectiva(boolean ventaEfectiva) {
		this.ventaEfectiva = ventaEfectiva;
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
