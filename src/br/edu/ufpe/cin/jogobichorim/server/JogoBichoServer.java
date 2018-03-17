package br.edu.ufpe.cin.jogobichorim.server;

import java.rmi.AlreadyBoundException;
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

		// register the instance of Calculator in the Naming Service
		registry.bind("JogoBicho", jogo_bicho);
	}
}
