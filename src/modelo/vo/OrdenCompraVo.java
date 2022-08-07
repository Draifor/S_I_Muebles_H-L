package modelo.vo;

import java.util.*;

public class OrdenCompraVo {

    private String referencia;
    private String clienteCedula;
    private String nombre;
    private Double precio;
    private Date fecha; 
    private boolean completada;
    private boolean ventaEfectiva;

	public OrdenCompraVo(String clienteCedula, String nombre, Double precio, Date fecha, boolean completada, boolean ventaEfectiva) {
    	this.clienteCedula = clienteCedula;
    	this.nombre = nombre;
    	this.precio = precio;
    	this.fecha = fecha;
    	this.completada = completada;
    	this.ventaEfectiva = ventaEfectiva;
    }
	
	public OrdenCompraVo(String referencia, String clienteCedula, String nombre, Double precio, Date fecha, boolean completada, boolean ventaEfectiva) {
		this(clienteCedula, nombre, precio, fecha, completada, ventaEfectiva);
		this.referencia = referencia;
	}

    public String getReferencia() {
    	return this.referencia;
    }

    public String getClienteCedula() {
        return this.clienteCedula;
    }
    
    public void setClienteCedula(String clienteCedula) {
    	this.clienteCedula = clienteCedula;
    }
    
    public String getNombre() {
    	return this.nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public Double getPrecio() {
    	return this.precio;
    }
    
    public void setPrecio(Double precio) {
    	this.precio = precio;
    }

    public Date getFecha() {
		return this.fecha;
	}
    
    public void setFecha(Date fecha) {
    	this.fecha = fecha;
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
        sb.append("OrdenCompra numero: ").append(this.referencia);
        sb.append(" {");
        sb.append("IdCliente: ").append(this.clienteCedula);
        sb.append(", fecha: ").append(this.fecha);
        sb.append('}');
        return sb.toString();
    }

}
