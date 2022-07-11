package modelo.vo;

public class ProductoVo {

    private int IdProducto;
    private int IdDiseño;
    private String nombre;
    private String tipo;
    private String referencia;
    private double precio;
    private static int contadorProductos;

    public ProductoVo(int IdDiseño, String nombre, String tipo, String referencia, double precio) {
        this.IdProducto = ++ProductoVo.contadorProductos;
        this.IdDiseño = IdDiseño;
        this.nombre = nombre;
        this.tipo = tipo;
        this.referencia = referencia;
        this.precio = precio;
    }

    public int getIdProducto() {
        return this.IdProducto;
    }

    public int getIdDiseño() {
        return this.IdDiseño;
    }

    public void setIdDiseño(int IdDiseño) {
        this.IdDiseño = IdDiseño;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        sb.append("Producto {");
        sb.append("IdProducto: ").append(IdProducto);
        sb.append(", nombre: ").append(nombre);
        sb.append(", tipo: ").append(tipo);
        sb.append(", referencia: ").append(referencia);
        sb.append(", precio: ").append(precio);
        sb.append('}');
        return sb.toString();
    }

}
