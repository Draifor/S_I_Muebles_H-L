package utilidades;

import java.awt.Color;
import java.awt.*;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.table.TableCellRenderer;

public class GestionEncabezadoTabla implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		JComponent jcomponent = null;

		if (value instanceof String) {
			jcomponent = new JLabel((String) value);
			((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
			((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
			((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
		}

		jcomponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
		jcomponent.setOpaque(true);
		jcomponent.setBackground(new Color(65, 65, 65));
		jcomponent.setForeground(Color.white);

		return jcomponent;
	}

}
