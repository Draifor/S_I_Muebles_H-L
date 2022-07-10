package vista;

import java.awt.*;
import javax.swing.*;
import utilidades.Color;
import vista.componentes.*;

public class VentanaPrincipal extends JFrame {

    private String TITULO = "SISTEMA DE INVENTARIOS MUEBLES H&L";
    private JPanel contenedor;
    private JScrollPane contenidoPrincipal;
    private Header encabezado;
    
    public static void main(String[] args) {
    	
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setMinimumSize(new Dimension(860, 630));
        setLocationRelativeTo(null);
        setTitle(this.TITULO);
    }

    private void iniciarComponentes() {

        this.encabezado = new Header();

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout(0, 0));
        this.setContentPane(contenedor);

        this.contenidoPrincipal = new JScrollPane();
        contenidoPrincipal.setViewportBorder(null);
        this.contenidoPrincipal.getViewport().setBackground(Color.AZUL_30.getColor());
//        contenidoPrincipal.setLayout(new BorderLayout(0, 0));
//		contenidoPrincipal.add(this.menuPrincipal, BorderLayout.CENTER);

        this.contenedor.add(this.encabezado, BorderLayout.NORTH);
        this.contenedor.add(contenidoPrincipal, BorderLayout.CENTER);
    }
    
    public void setContenidoPrincipal(JPanel nuevoContenido, String nombrePaginaActual) {
    	this.contenidoPrincipal.setViewportView(nuevoContenido);
    	PaginaActual.setPaginaActual(nombrePaginaActual);
    }
}
