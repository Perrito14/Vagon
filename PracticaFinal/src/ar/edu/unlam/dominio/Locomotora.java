package ar.edu.unlam.dominio;

import java.util.Arrays;

public class Locomotora {
	private int idLocomotora;
	private String nombre;
	private int cantidadMaximaDeVagones;
	private Vagon[] formacion;
	
	public Locomotora(int idLocomotora, String nombre, int cantidadMaximaDeVagones) {
		this.idLocomotora = idLocomotora;
		this.nombre = nombre;
		this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
		this.formacion = new Vagon[cantidadMaximaDeVagones];
	}

	public int getIdLocomotora() {
		return idLocomotora;
	}

	public void setIdLocomotora(int idLocomotora) {
		this.idLocomotora = idLocomotora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadMaximaDeVagones() {
		return cantidadMaximaDeVagones;
	}

	public void setCantidadMaximaDeVagones(int cantidadMaximaDeVagones) {
		this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
	}

	public Vagon[] getFormacion() {
		return formacion;
	}

	public void setFormacion(Vagon[] formacion) {
		this.formacion = formacion;
	}

	@Override
	public String toString() {
		return "Locomotora [idLocomotora=" + idLocomotora + ", nombre=" + nombre + ", cantidadMaximaDeVagones="
				+ cantidadMaximaDeVagones + ", formacion=" + Arrays.toString(formacion) + "]";
	}
	
	public boolean agregarVagon(Vagon vagon) {
	    boolean vagonAgregado = false;
	    int i = 0;
	    
	    while (!vagonAgregado && i < formacion.length) {
	        if (formacion[i] == null) {
	            formacion[i] = vagon;
	            vagonAgregado = true;
	        }
	        i++;
	    }
	    
	    return vagonAgregado;
	}
	
	public Vagon obtenerVagonDeMenorPeso() {
	    Vagon vagonDeMenorPeso = null;
	    double menorPeso = Double.MAX_VALUE; // Valor inicial alto
	    
	    for (int i = 0; i < formacion.length; i++) {
	        if (formacion[i] != null && formacion[i].getPesoDeCarga() < menorPeso) {
	            vagonDeMenorPeso = formacion[i];
	            menorPeso = formacion[i].getPesoDeCarga();
	        }
	    }
	    
	    return vagonDeMenorPeso;
	}

	public double obtenerPesoPromedioDeVagonesParaLaMarca(MarcaVagon marca) {
		Vagon[] vagonesDeLaMarcaBuscada = new Vagon[formacion.length];
		double suma = 0;
		int contadorVagonesDeLaMarca = 0;
		double promedio = 0;
		for(int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null && formacion[i].getMarca().equals(marca)) {
				vagonesDeLaMarcaBuscada[i] = formacion[i];
				suma += vagonesDeLaMarcaBuscada[i].getPesoDeCarga();
				contadorVagonesDeLaMarca++;
			}
		}
		promedio = suma / contadorVagonesDeLaMarca;
		return promedio;
	}
	
	public boolean editarIdDeVagon(String idVagon, String nuevoIdDeVagon) {
		boolean idEditado = false;
		for (int i = 0; i < formacion.length; i++) {
			if(formacion[i] != null && Vagon.validarIdentificadorDeVagon(idVagon) && formacion[i].getIdVagon().equals(idVagon)) {
				formacion[i].setIdVagon(nuevoIdDeVagon);
				idEditado = true;
				break;
			}
		}
		return idEditado;
	}
	
	public void ordenarVagonesPorIdVagon() {
		Vagon aux;
	    for (int i = 0; i < formacion.length - 1; i++) {
	        for (int j = 0; j < formacion.length - 1; j++) {
	            if (formacion[j] != null && formacion[j + 1] != null &&
	                formacion[j].getIdVagon().compareTo(formacion[j + 1].getIdVagon()) > 0) {
	                // Realizar el intercambio de vagones
	                aux = formacion[j];
	                formacion[j] = formacion[j + 1];
	                formacion[j + 1] = aux;
	            }
	        }
	    }
	}
	
	
}
