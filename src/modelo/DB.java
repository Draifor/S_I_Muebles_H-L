package modelo;

import java.sql.*;

public class DB {

	private Connection conexion;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String user = "root";
	private final String pass = "root";
	private final String db = "muebles_h_l";
	private final String url = "jdbc:mysql://localhost/" + db;
	
	public DB () {
		this.conexion = null;
		
		try {
			Class.forName(driver);
			this.conexion = DriverManager.getConnection(url, user, pass);
			
			if(this.conexion != null)
				System.out.println("Conexión a la BD establecida exitosamente");
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró el driver:\n\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Conexión a la BD Fallida:\n\n"+e.getMessage());
		}
	}
	
	public Connection getConexion() {
		return this.conexion;
	}
	
	public void desconectar() {
		this.conexion = null;
	}
}
