package modelo.vo;

public class ClienteVo {

    private int IdCliente;
    private String nombre;
    private String apellido;
	private double identificacion;
    private String direccion;
    private String celular;

    public ClienteVo(String nombre, String apellido, double identificacion, String celular, String direccion) {
    	
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.identificacion = identificacion;
    	this.celular = celular;
    	this.direccion = direccion;
    }
    public ClienteVo(int IdCliente, String nombre, String apellido, double identificacion, String celular, String direccion) {
        this.IdCliente = IdCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.celular = celular;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return this.IdCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
    	return apellido;
    }
    
    public void setApellido(String apellido) {
    	this.apellido = apellido;
    }
    
    public double getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente {");
        sb.append("IdCliente: ").append(IdCliente);
        sb.append(", nombre: ").append(nombre);
        sb.append(", identificacion: ").append(identificacion);
        sb.append(", direccion: ").append(direccion);
        sb.append(", celular: ").append(celular);
        sb.append('}');
        return sb.toString();
    }

}
