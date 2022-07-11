package controlador;

import java.util.List;

import modelo.dao.ClienteDao;
import modelo.vo.ClienteVo;

public class VistaClienteControl {
	
	private static ClienteDao clienteDao = new ClienteDao();
	
	public static void agregarCliente() {
		VistaClienteControl.clienteDao.agregarCliente();
	}
	
	public static List<ClienteVo> obtenerClientes() {
		return VistaClienteControl.clienteDao.obtenerClientes();
	}
}
