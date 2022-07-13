package controlador;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import modelo.vo.ClienteVo;
import vista.cliente.DialogCliente;
import vista.componentes.Texto;

public class DialogClienteControl {

    private static DialogCliente ventana = VentanaPrincipalControl.getClienteDialog();
    

    public static void mostrarAgregarCliente() {
    	
    	DialogClienteControl.ventana.setTitulo("Agregar Cliente");
    	DialogClienteControl.ventana.setOnClick(() -> DialogClienteControl.agregarCliente());
        DialogClienteControl.ventana.setVisible(true);
    }
    
    public static void mostrarModificarCliente() {
    	
    	DialogClienteControl.ventana.setTitulo("Modificar Cliente");
    	DialogClienteControl.ventana.setOnClick(() -> DialogClienteControl.modificarCliente());
    	JOptionPane.showMessageDialog(ventana, new Texto("Hola baby", 0,18), "Alerta", JOptionPane.PLAIN_MESSAGE);
//    	DialogClienteControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        DialogClienteControl.ventana.setVisible(false);
    }

	public static void agregarCliente() {
		String nombre = DialogClienteControl.ventana.getNombreInput();
		String apellido = DialogClienteControl.ventana.getApellidoInput();
		double identificacion = Double.parseDouble(DialogClienteControl.ventana.getIdentificacionInput());
		String celular = DialogClienteControl.ventana.getCelularInput();
		String direccion = DialogClienteControl.ventana.getDireccionInput();
		
		ClienteVo nuevoCliente = new ClienteVo(nombre, apellido, identificacion, celular, direccion);
		
		VistaClienteControl.getClienteDao().agregarCliente(nuevoCliente);
		VentanaPrincipalControl.actualizarVistaCliente();
		DialogClienteControl.ocultar();
	}

	public static void modificarCliente() {
		System.out.println("Se modificó el cliente");
	}
}
