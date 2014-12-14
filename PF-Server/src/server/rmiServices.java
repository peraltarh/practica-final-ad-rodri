package server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import system.System;

public class rmiServices extends UnicastRemoteObject implements remoteInterface {

	protected rmiServices() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<String> getMateriasPrimas() throws RemoteException {
		return System.getInstance().getMateriasPrimas();
	}

	@Override
	public ArrayList<String> getUnidades() throws RemoteException {
		return System.getInstance().getUnidades();
	}

	@Override
	public String AltaPedidoSemi(String desc, String mat, String un, String cost)
			throws RemoteException {

		return System.getInstance().AltaPedidoSemi( desc,  mat,  un , cost);
		
	}



}
