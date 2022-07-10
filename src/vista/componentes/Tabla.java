package vista.componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;

import modelo.Cliente;
import utilidades.*;

public class Tabla extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final int MIN_FILAS = 10;
	private JScrollPane scrollPaneTabla;
	private JTable tabla;
	private int cantidadFilas;
	List<? extends Object> lista;
	private ModeloTabla modelo;

	// No se esto para que me sirve
	private int filasTabla;
	private int columnasTabla;

	public Tabla() {
		
		this.setLayout(new BorderLayout(0, 0));

		this.tabla = new JTable();
		this.tabla.setBackground(Color.WHITE.getColor());
		this.tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.tabla.addMouseListener(this);
		
		this.scrollPaneTabla = new JScrollPane();
		this.scrollPaneTabla.setViewportView(this.tabla);
		
		this.add(this.scrollPaneTabla);

		this.construirTabla();
	}

	private void construirTabla() {
		this.lista = consultarLista();

		String[] titulos = { "COD CLIENTE", "NOMBRE", "APELLIDO", "IDENTIFICACION", "CELULAR", "DIRECCION" };

		Object[][] datos = obtenerMatrizDatos(titulos, "Cliente");
		construirTabla(titulos, datos);
	}

	private ArrayList<? extends Object> consultarLista() {
		ArrayList<Cliente> lista = new ArrayList<>();

		lista.add(new Cliente("Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
		return lista;
	}

	private Object[][] obtenerMatrizDatos(String[] titulosColumnas, String tipoLista) {
		this.cantidadFilas = this.lista.size() < this.MIN_FILAS ? this.lista.size() : this.MIN_FILAS;

		String informacion[][] = new String[this.cantidadFilas][titulosColumnas.length];

		switch (tipoLista.toLowerCase()) {

		case "cliente":
			for (int i = 0; i < informacion.length; i++) {

				informacion[i][ClientesColumnas.COD_CLIENTE] = ((Cliente) lista.get(i)).getIdCliente() + "";
				informacion[i][ClientesColumnas.NOMBRE] = ((Cliente) lista.get(i)).getNombre() + "";
				informacion[i][ClientesColumnas.APELLIDO] = ((Cliente) lista.get(i)).getApellido() + "";
				informacion[i][ClientesColumnas.IDENTIFICACION] = ((Cliente) lista.get(i)).getIdentificacion() + "";
				informacion[i][ClientesColumnas.CELULAR] = ((Cliente) lista.get(i)).getCelular() + "";
				informacion[i][ClientesColumnas.DIRECCION] = ((Cliente) lista.get(i)).getDireccion() + "";
			}

		}

		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] datos) {
		this.modelo = new ModeloTabla(titulos, datos);
		this.tabla.setModel(this.modelo);

		this.filasTabla = tabla.getRowCount();
		this.columnasTabla = tabla.getColumnCount();

		// se recorre y asignan las celdas que almacenan datos de tipo texto
		for (int i = 0; i < titulos.length; i++) {
			System.out.println(i);
			tabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas());
		}

		this.tabla.getTableHeader().setReorderingAllowed(false);
		this.tabla.setRowHeight(25);// tama�o de las celdas
		this.tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		this.tabla.getColumnModel().getColumn(ClientesColumnas.COD_CLIENTE).setPreferredWidth(115);// documento
		this.tabla.getColumnModel().getColumn(ClientesColumnas.NOMBRE).setPreferredWidth(280);// nombre
		this.tabla.getColumnModel().getColumn(ClientesColumnas.APELLIDO).setPreferredWidth(250);// direccion
		this.tabla.getColumnModel().getColumn(ClientesColumnas.IDENTIFICACION).setPreferredWidth(150);// telefono
		this.tabla.getColumnModel().getColumn(ClientesColumnas.CELULAR).setPreferredWidth(280);// profesion
		this.tabla.getColumnModel().getColumn(ClientesColumnas.DIRECCION).setPreferredWidth(280);// edad

		// personaliza el encabezado
		JTableHeader jtableHeader = this.tabla.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		this.tabla.setTableHeader(jtableHeader);

		// se asigna la tabla al scrollPane
		this.scrollPaneTabla.setViewportView(this.tabla);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
