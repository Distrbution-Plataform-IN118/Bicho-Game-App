package br.edu.ufpe.cin.jogobichorim.nameserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NamingServer {

	public static void main(String[] args) throws RemoteException, InterruptedException {
	     	Registry registry1 = LocateRegistry.createRegistry(1313);
			//Registry registry2 = LocateRegistry.createRegistry(2002);
			
			System.out.println("Registry ready...");
			
			while(true){Thread.sleep(1000);}
	}
}
