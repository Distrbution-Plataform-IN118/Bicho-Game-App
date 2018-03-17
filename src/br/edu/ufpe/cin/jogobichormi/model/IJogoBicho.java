package br.edu.ufpe.cin.jogobichormi.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IJogoBicho extends Remote {
	void identificarBicho(int id_bicho) throws RemoteException;
	String [] mostrarResultadoJogoBicho() throws RemoteException;
	
	

}