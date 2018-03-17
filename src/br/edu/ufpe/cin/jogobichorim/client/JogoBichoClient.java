package br.edu.ufpe.cin.jogobichorim.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

import br.edu.ufpe.cin.jogobichormi.model.IJogoBicho;

public class JogoBichoClient {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {

		//* obtain a reference to a bootstrap remote object registry */
		Registry registry = LocateRegistry.getRegistry("localhost", 1313);

		IJogoBicho jogo_bicho_cliente = (IJogoBicho) registry.lookup("JogoBicho");
		int sampleSize = 10;
		long startTime;

		startTime = System.nanoTime();
		
		int numero;
		for (int c = 0; c < 5; c++) {
			numero = (int) (100.0 * Math.random());
			jogo_bicho_cliente.identificarBicho(numero);
		}
		
		String []  resultado = 		jogo_bicho_cliente.mostrarResultadoJogoBicho();
		for (int i = 0; i < resultado.length; i++) {
			System.out.format("%s ", resultado[i]);
		} 
		System.out.println();
		/*for(int idx = 0; idx < sampleSize; idx++){
		   //System.out.println(calculator.add(1, 3));
			System.out.format("%d + %d = %.1f\n", idx,idx, calculator.add(idx,idx));
			calculator.add(idx, idx);
		}
		*/
		jogo_bicho_cliente = null;
		long duration = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
		System.out.println("Mean Time Duration: "+duration/(float) sampleSize+" ms");
		
	}

}