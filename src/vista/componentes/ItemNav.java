package vista.componentes;

import utilidades.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controlador.Operacion;

public class ItemNav extends JPanel implements MouseListener {

	private JLabel botonTxt;
	private Operacion onClick;

	public ItemNav(String name, Operacion onClick) {

		this.setBackground(Color.VERDE_50.getColor());
		this.setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setDoubleBuffered(false);
		this.setLayout(new BorderLayout(0, 0));
		this.addMouseListener(this);

		this.onClick = onClick;
		this.botonTxt = new JLabel(name);

		botonTxt.setFont(new Font("Times New Roman", 0, 15)); // NOI18N
		botonTxt.setForeground(Color.WHITE.getColor());
		botonTxt.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(botonTxt);
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
		this.setBackground(Color.VERDE_100.getColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.VERDE_50.getColor());
	}

}
