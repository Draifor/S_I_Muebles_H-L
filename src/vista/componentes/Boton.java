package vista.componentes;

import utilidades.Color;
import utilidades.Operacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Boton extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Texto botonTxt;
	private Operacion onClick;

	public Boton(String name, Operacion onClick) {

		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(2);

		setBackground(Color.VERDE_50.getColor());
		setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setDoubleBuffered(false);
		setFocusable(true);
		addMouseListener(this);
//		this.hacerEnfocable();

		this.onClick = onClick;
		this.botonTxt = new Texto(name, 0, 15);
		this.botonTxt.setForeground(Color.WHITE.getColor());

		add(botonTxt);
	}
	
//	public void hacerEnfocable() {
//		Action enviarFormulario = new AbstractAction() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				onClick.onMouseClicked();
//			}
//		};
//		enviarFormulario.setEnabled(true);
//		this.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Enter"), "enviarFormulario");
//		this.getActionMap().put("enviarFormulario",	enviarFormulario);
//	}

	public void setOnClick(Operacion onClick) {
		this.onClick = onClick;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.onClick.onMouseClicked();
		requestFocusInWindow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.VERDE_100.getColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.VERDE_50.getColor());
	}

	public void setTextoBoton(String botonTxt) {
		this.botonTxt.setText(botonTxt);
	}

}