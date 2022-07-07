package modelo;

import java.util.Date;

public class OrdenCompra {

    private int idOrden;
    private int idCliente;
    private Producto[] productos;
    private Diseño[] diseños;
    private Date fecha;  // Cómo y dónde agregar la fecha
    private static int contadorOrdenes;

    private OrdenCompra(int idCliente) {
        this.idOrden = ++OrdenCompra.contadorOrdenes;
        this.idCliente = idCliente;
    }

    public OrdenCompra(int idCliente, Producto[] productos) {
        this(idCliente);
        this.productos = productos;
    }

    public OrdenCompra(int idCliente, Diseño[] diseños) {
        this(idCliente);
        this.diseños = diseños;
    }

    public OrdenCompra(int idCliente, Diseño[] diseños, Producto[] productos) {
        this(idCliente);
        this.diseños = diseños;
        this.productos = productos;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.idCliente = idCliente;
    }

    public int getIdOrden() {
        return this.idOrden;
    }

    public Producto[] getProductos() {
        return this.productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

     public Diseño[] getDiseños() {
        return this.diseños;
    }

    public void setDiseños(Diseño[] diseños) {
        this.diseños = diseños;
    }

    // Getter and Setter fecha??
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdenCompra numero: ").append(this.idOrden);
        sb.append(" {");
        sb.append("IdCliente: ").append(this.idCliente);
        sb.append(", Productos: ").append(this.productos);
        sb.append(", fecha: ").append(this.fecha);
        sb.append('}');
        return sb.toString();
    }

}
