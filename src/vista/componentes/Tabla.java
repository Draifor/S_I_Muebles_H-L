package vista.componentes;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import utilidades.*;

public class Tabla extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final int MIN_FILAS = 18;
	private JScrollPane scrollPaneTabla;
	private JTable tabla;
	private JTableHeader headerTabla;
	private ModeloTabla modelo;
	private int filasTabla;
	List<? extends Object> lista;

	public Tabla(String[] titulos, String [][] datos) {

		setLayout(new BorderLayout(0, 0));

		this.tabla = new JTable();
		this.tabla.setBackground(Color.WHITE.getColor());
		this.tabla.addMouseListener(this);

		this.scrollPaneTabla = new JScrollPane();
		this.scrollPaneTabla.setViewportView(this.tabla);

		add(this.scrollPaneTabla);

		this.construirTabla(titulos, datos);
	}


	private void construirTabla(String[] titulos, String [][] datos) {
				
		this.modelo = new ModeloTabla(titulos, datos);
		this.tabla.setModel(this.modelo);

		this.filasTabla = tabla.getRowCount();
//		this.columnasTabla = tabla.getColumnCount();

		int filasParaCompletar = this.MIN_FILAS - filasTabla;

		if (filasParaCompletar > 0) {
			for (int i = 0; i < filasParaCompletar; i++) {
				modelo.addRow(new String[] { "", "", "", "", "", "" });
			}
		}
		
		// personaliza el encabezado
		this.headerTabla = this.tabla.getTableHeader();
		this.headerTabla.setDefaultRenderer(new GestionEncabezadoTabla());
		this.tabla.setTableHeader(this.headerTabla);

		// se asigna la tabla al scrollPane
		this.scrollPaneTabla.setViewportView(this.tabla);
	}

	public JTable getTabla() {
		return this.tabla;
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
