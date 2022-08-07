package modelo.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.OrdenCompraVo;

public class OrdenCompraDao {
	public int agregar(OrdenCompraVo nuevaOrdenCompra) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		int clienteId = this.getClienteId(nuevaOrdenCompra.getClienteCedula());

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO OrdenesCompra (Cliente_id, Precio, Completada) values (?, ?, ?)");

			statement.setInt(1, clienteId);
			statement.setDouble(2, nuevaOrdenCompra.getPrecio());
			statement.setBoolean(3, nuevaOrdenCompra.isCompletada());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en OrdenCompraDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int modificar(OrdenCompraVo ordenCompraActualizada) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		int clienteId = this.getClienteId(ordenCompraActualizada.getClienteCedula());
		try {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE OrdenesCompra SET Cliente_id=?, Precio=?, Completada=? WHERE Referencia=?");

			statement.setInt(1, clienteId);
			statement.setDouble(2, ordenCompraActualizada.getPrecio());
			statement.setBoolean(3, ordenCompraActualizada.isCompletada());
			statement.setString(4, ordenCompraActualizada.getReferencia());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en OrdenCompraDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
					.executeUpdate("DELETE FROM OrdenesCompra WHERE Referencia=" + referenciaEliminar);

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en OrdenCompraDao.eliminar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public OrdenCompraVo buscar(String referenciaBuscar) {

		OrdenCompraVo ordenCompra = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(
					"SELECT OrdenesCompra.Referencia, Clientes.Identificacion, Clientes.Nombre, Clientes.Apellido, OrdenesCompra.Precio, OrdenesCompra.Fecha, OrdenesCompra.Completada, OrdenesCompra.VentaEfectiva FROM OrdenesCompra"
							+ "INNER JOIN Clientes ON OrdenesCompra.Cliente_id = Clientes.Cliente_id"
							+ "WHERE OrdenesCompra.Referencia='" + referenciaBuscar + "';");

			String referencia;
			String clienteCedula;
			String nombre;
			Double precio;
			Date fecha;
			boolean completada;
			boolean ventaEfectiva;

			while (resultado.next()) {
				referencia = resultado.getString(1);
				clienteCedula = resultado.getString(2);
				nombre = resultado.getString(3) + " " + resultado.getString(4);
				precio = resultado.getDouble(5);
				fecha = resultado.getDate(6);
				completada = resultado.getBoolean(7);
				ventaEfectiva = resultado.getBoolean(8);

				ordenCompra = new OrdenCompraVo(referencia, clienteCedula, nombre, precio, fecha, completada, ventaEfectiva);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en OrdenCompraDao.buscar():\n" + e.getMessage());
		}

		return ordenCompra;
	}

	public int getClienteId(String identificacion) {
		int id = 0;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT Cliente_id FROM Clientes WHERE Identificacion='" + identificacion + "';");
			while (resultado.next()) {
				id = resultado.getInt("Cliente_id");
			}
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en ProductoDao.getId():\n" + e.getMessage());
		}

		return id;
	}

	public List<OrdenCompraVo> obtenerRegistros() {

		List<OrdenCompraVo> ordenesCompra = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
				Statement statement = connection.createStatement();
				ResultSet resultado = statement.executeQuery(
						"SELECT OrdenesCompra.Referencia, Clientes.Identificacion, Clientes.Nombre, Clientes.Apellido, OrdenesCompra.Precio, OrdenesCompra.Fecha, OrdenesCompra.Completada, OrdenesCompra.VentaEfectiva FROM OrdenesCompra "
								+ "INNER JOIN Clientes ON OrdenesCompra.Cliente_id = Clientes.Cliente_id;");

				String referencia;
				String clienteCedula;
				String nombre;
				Double precio;
				Date fecha;
				boolean completada;
				boolean ventaEfectiva;
				OrdenCompraVo ordenCompra;

				while (resultado.next()) {
					referencia = resultado.getString(1);
					clienteCedula = resultado.getString(2);
					nombre = resultado.getString(3) + " " + resultado.getString(4);
					precio = resultado.getDouble(5);
					fecha = resultado.getDate(6);
					completada = resultado.getBoolean(7);
					ventaEfectiva = resultado.getBoolean(8);

					ordenCompra = new OrdenCompraVo(referencia, clienteCedula, nombre, precio, fecha, completada, ventaEfectiva);
					ordenesCompra.add(ordenCompra);
				}
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en OrdenCompraDao.obtenerRegistros():\n" + e.getMessage());
		}

		return ordenesCompra;
	}
}
