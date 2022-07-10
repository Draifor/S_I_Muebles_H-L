package vista.componentes;

import utilidades.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.BorderLayout;

public class Header extends JPanel {

//	private String RUTA_IMAGEN = "C:\\Users\\Alfredo Parra\\Documents\\Eclipse-Workspace\\S_I_Muebles_H-L\\src\\vista\\img\\logo.jpeg";
	private String RUTA_IMAGEN = "C:\\Users\\USER\\Documents\\Eclipse-Workspace\\S_I_Muebles_H-L\\src\\utilidades\\img\\logo.jpeg";
	private JPanel contenedor;
	private Texto nombreEmpresa;
	private Imagen logo;
	private Fecha fecha;

	public Header() {
		this.setBackground(Color.AZUL_100.getColor());
		this.setLayout(new BorderLayout(0, 0));
		this.setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));

		this.nombreEmpresa = new Texto("MUEBLES H&L", 1, 36);
		this.logo = new Imagen(this.RUTA_IMAGEN);
		this.fecha = new Fecha();

		this.contenedor = new JPanel();
		this.contenedor.setLayout(new BorderLayout(0, 0));
		this.contenedor.setOpaque(false);
		this.contenedor.add(this.logo, BorderLayout.WEST);
		this.contenedor.add(this.nombreEmpresa, BorderLayout.CENTER);
		this.contenedor.add(this.fecha, BorderLayout.EAST);

		this.add(new JLabel("            "), BorderLayout.WEST);
		this.add(this.contenedor, BorderLayout.CENTER);
		this.add(new JLabel("            "), BorderLayout.EAST);
	}
}
