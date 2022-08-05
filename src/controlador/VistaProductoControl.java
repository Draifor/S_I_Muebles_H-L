package controlador;

import java.util.List;
import javax.swing.JTable;

import vista.producto.VistaProducto;
import modelo.dao.ProductoDao;
import modelo.vo.ProductoVo;
import utilidades.*;

public class VistaProductoControl {
	private static ProductoDao productoDao = new ProductoDao();
	private static VistaProducto vista = new VistaProducto();

	public static void agregarProducto() {
		ProductoVo nuevoProducto = DialogProductoControl.getDatosProducto();

		if (nuevoProducto != null) {
			int resultadoOperacion = VistaProductoControl.productoDao.agregar(nuevoProducto);

			if (resultadoOperacion > 0) {
				VistaProductoControl.actualizarVista();
				DialogProductoControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Producto guardado con éxito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el producto",
						"Operación Fallida");
			}
		}
	}

	public static void modificarProducto() {
		ProductoVo productoActualizado = DialogProductoControl.getDatosProducto();

		if (productoActualizado != null) {
			int resultadoOperacion = VistaProductoControl.productoDao.modificar(productoActualizado);

			if (resultadoOperacion > 0) {
				VistaProductoControl.actualizarVista();
				DialogProductoControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("El producto se modificó con éxito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el producto",
						"Operación Fallida");
			}
		}
	}

	public static void eliminarProducto() {
		int opcionElegida = VentanaPrincipalControl
				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");

		if (opcionElegida == 0) {
			ProductoVo productoPorEliminar = DialogProductoControl.getDatosProducto();

			int resultadoOperacion = VistaProductoControl.productoDao.eliminar(productoPorEliminar.getReferencia());

			if (resultadoOperacion > 0) {
				VistaProductoControl.actualizarVista();
				DialogProductoControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Producto eliminado con exito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el producto",
						"Operación Fallida");
			}
		}
	}

	public static String[][] obtenerProductos() {

		List<ProductoVo> productos = VistaProductoControl.productoDao.obtenerRegistros();
		String[][] matrizProductos = new String[productos.size()][ColumnasProductos.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizProductos.length; i++) {
			matrizProductos[i][ColumnasProductos.REFERENCIA] = ((ProductoVo) productos.get(i)).getReferencia();
			matrizProductos[i][ColumnasProductos.NOMBRE] = ((ProductoVo) productos.get(i)).getNombre();
			matrizProductos[i][ColumnasProductos.TIPO] = ((ProductoVo) productos.get(i)).getTipo();
			matrizProductos[i][ColumnasProductos.PRECIO] = ((ProductoVo) productos.get(i)).getPrecio() + "";
			matrizProductos[i][ColumnasProductos.CANTIDAD] = ((ProductoVo) productos.get(i)).getCantidad() + "";
			matrizProductos[i][ColumnasProductos.REF_DISEÑO] = ((ProductoVo) productos.get(i)).getRefDiseño();
		}

		return matrizProductos;
	}

	public static String[] obtenerTitulosColumnas() {
		return ColumnasProductos.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {

		// Se crean las columnas tipo texto
		for (int i = 0; i < ColumnasProductos.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ColumnasProductos.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se crea la columna tipo precio
		tabla.getColumnModel().getColumn(ColumnasProductos.PRECIO).setCellRenderer(new GestionCeldas("precio"));

		// Se crea la columna tipo numero simple
		tabla.getColumnModel().getColumn(ColumnasProductos.CANTIDAD)
				.setCellRenderer(new GestionCeldas("numero_simple"));

		// Se define el tamaño de las filas y columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(ColumnasProductos.REFERENCIA).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(ColumnasProductos.NOMBRE).setPreferredWidth(360);
		tabla.getColumnModel().getColumn(ColumnasProductos.TIPO).setPreferredWidth(170);
		tabla.getColumnModel().getColumn(ColumnasProductos.PRECIO).setPreferredWidth(160);
		tabla.getColumnModel().getColumn(ColumnasProductos.CANTIDAD).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(ColumnasProductos.REF_DISEÑO).setPreferredWidth(130);
	}

	public static void actualizarVista() {
		VistaProductoControl.vista.actualizarTabla();
	}

	public static ProductoVo obtenerRegistroSeleccionado(JTable tabla) {
		ProductoVo producto = null;
		int filaSeleccionada = tabla.getSelectedRow();
		
		try {
		if (filaSeleccionada != -1) {
			String referencia = (String) tabla.getValueAt(filaSeleccionada, ColumnasProductos.REFERENCIA);
			String nombre = (String) tabla.getValueAt(filaSeleccionada, ColumnasProductos.NOMBRE);
			String tipo = (String) tabla.getValueAt(filaSeleccionada, ColumnasProductos.TIPO);
			double precio = Double.parseDouble(tabla.getValueAt(filaSeleccionada, ColumnasProductos.PRECIO).toString());
			int cantidad = Integer.parseInt(tabla.getValueAt(filaSeleccionada, ColumnasProductos.CANTIDAD).toString());
			String refDiseño = (String) tabla.getValueAt(filaSeleccionada, ColumnasProductos.REF_DISEÑO);

			producto = new ProductoVo(referencia, nombre, tipo, precio, cantidad, refDiseño);
		}
		} catch(Exception e) {}
		return producto;
	}

	public static void buscarProducto() {
		try {
			String usuarioInput = VentanaPrincipalControl.dialogoInput("Referencia a buscar", "Buscar Producto").trim();

			if (usuarioInput.length() > 0) {
				ProductoVo producto = VistaProductoControl.productoDao.buscar(usuarioInput);
				if (producto != null) {
					DialogProductoControl.setDatosProducto(producto);
					DialogProductoControl.desactivarCampos();
					DialogProductoControl.mostrarSegundoBoton();
					DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
					DialogProductoControl.cambiarTextoSegundoBoton("Eliminar");
					DialogProductoControl.cambiarOnClickSegundoBoton(() -> VistaProductoControl.eliminarProducto());
					DialogProductoControl.mostrar("Producto",
							() -> VistaProductoControl.mostrarModificarProducto(producto));
				} else {
					VentanaPrincipalControl.dialogoAlerta("No se encontró el producto", "Resultado");
				}

			} else {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar una referencia", "Atención");
				VistaProductoControl.buscarProducto();
			}
		} catch (Exception e) {}
	}

	public static void mostrarAgregarProducto() {
		DialogProductoControl.limpiarDatos();
		DialogProductoControl.activarCampos();
		DialogProductoControl.mostrarCodigoPorDefecto();
		DialogProductoControl.cambiarTextoPrimerBoton("Agregar");
		DialogProductoControl.ocultarSegundoBoton();
		DialogProductoControl.mostrar("Agregar Producto", () -> VistaProductoControl.agregarProducto());
	}

	public static void validarModificarProducto() {
		ProductoVo producto = VistaProductoControl.obtenerRegistroSeleccionado(VistaProductoControl.vista.getTabla());

		if (producto != null) {
			VistaProductoControl.mostrarModificarProducto(producto);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el producto a modificar", "Modificar Producto");
		}
	}

	public static void validarEliminarProducto() {
		ProductoVo producto = VistaProductoControl.obtenerRegistroSeleccionado(VistaProductoControl.vista.getTabla());

		if (producto != null) {
			VistaProductoControl.mostrarEliminarProducto(producto);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el producto a eliminar", "Eliminar Producto");
		}
	}

	public static void mostrarModificarProducto(ProductoVo producto) {
		DialogProductoControl.setDatosProducto(producto);
		DialogProductoControl.activarCampos();
		DialogProductoControl.cambiarTextoPrimerBoton("Modificar");
		DialogProductoControl.ocultarSegundoBoton();
		DialogProductoControl.mostrar("Modificar Producto", () -> VistaProductoControl.modificarProducto());
	}

	public static void mostrarEliminarProducto(ProductoVo producto) {
		DialogProductoControl.setDatosProducto(producto);
		DialogProductoControl.desactivarCampos();
		DialogProductoControl.cambiarTextoPrimerBoton("Eliminar");
		DialogProductoControl.ocultarSegundoBoton();
		DialogProductoControl.mostrar("Eliminar Producto", () -> VistaProductoControl.eliminarProducto());
	}

	public static VistaProducto getVista() {
		return VistaProductoControl.vista;
	}
}
