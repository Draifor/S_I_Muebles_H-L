package modelo.vo;

public class ProductoVo {

    private int id;
    private String referencia;
    private String nombre;
    private String tipo;
    private double precio;
    private  int cantidad;
    private int idDiseño;

    public ProductoVo(String referencia, String nombre, String tipo, double precio, int cantidad, int idDiseño) {
    	this.referencia = referencia;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idDiseño = idDiseño;
    }
    
    public ProductoVo(int id, String referencia, String nombre, String tipo, double precio, int cantidad, int idDiseño) {
    	this(referencia, nombre, tipo, precio, cantidad, idDiseño);
    	this.id = id;
    }

    public int getId() {
        return this.id;
    }
    
    public String getReferencia() {
    	return this.referencia;
    }
    
    public void setReferencia(String referencia) {
    	this.referencia = referencia;
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
    
    public int getIdDiseño() {
    	return this.idDiseño;
    }
    
    public void setIdDiseño(int IdDiseño) {
    	this.idDiseño = IdDiseño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto {");
        sb.append("IdProducto: ").append(id);
        sb.append(", nombre: ").append(nombre);
        sb.append(", tipo: ").append(tipo);
        sb.append(", referencia: ").append(referencia);
        sb.append(", precio: ").append(precio);
        sb.append('}');
        return sb.toString();
    }

}
