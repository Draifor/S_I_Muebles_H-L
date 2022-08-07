package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.ProductoVo;

public class ProductoDao {
	public int agregar(ProductoVo nuevoProducto) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		int diseñoId = this.getId(nuevoProducto.getRefDiseño());

		if (diseñoId != 0) {
			try {
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Productos (Nombre, Tipo, Precio, Cantidad, Diseño_id) values (?, ?, ?, ?, ?)");

				statement.setString(1, nuevoProducto.getNombre());
				statement.setString(2, nuevoProducto.getTipo());
				statement.setDouble(3, nuevoProducto.getPrecio());
				statement.setInt(4, nuevoProducto.getCantidad());
				statement.setInt(5, diseñoId);

				resultadoOperacion = statement.executeUpdate();

				statement.close();
				conexion.desconectar();

			} catch (SQLException e) {
				System.out.println("Ocurrió un SQLException en ProductoDao.agregar(): " + e.getMessage() + "\n\n" + e);
			}
		} else {
			System.out.println("No se encontró un diseño con la referencia: " + nuevoProducto.getRefDiseño());
		}

		return resultadoOperacion;
	}

	public int modificar(ProductoVo productoActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		int diseñoId = this.getId(productoActualizado.getRefDiseño());

		try {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE Productos SET Nombre=?, Tipo=?, Precio=?, Cantidad=?, Diseño_id=? WHERE Referencia=?");

			statement.setString(1, productoActualizado.getNombre());
			statement.setString(2, productoActualizado.getTipo());
			statement.setDouble(3, productoActualizado.getPrecio());
			statement.setInt(4, productoActualizado.getCantidad());
			statement.setInt(5, diseñoId);
			statement.setString(6, productoActualizado.getReferencia());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ProductoDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
					.executeUpdate("DELETE FROM Productos WHERE Referencia='" + referenciaEliminar + "';");

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ProductoDao.eliminar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public ProductoVo buscar(String referenciaBuscar) {

		ProductoVo producto = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT Productos.Referencia, Productos.Nombre, Productos.Tipo, Productos.Precio, Productos.Cantidad, Diseños.Referencia FROM Productos "
							+ "INNER JOIN Diseños ON Productos.Diseño_id = Diseños.Diseño_id "
							+ "WHERE Productos.Referencia='" + referenciaBuscar + "';");

			String referencia;
			String nombre;
			String tipo;
			double precio;
			int cantidad;
			String refDiseño;

			while (resultado.next()) {
				referencia = resultado.getString(1);
				nombre = resultado.getString(2);
				tipo = resultado.getString(3);
				precio = resultado.getDouble(4);
				cantidad = resultado.getInt(5);
				refDiseño = resultado.getString(6);

				producto = new ProductoVo(referencia, nombre, tipo, precio, cantidad, refDiseño);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en ProductoDao.buscar():\n" + e.getMessage());
		}

		return producto;
	}

	public int getId(String referencia) {
		int id = 0;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT Diseño_id FROM Diseños WHERE Referencia='" + referencia + "';");
			while (resultado.next()) {
				id = resultado.getInt("Diseño_id");
			}
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en ProductoDao.getId():\n" + e.getMessage());
		}

		return id;
	}

	public List<ProductoVo> obtenerRegistros() {

		List<ProductoVo> productos = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(
					"SELECT Productos.Referencia, Productos.Nombre, Productos.Tipo, Productos.Precio, Productos.Cantidad, Diseños.Referencia FROM Productos\n"
							+ "INNER JOIN Diseños ON Productos.Diseño_id = Diseños.Diseño_id; ");

			String referencia;
			String nombre;
			String tipo;
			double precio;
			int cantidad;
			String refDiseño;
			ProductoVo producto;

			while (resultado.next()) {
				referencia = resultado.getString(1);
				nombre = resultado.getString(2);
				tipo = resultado.getString(3);
				precio = resultado.getDouble(4);
				cantidad = resultado.getInt(5);
				refDiseño = resultado.getString(6);

				producto = new ProductoVo(referencia, nombre, tipo, precio, cantidad, refDiseño);
				productos.add(producto);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en ProductoDao.obtenerRegistros():\n" + e.getMessage());
		}

		return productos;
	}
}
