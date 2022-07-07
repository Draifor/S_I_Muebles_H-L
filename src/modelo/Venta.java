package modelo;

public class Venta {

    private int IdVenta;
    private int IdCliente;
    private int IdOrden;
    private Producto[] productos;
    private double precio;
    private static int contadorVentas;

    public Venta(int IdCliente, int IdOrden, Producto[] productos, double precio) {
        this.IdVenta = ++Venta.contadorVentas;
        this.IdCliente = IdCliente;
        this.IdOrden = IdOrden;
        this.productos = productos;
        this.precio = precio;
    }

    public int getIdVenta() {
        return this.IdVenta;
    }

    public int getIdCliente() {
        return this.IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdOrden() {
        return this.IdOrden;
    }

    public void setIdOrden(int IdFactura) {
        this.IdOrden = IdFactura;
    }

    public Producto[] getProductos() {
        return this.productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("IdVenta: ").append(this.IdVenta);
        sb.append(", IdCliente: ").append(this.IdCliente);
        sb.append(", IdFactura: ").append(this.IdOrden);
        sb.append(", refProducto: ").append(this.productos);
        sb.append(", precio: ").append(this.precio);
        sb.append('}');
        return sb.toString();
    }
}
