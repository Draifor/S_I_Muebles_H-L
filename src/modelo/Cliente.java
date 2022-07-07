package modelo;

public class Cliente {

    private int IdCliente;
    private String nombre;
    private double identificacion;
    private String direccion;
    private double celular;
    private static int contadorClientes;

    public Cliente(String nombre, double identificacion, String direccion, double celular) {
        this.IdCliente = ++Cliente.contadorClientes;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.celular = celular;
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

    public double getCelular() {
        return this.celular;
    }

    public void setCelular(double celular) {
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
