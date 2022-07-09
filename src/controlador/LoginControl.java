package controlador;

import vista.VentanaLogin;

public class LoginControl {

    private static VentanaLogin ventana = new VentanaLogin();

    public static void mostrar() {
        LoginControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        LoginControl.ventana.setVisible(false);
    }

    public static void iniciarSesion() {
        LoginControl.ocultar();
        VentanaPrincipalControl.mostrar();
        VentanaPrincipalControl.mostrarVistaMenu();
    }
}
