package vista.componentes;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import controlador.Operacion;
import utilidades.Color;

public class ItemCRUD extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Imagen icono;
	private Texto label;
	private Operacion onClick;

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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
