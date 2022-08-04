package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.MaterialVo;

public class MaterialDao {
	public int agregar(MaterialVo nuevoMaterial) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Materiales (Nombre, Costo, Cantidad) values (?, ?, ?)");

			statement.setString(1, nuevoMaterial.getNombre());
			statement.setDouble(2, nuevoMaterial.getCosto());
			statement.setInt(3, nuevoMaterial.getCantidad());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en MaterialDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int modificar(MaterialVo materialActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE Materiales SET Nombre=?, Costo=?, Cantidad=? WHERE Referencia=?");

			statement.setString(1, materialActualizado.getNombre());
			statement.setDouble(2, materialActualizado.getCosto());
			statement.setInt(3, materialActualizado.getCantidad());
			statement.setString(4, materialActualizado.getReferencia());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en MaterialDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
			resultadoOperacion = statement
					.executeUpdate("DELETE FROM Materiales WHERE Referencia='" + referenciaEliminar + "';");

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en MaterialDao.eliminar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public MaterialVo buscar(String referenciaBuscar) {

		MaterialVo material = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT * FROM Materiales WHERE Referencia='" + referenciaBuscar + "';");

			String referencia;
			String nombre;
			double costo;
			int cantidad;

			while (resultado.next()) {
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				costo = resultado.getDouble("Costo");
				cantidad = resultado.getInt("Cantidad");

				material = new MaterialVo(referencia, nombre, costo, cantidad);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en MaterialDao.buscar():\n" + e.getMessage());
		}

		return material;
	}

	public List<MaterialVo> obtenerRegistros() {

		List<MaterialVo> materiales = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM Materiales");

			String referencia;
			String nombre;
			double costo;
			int cantidad;
			MaterialVo material;

			while (resultado.next()) {
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				costo = resultado.getDouble("Costo");
				cantidad = resultado.getInt("Cantidad");

				material = new MaterialVo(referencia, nombre, costo, cantidad);
				materiales.add(material);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en MaterialDao.obtenerRegistros():\n" + e.getMessage());
		}

		return materiales;
	}
}
