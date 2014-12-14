package server;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import hbt.HibernateUtil;

public class Server {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		new Server();
		System.out.println("Arranco server");

	}
	
	private Server(){
		start();
	}
	
	private void start(){
		
		try {
			LocateRegistry.createRegistry(1099);
	        remoteInterface objetoRemoto = new rmiServices();
	        Naming.rebind ("//localhost/Final", objetoRemoto);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}	

		
	}
	

	
	

}
