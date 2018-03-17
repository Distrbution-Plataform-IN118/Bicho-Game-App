package br.edu.ufpe.cin.jogobichormi.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JogoBichoImpl extends UnicastRemoteObject implements IJogoBicho {

	String[] bichos = { "Vaca", "Avestruz", "Avestruz", "Avestruz",
			"Avestruz", "Águia", "Águia", "Águia", "Águia", "Burro",
			"Burro", "Burro", "Burro", "Borboleta", "Borboleta",
			"Borboleta", "Borboleta", "Cachorro", "Cachorro", "Cachorro",
			"Cachorro", "Cabra", "Cabra", "Cabra", "Cabra", "Carneiro",
			"Carneiro", "Carneiro", "Carneiro", "Camelo", "Camelo",
			"Camelo", "Camelo", "Cobra", "Cobra", "Cobra", "Cobra",
			"Coelho", "Coelho", "Coelho", "Coelho", "Cavalo", "Cavalo",
			"Cavalo", "Cavalo", "Elefante", "Elefante", "Elefante",
			"Elefante", "Galo", "Galo", "Galo", "Galo", "Gato", "Gato",
			"Gato", "Gato", "Jacaré", "Jacaré", "Jacaré", "Jacaré", "Leão",
			"Leão", "Leão", "Leão", "Macaco", "Macaco", "Macaco", "Macaco",
			"Porco", "Porco", "Porco", "Porco", "Pavão", "Pavão", "Pavão",
			"Pavão", "Peru", "Peru", "Peru", "Peru", "Touro", "Touro",
			"Touro", "Touro", "Tigre", "Tigre", "Tigre", "Tigre", "Urso",
			"Urso", "Urso", "Urso", "Veado", "Veado", "Veado", "Veado",
			"Vaca", "Vaca", "Vaca" };
	
	public JogoBichoImpl() throws RemoteException {
		super();
		init();
	}



	
	@Override
	public String [] mostrarResultadoJogoBicho() throws RemoteException {
		// TODO Auto-generated method stub
	
		return resultado;
		
	}
	
	private void init(){
		contador = 0;
		//resultado = ];
		
	}
	 int contador;
	 String[] resultado = new String[5];
	//private String[] resultado_final;
	@Override
	public void identificarBicho(int id_bicho) throws RemoteException {
		// TODO Auto-generated method stub
		int numero;
		
		String temp;
		
			numero = id_bicho;
			System.out.println("Numero recebido do cliente: " + numero);
			
			temp = Integer.toString(numero);
			if (numero < 10) {
				temp = "0"+temp;
			}
			temp += " ";
			temp += "-";
			temp += " ";
			temp += bichos[numero];

			if (contador != 4) {
				temp += ",";
			}
			resultado[contador] = temp;
			contador++;
			if (contador == 5){
				init();
			}
		
	}
/*	void saveResult(){
		for (int i = 0; i < resultado.length; i++) {
			resultado_final[i] = resultado[i];
		}
	}*/

}
