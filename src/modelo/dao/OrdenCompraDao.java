package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.OrdenCompraVo;
import modelo.vo.ProductoVo;

public class OrdenCompraDao {
	public int agregar(OrdenCompraVo nuevaOrdenCompra) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO OrdenesCompra (Cod_Cliente) values (?)");

			statement.setInt(1, nuevaOrdenCompra.getIdCliente());

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

		try {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE OrdenesCompra SET Cod_Cliente=? WHERE Cod_OrdComp=?");

			statement.setInt(1, ordenCompraActualizada.getIdCliente());
			statement.setInt(2, ordenCompraActualizada.getId());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en OrdenCompraDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
			resultadoOperacion = statement.executeUpdate("DELETE FROM OrdenesCompra WHERE Cod_OrdComp=" + idEliminar);

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
			ResultSet resultado = statement
					.executeQuery("SELECT * FROM OrdenesCompra WHERE Cod_Cliente='" + referenciaBuscar + "';");

			int id;
			String referencia;
			String nombre;
			String tipo;
			double precio;
			int cantidad;
			int idDiseño;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Producto");
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				tipo = resultado.getString("Tipo");
				precio = resultado.getDouble("Precio");
				cantidad = resultado.getInt("Cantidad");
				idDiseño = resultado.getInt("Cod_Diseño");

				ordenCompra = new OrdenCompraVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en OrdenCompraDao.buscar():\n" + e.getMessage());
		}

		return ordenCompra;
	}
	
	OrdenCompraVo
	OrdenCompraDao
}
