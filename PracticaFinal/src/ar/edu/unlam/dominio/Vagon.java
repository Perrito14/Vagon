package ar.edu.unlam.dominio;

public class Vagon {
	private String idVagon;
	private String descripcion;
	private MarcaVagon marca;
	private double pesoMaximoSoportado;
	private double pesoDeCarga;
	
	public Vagon(String idVagon, String descripcion, MarcaVagon marca, double pesoMaximoSoportado, double pesoDeCarga) {
		this.idVagon = idVagon;
		this.descripcion = descripcion;
		this.marca = marca;
		this.pesoMaximoSoportado = pesoMaximoSoportado;
		this.pesoDeCarga = pesoDeCarga;
	}

	public String getIdVagon() {
		return idVagon;
	}

	public void setIdVagon(String idVagon) {
		this.idVagon = idVagon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MarcaVagon getMarca() {
		return marca;
	}

	public void setMarca(MarcaVagon marca) {
		this.marca = marca;
	}

	public double getPesoMaximoSoportado() {
		return pesoMaximoSoportado;
	}

	public void setPesoMaximoSoportado(double pesoMaximoSoportado) {
		this.pesoMaximoSoportado = pesoMaximoSoportado;
	}

	public double getPesoDeCarga() {
		return pesoDeCarga;
	}

	public void setPesoDeCarga(double pesoDeCarga) {
		this.pesoDeCarga = pesoDeCarga;
	}

	@Override
	public String toString() {
		return "Vagon [idVagon=" + idVagon + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", pesoMaximoSoportado=" + pesoMaximoSoportado + ", pesoDeCarga=" + pesoDeCarga + "]";
	}
	
	public static boolean validarIdentificadorDeVagon(String idVagon) {
	    boolean idValido = false;
	    
	    if (idVagon.length() == 6) {
	        boolean primerosTresLetras = true;
	        for (int i = 0; i < 3; i++) {
	            if (!Character.isLetter(idVagon.charAt(i))) {
	                primerosTresLetras = false;
	                break;
	            }
	        }
	        
	        boolean ultimosTresNumeros = true;
	        for (int i = 3; i < 6; i++) {
	            if (!Character.isDigit(idVagon.charAt(i))) {
	                ultimosTresNumeros = false;
	                break;
	            }
	        }
	        
	        if (primerosTresLetras && ultimosTresNumeros) {
	            idValido = true;
	        }
	    }
	    
	    return idValido;
	}
	
}
