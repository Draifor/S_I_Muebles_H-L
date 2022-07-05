package controlador;

import vista.VentanaPrincipal;

public class PrincipalControl {

    private static VentanaPrincipal ventana = new VentanaPrincipal();

    public static void mostrar() {
        PrincipalControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        PrincipalControl.ventana.setVisible(false);
    }

    public static void cerrarSesion() {
        PrincipalControl.ocultar();
        LoginControl.mostrar();
    }
}
