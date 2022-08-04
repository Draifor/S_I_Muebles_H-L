package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.DiseñoVo;

public class DiseñoDao {
	public int agregar(DiseñoVo nuevoDiseño) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Diseños (Nombre, Tipo, Imagen) values (?, ?, ?)");

			statement.setString(1, nuevoDiseño.getNombre());
			statement.setString(2, nuevoDiseño.getTipo());
			statement.setString(3, nuevoDiseño.getUrlImagen());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en DiseñoDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int modificar(DiseñoVo diseñoActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE Diseños SET Nombre=?, Tipo=?, Imagen=? WHERE Referencia=?");

			statement.setString(1, diseñoActualizado.getNombre());
			statement.setString(2, diseñoActualizado.getTipo());
			statement.setString(3, diseñoActualizado.getUrlImagen());
			statement.setString(4, diseñoActualizado.getReferencia());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en DiseñoDao.modificar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int eliminar(String referenciaEliminar) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			Statement statement = connection.createStatement();
			resultadoOperacion = statement.executeUpdate("DELETE FROM Diseños WHERE Referencia='" + referenciaEliminar + "';");

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en DiseñoDao.eliminar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public DiseñoVo buscar(String referenciaBuscar) {

		DiseñoVo diseño = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT * FROM Diseños WHERE Referencia='" + referenciaBuscar + "';");

			while (resultado.next()) {
				String referencia = resultado.getString("Referencia");
				String nombre = resultado.getString("Nombre");
				String tipo = resultado.getString("Tipo");
				String urlImagen = resultado.getString("Imagen");

				diseño = new DiseñoVo(referencia, nombre, tipo, urlImagen);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en DiseñoDao.buscar():\n" + e.getMessage());
		}

		return diseño;
	}

	public List<DiseñoVo> obtenerRegistros() {

		List<DiseñoVo> diseños = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM Diseños");

			String referencia;
			String nombre;
			String tipo;
			String urlImagen;
			DiseñoVo diseño;

			while (resultado.next()) {
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				tipo = resultado.getString("Tipo");
				urlImagen = resultado.getString("Imagen");

				diseño = new DiseñoVo(referencia, nombre, tipo, urlImagen);

				diseños.add(diseño);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en DiseñoDao.obtenerDiseños():\n" + e.getMessage());
		}

		return diseños;
	}
}
