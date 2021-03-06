package vista.componentes;

import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import utilidades.*;

public class Tabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int MIN_FILAS = 18;
	private JScrollPane scrollPaneTabla;
	private JTable tabla;
	private JTableHeader headerTabla;
	private ModeloTabla modelo;
	private int filasTabla;
	List<? extends Object> lista;

	public Tabla(String[] titulos, String[][] datos) {

		setLayout(new BorderLayout(0, 0));

		this.tabla = new JTable();
		this.tabla.setBackground(Color.WHITE.getColor());

		this.scrollPaneTabla = new JScrollPane();
		this.scrollPaneTabla.setViewportView(this.tabla);

		add(this.scrollPaneTabla);

		this.construirTabla(titulos, datos);
	}

	private void construirTabla(String[] titulos, String[][] datos) {

		this.modelo = new ModeloTabla(titulos, datos);
		this.tabla.setModel(this.modelo);

		completarFilasVacias();

		this.headerTabla = this.tabla.getTableHeader();
		this.headerTabla.setDefaultRenderer(new GestionEncabezadoTabla());
		this.tabla.setTableHeader(this.headerTabla);

		this.scrollPaneTabla.setViewportView(this.tabla);
	}

	public void actualizarTabla(String[] titulos, Object[][] datos) {
		this.modelo.actualizarModeloTabla(titulos, datos);
		completarFilasVacias();
	}

	public void completarFilasVacias() {
		this.filasTabla = tabla.getRowCount();

		int filasParaCompletar = this.MIN_FILAS - filasTabla;

		if (filasParaCompletar > 0) {
			for (int i = 0; i < filasParaCompletar; i++) {
				modelo.addRow(new String[] { "", "", "", "", "", "" });
			}
		}

	}

	public JTable getTabla() {
		return this.tabla;
	}

}
