package ar.edu.unlam.interfaz;
import java.util.Scanner;
import ar.edu.unlam.dominio.*;

public class SistemaMusica {

	public static void main(String[] args) {
//		El programa debe contar con el siguiente menú de opciones :
//			a. Guardar mis datos personales
//			b. Crear una lista de reproducción
//			c. Agregar canciones a la lista
//			d. Reproducir una lista de reproducción. Del tratamiento del sonido debemos olvidarnos porque eso
//			lo resolverá un equipo específico, pero a nosotros nos toca garantizar que se visualice por pantalla
//			la información de la lista:
//			i. El listado de las canciones
//			ii. La cantidad de canciones
//			iii. La duración de la lista (Se debe mostrar en el formato mm:ss)
		
		Scanner scanner = new Scanner(System.in);
		
		
		Usuario usuario = new Usuario();
		System.out.println("Ingrese su nombre de usuario");
		String nombreUsuario = scanner.next();
		
		System.out.println("Ingrese su edad");
		int edad = scanner.nextInt();

		usuario.setNombre(nombreUsuario);
		usuario.setEdad(edad);
		
		System.out.println("Bienvenido " + usuario.getNombre() + " a MusicApp");
		
		//Creación de la lista de reproducción:
		System.out.println("Ingrese un nombre para la lista de reproduccion");
		String nombreLista = scanner.next();
		
		System.out.println("Cuantas canciones tiene su lista de reproduccion");
		int cantidadCanciones = scanner.nextInt();
		
		ListaDeReproduccion lista = new ListaDeReproduccion(nombreLista, cantidadCanciones);

		
		Cancion[] canciones = new Cancion[cantidadCanciones];
		for(int i = 0; i < canciones.length; i++) {
			
			if(canciones[i] == null) {
				System.out.println("Ingrese el nombre de la cancion");
				String nombreCancion = scanner.next();
				
				System.out.println("Ingrese el genero de la cancion");
				String genero = scanner.next();
				
				System.out.println("Ingrese la duracion en segundos de la cancion");
				long duracion = scanner.nextLong();
				
				System.out.println("Ingrese el nombre del artista");
				String nombreArtista = scanner.next();
				
				canciones[i] = new Cancion(nombreCancion, genero, duracion, nombreArtista);
				lista.agregarCancion(canciones[i]);
				System.out.println("Cancion agregada con exito");
			}
			
		}
 
		
		System.out.println(usuario.reproducirLista(0));
		
		
		
			
			scanner.close();
		
		
	}

}

//int decision = 0;
//MenuMusica opcion = MenuMusica.REPRODUCIR_LISTA;
//
//while(opcion != MenuMusica.SALIR) {
//	do {
//		System.out.println("Que desea hacer:");
//		for(int i = 0; i < MenuMusica.values().length; i++) {
//			System.out.println("Ingrese " + (i + 1) + " " + MenuMusica.values()[i]);
//		}
//		decision = scanner.nextInt();
//		if (decision > 0 && decision <= MenuMusica.values().length) {
//    		opcion = MenuMusica.values()[decision-1];
//    	}
//		
//		switch (opcion) {
//		case GUARDAR_DATOS_PERSONALES:
//			
//			break;
//			
//		case CREAR_LISTA_DE_REPRODUCCION:
//			if(usuario != null) {
//				System.out.println("Ingrese el nombre de la nueva lista");
//				String nombreLista = scanner.next();
//				usuario.agregarNuevaLista(nombreLista);
//				System.out.println("Lista agregada con éxito: " + usuario.verMisListasDeReproduccion());
//			}else {
//				System.out.println("Error al agregar la lista");
//			}
//			break;
//		case AGREGAR_CANCIONES_A_LA_LISTA:
//			if(usuario != null) {
//				for(int i = 0; i < usuario.getMisListasDeReproduccion().length; i++) {
//					
//				}
//			}
//			break;
//		case REPRODUCIR_LISTA:
//			break;
//		case SALIR:
//			System.out.println("Hasta pronto");
//		}
//	} while(decision <= 0 || decision > MenuMusica.values().length);
//
