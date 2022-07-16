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
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Materiales (Referencia, Nombre, Costo, Cantidad) values (?, ?, ?, ?)");

			statement.setString(1, nuevoMaterial.getReferencia());
			statement.setString(2, nuevoMaterial.getNombre());
			statement.setDouble(3, nuevoMaterial.getCosto());
			statement.setInt(4, nuevoMaterial.getCantidad());

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
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE Materiales SET Referencia=?, Nombre=?, Costo=?, Cantidad=? WHERE Cod_Material=?");

			statement.setString(1, materialActualizado.getReferencia());
			statement.setString(2, materialActualizado.getNombre());
			statement.setDouble(3, materialActualizado.getCosto());
			statement.setInt(4, materialActualizado.getCantidad());
			statement.setInt(5, materialActualizado.getId());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en MaterialDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
			resultadoOperacion = statement.executeUpdate("DELETE FROM Materiales WHERE Cod_Material=" + idEliminar);

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

			int id;
			String referencia;
			String nombre;
			double costo;
			int cantidad;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Material");
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				costo = resultado.getDouble("Costo");
				cantidad = resultado.getInt("Cantidad");

				material = new MaterialVo(id, referencia, nombre, costo, cantidad);
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

			int id;
			String referencia;
			String nombre;
			double costo;
			int cantidad;
			MaterialVo material;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Material");
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				costo = resultado.getDouble("Costo");
				cantidad = resultado.getInt("Cantidad");

				material = new MaterialVo(id, referencia, nombre, costo, cantidad);
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
