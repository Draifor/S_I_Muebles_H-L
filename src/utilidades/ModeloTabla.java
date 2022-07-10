package utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	String[] titulosColumnas;
	Object[][] datos;

	public ModeloTabla(String[] titulos, Object[][] datos) {
		super();
		this.titulosColumnas=titulos;
		this.datos=datos;
		setDataVector(datos, titulos);
	}
	
	@Override
	public boolean isCellEditable (int row, int column) {
		return false;
	}
}
