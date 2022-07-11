package modelo.vo;

public class VentaVo {

    private int IdVenta;
    private int IdCliente;
    private int IdOrden;
    private ProductoVo[] productoVos;
    private double precio;
    private static int contadorVentas;

    public VentaVo(int IdCliente, int IdOrden, ProductoVo[] productos, double precio) {
        this.IdVenta = ++VentaVo.contadorVentas;
        this.IdCliente = IdCliente;
        this.IdOrden = IdOrden;
        this.productoVos = productos;
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

    public ProductoVo[] getProductos() {
        return this.productoVos;
    }

    public void setProductos(ProductoVo[] productos) {
        this.productoVos = productos;
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
        sb.append(", refProducto: ").append(this.productoVos);
        sb.append(", precio: ").append(this.precio);
        sb.append('}');
        return sb.toString();
    }
}
