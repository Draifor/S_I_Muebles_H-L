package controlador;

import java.util.List;

import javax.swing.JTable;

import modelo.dao.VentaDao;
import modelo.vo.VentaVo;
import utilidades.ColumnasVentas;
import utilidades.GestionCeldas;
import vista.venta.VistaVenta;

public class VistaVentaControl {
	private static VentaDao ventaDao = new VentaDao();
	private static VistaVenta vista = new VistaVenta();

	public static void agregarVenta() {
//		VentaVo nuevaVenta = DialogProductoControl.getDatosVenta();
//
//		if (nuevaOrdenCompra != null) {
//			int resultadoOperacion = VistaVentaControl.ordenCompraDao.agregar(nuevaVenta);
//
//			if (resultadoOperacion > 0) {
//				VistaVentaControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("Producto guardado con éxito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static void modificarVenta() {
//		VentaVo productoActualizado = DialogProductoControl.getDatosVenta();
//
//		if (productoActualizado != null) {
//			int resultadoOperacion = VistaVentaControl.ordenCompraDao.modificar(productoActualizado);
//
//			if (resultadoOperacion > 0) {
//				VistaVentaControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("El producto se modificó con éxito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static void eliminarVenta() {
//		int opcionElegida = VentanaPrincipalControl
//				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");
//
//		if (opcionElegida == 0) {
//			ProductoVo productoPorEliminar = DialogProductoControl.getDatosOrdenCompra();
//
//			int resultadoOperacion = VistaVentaControl.ordenCompraDao.eliminar(productoPorEliminar.getId());
//
//			if (resultadoOperacion > 0) {
//				VistaVentaControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("OrdenCompra eliminada con exito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static String[][] obtenerVentas() {
		List<VentaVo> ordenesCompra = VistaVentaControl.ventaDao.obtenerRegistros();
		String[][] matrizVentas = new String[ordenesCompra.size()][ColumnasVentas.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizVentas.length; i++) {
//			matrizProductos[i][ColumnasVentas.CODIGO] = ((VentaVo) ordenesCompra.get(i)).getId() + "";
//			matrizProductos[i][ColumnasVentas.REFERENCIA] = ((VentaVo) ordenesCompra.get(i)).getReferencia();
//			matrizProductos[i][ColumnasVentas.NOMBRE] = ((VentaVo) ordenesCompra.get(i)).getNombre();
//			matrizProductos[i][ColumnasVentas.TIPO] = ((VentaVo) ordenesCompra.get(i)).getTipo();
//			matrizProductos[i][ColumnasVentas.PRECIO] = ((VentaVo) ordenesCompra.get(i)).getPrecio() + "";
//			matrizProductos[i][ColumnasVentas.CANTIDAD] = ((VentaVo) ordenesCompra.get(i)).getCantidad() + "";
//			matrizProductos[i][ColumnasVentas.ID_DISEÑO] = ((VentaVo) ordenesCompra.get(i)).getIdDiseño() + "";
		}

		return matrizVentas;
	}

	public static String[] obtenerTitulosColumnas() {
		return ColumnasVentas.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// Se crean las columnas tipo texto
		for (int i = 0; i < ColumnasVentas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ColumnasVentas.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se crean las columnas tipo numero
		for (int i = 0; i < ColumnasVentas.TIPO_NUMERO.length; i++) {
			tabla.getColumnModel().getColumn(ColumnasVentas.TIPO_NUMERO[i])
					.setCellRenderer(new GestionCeldas("numero"));
		}
//		tabla.getColumnModel().getColumn(ColumnasVentas.COD_CLIENTE)
//				.setCellRenderer(new GestionCeldas("numero"));
//		tabla.getColumnModel().getColumn(ColumnasVentas.ORDEN_COMPRA_ID).setCellRenderer(new GestionCeldas("numero"));

		// Se crea la columna tipo precio
		tabla.getColumnModel().getColumn(ColumnasVentas.PRECIO).setCellRenderer(new GestionCeldas("precio"));

		// Se define el tamaño de las filas y columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(ColumnasVentas.FACTURA_ID).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(ColumnasVentas.COD_CLIENTE).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(ColumnasVentas.LISTA_PRODUCTOS).setPreferredWidth(420);
		tabla.getColumnModel().getColumn(ColumnasVentas.PRECIO).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(ColumnasVentas.FECHA).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(ColumnasVentas.ORDEN_COMPRA_ID).setPreferredWidth(130);
	}

	public static VentaVo obtenerRegistroSeleccionado(JTable tabla) {
		VentaVo venta = null;
		int filaSeleccionada = tabla.getSelectedRow();

		try {
			if (filaSeleccionada != -1) {
//			int id = Integer.parseInt(tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.CODIGO).toString());
//			String referencia = (String) tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.REFERENCIA);
//			String nombre = (String) tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.NOMBRE);
//			String tipo = (String) tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.TIPO);
//			double precio = Double.parseDouble(tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.PRECIO).toString());
//			int cantidad = Integer.parseInt(tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.CANTIDAD).toString());
//			int idDiseño = Integer.parseInt(tabla.getValueAt(filaSeleccionada, OrdenesCompraColumnas.ID_DISEÑO).toString());
//
//			producto = new OrdenCompraVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
			}
		} catch (Exception e) {
		}
		return venta;
	}

	public static void actualizarVista() {
		VistaVentaControl.vista.actualizarTabla();
	}

	public static void buscarVenta() {
		try {
			String usuarioInput = VentanaPrincipalControl.dialogoInput("Referencia a buscar", "Buscar Venta").trim();

			if (usuarioInput.length() > 0) {
				VentaVo venta = VistaVentaControl.ventaDao.buscar(usuarioInput);
				if (venta != null) {
//					DialogProductoControl.setDatosProducto(producto);
//					DialogProductoControl.desactivarCampos();
//					DialogProductoControl.mostrarSegundoBoton();
//					DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
//					DialogProductoControl.cambiarTextoSegundoBoton("Eliminar");
//					DialogProductoControl.cambiarOnClickSegundoBoton(() -> VistaProductoControl.eliminarProducto());
//					DialogProductoControl.mostrar("Producto",
//							() -> VistaProductoControl.mostrarModificarProducto(producto));
				} else {
					VentanaPrincipalControl.dialogoAlerta("No se encontró la venta", "Resultado");
				}

			} else {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar una referencia", "Atención");
				VistaVentaControl.buscarVenta();
			}
		} catch (Exception e) {
		}
	}

	public static void mostrarAgregarVenta() {
		DialogProductoControl.limpiarDatos();
		DialogProductoControl.activarCampos();
		DialogProductoControl.mostrarCodigoPorDefecto();
		DialogProductoControl.cambiarTextoPrimerBoton("Agregar");
		DialogProductoControl.ocultarSegundoBoton();
		DialogProductoControl.mostrar("Agregar Orden de Compra", () -> VistaVentaControl.agregarVenta());
	}

	public static void validarModificarVenta() {
		VentaVo ordenCompra = VistaVentaControl.obtenerRegistroSeleccionado(VistaVentaControl.vista.getTabla());

		if (ordenCompra != null) {
			VistaVentaControl.mostrarModificarVenta(ordenCompra);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona la orden de compra a modificar", "Modificar Orden de Compra");
		}
	}

	public static void validarEliminarVenta() {
		 VentaVo ordenCompra = VistaVentaControl.obtenerRegistroSeleccionado(VistaVentaControl.vista.getTabla());

			if (ordenCompra != null) {
				VistaVentaControl.mostrarEliminarVenta(ordenCompra);
			} else {
				VentanaPrincipalControl.dialogoAlerta("Selecciona la orden de compra a eliminar", "Eliminar Orden de Compra");
			}
	}
	
	public static void mostrarModificarVenta(VentaVo ordenCompra) {
//		DialogProductoControl.setDatosProducto(ordenCompra);
//		DialogProductoControl.activarCampos();
//		DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
//		DialogProductoControl.ocultarSegundoBoton();
//		DialogProductoControl.mostrar("Modificar Orden de Compra", () -> VistaOrdenCompraControl.modificarOrdenCompra());
	}

	public static void mostrarEliminarVenta(VentaVo ordenCompra) {
//		DialogProductoControl.setDatosProducto(ordenCompra);
//		DialogProductoControl.desactivarCampos();
//		DialogProductoControl.cambiarTextoPrimerBoton("Eliminar");
//		DialogProductoControl.ocultarSegundoBoton();
//		DialogProductoControl.mostrar("Eliminar Orden de Compra", () -> VistaOrdenCompraControl.eliminarOrdenCompra());
	}

	public static VistaVenta getVista() {
		return VistaVentaControl.vista;
	}
}
