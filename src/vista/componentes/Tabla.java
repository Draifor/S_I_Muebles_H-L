package vista.componentes;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import controlador.VistaClienteControl;
import modelo.vo.ClienteVo;
import utilidades.*;

public class Tabla extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final int MIN_FILAS = 18;
	private JScrollPane scrollPaneTabla;
	private JTable tabla;
	List<? extends Object> lista;
	private ModeloTabla modelo;

	private int filasTabla;

	public Tabla() {

		setLayout(new BorderLayout(0, 0));

		this.tabla = new JTable();
		this.tabla.setBackground(Color.WHITE.getColor());
		this.tabla.setBorder(null);
		this.tabla.addMouseListener(this);

		this.scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBorder(null);
		this.scrollPaneTabla.setViewportView(this.tabla);

		add(this.scrollPaneTabla);

		this.construirTabla();
	}

	private void construirTabla() {
		this.lista = VistaClienteControl.obtenerClientes();

		String[] titulos = { "COD CLIENTE", "NOMBRE", "APELLIDO", "IDENTIFICACION", "CELULAR", "DIRECCION" };

		Object[][] datos = obtenerMatrizDatos(titulos, "Cliente");
		construirTabla(titulos, datos);
	}

//	private List<? extends Object> consultarLista() {
//		List<ClienteVo> lista = new ArrayList<>();
//
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		lista.add(new ClienteVo("Anastasio Hermelindo", "Buen Día", 1117540545, "Calle 5 # 85", 320364045));
//		return lista;
//	}

	private Object[][] obtenerMatrizDatos(String[] titulosColumnas, String tipoLista) {

		String informacion[][] = new String[this.lista.size()][titulosColumnas.length];

		switch (tipoLista.toLowerCase()) {

		case "cliente":
			for (int i = 0; i < informacion.length; i++) {

				informacion[i][ClientesColumnas.COD_CLIENTE] = ((ClienteVo) lista.get(i)).getIdCliente() + "";
				informacion[i][ClientesColumnas.NOMBRE] = ((ClienteVo) lista.get(i)).getNombre() + "";
				informacion[i][ClientesColumnas.APELLIDO] = ((ClienteVo) lista.get(i)).getApellido() + "";
				informacion[i][ClientesColumnas.IDENTIFICACION] = ((ClienteVo) lista.get(i)).getIdentificacion() + "";
				informacion[i][ClientesColumnas.CELULAR] = ((ClienteVo) lista.get(i)).getCelular() + "";
				informacion[i][ClientesColumnas.DIRECCION] = ((ClienteVo) lista.get(i)).getDireccion() + "";
			}
		}

		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] datos) {
		this.modelo = new ModeloTabla(titulos, datos);
		this.tabla.setModel(this.modelo);

		this.filasTabla = tabla.getRowCount();
//		this.columnasTabla = tabla.getColumnCount();

		int filasVaciasRequeridas = this.MIN_FILAS - filasTabla;

		if (filasVaciasRequeridas > 0) {
			for (int i = 0; i < filasVaciasRequeridas; i++) {
				modelo.addRow(new Object[] { "", "", "", "", "", "" });
			}
		}
		// se recorre y asignan las celdas que almacenan datos de tipo texto
		for (int i = 0; i < ClientesColumnas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_TEXTO[i]).setCellRenderer(new GestionCeldas());
		}

		// Se recorre para asignar datos de tipo numero
		for (int i = 0; i < ClientesColumnas.TIPO_NUMERO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_NUMERO[i])
					.setCellRenderer(new GestionCeldas("numero"));
		}

		this.tabla.getTableHeader().setReorderingAllowed(false);
		this.tabla.setRowHeight(25);// tama�o de las celdas
		this.tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		this.tabla.getColumnModel().getColumn(ClientesColumnas.COD_CLIENTE).setPreferredWidth(115);// documento
		this.tabla.getColumnModel().getColumn(ClientesColumnas.NOMBRE).setPreferredWidth(230);// nombre
		this.tabla.getColumnModel().getColumn(ClientesColumnas.APELLIDO).setPreferredWidth(230);// direccion
		this.tabla.getColumnModel().getColumn(ClientesColumnas.IDENTIFICACION).setPreferredWidth(150);// telefono
		this.tabla.getColumnModel().getColumn(ClientesColumnas.CELULAR).setPreferredWidth(150);// profesion
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
