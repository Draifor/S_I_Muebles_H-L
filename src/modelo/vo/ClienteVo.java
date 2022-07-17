package modelo.vo;

public class ClienteVo {

	private int id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String celular;
	private String direccion;

	public ClienteVo(String nombre, String apellido, String identificacion, String celular, String direccion) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.celular = celular;
		this.direccion = direccion;
	}

	public ClienteVo(int id, String nombre, String apellido, String identificacion, String celular, String direccion) {
		this(nombre, apellido, identificacion, celular, direccion);
		this.id = id;

	}

	public int getId() {
		return this.id;
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

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
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
		sb.append("Id: ").append(id);
		sb.append(", nombre: ").append(nombre);
		sb.append(", identificacion: ").append(identificacion);
		sb.append(", direccion: ").append(direccion);
		sb.append(", celular: ").append(celular);
		sb.append('}');
		return sb.toString();
	}

}
