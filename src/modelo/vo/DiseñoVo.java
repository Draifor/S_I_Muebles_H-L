package modelo.vo;

public class DiseñoVo {

	private int idDiseño;
	private String referencia;
	private String nombre;
	private String tipo;
	private String urlImagen;

	public DiseñoVo( String referencia, String nombre, String tipo, String urlImagen) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.tipo = tipo;
		this.urlImagen = urlImagen;
	}

	public DiseñoVo(int idDiseño, String referencia, String nombre, String tipo, String urlImagen) {
		this.idDiseño = idDiseño;
		this.referencia = referencia;
		this.nombre = nombre;
		this.tipo = tipo;
		this.urlImagen = urlImagen;
	}

	public int getIdDiseño() {
		return this.idDiseño;
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

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DiseÃ±o{");
		sb.append("IdDiseño: ").append(idDiseño);
		sb.append(", nombre: ").append(nombre);
		sb.append(", tipo: ").append(tipo);
		sb.append(", referencia: ").append(referencia);
		sb.append(", urlImagen: ").append(urlImagen);
		sb.append('}');
		return sb.toString();
	}

}
