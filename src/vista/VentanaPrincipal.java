package vista;

import java.awt.*;
import javax.swing.*;

import utilidades.Color;

import vista.componentes.*;

public class VentanaPrincipal extends JFrame {

    private String TITULO = "SISTEMA DE INVENTARIOS MUEBLES H&L";
    private JPanel contenedor;
    public static JPanel contenidoPrincipal;
    private Header encabezado;
    private JPanel menuPrincipal;
//	private VistaCliente seccionCliente;
//	private VistaDiseño seccionDiseño;
//	private VistaMaterial seccionMaterial;
//	private VistaOrdenCompra seccionOrdenCompra;
//	private VistaProducto seccionProducto;
//	private VistaVenta seccionVenta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    System.out.println("Aqui");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Aqui2");
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
        setMinimumSize(new Dimension(1100, 700));
        setSize(860, 570);
        setLocationRelativeTo(null);
        setTitle(this.TITULO);

        this.menuPrincipal = new VistaMenu();
        contenidoPrincipal.removeAll();
        contenidoPrincipal.add(this.menuPrincipal, BorderLayout.CENTER);
//        contenidoPrincipal.revalidate();
        contenidoPrincipal.repaint();

    }

    private void iniciarComponentes() {

        this.encabezado = new Header();
//		this.seccionCliente = new VistaCliente();
//		this.seccionDiseño = new VistaDiseño();
//		this.seccionMaterial = new VistaMaterial();
//		this.seccionOrdenCompra = new VistaOrdenCompra();
//		this.seccionProducto = new VistaProducto();
//		this.seccionVenta = new VistaVenta();

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout(0, 0));
        this.setContentPane(contenedor);

        contenidoPrincipal = new JPanel();
        contenidoPrincipal.setBackground(Color.AZUL_30.getColor());
        contenidoPrincipal.setLayout(new BorderLayout(0, 0));
//		contenidoPrincipal.add(this.menuPrincipal, BorderLayout.CENTER);

        this.contenedor.add(this.encabezado, BorderLayout.NORTH);
        this.contenedor.add(contenidoPrincipal, BorderLayout.CENTER);
    }

    public void setContenidoPrincipal(String nuevoContenido) {

        nuevoContenido = nuevoContenido.toLowerCase();

        this.menuPrincipal = nuevoContenido == "cliente" ? new VistaCliente()
                : nuevoContenido == "diseño" ? new VistaDiseño()
                        : nuevoContenido == "material" ? new VistaMaterial()
                                : nuevoContenido == "ordencompra" ? new VistaOrdenCompra() : new VistaMenu();

//		this.contenidoPrincipal.removeAll();
//		this.contenidoPrincipal.add(nuevoPanel, BorderLayout.CENTER);
        contenidoPrincipal.removeAll();
        contenidoPrincipal.add(this.menuPrincipal, BorderLayout.CENTER);
//        contenidoPrincipal.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
        this.validateTree();
        contenidoPrincipal.repaint();
    }

    public JPanel getMenuPrincipal() {
        return this.menuPrincipal;
    }

//	public VistaCliente getSeccionCliente() {
//		return this.seccionCliente;
//	}
//
//	public VistaDiseño getSeccionDiseño() {
//		return this.seccionDiseño;
//	}
//
//	public VistaMaterial getSeccionMaterial() {
//		return this.seccionMaterial;
//	}
//
//	public VistaOrdenCompra getSeccionOrdenCompra() {
//		return this.seccionOrdenCompra;
//	}
//
//	public VistaProducto getSeccionProducto() {
//		return this.seccionProducto;
//	}
//
//	public VistaVenta getSeccionVenta() {
//		return this.seccionVenta;
//	}
}
