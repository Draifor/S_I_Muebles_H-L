package controlador;

import java.awt.Dialog;
import java.util.List;

import javax.swing.JTable;

import modelo.dao.ClienteDao;
import modelo.vo.ClienteVo;
import utilidades.*;
import vista.cliente.VistaCliente;

public class VistaClienteControl {

	private static ClienteDao clienteDao = new ClienteDao();
	private static VistaCliente vistaCliente = new VistaCliente();

	;

	public static void agregarCliente() {
		ClienteVo nuevoCliente = DialogClienteControl.getDatosCliente();
		int resultadoOperacion = VistaClienteControl.clienteDao.agregarCliente(nuevoCliente);

		if (resultadoOperacion > 0) {
			VistaClienteControl.actualizarVistaCliente();
			DialogClienteControl.ocultar();
			VentanaPrincipalControl.dialogoAlerta("Cliente registrado con éxito", "Operación Exitosa");
		} else {
			VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el usuario", "Operación Fallida");
		}
	}

	public static void modificarCliente() {
		ClienteVo clienteActualizado = DialogClienteControl.getDatosCliente();
		int resultadoOperacion = VistaClienteControl.clienteDao.modificarCliente(clienteActualizado);

		if (resultadoOperacion > 0) {
			VistaClienteControl.actualizarVistaCliente();
			DialogClienteControl.ocultar();
			VentanaPrincipalControl.dialogoAlerta("El cliente se modificó con éxito", "Operación Exitosa");
		} else {
			VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el usuario", "Operación Fallida");
		}
	}

	public static void eliminarCliente() {
		int opcionElegida = VentanaPrincipalControl
				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");

		if (opcionElegida == 0) {
			ClienteVo clientePorEliminar = DialogClienteControl.getDatosCliente();

			int resultadoOperacion = VistaClienteControl.clienteDao.eliminarCliente(clientePorEliminar.getIdCliente());

			if (resultadoOperacion > 0) {
				VistaClienteControl.actualizarVistaCliente();
				DialogClienteControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Cliente eliminado con exito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el usuario",
						"Operación Fallida");
			}
		}

	}

	public static String[][] obtenerClientes() {

		List<ClienteVo> clientes = VistaClienteControl.clienteDao.obtenerClientes();
		String[][] matrizClientes = new String[clientes.size()][ClientesColumnas.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizClientes.length; i++) {
			matrizClientes[i][ClientesColumnas.CODIGO] = ((ClienteVo) clientes.get(i)).getIdCliente() + "";
			matrizClientes[i][ClientesColumnas.NOMBRE] = ((ClienteVo) clientes.get(i)).getNombre() + "";
			matrizClientes[i][ClientesColumnas.APELLIDO] = ((ClienteVo) clientes.get(i)).getApellido() + "";
			matrizClientes[i][ClientesColumnas.IDENTIFICACION] = ((ClienteVo) clientes.get(i)).getIdentificacion() + "";
			matrizClientes[i][ClientesColumnas.CELULAR] = ((ClienteVo) clientes.get(i)).getCelular() + "";
			matrizClientes[i][ClientesColumnas.DIRECCION] = ((ClienteVo) clientes.get(i)).getDireccion() + "";
		}

		return matrizClientes;
	}

	public static String[] obtenerTitulosColumnas() {
		return ClientesColumnas.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// se recorre y asignan las celdas que almacenan datos de tipo texto
		for (int i = 0; i < ClientesColumnas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se recorre para asignar datos de tipo numero
		for (int i = 0; i < ClientesColumnas.TIPO_NUMERO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_NUMERO[i])
					.setCellRenderer(new GestionCeldas("numero"));
		}

		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);// tama�o de las celdas
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(ClientesColumnas.CODIGO).setPreferredWidth(115);
		tabla.getColumnModel().getColumn(ClientesColumnas.NOMBRE).setPreferredWidth(230);
		tabla.getColumnModel().getColumn(ClientesColumnas.APELLIDO).setPreferredWidth(230);
		tabla.getColumnModel().getColumn(ClientesColumnas.IDENTIFICACION).setPreferredWidth(150);
		tabla.getColumnModel().getColumn(ClientesColumnas.CELULAR).setPreferredWidth(150);
		tabla.getColumnModel().getColumn(ClientesColumnas.DIRECCION).setPreferredWidth(280);
	}

	public static void actualizarVistaCliente() {
		VistaClienteControl.vistaCliente.actualizarTabla();
		System.out.println("Actualizar Clientes");
	}

	public static ClienteVo obtenerClienteSeleccionado(JTable tabla) {
		ClienteVo cliente = null;
		int filaSeleccionada = tabla.getSelectedRow();

		if (filaSeleccionada != -1) {
			int IdCliente = Integer.parseInt(tabla.getValueAt(filaSeleccionada, ClientesColumnas.CODIGO).toString());
			String nombre = (String) tabla.getValueAt(filaSeleccionada, ClientesColumnas.NOMBRE);
			String apellido = (String) tabla.getValueAt(filaSeleccionada, ClientesColumnas.APELLIDO);
			String identificacion = (String) tabla.getValueAt(filaSeleccionada, ClientesColumnas.IDENTIFICACION);
			String celular = (String) tabla.getValueAt(filaSeleccionada, ClientesColumnas.CELULAR);
			String direccion = (String) tabla.getValueAt(filaSeleccionada, ClientesColumnas.DIRECCION);

			cliente = new ClienteVo(IdCliente, nombre, apellido, identificacion, celular, direccion);
		}
		return cliente;
	}

	public static void buscarCliente() {
		String usuarioInput = VentanaPrincipalControl.dialogoInput("Número de identificación a buscar",
				"Buscar Cliente");

		try {

			if (MetodosAuxiliares.esNumero(usuarioInput)) {
				ClienteVo cliente = VistaClienteControl.clienteDao.buscarCliente(Integer.parseInt(usuarioInput));
				if (cliente != null) {
					DialogClienteControl.setDatosCliente(cliente);
					DialogClienteControl.desactivarCampos();
					DialogClienteControl.mostrarSegundoBoton();
					DialogClienteControl.cambiarTextoPrimerBoton("Modificar");
					DialogClienteControl.cambiarTextoSegundoBoton("Eliminar");
					DialogClienteControl.cambiarOnClickSegundoBoton(() -> VistaClienteControl.eliminarCliente());
					DialogClienteControl.mostrar("Cliente", () -> VistaClienteControl.mostrarClienteModificar(cliente));
				} else {
					VentanaPrincipalControl.dialogoAlerta("No se encontró el cliente", "Resultado");
				}

			} else if (usuarioInput.length() == 0) {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar un número", "Atención");
				VistaClienteControl.buscarCliente();
			} else {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar solo el número sin caracteres adicionales",
						"Formato de Número Incorrecto");
				VistaClienteControl.buscarCliente();
			}

		} catch (Exception e) {

		}
	}

	public static void mostrarAgregarCliente() {
		DialogClienteControl.limpiarDatos();
		DialogClienteControl.activarCampos();
		DialogClienteControl.mostrarCodigoPorDefecto();
		DialogClienteControl.cambiarTextoPrimerBoton("Agregar");
		DialogClienteControl.ocultarSegundoBoton();
		DialogClienteControl.mostrar("Agregar Cliente", () -> VistaClienteControl.agregarCliente());
	}

	public static void validarClienteModificar() {
		ClienteVo cliente = VistaClienteControl.obtenerClienteSeleccionado(VistaClienteControl.vistaCliente.getTabla());

		if (cliente != null) {
			VistaClienteControl.mostrarClienteModificar(cliente);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el cliente a modificar", "Modificar Cliente");
		}
	}

	public static void validarClienteEliminar() {
		ClienteVo cliente = VistaClienteControl.obtenerClienteSeleccionado(VistaClienteControl.vistaCliente.getTabla());

		if (cliente != null) {
			VistaClienteControl.mostrarClienteEliminar(cliente);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el cliente a eliminar", "Eliminar Cliente");
		}
	}

	public static void mostrarClienteModificar(ClienteVo cliente) {
		DialogClienteControl.setDatosCliente(cliente);
		DialogClienteControl.activarCampos();
		DialogClienteControl.cambiarTextoPrimerBoton("Modificar");
		DialogClienteControl.ocultarSegundoBoton();
		DialogClienteControl.mostrar("Modificar Cliente", () -> VistaClienteControl.modificarCliente());
	}

	public static void mostrarClienteEliminar(ClienteVo cliente) {
		DialogClienteControl.setDatosCliente(cliente);
		DialogClienteControl.desactivarCampos();
		DialogClienteControl.cambiarTextoPrimerBoton("Eliminar");
		DialogClienteControl.ocultarSegundoBoton();
		DialogClienteControl.mostrar("Eliminar Cliente", () -> VistaClienteControl.eliminarCliente());
	}

	public static VistaCliente getVistaCliente() {
		return VistaClienteControl.vistaCliente;
	}
}
