package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ClienteVo;

public class ClienteDao {
	
	private String[] TITULOS_COLUMNAS = {""};
	
	public void agregarCliente() {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		
		
		conexion.desconectar();
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
						resultado.getString("Apellido"), (double) resultado.getInt("Identificacion"),
						resultado.getString("Direccion"), resultado.getString("Celular"));

				clientes.add(cliente);

			}
			
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException al intentar obtenerClientes:\n" + e.getMessage());
		}

		return clientes;
	}
	
//	public String[] obtenerTitulosColumnas() {
////		String titulosColumnas
//	}
}
