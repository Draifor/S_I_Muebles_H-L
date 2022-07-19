package vista.componentes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import utilidades.Color;
import utilidades.Operacion;

public class ItemCRUD extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Imagen icono;
	private Texto label;
	private Operacion onClick;
	private boolean habilitado;

	public ItemCRUD(String label, String source, Operacion onClick) {

		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);

		this.icono = new Imagen(source);
		this.icono.setBorder(new LineBorder(Color.VERDE_50.getColor(), 2));

		this.label = new Texto(label, 0, 16);

		add(new JLabel("   "), BorderLayout.WEST);
		add(this.icono, BorderLayout.CENTER);
		add(new JLabel("   "), BorderLayout.EAST);
		add(this.label, BorderLayout.SOUTH);

		this.onClick = onClick;
		this.habilitado = true;
	}
	
	public void deshabilitarItem() {
		this.habilitado = false;
		this.icono.setEnabled(false);
		this.icono.setBorder(new LineBorder(Color.GRIS_50.getColor(), 1));
		this.label.setForeground(Color.GRIS_50.getColor());
		setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.habilitado)
			this.onClick.onMouseClicked();
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
