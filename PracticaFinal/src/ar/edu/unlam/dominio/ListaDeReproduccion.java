package ar.edu.unlam.dominio;

import java.util.Arrays;

public class ListaDeReproduccion {
	private String nombre;
	private Cancion[] canciones;
	
	public ListaDeReproduccion(String nombre, int cantidadCanciones) {
		this.nombre = nombre;
		this.canciones = new Cancion[cantidadCanciones];
	}
	
	public boolean agregarCancion(Cancion nueva) {
		boolean cancionAgregada = false;
	    for (int i = 0; i < canciones.length; i++) {
	        if (canciones[i] != null && canciones[i].equals(nueva)) {
	            // La canción ya existe en la lista
	            cancionAgregada = false;
	            break;
	        }
	    }

	    // Agregar la canción al primer lugar disponible en el array
	    for (int i = 0; i < canciones.length; i++) {
	        if (canciones[i] == null) {
	            canciones[i] = nueva;
	            cancionAgregada = true;
	            return cancionAgregada;
	        }
	    }

	    // No se pudo agregar la canción (array lleno)
	    return cancionAgregada;
	}
	
	public boolean eliminarCancion(String nombreDeLaCancion) {
		boolean cancionEliminada = false;
		for(int i = 0; i < canciones.length;i++) {
			if(canciones[i] != null && canciones[i].getNombre().equals(nombreDeLaCancion)) {
				canciones[i] = null;
				cancionEliminada = true;
				break;
			}
		}
		return cancionEliminada;
	}

	@Override
	public String toString() {
		return "ListaDeReproduccion [nombre=" + nombre + ", canciones=" + Arrays.toString(canciones) + "]";
	}
}