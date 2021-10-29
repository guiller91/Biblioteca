package server;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private double precio;
	
	// ----- Builders -----
	public Libro(String isbn, String titulo, String autor, double precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public Libro() {
		super();
	}
	
	// ----- Getters and Setters -----
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	
	public String toString() {
		return titulo + " [isbn=" + isbn + ", autor=" + autor + ", precio=" + precio + "€]";
	}
	
	
	
}
