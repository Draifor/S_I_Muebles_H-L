package controlador;

import vista.*;

public class VentanaPrincipalControl {

    private static VentanaPrincipal ventana = new VentanaPrincipal();

    private static VistaMenu menuPrincipal = new VistaMenu();
	private static VistaCliente seccionCliente = new VistaCliente();;
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
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.menuPrincipal);
    	System.out.println("Mostrar Menu");
    }
    
    public static void mostrarVistaCliente() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionCliente);
    	System.out.println("Mostrar Cliente");
    }

    public static void mostrarVistaDiseño() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionDiseño);
    	System.out.println("Mostrar Diseño");
    }

    public static void mostrarVistaMaterial() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionMaterial);
    	System.out.println("Mostrar Material");
    }

    public static void mostrarVistaOrdenCompra() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionOrdenCompra);
    	System.out.println("Mostrar OrdenCompra");
    }

    public static void mostrarVistaProducto() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionProducto);
    	System.out.println("Mostrar Producto");
    }

    public static void mostrarVistaVenta() {
    	VentanaPrincipalControl.ventana.setContenidoPrincipal(VentanaPrincipalControl.seccionVenta);
    	System.out.println("Mostrar Venta");
    }
}
