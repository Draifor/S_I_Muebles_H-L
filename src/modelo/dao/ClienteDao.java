package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ClienteVo;
import utilidades.ClientesColumnas;

public class ClienteDao {

	public int agregarCliente(ClienteVo nuevoCliente) {
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
			System.out.println("Ocurrió un SQLException: " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int modificarCliente(ClienteVo clienteActualizado) {
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
			statement.setInt(6, clienteActualizado.getIdCliente());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException: " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int eliminarCliente(int idEliminar) {
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
			System.out.println("Ocurrió un SQLException: " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public ClienteVo buscarCliente(int idBuscar) {

		ClienteVo cliente = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM clientes WHERE Cod_Cliente=" + idBuscar);

			while (resultado.next()) {
				int idCliente = resultado.getInt("Cod_Cliente");
				String nombre = resultado.getString("Nombre");
				String apellido = resultado.getString("Apellido");
				String identificacion = resultado.getInt("Identificacion") + "";
				String celular = resultado.getString("Celular");
				String direccion = resultado.getString("Direccion");

				cliente = new ClienteVo(idCliente, nombre, apellido, identificacion, celular, direccion);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException al intentar obtenerClientes:\n" + e.getMessage());
		}

		return cliente;
	}

	public List<ClienteVo> obtenerClientes() {

		List<ClienteVo> clientes = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM clientes");

			while (resultado.next()) {
				ClienteVo cliente = new ClienteVo(resultado.getInt("Cod_Cliente"), resultado.getString("Nombre"),
						resultado.getString("Apellido"), resultado.getInt("Identificacion") + "",
						resultado.getString("Celular"), resultado.getString("Direccion"));

				clientes.add(cliente);

			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException al intentar obtenerClientes:\n" + e.getMessage());
		}

		return clientes;
	}
}
