package modelo.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.vo.VentaVo;
import utilidades.MetodosAuxiliares;

public class VentaDao {
	public int agregar(VentaVo nuevaVenta) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();
		
		int resultadoOperacion = 0;
		int nuevoId = this.obtenerUltimoId(connection) + 1;
		String referencia = "VEN-" + MetodosAuxiliares.formatearId(nuevoId);


		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Ventas (Referencia, Cod_Cliente, FacturaId, Cod_OrdComp) values (?, ?, ?, ?)");

			statement.setString(1, referencia);
			statement.setInt(1, nuevaVenta.getIdCliente());
			statement.setInt(1, nuevaVenta.getIdOrden());

			resultadoOperacion = statement.executeUpdate();

			statement.close();
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println("Ocurrió un SQLException en VentaDao.agregar(): " + e.getMessage() + "\n\n" + e);
		}

		return resultadoOperacion;
	}

	public int obtenerUltimoId(Connection connection) {
		int ultimoId = 0;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT MAX(Venta_id) FROM Ventas;");

			while (resultado.next()) {
				ultimoId = resultado.getInt(1);
			}
		} catch (Exception error) {
			System.out.println("Ocurrió una Exception en VentaDao.obtenerUltimoId():\n" + error.getMessage());
		}
		return ultimoId;
	}
	
	public VentaVo buscar(String referenciaBuscar) {

		VentaVo ordenCompra = null;

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement
					.executeQuery("SELECT * FROM OrdenesCompra WHERE Cod_Cliente='" + referenciaBuscar + "';");

			int id;
			int idCliente;
			Date fecha;
			boolean completada;
			boolean ventaEfectiva;

//				while (resultado.next()) {
//					id = resultado.getInt("Cod_OrdComp");
//					idCliente = resultado.getInt("Cod_Cliente");
//					fecha = resultado.getDate("fecha");
//					idDiseño = resultado.getInt("Cod_Diseño");
			//
//					ordenCompra = new OrdenCompraVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
//				}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en VentaDao.buscar():\n" + e.getMessage());
		}

		return ordenCompra;
	}

	public List<VentaVo> obtenerRegistros() {

		List<VentaVo> ordenesCompra = new ArrayList<>();

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM Productos");

//				int id;
//				String referencia;
//				String nombre;
//				String tipo;
//				double precio;
//				int cantidad;
//				int idDiseño;
//				OrdenCompraVo producto;
			//
//				while (resultado.next()) {
//					id = resultado.getInt("Cod_Producto");
//					referencia = resultado.getString("Referencia");
//					nombre = resultado.getString("Nombre");
//					tipo = resultado.getString("Tipo");
//					precio = resultado.getDouble("Precio");
//					cantidad = resultado.getInt("Cantidad");
//					idDiseño = resultado.getInt("Cod_Diseño");
			//
//					producto = new OrdenCompraVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
//					ordenesCompra.add(producto);
//				}

			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("Ocurrió una SQLException en VentaDao.obtenerRegistros():\n" + e.getMessage());
		}

		return ordenesCompra;
	}
}