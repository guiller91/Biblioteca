package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;

public class SocketCliente {

	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		System.out.println("|-----------------|");
		System.out.println("|     CLIENTE     |");
		System.out.println("|-----------------|");

		InetSocketAddress direccionServer = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("CLIENTE: Esperando a que el server acepte conexión");

			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServer);
			System.out.println("CLIENTE: Conexión establecida a " + IP_SERVER + " por el puerto " + PUERTO);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader entradaBuffer = new BufferedReader(entrada);

			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());

			String texto = "";
			boolean continuar = true;
			int num;
			Libro libro;
			Gson gson = new Gson();
			String json = "";

			do {
				System.out.println("Elige una número del menu:\n" + "1. Consultar libro por ISBN\n"
						+ "2. Consultar libro por titulo\n" + "3. Consultar libros por autor\n" + "4. Añadir libro\n"
						+ "5. Salir de la aplicación");
				num = Integer.parseInt(sc.nextLine());

				switch (num) {
				case 1:
					libro = new Libro();
					System.out.println("Introduzca el ISBN");
					texto = sc.nextLine();
					libro.setIsbn(texto);
					json = gson.toJson(libro);
					break;
				case 2:
					libro = new Libro();
					System.out.println("Introduzca el título");
					texto = sc.nextLine();
					libro.setTitulo(texto);
					json = gson.toJson(libro);
					break;
				case 3:
					libro = new Libro();
					System.out.println("Introduzca el autor");
					texto = sc.nextLine();
					libro.setAutor(texto);
					json = gson.toJson(libro);
					break;
				case 4:
					libro = new Libro();
					System.out.println("Introduzca un ISBN");
					texto = sc.nextLine();
					libro.setIsbn(texto);
					System.out.println("Introduzca el título");
					texto = sc.nextLine();
					libro.setTitulo(texto);
					System.out.println("Introduzca el autor");
					texto = sc.nextLine();
					libro.setAutor(texto);
					System.out.println("Introduzca el precio");
					int precio = Integer.parseInt(sc.nextLine());
					libro.setPrecio(precio);
					json = gson.toJson(libro);
					break;
				case 5:
					System.out.println("Saliendo de la aplicación....");
					json = "FIN";
					continuar = false;
					break;
				default:
					System.out.println("Introduzca un numero del menu");
				}
				// Enviamos lo que quiera el cliente solicitar mediante un objeto transformado a
				// json
				// salvo que sea la finalización del programa
				salida.println(json);

				System.out.println("CLIENTE: Esperando respuesta.....");
				// recibimos respuesta del servidor
				String respuesta = entradaBuffer.readLine();
				// damos formato a la respuesta del servidor, cambiando
				// las @@ por un salto de linea, asi podremos ver cada libro
				// en una linea
				String remplazo = respuesta.replaceAll("@@", "\n");

				System.out.println("El Servidor responde: \n" + remplazo + "\n");

			} while (continuar);

			socketAlServidor.close();

		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}

		System.out.println("CLIENTE: Fin del programa");
	}

}
