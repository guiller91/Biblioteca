package server;

import java.util.ArrayList;

public class Biblioteca {

	public ArrayList<Libro> libros = new ArrayList<Libro>();
	public String texto;
	Libro libro1 = new Libro("1", "libro1", "guiller", 20);
	Libro libro2 = new Libro("2", "libro2", "guiller", 20);
	Libro libro3 = new Libro("3", "libro3", "guiller", 20);
	Libro libro4 = new Libro("4", "libro4", "guiller", 20);
	Libro libro5 = new Libro("5", "libro5", "guiller", 20);

	public Biblioteca() {
		super();
		registrarLibro(libro1);
		registrarLibro(libro2);
		registrarLibro(libro3);
		registrarLibro(libro4);
		registrarLibro(libro5);
	}
	
	// Evaluamos la petición del cliente, utilizando los valores NULL del objeto
	// para saber que es lo que solicita.
	public String evaluarPeticion(Libro libro) {
		// consulta por isbn
		if (libro.getAutor() == null & libro.getTitulo() == null) {
			texto = buscarLibroByCodigo(libro.getIsbn());
			return texto;
		}
		// consulta por titulo
		else if (libro.getAutor() == null & libro.getIsbn() == null) {
			texto = buscarLibroByTitulo(libro.getTitulo());
			return texto;
		}
		// consulta por autor
		else if (libro.getIsbn() == null & libro.getTitulo() == null) {
			texto = buscarLibroByAutor(libro.getAutor());
			return texto;
		}
		// unica opción que queda, añadir libro
		else {
			registrarLibro(libro);
			return "Libro " + libro.getTitulo() + " añadido";
		}
	}
	
	// Evaluamos la petición del cliente y devolvemos al servidor información de la solicitud
	public String evaluarPeticionServidor(Libro libro) {
		// consulta por isbn
		if (libro.getAutor() == null & libro.getTitulo() == null) {
			texto = "Consulta de libro por ISBN";
			return texto;
		}
		// consulta por titulo
		else if (libro.getAutor() == null & libro.getIsbn() == null) {
			texto = "Consulta de libro por titulo";
			return texto;
		}
		// consulta por autor
		else if (libro.getIsbn() == null & libro.getTitulo() == null) {
			texto = "Consulta de libro por Autor";
			return texto;
		}
		// unica opción que queda, añadir libro
		else {

			return "Añadir libro";
		}
	}
	
	// Añadimos objeto al ArrayList
	public void registrarLibro(Libro libro) {
		libros.add(libro);
	}
	
	// Buscamos coincidencia en el ArrayList y devolvemos información sobre el objeto encontrado
	public String buscarLibroByCodigo(String codigoLibro) {
		Libro libro;
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getIsbn().equals(codigoLibro)) {
				return libro.toString();
			}
		}
		return "No se encontro el libro";
	}
	
	// Buscamos coincidencia en el ArrayList y devolvemos información sobre el objeto encontrado
	public String buscarLibroByTitulo(String titulo) {
		Libro libro;
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getTitulo().equals(titulo)) {
				return libro.toString();
			}
		}
		return "No se encontro el libro";
	}

	// Buscamos coincidencia en el ArrayList y devolvemos información sobre el objeto encontrado
	// De ser más de una coincidencia, devolvemos los objetos separados por @@ para que el cliente 
	// procese la información
	public String buscarLibroByAutor(String autor) {
		Libro libro = new Libro();
		texto = "Los libros encontrados son:";
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getAutor().equals(autor)) {
				texto = texto + "@@" + libro.toString();
				if (i == (libros.size() - 1)) {
					return texto;
				}
			}
		}
		return "Libro no encontrado";
	}

}
