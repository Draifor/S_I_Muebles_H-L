package controlador;

import vista.*;
import vista.cliente.*;
import vista.diseño.*;
import vista.material.*;
import vista.ordencompra.*;
import vista.producto.*;
import vista.venta.*;

public class VentanaPrincipalControl {

	private static VentanaPrincipal ventana = new VentanaPrincipal();

	private static VistaMenu menuPrincipal = new VistaMenu();
	private static VistaCliente seccionCliente = VistaClienteControl.getVistaCliente();
	private static VistaDiseño seccionDiseño = new VistaDiseño();;
	private static VistaMaterial seccionMaterial = new VistaMaterial();;
	private static VistaOrdenCompra seccionOrdenCompra = new VistaOrdenCompra();;
	private static VistaProducto seccionProducto = new VistaProducto();;
	private static VistaVenta seccionVenta = new VistaVenta();;

	public static void mostrar() {
		VentanaPrincipalControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		VentanaPrincipalControl.ventana.setVisible(false);
	}

	public static void cerrarSesion() {
		VentanaPrincipalControl.ocultar();
		LoginControl.mostrar();
	}

	public static void mostrarVistaMenu() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.menuPrincipal, "INVENTARIOS");
		System.out.println("Mostrar Menu");
	}

	// Operaciones Vista Cliente

	public static void mostrarVistaCliente() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionCliente, "CLIENTES");
		System.out.println("Mostrar Clientes");
	}

	public static DialogCliente getClienteDialog() {
		return new DialogCliente(VentanaPrincipalControl.ventana);
	}

	// Operaciones Vista Diseño

	public static void mostrarVistaDiseño() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionDiseño, "DISEÑOS");
		System.out.println("Mostrar Diseños");
	}

	// Operaciones Vista Material

	public static void mostrarVistaMaterial() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionMaterial, "MATERIALES");
		System.out.println("Mostrar Materiales");
	}

	// Operaciones Vista Orden de Compra

	public static void mostrarVistaOrdenCompra() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionOrdenCompra,
				"ORDEN DE COMPRA");
		System.out.println("Mostrar OrdenCompras");
	}

	// Operaciones Vista Producto

	public static void mostrarVistaProducto() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionProducto, "PRODUCTOS");
		System.out.println("Mostrar Productos");
	}

	// Operaciones Vista Venta

	public static void mostrarVistaVenta() {
		VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionVenta, "VENTAS");
		System.out.println("Mostrar Ventas");
	}

	// Métodos Auxiliares

	public static void dialogoAlerta(String mensaje, String titulo) {
		VentanaPrincipalControl.ventana.dialogoAlerta(mensaje, titulo);
	}

	public static int dialogoConfirmacion(String mensaje, String titulo) {
		int opcionElegida = VentanaPrincipalControl.ventana.dialogoConfirmacion(mensaje, titulo);
		return opcionElegida;
	}

	public static String dialogoInput(String mensaje, String titulo) {
		String usuarioInput = VentanaPrincipalControl.ventana.dialogoInput(mensaje, titulo);
		return usuarioInput;
	}
}
