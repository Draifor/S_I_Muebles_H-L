package modelo.conexion;

import java.sql.*;

public class Conexion {

	private Connection conexion;
	private final String user = "root";
	private final String pass = "root";
	private final String db = "muebles_h_l";
	private final String url = "jdbc:mysql://localhost/" + db;

	public Conexion() {
		this.conexion = null;

		try {
			this.conexion = DriverManager.getConnection(url, user, pass);

			if (this.conexion != null)
				System.out.println("Conexión a la BD establecida exitosamente");

		} catch (SQLException e) {
			System.out.println("Conexión a la BD Fallida:\n\n" + e.getMessage());
		}
	}

	public Connection getConexion() {
		return this.conexion;
	}

	public void desconectar() {
		this.conexion = null;
		System.out.println("Se cerró la conexión a la BD");
	}
}
