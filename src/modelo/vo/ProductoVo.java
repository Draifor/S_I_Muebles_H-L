package modelo.vo;

public class ProductoVo {

    private String referencia;
    private String nombre;
    private String tipo;
    private double precio;
    private  int cantidad;
    private String refDiseño;

    public ProductoVo(String nombre, String tipo, double precio, int cantidad, String refDiseño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.refDiseño = refDiseño;
    }
    
    public ProductoVo(String referencia, String nombre, String tipo, double precio, int cantidad, String refDiseño) {
    	this(nombre, tipo, precio, cantidad, refDiseño);
    	this.referencia = referencia;
    }
    
    public String getReferencia() {
    	return this.referencia;
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

	public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
    	return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
    	this.cantidad = cantidad;
    }
    
    public String getRefDiseño() {
    	return this.refDiseño;
    }
    
    public void setRefDiseño(String refDiseño) {
    	this.refDiseño = refDiseño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto {");
        sb.append("Referencia: ").append(referencia);
        sb.append(", nombre: ").append(nombre);
        sb.append(", tipo: ").append(tipo);
        sb.append(", precio: ").append(precio);
        sb.append('}');
        return sb.toString();
    }

}
