package utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public ModeloTabla(String[] titulos, Object[][] datos) {
		setDataVector(datos, titulos);
	}

	public void actualizarModeloTabla(String[] titulos, Object[][] datos) {
		setDataVector(datos, titulos);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
