package modelo.vo;

import java.util.*;

public class OrdenCompraVo {

    private int referencia;
    private int codCliente;
    private Date fecha; 
    private boolean completada;
    private boolean ventaEfectiva;

	public OrdenCompraVo(int codCliente, Date fecha, boolean completada, boolean ventaEfectiva) {
    	this.codCliente = codCliente;
    	this.fecha = fecha;
    	this.completada = completada;
    	this.ventaEfectiva = ventaEfectiva;
    }
	
	public OrdenCompraVo(int referencia, int codCliente, Date fecha, boolean completada, boolean ventaEfectiva) {
		this(codCliente, fecha, completada, ventaEfectiva);
		this.referencia = referencia;
	}

    public int getReferencia() {
    	return this.referencia;
    }

    public int getCodCliente() {
        return this.codCliente;
    }
    
    public void setCodCliente(int idCliente) {
    	this.codCliente = idCliente;
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
        sb.append("IdCliente: ").append(this.codCliente);
        sb.append(", fecha: ").append(this.fecha);
        sb.append('}');
        return sb.toString();
    }

}
