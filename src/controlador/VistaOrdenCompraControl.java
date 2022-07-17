package controlador;

import java.util.List;
import javax.swing.JTable;

import vista.ordencompra.VistaOrdenCompra;
import modelo.dao.OrdenCompraDao;
import modelo.vo.OrdenCompraVo;
import utilidades.*;

public class VistaOrdenCompraControl {
	private static OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
	private static VistaOrdenCompra vista = new VistaOrdenCompra();

	public static void agregarOrdenCompra() {
//		OrdenCompraVo nuevaOrdenCompra = DialogProductoControl.getDatosOrdenCompra();
//
//		if (nuevaOrdenCompra != null) {
//			int resultadoOperacion = VistaOrdenCompraControl.ordenCompraDao.agregar(nuevaOrdenCompra);
//
//			if (resultadoOperacion > 0) {
//				VistaOrdenCompraControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("Producto guardado con éxito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static void modificarOrdenCompra() {
//		OrdenCompraVo productoActualizado = DialogProductoControl.getDatosOrdenCompra();
//
//		if (productoActualizado != null) {
//			int resultadoOperacion = VistaOrdenCompraControl.ordenCompraDao.modificar(productoActualizado);
//
//			if (resultadoOperacion > 0) {
//				VistaOrdenCompraControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("El producto se modificó con éxito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static void eliminarOrdenCompra() {
//		int opcionElegida = VentanaPrincipalControl
//				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");
//
//		if (opcionElegida == 0) {
//			ProductoVo productoPorEliminar = DialogProductoControl.getDatosOrdenCompra();
//
//			int resultadoOperacion = VistaOrdenCompraControl.ordenCompraDao.eliminar(productoPorEliminar.getId());
//
//			if (resultadoOperacion > 0) {
//				VistaOrdenCompraControl.actualizarVista();
//				DialogProductoControl.ocultar();
//				VentanaPrincipalControl.dialogoAlerta("OrdenCompra eliminada con exito", "Operación Exitosa");
//			} else {
//				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el producto",
//						"Operación Fallida");
//			}
//		}
	}

	public static String[][] obtenerOrdenCompras() {
		List<OrdenCompraVo> ordenesCompra = VistaOrdenCompraControl.ordenCompraDao.obtenerRegistros();
		String[][] matrizProductos = new String[ordenesCompra.size()][OrdenesCompraColumnas.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizProductos.length; i++) {
//			matrizProductos[i][OrdenesCompraColumnas.CODIGO] = ((OrdenCompraVo) ordenesCompra.get(i)).getId() + "";
//			matrizProductos[i][OrdenesCompraColumnas.REFERENCIA] = ((OrdenCompraVo) ordenesCompra.get(i)).getReferencia();
//			matrizProductos[i][OrdenesCompraColumnas.NOMBRE] = ((OrdenCompraVo) ordenesCompra.get(i)).getNombre();
//			matrizProductos[i][OrdenesCompraColumnas.TIPO] = ((OrdenCompraVo) ordenesCompra.get(i)).getTipo();
//			matrizProductos[i][OrdenesCompraColumnas.PRECIO] = ((OrdenCompraVo) ordenesCompra.get(i)).getPrecio() + "";
//			matrizProductos[i][OrdenesCompraColumnas.CANTIDAD] = ((OrdenCompraVo) ordenesCompra.get(i)).getCantidad() + "";
//			matrizProductos[i][OrdenesCompraColumnas.ID_DISEÑO] = ((OrdenCompraVo) ordenesCompra.get(i)).getIdDiseño() + "";
		}

		return matrizProductos;
	}

	public static String[] obtenerTitulosColumnas() {
		return OrdenesCompraColumnas.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// Se crean las columnas tipo texto
		for (int i = 0; i < OrdenesCompraColumnas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(OrdenesCompraColumnas.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se crean las columnas tipo numero
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.CODIGO).setCellRenderer(new GestionCeldas("numero"));
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.COD_CLIENTE)
				.setCellRenderer(new GestionCeldas("numero"));

		// Se crea la columna tipo precio
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.PRECIO).setCellRenderer(new GestionCeldas("precio"));

		// Se define el tamaño de las filas y columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.CODIGO).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.COD_CLIENTE).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.LISTA_PRODUCTOS).setPreferredWidth(410);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.PRECIO).setPreferredWidth(110);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.FECHA).setPreferredWidth(110);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.ESTADO_PRODUCTOS).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(OrdenesCompraColumnas.ESTADO_FACTURA).setPreferredWidth(120);
	}

	public static OrdenCompraVo obtenerRegistroSeleccionado(JTable tabla) {
		OrdenCompraVo producto = null;
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
		return producto;
	}

	public static void actualizarVista() {
		VistaOrdenCompraControl.vista.actualizarTabla();
	}

	public static void buscarOrdenCompra() {
		try {
			String usuarioInput = VentanaPrincipalControl.dialogoInput("Referencia a buscar", "Buscar Orden de Compra").trim();

			if (usuarioInput.length() > 0) {
				OrdenCompraVo producto = VistaOrdenCompraControl.ordenCompraDao.buscar(usuarioInput);
				if (producto != null) {
//					DialogProductoControl.setDatosProducto(producto);
//					DialogProductoControl.desactivarCampos();
//					DialogProductoControl.mostrarSegundoBoton();
//					DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
//					DialogProductoControl.cambiarTextoSegundoBoton("Eliminar");
//					DialogProductoControl.cambiarOnClickSegundoBoton(() -> VistaProductoControl.eliminarProducto());
//					DialogProductoControl.mostrar("Producto",
//							() -> VistaProductoControl.mostrarModificarProducto(producto));
				} else {
					VentanaPrincipalControl.dialogoAlerta("No se encontró la orden de compra", "Resultado");
				}

			} else {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar una referencia", "Atención");
				VistaProductoControl.buscarProducto();
			}
		} catch (Exception e) {
		}
	}

	public static void mostrarAgregarOrdenCompra() {
		DialogProductoControl.limpiarDatos();
		DialogProductoControl.activarCampos();
		DialogProductoControl.mostrarCodigoPorDefecto();
		DialogProductoControl.cambiarTextoPrimerBoton("Agregar");
		DialogProductoControl.ocultarSegundoBoton();
		DialogProductoControl.mostrar("Agregar Orden de Compra", () -> VistaOrdenCompraControl.agregarOrdenCompra());
	}

	public static void validarModificarOrdenCompra() {
		OrdenCompraVo ordenCompra = VistaOrdenCompraControl.obtenerRegistroSeleccionado(VistaOrdenCompraControl.vista.getTabla());

		if (ordenCompra != null) {
			VistaOrdenCompraControl.mostrarModificarOrdenCompra(ordenCompra);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona la orden de compra a modificar", "Modificar Orden de Compra");
		}
	}

	public static void validarEliminarOrdenCompra() {
		 OrdenCompraVo ordenCompra = VistaOrdenCompraControl.obtenerRegistroSeleccionado(VistaOrdenCompraControl.vista.getTabla());

			if (ordenCompra != null) {
				VistaOrdenCompraControl.mostrarEliminarOrdenCompra(ordenCompra);
			} else {
				VentanaPrincipalControl.dialogoAlerta("Selecciona la orden de compra a eliminar", "Eliminar Orden de Compra");
			}
	}
	
	public static void mostrarModificarOrdenCompra(OrdenCompraVo ordenCompra) {
//		DialogProductoControl.setDatosProducto(ordenCompra);
//		DialogProductoControl.activarCampos();
//		DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
//		DialogProductoControl.ocultarSegundoBoton();
//		DialogProductoControl.mostrar("Modificar Orden de Compra", () -> VistaOrdenCompraControl.modificarOrdenCompra());
	}

	public static void mostrarEliminarOrdenCompra(OrdenCompraVo ordenCompra) {
//		DialogProductoControl.setDatosProducto(ordenCompra);
//		DialogProductoControl.desactivarCampos();
//		DialogProductoControl.cambiarTextoPrimerBoton("Eliminar");
//		DialogProductoControl.ocultarSegundoBoton();
//		DialogProductoControl.mostrar("Eliminar Orden de Compra", () -> VistaOrdenCompraControl.eliminarOrdenCompra());
	}

	public static VistaOrdenCompra getVista() {
		return VistaOrdenCompraControl.vista;
	}

}
