package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ClienteVo;
import utilidades.ClientesColumnas;

public class ClienteDao {

	public void agregarCliente(ClienteVo nuevoCliente) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO clientes (Nombre, Apellido, Identificacion, Celular, Direccion) values (?, ?, ?, ?, ?)");

			statement.setString(1, nuevoCliente.getNombre());
			statement.setString(2, nuevoCliente.getApellido());
			statement.setInt(3, Integer.parseInt(nuevoCliente.getIdentificacion()));
			statement.setString(4, nuevoCliente.getCelular());
			statement.setString(5, nuevoCliente.getDireccion());
			statement.executeUpdate();
			
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException: " + e.getMessage() + "\n\n" + e);
		}

	}
	
	public void modificarCliente(ClienteVo clienteActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO clientes (Nombre, Apellido, Identificacion, Celular, Direccion) values (?, ?, ?, ?, ?)");
			
			statement.setString(1, clienteActualizado.getNombre());
			statement.setString(2, clienteActualizado.getApellido());
			statement.setInt(3, Integer.parseInt(clienteActualizado.getIdentificacion()));
			statement.setString(4, clienteActualizado.getCelular());
			statement.setString(5, clienteActualizado.getDireccion());
			statement.executeUpdate();
			
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException: " + e.getMessage() + "\n\n" + e);
		}
		
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
				ClienteVo cliente = new ClienteVo(
						resultado.getInt("Cod_Cliente"),
						resultado.getString("Nombre"),
						resultado.getString("Apellido"),
						resultado.getInt("Identificacion") + "",
						resultado.getString("Celular"),
						resultado.getString("Direccion"));

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
