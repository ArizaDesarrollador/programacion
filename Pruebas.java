package programacion;

/**
 * @author ariza
 *
 */
public class Pruebas {
public static void main(String[] args) {
	
	int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	int numero =17;
	
	System.out.println(busquedaBinaria(array, numero));
	
	}




	// Prueba de la busqueda binaria (Funciona, pero hay que preguntar a profesor la manera de aplicar esto a los objetos)
	public static String busquedaBinaria (int [] array, int numero) {
		
		int der = array.length -1;
		int izq = 0;
		int pasos = 0;
		
		
		int aux;
		boolean encontrado = false;
		for (int i = 0; i < array.length; i++) {
			pasos++;
			int posicion = (der + izq) /2;
			if (array [posicion] == numero) {
				encontrado = true;
				return "El numero "+array[posicion]+" ha sido encontrado en la posición "+ posicion+" del array"+" con un total de "+pasos+" pasos";
				
			}else if (numero < array [posicion]) {
				der = posicion -1;
			}else {
				izq = posicion +1;
			}
			
			
			
		}
		
		if (encontrado == false) {
			return "El numero no ha sido encontrado";
		
		}else {
			return null;
		}
		
			
		
	}


}

