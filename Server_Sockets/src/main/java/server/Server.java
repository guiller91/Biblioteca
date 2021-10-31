package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PUERTO = 2021;

	public static void main(String[] args) {
		System.out.println("|-----------------|");
		System.out.println("|     SERVIDOR    |");
		System.out.println("|-----------------|");
		Biblioteca biblio = new Biblioteca();

		int peticion = 0;

		try (ServerSocket servidor = new ServerSocket()) {

			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);

			System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);

			while (true) {
				Socket socketAlCliente = servidor.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				new Hilo(socketAlCliente, biblio);

			}

		} catch (IOException e) {
			System.out.println("SERVIDOR: error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("SERVIDOR: Error");
			e.printStackTrace();
		}
	}
}
