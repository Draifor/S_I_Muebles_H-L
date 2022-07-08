package controlador;

import vista.VentanaPrincipal;

public class VistaMenuControl {

    private static VentanaPrincipal ventana = new VentanaPrincipal();

    public static void mostrar() {
        VistaMenuControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        VistaMenuControl.ventana.setVisible(false);
    }

    public static void cerrarSesion() {
        VistaMenuControl.ocultar();
        LoginControl.mostrar();
    }
    
    public static void mostrarVistaMenu() {
    	ventana.setContenidoPrincipal("");
    	System.out.println("Mostrar Menu");
    }
    
    public static void mostrarVistaCliente() {
    	ventana.setContenidoPrincipal("Cliente");
    	System.out.println("Mostrar Cliente");
    }

    public static void mostrarVistaDiseño() {
    	ventana.setContenidoPrincipal("Diseño");
    	System.out.println("Mostrar Diseño");
    }

    public static void mostrarVistaMaterial() {
    	ventana.setContenidoPrincipal("Material");
    	System.out.println("Mostrar Material");
    }

    public static void mostrarVistaOrdenCompra() {
    	ventana.setContenidoPrincipal("OrdenCompra");
    	System.out.println("Mostrar OrdenCompra");
    }

    public static void mostrarVistaProducto() {
    	ventana.setContenidoPrincipal("Producto");
    	System.out.println("Mostrar Producto");
    }

    public static void mostrarVistaVenta() {
    	ventana.setContenidoPrincipal("Venta");
    	System.out.println("Mostrar Venta");
    }
}
