package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ClienteVo;

public class ClienteDao {

	public int agregar(ClienteVo nuevoCliente) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO clientes (Nombre, Apellido, Identificacion, Celular, Direccion) values (?, ?, ?, ?, ?)");

			statement.setString(1, nuevoCliente.getNombre());
			statement.setString(2, nuevoCliente.getApellido());
			statement.setInt(3, Integer.parseInt(nuevoCliente.getIdentificacion()));
			statement.setString(4, nuevoCliente.getCelular());
			statement.setString(5, nuevoCliente.getDireccion());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ClienteDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int modificar(ClienteVo clienteActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE clientes SET Nombre=?, Apellido=?, Identificacion=?, Celular=?, Direccion=? WHERE Cod_Cliente=?");

			statement.setString(1, clienteActualizado.getNombre());
			statement.setString(2, clienteActualizado.getApellido());
			statement.setInt(3, Integer.parseInt(clienteActualizado.getIdentificacion()));
			statement.setString(4, clienteActualizado.getCelular());
			statement.setString(5, clienteActualizado.getDireccion());
			statement.setInt(6, clienteActualizado.getId());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ClienteDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
			resultadoOperacion = statement.executeUpdate("DELETE FROM clientes WHERE Cod_Cliente=" + idEliminar);

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ClienteDao.eliminar: " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public ClienteVo buscar(int idBuscar) {

		ClienteVo cliente = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM clientes WHERE Cod_Cliente=" + idBuscar);

			while (resultado.next()) {
				int id = resultado.getInt("Cod_Cliente");
				String nombre = resultado.getString("Nombre");
				String apellido = resultado.getString("Apellido");
				String identificacion = resultado.getInt("Identificacion") + "";
				String celular = resultado.getString("Celular");
				String direccion = resultado.getString("Direccion");

				cliente = new ClienteVo(id, nombre, apellido, identificacion, celular, direccion);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException  en ClienteDao.buscar():\n" + e.getMessage());
		}

		return cliente;
	}

	public List<ClienteVo> obtenerRegistros() {

		List<ClienteVo> clientes = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM clientes");

			int id;
			String nombre;
			String apellido;
			String identificacion;
			String celular;
			String direccion;
			ClienteVo cliente;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Cliente");
				nombre = resultado.getString("Nombre");
				apellido = resultado.getString("Apellido");
				identificacion = resultado.getInt("Identificacion") + "";
				celular = resultado.getString("Celular");
				direccion = resultado.getString("Direccion");

				cliente = new ClienteVo(id, nombre, apellido, identificacion, celular, direccion);

				clientes.add(cliente);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException  en ClienteDao.obtenerClientes():\n" + e.getMessage());
		}

		return clientes;
	}
}
