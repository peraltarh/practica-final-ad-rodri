package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface remoteInterface extends Remote {
	
	public ArrayList<String> getMateriasPrimas()  throws RemoteException;

	public ArrayList<String> getUnidades()  throws RemoteException;
	
	public String AltaPedidoSemi (String desc, String mat, String un, String cost) throws RemoteException;
	
}
