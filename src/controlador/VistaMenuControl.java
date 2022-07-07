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
    
    public static void mostrarVistaCliente() {
    	ventana.setContenedorPrincipal(null);
    }
}
