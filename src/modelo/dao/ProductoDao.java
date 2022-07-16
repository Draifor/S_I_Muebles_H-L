package modelo.dao;

import java.sql.*;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.MaterialVo;
import modelo.vo.ProductoVo;

public class ProductoDao {
	public int agregar(ProductoVo nuevoProducto) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Productos (Referencia, Nombre, Tipo, Precio, Cantidad, idDiseño) values (?, ?, ?, ?, ?, ?)");

			statement.setString(1, nuevoProducto.getReferencia());
			statement.setString(2, nuevoProducto.getNombre());
			statement.setString(3, nuevoProducto.getTipo());
			statement.setDouble(4, nuevoProducto.getPrecio());
			statement.setInt(5, nuevoProducto.getCantidad());
			statement.setInt(6, nuevoProducto.getIdDiseño());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ProductoDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}
	
	public int modificar(ProductoVo productoActualizado) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		int resultadoOperacion = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE Productos SET Referencia=?, Nombre=?, Tipo=?, Precio=?, Cantidad=?, Cod_Diseño=? WHERE Cod_Producto=?");

			statement.setString(1, productoActualizado.getReferencia());
			statement.setString(2, productoActualizado.getNombre());
			statement.setString(3, productoActualizado.getTipo());
			statement.setDouble(4, productoActualizado.getPrecio());
			statement.setInt(5, productoActualizado.getCantidad());
			statement.setInt(6, productoActualizado.getIdDiseño());
			statement.setInt(7, productoActualizado.getId());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en ProductoDao.modificar(): " + e.getMessage() + "\n\n" + e);
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
			resultadoOperacion = statement.executeUpdate("DELETE FROM Productos WHERE Cod_Producto=" + idEliminar);

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
					.executeQuery("SELECT * FROM Productos WHERE Referencia='" + referenciaBuscar + "';");

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

				producto = new ProductoVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
			}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en ProductoDao.buscar():\n" + e.getMessage());
		}

		return producto;
	}
	
	public List<ProductoVo> obtenerRegistros() {

		List<ProductoVo> productos = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM Productos");

			int id;
			String referencia;
			String nombre;
			String tipo;
			double precio;
			int cantidad;
			int idDiseño;
			ProductoVo producto;

			while (resultado.next()) {
				id = resultado.getInt("Cod_Producto");
				referencia = resultado.getString("Referencia");
				nombre = resultado.getString("Nombre");
				tipo = resultado.getString("Tipo");
				precio = resultado.getDouble("Precio");
				cantidad = resultado.getInt("Cantidad");
				idDiseño = resultado.getInt("Cod_Diseño");

				producto = new ProductoVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
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
