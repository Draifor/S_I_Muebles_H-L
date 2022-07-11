package modelo.vo;

public class MaterialVo {
    private int IdMaterial;
    private String nombre;
    private String referencia;
    private double costo;
    private int cantidad;
    private static int contadorMateriales;

    public MaterialVo(String nombre, String referencia, double costo, int cantidad) {
        this.IdMaterial = ++MaterialVo.contadorMateriales;
        this.nombre = nombre;
        this.referencia = referencia;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public int getIdMaterial() {
        return this.IdMaterial;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        sb.append("IdMaterial: ").append(IdMaterial);
        sb.append(", nombre: ").append(nombre);
        sb.append(", referencia: ").append(referencia);
        sb.append(", costo: ").append(costo);
        sb.append(", cantidad: ").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

}
