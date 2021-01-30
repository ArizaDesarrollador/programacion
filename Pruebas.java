package programacion;

import javax.swing.JOptionPane;

/**
 * @author ariza
 *
 */
public class Pruebas {
// PRUEBA PARA BUBBLESORT SIN OBJETO JUGADOR
	public static void main(String[] args) {
		//int [] equipo = {1,2,3,4,5};
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe la cantidad de jugadores"));
		int [] equipo = generarEquipo(cantidad);
		// ordenado
		imprimirEquipo(equipo);
		System.out.println();
		desordenarEquipo(equipo);
		imprimirEquipo(equipo);
		System.out.println();
		BubbleSort(equipo);
		imprimirEquipo(equipo);
		
		

		
		
		
		
		
		
		
	}
	
	
	public static int [] BubbleSort (int equipo []) {
		int aux;
		
		for (int i = 0; i < equipo.length -1; i++) {
			for (int j = 0; j < equipo.length -1; j++) {
				if (equipo [j] > equipo [j+1]) {
					aux = equipo [j];
					equipo [j] = equipo [j+1];
					equipo [j+1] = aux;
				}
			}
		}
		
		return equipo;
		
	}
	
	
	
	public static int [] desordenarEquipo (int[] equipo) {
		int aux;
		for ( int i = 0  ; i < equipo.length   ; i++) {
			int contador = (int) Math.floor(Math.random()*equipo.length);
			aux = equipo [i];
			equipo [i] = equipo [contador];
			equipo [contador] = aux;
			
		}
		return equipo;


	}
	
	
	public static int [] generarEquipo (int cantidad) {
		int [] equipo = new int [cantidad];
		
		for (int i = 0; i < equipo.length; i++) {
			equipo [i] = i;
			
		}
		return equipo;
	}
	
	public static void imprimirEquipo (int[] equipo) {
		for (int i = 0; i < equipo.length; i++) {
			System.out.print(equipo [i]+ " ");
		}
	}
	
	
	


}























