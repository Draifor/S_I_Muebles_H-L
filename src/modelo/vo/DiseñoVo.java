package modelo.vo;

public class DiseñoVo {

	private String referencia;
	private String nombre;
	private String tipo;
	private String urlImagen;

	public DiseñoVo( String nombre, String tipo, String urlImagen) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.urlImagen = urlImagen;
	}

	public DiseñoVo(String referencia, String nombre, String tipo, String urlImagen) {
		this(nombre, tipo, urlImagen);
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

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Diseño{");
		sb.append(", nombre: ").append(nombre);
		sb.append(", tipo: ").append(tipo);
		sb.append(", referencia: ").append(referencia);
		sb.append(", urlImagen: ").append(urlImagen);
		sb.append('}');
		return sb.toString();
	}

}
