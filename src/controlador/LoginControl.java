package controlador;

import vista.VentanaLogin;

public class LoginControl {

	private static VentanaLogin ventana = new VentanaLogin();

	public static void mostrar() {
		LoginControl.ventana.limpiarDatos();
		LoginControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		LoginControl.ventana.setVisible(false);
	}

	public static void iniciarSesion() {
		if (LoginControl.validarCredenciales()) {
			try {
				VentanaPrincipalControl.mostrar();
				LoginControl.ocultar();
				VentanaPrincipalControl.mostrarVistaMenu();
			} catch (Exception error) {
				LoginControl.dialogoAlerta("Ocurrió un error: " + error, "Error al lanzar el programa");
			}
		} else {
			LoginControl.dialogoAlerta("Usuario y/o contraseña incorrectos", "Error de autenticación");
		}
	}

	public static Boolean validarCredenciales() {
		if (LoginControl.ventana.getUsuario().trim().equalsIgnoreCase("admin")) {
			if (LoginControl.ventana.getContraseña().equals("1234")) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public static void dialogoAlerta(String mensaje, String titulo) {
		LoginControl.ventana.dialogoAlerta(mensaje, titulo);
	}
}
