package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.google.gson.Gson;

public class Hilo implements Runnable {
	
	private Thread hilo;
	private static int numCliente = 0;
	private Socket socketAlCliente;
	public Biblioteca biblio = new Biblioteca();
	

	public Hilo(Socket socketAlCliente ) {
		numCliente++;
		hilo = new Thread(this, "cliente_"+numCliente);
		this.socketAlCliente = socketAlCliente;
		hilo.start();	
	}
	
	@Override
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;		
		Gson gson= new Gson();
		
		
		try {
			
			salida = new PrintStream(socketAlCliente.getOutputStream());
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer =  new BufferedReader(entrada);
			
			String texto = "";
			boolean continuar = true;
			
			while(continuar) {
				texto = entradaBuffer.readLine();
				
				if(texto.equalsIgnoreCase("FIN")) {
					salida.println("Cerrando conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicacion");
					continuar = false;					
				}else {
					
					Libro libro = gson.fromJson(texto, Libro.class);
					System.out.println("El" + hilo.getName()+ " " + biblio.evaluarPeticionServidor(libro));
					String respuesta = biblio.evaluarPeticion(libro);
					salida.println(respuesta);
					System.out.println("SERVIDOR: le ha respondido al cliente : \n" + respuesta.replaceAll("@@", "\n"));
					
					
				}
			}
			
			socketAlCliente.close();
			
		} catch (IOException e) {
			System.err.println("Hilo: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Hilo: Error");
			e.printStackTrace();
		}
		
	}
	
	
	

}
