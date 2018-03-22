package br.edu.ufpe.cin.jogobichorim.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ufpe.cin.jogobichormi.model.JogoBichoImpl;

public class JogoBichoServer {

	protected JogoBichoServer() throws RemoteException {
		super();
	}

	public static void main(String args[]) throws RemoteException,
			AlreadyBoundException {

		// create an instance of Calculator
		JogoBichoImpl jogo_bicho = new JogoBichoImpl();
	    //ICalculator calculatorI = (ICalculator) UnicastRemoteObject.exportObject(calculator, 0);

		// create  a Registry instance on the local host
		Registry registry = LocateRegistry.getRegistry("localhost",1313);

		// registre a instância da JogoBicho no Serviço de Nomes
		registry.bind("JogoBicho", jogo_bicho);
		
		//mostra os servicos RMI disponiveis no servidor de nome
		   String[] bindings;
			try {
				bindings = Naming.list("rmi://localhost:1313/");
				for (int i = 0; i < bindings.length; i++)
			           System.out.println(bindings[i]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
     
	}
}
