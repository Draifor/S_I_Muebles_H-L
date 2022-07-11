package modelo.vo;

import java.util.Date;

public class OrdenCompraVo {

    private int idOrden;
    private int idCliente;
    private ProductoVo[] productoVos;
    private DiseñoVo[] diseñoVos;
    private Date fecha;  // Cómo y dónde agregar la fecha
    private static int contadorOrdenes;

    private OrdenCompraVo(int idCliente) {
        this.idOrden = ++OrdenCompraVo.contadorOrdenes;
        this.idCliente = idCliente;
    }

    public OrdenCompraVo(int idCliente, ProductoVo[] productos) {
        this(idCliente);
        this.productoVos = productos;
    }

    public OrdenCompraVo(int idCliente, DiseñoVo[] diseños) {
        this(idCliente);
        this.diseñoVos = diseños;
    }

    public OrdenCompraVo(int idCliente, DiseñoVo[] diseños, ProductoVo[] productos) {
        this(idCliente);
        this.diseñoVos = diseños;
        this.productoVos = productos;
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

    public ProductoVo[] getProductos() {
        return this.productoVos;
    }

    public void setProductos(ProductoVo[] productos) {
        this.productoVos = productos;
    }

     public DiseñoVo[] getDiseños() {
        return this.diseñoVos;
    }

    public void setDiseños(DiseñoVo[] diseños) {
        this.diseñoVos = diseños;
    }

    // Getter and Setter fecha??
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdenCompra numero: ").append(this.idOrden);
        sb.append(" {");
        sb.append("IdCliente: ").append(this.idCliente);
        sb.append(", Productos: ").append(this.productoVos);
        sb.append(", fecha: ").append(this.fecha);
        sb.append('}');
        return sb.toString();
    }

}
