package controlador;

import modelo.vo.ClienteVo;
import vista.cliente.VentanaAgregarCliente;

public class VentanaAgregarClienteControl {

    private static VentanaAgregarCliente ventana = new VentanaAgregarCliente();

    public static void mostrar() {
        VentanaAgregarClienteControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        VentanaAgregarClienteControl.ventana.setVisible(false);
    }

	public static void agregarCliente() {
		String nombre = VentanaAgregarClienteControl.ventana.getNombreInput();
		String apellido = VentanaAgregarClienteControl.ventana.getApellidoInput();
		double identificacion = Double.parseDouble(VentanaAgregarClienteControl.ventana.getIdentificacionInput());
		String celular = VentanaAgregarClienteControl.ventana.getCelularInput();
		String direccion = VentanaAgregarClienteControl.ventana.getDireccionInput();
		
		ClienteVo nuevoCliente = new ClienteVo(nombre, apellido, identificacion, celular, direccion);
		
		VistaClienteControl.getClienteDao().agregarCliente(nuevoCliente);
	}

}
