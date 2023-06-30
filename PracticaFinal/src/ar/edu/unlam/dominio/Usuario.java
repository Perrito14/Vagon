package ar.edu.unlam.dominio;

public class Usuario {
	private String nombre;
	private int edad;
	private ListaDeReproduccion[] misListasDeReproduccion;
	
	public Usuario() {
		this.misListasDeReproduccion = new ListaDeReproduccion[1];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	};
	
	public boolean agregarNuevaLista(String nombreDeLaLista, int cantidadCanciones) {
		boolean listaAgregada = false;
		for(int i = 0; i < misListasDeReproduccion.length; i++) {
			if(misListasDeReproduccion[i] == null) {
				misListasDeReproduccion[i] = new ListaDeReproduccion(nombreDeLaLista, cantidadCanciones);
				listaAgregada = true;
				break;
			}
		}
		return listaAgregada;
	}
	
	public ListaDeReproduccion[] getMisListasDeReproduccion() {
		ListaDeReproduccion[] miLista = new ListaDeReproduccion[misListasDeReproduccion.length];
		
		for(int i = 0; i < misListasDeReproduccion.length; i++) {
			if(misListasDeReproduccion[i] != null) {
				miLista[i] = misListasDeReproduccion[i];
			}
		}
		return miLista;
	}
	
	public String verMisListasDeReproduccion() {
		String mensaje = "";
		for(int i = 0; i < misListasDeReproduccion.length; i++) {
			if(misListasDeReproduccion[i] != null) {
				mensaje += "Lista: " + (i + 1) + " " +  misListasDeReproduccion[i].toString() + "\n";
			}
		}
		return mensaje;
	}
	
	public String reproducirLista(int numeroDeLista) {
	    String mensaje = "";
	    if (misListasDeReproduccion[numeroDeLista] != null) {
	        mensaje = "Reproduciendo: " + misListasDeReproduccion[numeroDeLista].toString();
	    } else {
	        mensaje = "Lista inexistente";
	    }
	    return mensaje;
	}
}


