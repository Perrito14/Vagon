package ar.edu.unlam.interfaz;
import java.util.Scanner;
import ar.edu.unlam.dominio.*;

public class SistemaTren {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Bienvenido a QTrainQTrain");
		
		//Creamos la locomotora
		System.out.println("Ingrese el id de la Locomotora (Solo numeros enteros)");
		int idLocomotora = scanner.nextInt();
		
		System.out.println("Ingrese el nombre de la locomotora");
		String nombreLocomotora = scanner.next();
		
		System.out.println("Ingrese la cantidad máxima de vagones (Solo numeros enteros)");
		int cantidadMaximaDeVagones = scanner.nextInt();
		
		Locomotora locomotora = new Locomotora(idLocomotora, nombreLocomotora, cantidadMaximaDeVagones);
		Vagon [] vagones = new Vagon[cantidadMaximaDeVagones];
		
		OpcionesMenu opcion = OpcionesMenu.AGREGAR_VAGON;
		int accion = 0;
		
	    while (opcion != OpcionesMenu.SALIR) {
	    System.out.println("---------------------------------");
	    do {
	    	System.out.println("Que desea hacer? ");
	    	for (int i = 0; i < OpcionesMenu.values().length; i++) {
	    		System.out.println("Ingrese " + (i+1) + " para " + OpcionesMenu.values()[i]);
	    	}
	    	accion = scanner.nextInt();
	    	if (accion > 0 && accion <= OpcionesMenu.values().length) {
	    		opcion = OpcionesMenu.values()[accion-1];
	    	}
	    } while (accion <= 0 || accion > OpcionesMenu.values().length);
	    
	    switch (opcion) {
	    
	    case AGREGAR_VAGON:
	        boolean vagonAgregado = false;
	        boolean idCorrecto = false;
	        int i = 0;
	        String idVagon = "";
	        
	        while (!vagonAgregado && i < vagones.length) {
	            if (vagones[i] != null) {
	                i++;
	            } else {
	            	 	do{
	            		 	System.out.println("Ingrese el id del Vagon (Debe ser un valor alfanumerico, 3 letras y 3 números, ejemplo: ABC123)");
		                	idVagon = scanner.next();
		                	if(Vagon.validarIdentificadorDeVagon(idVagon)) {
			                	idCorrecto = true;
			                } else {
			                	System.out.println("ID incorrecto");
			                }
	            	 	}while(!idCorrecto);
		                
		     
		                System.out.println("Describe al vagon en una palabra");
		                String descripcion = scanner.next();
		                
		                MarcaVagon marca = elegirMarca(scanner);
		                
		                System.out.println("Indica el peso maximo soportado");
		                double pesoMaximoSoportado = scanner.nextDouble();
		                
		                System.out.println("Indica el peso de carga");
		                double pesoDeCarga = scanner.nextDouble();
		                
		                vagones[i] = new Vagon(idVagon, descripcion, marca, pesoMaximoSoportado, pesoDeCarga);
		                
		                locomotora.agregarVagon(vagones[i]);
		                System.out.println("Vagon agregado con exito");
		                System.out.println(vagones[i].toString());
		                vagonAgregado = true;
	            	
	            }
	        }
	        
	        if (!vagonAgregado) {
	            System.out.println("No se pudo agregar el vagon. La formación está completa.");
	        }
	        
	        break;

	    	
	    case OBTENER_VAGON_DE_MENOR_PESO:
	        Vagon vagonDeMenorPeso = locomotora.obtenerVagonDeMenorPeso();
	        if (vagonDeMenorPeso != null) {
	            System.out.println("El vagon de menor peso es: " + vagonDeMenorPeso.toString());
	        } else {
	            System.out.println("Aun no hay vagones en la locomotora");
	        }
	    break;
	    
	    case OBTENER_PESO_PROMEDIO_DE_VAGONES_PARA_LA_MARCA:
	    	
	    	MarcaVagon marca = elegirMarca(scanner);
	    	if(locomotora.obtenerPesoPromedioDeVagonesParaLaMarca(marca) == 0 || Double.isNaN(locomotora.obtenerPesoPromedioDeVagonesParaLaMarca(marca)) ) {
	    		System.out.println("No existen vagones de esta marca");
	    	} else {
	    		System.out.println("El peso promedio para los vagones de la marca " + marca +" es de: " + locomotora.obtenerPesoPromedioDeVagonesParaLaMarca(marca));
	    	}
	    	
	    break;
	    
	    case EDITAR_ID_DE_VAGON:
	        boolean idEditado = false;
	        boolean vagonEncontrado = false;

	        while (!idEditado) {
	            System.out.println("Ingrese el ID actual del vagon que desea modificar");
	            String idActual = scanner.next();

	            vagonEncontrado = false; // Reiniciamos el indicador de vagón encontrado

	            for (i = 0; i < vagones.length; i++) {
	                if (vagones[i] != null && vagones[i].getIdVagon().equals(idActual)) {
	                    System.out.println("Ingrese el nuevo ID para el vagon");
	                    String nuevoId = scanner.next();

	                    if (Vagon.validarIdentificadorDeVagon(nuevoId)) {
	                        locomotora.editarIdDeVagon(idActual, nuevoId);
	                        System.out.println("ID Editado exitosamente");
	                        System.out.println(vagones[i].toString());
	                        idEditado = true;
	                    } else {
	                        System.out.println("Error, escribe tu id nuevamente");
	                    }

	                    vagonEncontrado = true; // Marcamos que se encontró el vagón
	                    break; // Salimos del bucle for
	                }
	            }

	            if (!vagonEncontrado) {
	                System.out.println("El vagon que estas buscando no existe");
	            }
	        }

	        break;
	    case ORDENAR_VAGONES_POR_ID_VAGON:	    	System.out.println("Array de Vagones desordenados:\n");
	    	for(i = 0; i < vagones.length; i++) {
	    		System.out.println(vagones[i].toString());
	    	}
	    	
	    	locomotora.ordenarVagonesPorIdVagon();
	    	
	    	System.out.print("Array de Vagones ordenados:\n");
	    	for(i = 0; i < vagones.length; i++) {
	    		System.out.println(vagones[i].toString());
	    	}	    break;	    	    case SALIR:	    	System.out.println("Hasta pronto");	    break;	   }	    System.out.println("\n");	    }	    		scanner.close();	}	private static MarcaVagon elegirMarca(Scanner scanner) {		System.out.println("Indica la marca del vagon con un numero: 1- LIMA, 2- ROCO, 3- PHILOTRAIN");		int opcionMarca = scanner.nextInt();		MarcaVagon marca = MarcaVagon.LIMA;		switch (opcionMarca) {		case 1: {			marca = MarcaVagon.LIMA;			break;		}		case 2: {			marca = MarcaVagon.ROCO;			break;		}		case 3: {			marca = MarcaVagon.PHILOTRAIN;			break;		}		default:			System.out.println("Opción inválida");;		}		return marca;
	}
}
