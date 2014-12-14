package clienteWeb;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.remoteInterface;

public class WebController {

	private static WebController instancia;
	remoteInterface controladorRMI;
	
	
	public static WebController getInstancia()
	{
		if(instancia==null)
			return instancia=new WebController();
		return instancia;
	}
	
	private WebController()
	{
		this.getStub();
	}
	
	private boolean getStub() 
	{
		try {
			controladorRMI = (remoteInterface)Naming.lookup ("//localhost/Final");
			System.out.println("Me pude conectar al server");
			return true;
		} catch (Exception e) {
			System.out.println("No me puedo conectar al server");
			e.printStackTrace();
		}
		return false;

	}
	

	public ArrayList<String> getMateriasPrimas() throws RemoteException{
		return controladorRMI.getMateriasPrimas();
	}
	
	public ArrayList<String> getUnidades() throws RemoteException{
		return controladorRMI.getUnidades();
	}

	public String altaPedidoSemi(String desc, String mat, String un, String cost) throws RemoteException {
		return controladorRMI.AltaPedidoSemi( desc,  mat,  un, cost);
		
	}
	
	//Funciones para que los servlet consigan cosas del controladorRMI
	
	

}
