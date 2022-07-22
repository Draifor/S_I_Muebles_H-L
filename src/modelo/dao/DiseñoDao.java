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
					.prepareStatement("INSERT INTO Diseños (Referencia, Nombre, Tipo, Imagen) values (?, ?, ?, ?)");

			statement.setString(1, nuevoDiseño.getReferencia());
			statement.setString(2, nuevoDiseño.getNombre());
			statement.setString(3, nuevoDiseño.getTipo());
			statement.setString(4, nuevoDiseño.getUrlImagen());

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
					.prepareStatement("UPDATE Diseños SET Referencia=?, Nombre=?, Tipo=?, Imagen=? WHERE Cod_Diseño=?");

			statement.setString(1, diseñoActualizado.getReferencia());
			statement.setString(2, diseñoActualizado.getNombre());
			statement.setString(3, diseñoActualizado.getTipo());
			statement.setString(4, diseñoActualizado.getUrlImagen());
			statement.setInt(5, diseñoActualizado.getId());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en DiseñoDao.modificar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int eliminar(int idEliminar) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			Statement statement = connection.createStatement();
			resultadoOperacion = statement.executeUpdate("DELETE FROM Diseños WHERE Cod_Diseño=" + idEliminar);

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
				int id = resultado.getInt("Cod_Diseño");
				String referencia = resultado.getString("Referencia") == null ? resultado.getString("Referencia") : "DIS-" + referenciaBuscar;
				String nombre = resultado.getString("Nombre");
				String tipo = resultado.getString("Tipo");
				String urlImagen = resultado.getString("Imagen");

				diseño = new DiseñoVo(id, referencia, nombre, tipo, urlImagen);
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

			int id;
			String referencia;
			String nombre;
			String tipo;
			String urlImagen;
			DiseñoVo diseño;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Diseño");
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				tipo = resultado.getString("Tipo");
				urlImagen = resultado.getString("Imagen");

				diseño = new DiseñoVo(id, referencia, nombre, tipo, urlImagen);

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
