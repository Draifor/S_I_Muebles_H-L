package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ClienteVo;
import utilidades.ClientesColumnas;

public class ClienteDao {

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
				ClienteVo cliente = new ClienteVo(
						resultado.getInt(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.CODIGO]),
						resultado.getString(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.NOMBRE]),
						resultado.getString(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.APELLIDO]),
						(double) resultado.getInt(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.IDENTIFICACION]),
						resultado.getString(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.CELULAR]),
						resultado.getString(ClientesColumnas.TITULOS_COLUMNAS[ClientesColumnas.DIRECCION]));

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
