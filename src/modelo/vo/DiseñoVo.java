package modelo.vo;

import java.util.ArrayList;

public class DiseñoVo {

    private int IdDiseño;
    private String nombre;
    private String tipo;
    private String referencia;
    private ArrayList<String> materiales;
    private double costo;
    private static int contadorDiseños;

    public DiseñoVo(String nombre, String tipo, String referencia, ArrayList<String> materiales, double costo) {
        this.IdDiseño = ++DiseñoVo.contadorDiseños;
        this.nombre = nombre;
        this.tipo = tipo;
        this.referencia = referencia;
        this.materiales = materiales;
        this.costo = costo;
    }

    public int getIdDiseño() {
        return this.IdDiseño;
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

    public ArrayList<String> getMateriales() {
        return this.materiales;
    }

    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DiseÃ±o{");
        sb.append("IdDiseño: ").append(IdDiseño);
        sb.append(", nombre: ").append(nombre);
        sb.append(", tipo: ").append(tipo);
        sb.append(", referencia: ").append(referencia);
        sb.append(", costo: ").append(costo);
        sb.append('}');
        return sb.toString();
    }

}
