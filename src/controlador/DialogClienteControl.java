package controlador;

import vista.cliente.DialogCliente;
import modelo.vo.ClienteVo;
import utilidades.*;

public class DialogClienteControl {

    private static DialogCliente ventana = VentanaPrincipalControl.getClienteDialog();

    public static void mostrar(String titulo, Operacion onClick) {
        DialogClienteControl.ventana.setTitulo(titulo);
        DialogClienteControl.ventana.setOnClickBoton1(onClick);
        DialogClienteControl.ventana.setVisible(true);
    }

    public static void ocultar() {
        DialogClienteControl.ventana.setVisible(false);
    }

    public static ClienteVo getDatosCliente() {
        String nombre = DialogClienteControl.ventana.getNombreInput();
        String apellido = DialogClienteControl.ventana.getApellidoInput();
        String identificacion = DialogClienteControl.ventana.getIdentificacionInput();
        String celular = DialogClienteControl.ventana.getCelularInput();
        String direccion = DialogClienteControl.ventana.getDireccionInput();

        ClienteVo cliente;

        if (MetodosAuxiliares.esNumero(DialogClienteControl.ventana.getCodigoInput())) {
            int IdCliente = Integer.parseInt(DialogClienteControl.ventana.getCodigoInput());
            cliente = new ClienteVo(IdCliente, nombre, apellido, identificacion, celular, direccion);
        } else {
            cliente = new ClienteVo(nombre, apellido, identificacion, celular, direccion);
        }

        return cliente;
    }

    public static void setDatosCliente(ClienteVo cliente) {
        DialogClienteControl.ventana
                .setCodigoInput(MetodosAuxiliares.formatearNumero((Object) (cliente.getIdCliente() + "")).toString());
        DialogClienteControl.ventana.setNombreInput(cliente.getNombre());
        DialogClienteControl.ventana.setApellidoInput(cliente.getApellido());
        DialogClienteControl.ventana.setIdentificacionInput(cliente.getIdentificacion() + "");
        DialogClienteControl.ventana.setCelularInput(cliente.getCelular());
        DialogClienteControl.ventana.setDireccionInput(cliente.getDireccion());
    }

    public static void limpiarDatos() {
        DialogClienteControl.ventana.setCodigoInput("");
        DialogClienteControl.ventana.setNombreInput("");
        DialogClienteControl.ventana.setApellidoInput("");
        DialogClienteControl.ventana.setIdentificacionInput("");
        DialogClienteControl.ventana.setCelularInput("");
        DialogClienteControl.ventana.setDireccionInput("");
    }

    public static void mostrarCodigoPorDefecto() {
        DialogClienteControl.ventana.codigoPorDefecto();
    }

    public static void cambiarTextoPrimerBoton(String textoBoton) {
        DialogClienteControl.ventana.setTextoBoton1(textoBoton);
    }
    
    public static void cambiarTextoSegundoBoton(String textoBoton) {
    	DialogClienteControl.ventana.setTextoBoton2(textoBoton);
    }
    
    public static void cambiarOnClickSegundoBoton(Operacion onClick) {
    	DialogClienteControl.ventana.setOnClickBoton2(onClick);
    }
    
    public static void activarCampos() {
    	DialogClienteControl.ventana.activarCampos();
    }
    
    public static void desactivarCampos() {
    	DialogClienteControl.ventana.desactivarCampos();
    }
    
    public static void ocultarSegundoBoton() {
    	DialogClienteControl.ventana.ocultarBoton2();
    }
    
    public static void mostrarSegundoBoton() {
    	DialogClienteControl.ventana.mostrarBoton2();
    }
}
