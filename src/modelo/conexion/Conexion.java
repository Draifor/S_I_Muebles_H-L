package modelo.conexion;

import java.sql.*;

import javax.swing.JOptionPane;

import vista.componentes.Texto;

public class Conexion {

	private Connection conexion;
	private final String user = "root";
	private final String pass = "";
	private final String db = "muebles_h_l";
	private final String url = "jdbc:mysql://localhost/" + db;
	private String error;

	public Conexion() {
		this.conexion = null;

		try {
			this.conexion = DriverManager.getConnection(url, user, pass);

			if (this.conexion != null)
				System.out.println("Conexión a la BD establecida exitosamente");

		} catch (SQLException e) {
			System.out.println("Conexión a la BD Fallida:\n\n" + e.getMessage());
			this.error = e.toString(); 
		}
	}

	public Connection getConexion() {
		if (this.conexion == null) {
			JOptionPane.showMessageDialog(null, new Texto("No se pudo conectar a la base de datos", 0, 18), "Error Detectado", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, new Texto(error, 0, 18), "Detalle del Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return this.conexion;
	}

	public void desconectar() {
		this.conexion = null;
		System.out.println("Se cerró la conexión a la BD");
	}
}
