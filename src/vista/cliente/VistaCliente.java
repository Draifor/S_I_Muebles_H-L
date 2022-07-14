package vista.cliente;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.*;
import vista.componentes.*;

public class VistaCliente extends JPanel {

    private static final long serialVersionUID = 1L;
    private ContenedorVista contenedorVista;
    private Tabla tabla;

    public VistaCliente() {

        setLayout(new BorderLayout(0, 0));
        setOpaque(false);

        this.construirTabla();

        this.contenedorVista = new ContenedorVista("CLIENTES", this.tabla);

        this.add(this.contenedorVista, BorderLayout.CENTER);
    }

    public void construirTabla() {

        String[] titulos = VistaClienteControl.obtenerTitulosColumnas();
        String[][] datos = VistaClienteControl.obtenerClientes();

        this.tabla = new Tabla(titulos, datos);

        VistaClienteControl.construirTabla(this.tabla.getTabla());
    }

    public void actualizarTabla() {
        String[] titulos = VistaClienteControl.obtenerTitulosColumnas();
        String[][] datos = VistaClienteControl.obtenerClientes();

        this.tabla.actualizarTabla(titulos, datos);
        VistaClienteControl.construirTabla(this.tabla.getTabla());
    }

    public String obtenerClienteSeleccionado(String mensaje, String titulo) {
        String resultadoOperacion = VistaClienteControl.obtenerClienteSeleccionado(this.tabla.getTabla());

        if (resultadoOperacion.equals("error")) {
            this.mostrarAlerta(mensaje, titulo);
            return "error";
        } else {
            return "mostrar";
        }
    }

    public void mostrarAlerta(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, new Texto(mensaje, 0, 18), titulo, JOptionPane.PLAIN_MESSAGE);
    }

    public String mostrarDialogoConfirmacion(String mensaje, String titulo) {
        int opcionElegida = JOptionPane.showConfirmDialog(this, new Texto(mensaje, 0, 15), titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (opcionElegida == 0) return "eliminar";
        else return "cancelar";
    }
}
