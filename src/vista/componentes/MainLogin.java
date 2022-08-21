package vista.componentes;

import javax.swing.*;
import java.awt.*;

import utilidades.Color;
import utilidades.Operacion;
import controlador.*;

public class MainLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorLogin;
	private Texto titulo;
	private Label usuario;
	private CampoInput usuarioInput;
	private Label contraseña;
	private CampoInput contraseñaInput;
	private Boton btnIngresar;
	private Operacion onClick;

	public MainLogin() {
		setBackground(Color.AZUL_50.getColor());
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		this.titulo = new Texto("INGRESO AL SISTEMA", 1, 24);
		this.titulo.setBounds(2, 11, 396, 35);

		this.usuario = new Label("Usuario:");
		this.usuario.setBounds(36, 78, 105, 29);

		this.usuarioInput = new CampoInput("texto");
		this.usuarioInput.setBounds(178, 78, 183, 29);

		this.contraseña = new Label("Contraseña:");
		this.contraseña.setBounds(36, 144, 105, 29);

		this.contraseñaInput = new CampoInput("contraseña");
		this.contraseñaInput.setBounds(178, 144, 183, 29);

		this.onClick = () -> LoginControl.iniciarSesion();
		this.btnIngresar = new Boton("Ingresar", this.onClick);
		this.btnIngresar.setBounds(150, 206, 105, 27);
		
		this.contenedorLogin = new JPanel();
		this.contenedorLogin.setBackground(Color.AZUL_30.getColor());
		this.contenedorLogin.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 2));
		this.contenedorLogin.setPreferredSize(new Dimension(400, 267));
		this.contenedorLogin.setLayout(null);
		this.contenedorLogin.add(this.titulo);
		this.contenedorLogin.add(this.usuario);
		this.contenedorLogin.add(this.usuarioInput);
		this.contenedorLogin.add(this.contraseña);
		this.contenedorLogin.add(this.contraseñaInput);
		this.contenedorLogin.add(btnIngresar);

		add(this.contenedorLogin);
	}

	public String getUsuario() {
		return this.usuarioInput.getTextInput();
	}
	
	public String getContraseña() {
		return this.contraseñaInput.getTextInput();
	}
	
	public void limpiarDatos() {
		this.usuarioInput.setTextInput("");
		this.contraseñaInput.setTextInput("");
		this.usuarioInput.enfocar();
	}
}
