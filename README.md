# Actividad 2 - Sockets

### Miembros del grupo:

- [Iván Gaitán Muñoz](https://github.com/IGaitanM)
- [Luz Maria Lozano Asimbaya](https://github.com/luzlozas)
- [Miguel Pérez Larren](https://github.com/miguelperezlarren)
- [Guillermo Pérez Arias](https://github.com/guiller91)

## Objetivos

- [x]  Programa Cliente-Servidor que gestione una librería virtual alojada en el server.
- [x]  Un menú en la aplicación cliente que nos de las siguientes funcionalidades
    - [x]  Consultar libro por ISBN
    - [x]  Consultar libro por Titulo
    - [x]  Consultar libro por autor
    - [x]  Añadir Libro
    - [x]  Salir de la aplicación
- [x]  Soporte de hilos en servidor

## Solución aportada

Nos hemos decantado por un proyecto Maven para poder implementar la dependencia de JSON y poder operar con el, como vía de comunicación con el servidor. De esta manera nos facilitara a la hora de recibir los datos y poder operar con ellos en el servidor.

## Explicación de puntos clave

### Cliente

---

Para el menú del cliente hemos usado un `Switch{}` para movernos entre las opciones del menú.

```java
System.out.println("Elige una número del menu:\n"+"1. Consultar libro por ISBN\n"+"2. Consultar libro por titulo\n"+
									"3. Consultar libros por autor\n" + "4. Añadir libro\n" + "5. Salir de la aplicación" );
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
					libro=new Libro();
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
					json="FIN";
					continuar=false;
					break;
				default:
					System.out.println("Introduzca un numero del menu");;
				}
```

Como curiosidad, hemos tenido que usar `Scanner.nextLine()`, para poder recoger espacios, por si el usuario quería dar una opción con varias palabras. Al usar el tipo `Integer`  para el precio del libro, hemos tenido que usar el `Integer.parseInt(scanner.nextLine())`  para que no nos diera un error de salto de línea a la hora de interactuar con el menú.

Para enviar la información al servidor, lo haremos mediante un objeto `Libro` convertido a JSON.
`gson.toJson(libro)`.

El servidor nos contestara devolviéndonos un `String` compuesto por  la información del libro( si es que existe ) o de varios libros si es necesario. El patrón que hemos establecido es que si son varios libros los separaran mediante `@@.`

Como ejemplo `Libro.toString()@@Libro2.toString()` , por lo cual tomamos de referencia las `@@` y las sustituiremos por un salto de línea. `respuesta.replaceAll("@@", "\n")`

Si el usuario quiere cerrar la aplicación, enviaremos un `"FIN"` al servidor y usaremos `continuar=false` para poder salir del bucle y cerraremos conexión `socketAlServidor.close()`.

### Servidor

---

Hemos usado un servidor que acepte varios clientes mediante hilos. Entonces cada vez que entre una petición de un cliente se la asignaremos a un nuevo hilo.

```java
Socket socketAlCliente = servidor.accept();
System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
//Creación de nuevo hilo por cada cliente que solicite.				
new Hilo(socketAlCliente);
```

Hemos usado una Biblioteca  usando un `ArrayList<Libros> libros = new ArrayList<Libros>()`con 5 libros ya predefinidos.

Añadimos varios métodos para la problemática que plantea el problema. Empezaremos por el de registrar un libro.  Nos pasan un objeto `Libro` y lo agregamos al `ArrayList` mediante  `libros.add(libro)`

Para buscar un Libro por su ISBN recorreremos el Array mediante un bucle pasando el valor a un libro creado y si lo encuentra nos devolverá `libro.toString()`. En caso de no encontrarlo, nos devolverá un `String` con el mensaje de *"No se encontró el libro"*

```java
public String buscarLibroByCodigo(String codigoLibro){
        Libro libro;           
        for(int i=0; i<libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getIsbn().equals(codigoLibro)){
                return libro.toString();                
            }
        }        
        return "No se encontro el libro";
    }
```

Para buscar el libro mediante su titulo, el funcionamiento es el mismo que el método anterior.

```java
public String buscarLibroByTitulo(String titulo){
        Libro libro;        
        for(int i=0; i<libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getTitulo().equals(titulo)){
                return libro.toString();                
            }
        }        
        return "No se encontro el libro";
    }
```

Para buscar el libro mediante Autor, tenemos que tener en cuenta que un Autor puede tener varios libros, por lo cuál tendremos que devolver todos los libros. Como solo vamos a devolver un `String` al cliente, recorremos el Array y cada vez que encuentre un Libro de dicho Autor lo añadirá y concatenara junto con `@@` ( para que el cliente sepa que aquí tiene que meter un salto de línea)

`texto = texto + "@@" +libro.toString();`

Añadiremos la condición `if(i==(libros.size()-1)) {return texto;}` para que nos devuelva el `texto` solo cuando haya recorrido todo el Array, para asegurarnos que nos coge todos los libros.

```java
public String buscarLibroByAutor(String autor){
        Libro libro= new Libro();
        texto="Los libros encontrados son:";
        for(int i=0; i<libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getAutor().equals(autor)){                
                texto = texto + "@@" +libro.toString();
                if(i==(libros.size()-1)) {
                	return texto;
                }
            }
        }       
        return "Libro no encontrado";
    }
```

Para evaluar la petición del cliente, lo hemos añadido con las siguientes condiciones:

```java
public String evaluarPeticion(Libro libro) {
		// consulta por isbn
		if(libro.getAutor()==null & libro.getTitulo()==null){
			texto = buscarLibroByCodigo(libro.getIsbn());
			return texto;
		}
		// consulta por titulo
		else if(libro.getAutor()==null & libro.getIsbn()==null) {
			texto = buscarLibroByTitulo(libro.getTitulo());
			return texto;
		}
		// consulta por autor
		else if(libro.getIsbn()==null & libro.getTitulo()==null) {
			texto = buscarLibroByAutor(libro.getAutor());
			return texto;	
		}
		// unica opción que queda, añadir libro
		else {
			registrarLibro(libro);
			return "Libro "+ libro.getTitulo() +" añadido";
		}	
	}
```

Como recibimos de valor un `Libro`, usamos sus propiedades para evaluar que quiere el usuario y devolver los datos que solicita.

Añadimos un método basado en el anterior, solo para que nos informe al servidor exclusivamente de que esta solicitando el cliente.

```java
public String evaluarPeticionServidor(Libro libro) {
		// consulta por isbn
		if(libro.getAutor()==null & libro.getTitulo()==null){
			texto = "Consulta de libro por ISBN";
			return texto;
		}
		// consulta por titulo
		else if(libro.getAutor()==null & libro.getIsbn()==null) {
			texto = "Consulta de libro por titulo";
			return texto;
		}
		// consulta por autor
		else if(libro.getIsbn()==null & libro.getTitulo()==null) {
			texto = "Consulta de libro por Autor";
			return texto;	
		}
		// unica opción que queda, añadir libro
		else {
			
			return "Añadir libro";
		}	
	}
```

Pasemos a la clase `Hilo` , donde cada vez que el servidor recibe una petición de entrada de cliente crea un `Hilo` y es este quien va a gestionar todas las operaciones, como os mostrara el siguiente código. 

```java
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
				}else{
					
					Libro libro = gson.fromJson(texto, Libro.class);
					System.out.println("El" + hilo.getName()+ " " + biblio.evaluarPeticionServidor(libro));
					String respuesta = biblio.evaluarPeticion(libro);
					salida.println(respuesta);
					System.out.println("SERVIDOR: le ha respondido al cliente : \n" + respuesta.replaceAll("@@", "\n"));		
				}
			}
			// Matamos el hilo
			socketAlCliente.close();
	
		} catch (IOException e) {
			System.err.println("Hilo: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Hilo: Error");
			e.printStackTrace();
		}
		
	}
```

Cuando recibimos la información del cliente, lo primero que comprobaremos es si el `texto="FIN"`

Si es así, cerraremos la conexión con el cliente mediante `continuar = false` así no se volverá a ejecutar el bucle y cerramos conexión `socketAlCliente.close()`

De no ser así, lo primero que haremos es pasar el JSON que nos ha enviado el cliente a un objeto `Libro` así podremos manejar los datos más fácilmente, pudiendo acceder a todos los métodos del `Libro`  mediante `Libro libro = gson.fromJson(texto, Libro.class)`

Usaremos el método `biblio.evaluarPeticion(libro)` para evaluar la petición del cliente y devolverle la respuesta necesaria, que se la enviaremos `salida.println(respuesta)`

Como información adicional, solo para el SERVIDOR usaremos el método `biblio.evaluarPeticionServidor(libro)` para tener más información del cliente.

Una vez obtenida la información se la enviamos al cliente `salida.println(respuesta)` y seguiremos a la escucha hasta que nos diga que cierra la conexión.