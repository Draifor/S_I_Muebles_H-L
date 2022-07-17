package modelo.vo;

public class MaterialVo {
    private int id;
    private String referencia;
    private String nombre;
    private double costo;
    private int cantidad;

    public MaterialVo(String referencia, String nombre, double costo, int cantidad) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.costo = costo;
        this.cantidad = cantidad;
    }
    
    public MaterialVo(int id, String referencia, String nombre, double costo, int cantidad) {
    	this(referencia, nombre, costo, cantidad);
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

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Material{");
        sb.append("Id: ").append(id);
        sb.append(", nombre: ").append(nombre);
        sb.append(", referencia: ").append(referencia);
        sb.append(", costo: ").append(costo);
        sb.append(", cantidad: ").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

}
