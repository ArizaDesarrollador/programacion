
//TRABAJO EN GRUPO DE PROGRAMACIÓN-2º TRIMESTRE.
//INTEGRANTES: JESÚS Y RIDUOAN.

package programacion;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Principal {
	
	//Método MAIN
	public static void main(String[] args) {
	// Opciones del menu
	int opcion = Integer.parseInt(JOptionPane.showInputDialog(" <(^.^)> Bienvenido al menú. Elige una opcion. <(^.^)>\n"
			+ "1 Generar Equipo.\n"
			+ "2 Generar Equipo desordenado.\n"
			+ "3 Buscar un jugador (Busqueda binaria).\n"
			+ "4 Ordenar equipo desordenado con Bubble-Sort.\n"
			+ "5 Ordenar equipo desordenado con Quick-Sort.\n"
			+ "6 Comparar algoritmos de orden Quick & Bubble."));
	//MÉTODO DEL MENU QUE EJECUTARÁ TODOS LOS MÉTODOS DE LA OPCIÓN ELEGIDA
	menu(opcion); 
		
	}
	
		
	//MÉTODO PARA GENERAR EL MENU
	public static void menu (int opcion) {
		switch (opcion) {
		//OPCIÓN DE GENERAR EL EQUIPO 
		case 1: 
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores:"));
			Jugador [] equipo = generarEquipo(cantidad);
			imprimirEquipo(equipo);
			break;
		//OPCIÓN DE DESORDENAR EL EQUIPO ORDENADO
		case 2: 
			int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
			equipo = generarEquipo(cantidad2);
			desordenarEquipo(equipo);
			imprimirEquipo(equipo);
			break;
		//OPCIÓN DE BUSCAR UN JUGADOR DE UN EQUIPO ORDENADO MEDIANTE SU DORSAL
		case 3:
		int  
			cantidad3 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
			equipo = generarEquipo(cantidad3);
			imprimirEquipo(equipo);
			System.out.println();
			System.out.println("RESULTADOS DEL JUGADOR BUSCADO");
			imprimirJugadorBuscado(equipo);
		break;
		//OPCIÓN PARA ORDENAR UN EQUIPO DESORDENADO MEDIANTE EL ALGORITMO DE BUBBLE-SORT
		case 4:
			int cantidad4 =	Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
			equipo = generarEquipo(cantidad4);
			System.out.println("****DESORDENADO****");
			desordenarEquipo(equipo);
			imprimirEquipo(equipo);
			System.out.println();
			System.out.println("****ORDENADO DE NUEVO CON BUBBLE-SORT****");
			equipoBubble(equipo);
			imprimirEquipo(equipo);
			break;
		case 5:
			int cantidad5 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores:"));
			Jugador [] equipo5 = generarEquipo(cantidad5);
			
			desordenarEquipo(equipo5);
			System.out.println("****EQUIPO DESORDENADO****");
			imprimirEquipo(equipo5);
			System.out.println();
			System.out.println("****EQUIPO ORDENADO POR QUICK-SORT****");
			quick(equipo5, 0, equipo5.length-1);
			imprimirEquipo(equipo5);
			break;
		case 6:
			mainAlgoritmos();
			
			
			
			break;
		// EN EL CASO DE QUE EL USUARIO INSERTE UN NUMERO SIN CASE APARECERA EL SIGUIENT MENSAJE
		default: JOptionPane.showMessageDialog(null, "Solo hay 6 opciones posibles.");
		}
		
	}
	
	
	//MÉTODO PARA ORDENAR CON QUICK-SORT
		public static Jugador [] quick (Jugador [] equipo,int primero,int ultimo) {
			int contadorPivote = 0;
			int pivote = equipo [(primero + ultimo) /2].getDorsal();
			contadorPivote++;
			
			int i = primero;
			int j = ultimo;
			Jugador aux ;
			
			
			while (i<j) {
				while (equipo [i].getDorsal() < pivote && i<j) {
					i++;
				}
				
				while ( equipo [j].getDorsal() > pivote) {
					j--;
				}
				
				if (i<j) {
					aux = equipo[i];
					equipo [i] = equipo [j];
					equipo [j] = aux;
					
				}
			}
			
			if (primero < j-1) {
				quick(equipo, primero, j);
			}
			
			if (i+1 < ultimo) {
				quick(equipo, i, ultimo);
			}
			
		
			
			return equipo ;
			
			
		}
	
	//MÉTODO PARA ORDENAR UN EQUIPO DESORDENADO CON BUBBLE
	public static Jugador [] equipoBubble (Jugador [] equipo ) {
		
		Jugador aux;
		for (int i = 0; i < equipo.length-1; i++) {
			for ( int j = 0; j< equipo.length -1 -i; j++) {
				if (equipo[j].getDorsal() > equipo [j+1].getDorsal()) {
					aux = equipo [j];
					equipo [j] = equipo [j+1];
					equipo [j+1] = aux;
					
				
				}  
			
				
			}
		}
		
		
		return equipo;

	}
	
	
	//METODO PARA IMPRIMIR EL JUGADOR BUSCADO MEDIANTE EL METODO "BUSCARJUGADOR" QUE NOS DEVUELVE LA POSICIÓN
	
	public static void imprimirJugadorBuscado ( Jugador [] equipo ) {
		int jugador =buscarJugador(equipo);
		if (jugador == -1) {
			System.out.println("El jugador no ha sido encontrado ");
		}else {
			equipo [jugador].imprimir() ; 
		}
		
		
	}
	
	//MÉTODO QUE NOS DEVUELVE LA POSICIÓN DE EL JUGADOR BUSCADO, ESTO SE APLICARÁ EN OTRA FUNCIÓN PARA IMPRIMIR EL JUGADOR
	public static int buscarJugador (Jugador [] equipo) {
		int numero = (int) Integer.parseInt(JOptionPane.showInputDialog("¿Qué número de dorsal estas buscando?"));
		
		int izq = equipo [0].getDorsal();
		int der = equipo [equipo.length -1].getDorsal();
		boolean encontrado = false;
		
		
		for (int i = 0; i < equipo.length; i++) {
			
			int posicion =  (izq + der) /2;
			if ( posicion == numero) {
				encontrado = true;
				return posicion;
				 
			}else if (numero < equipo [posicion].getDorsal()) {
				
				der = equipo [posicion].getDorsal() -1;
				
			}else {
				izq = equipo [posicion].getDorsal() +1;
			}
			
		}
		
		if (encontrado == false) {
			return -1;
		}else {
			return -1;
		}
		
		
	}
		
		
	
	//MÉTODO PARA IMPRIMIR EL EQUIPO
	public static void  imprimirEquipo (Jugador [] equipo) {
		
		for (Jugador jugador : equipo) {
			 jugador.imprimir();
		}
		
	}
	
	
	//MÉTODO QUE GENERA EL EQUIPO
	public static Jugador[] generarEquipo(int cantidad) {
		Jugador[] equipo = new Jugador[cantidad];
		for (int i=0; i<cantidad;i++) {
			String nombre= nombreJugador();
			String apellidos = apellidosJugador();
			String posicion = posicionJugador();
			int dorsal=i;
			equipo[i]= new Jugador (nombre, apellidos, posicion, dorsal);
		}
		return equipo;
	}
	

	//MÉTODO PARA DESORDENAR EL EQUIPO
	public static Jugador [] desordenarEquipo (Jugador [] equipo) {
		Jugador aux;
		for ( int i = 0  ; i < equipo.length   ; i++) {
			int contador = (int) Math.floor(Math.random()*equipo.length);
			aux = equipo [i];
			equipo [i] = equipo [contador];
			equipo [contador] = aux;
			
		}
		return equipo;
		
	
	}
	
	// MÉTODO PARA SACAR 1 NOMBRE ALEATORIO DE UN ARRAY
	public static String nombreJugador () {
		
		
		String [] nombre = {"Paco","Manuela","Jesús","Naomi","Marcos","Naroa","Rosa","rubén","Antonio","Robber"};
		
		
			 return nombre [(int) Math.floor(Math.random() * nombre.length)];
		
		
		
	}
	
	// MÉTODO PARA SACAR 1 APELLIDO ALEATORIO DE DOS ARRAY CONCATENANDOLOS
		public static String apellidosJugador () {
			
			String [] apellido1 = {"Ariza ","Melero","Baena ","Ruíz ","Reyes ","Garcés ","González ","Martín ","Ortega ","Garcia "};
			String [] apellido2 = {"Rosa ","Díaz ","Valverde ","Roldán ","Fernández ","Romero ","Padilla ","Santaella ","Bueno","Ferreiro "};
			
			return apellido1 [(int) Math.floor(Math.random() * apellido1.length)]
					+  apellido2 [(int) Math.floor(Math.random() * apellido2.length)];
			
		}
		
		//MÉTODO PARA SACAR LA POSICIÓN DEL JUGADOR
		public static String posicionJugador () {
			
			String [] posiciones = {"Portero","Defensa","Centro-Campista","Delantero"};
			
			return posiciones [(int) Math.floor(Math.random()* posiciones.length )];
		}
		
		
		
		
		
		/*********** EJERCICIO 6*************/ 
		
		//AQUÍ AÑADO METODOS REPETIDOS PARA NO APLICARLOS A LOS OBJETOS PARA QUE SEA UNA COMPARACIÓN SOLO DE NUMEROS.

		//COMPARAR ALGORITMOS DE ORDEN
		
			// EJERCICIO 6 PARA CALCULAR EL TIEMPO DE EJECUCIÓN DE CADA UNO DE LOS DOS ALGORITMOS DE ORDENAMIENTO.
			//ESTE ES EL MÉTODO MAIN QUE IRÁ EN EL MENÚ Y DENTRO DE ESTE ESTAN TODOS LOS MÉTODOS INTEGRADOS.
		public static void mainAlgoritmos() {
				int cantidad;
				//REALIZARÁ LA RECOGIDA DE DATOS HASTA QUE EL NÚMERO SEA IGUAL O MAYOR A CIEN-MIL.
				do {
				 cantidad = Integer.parseInt(JOptionPane.showInputDialog("introduce una cantidad >= 1e5 (100000)", "Ejemplo: 568954 "));
				}while (cantidad < 100000);
				
				// CREAMOS EL ESPACIO EN MEMORIA Y AÑADIMOS EL MÉTODO QUE GENERA EL EQUIPO COMO TAMBIÉN EL MÉTODO  DESORDENAR.
				int [] a = new int [cantidad];
				a = generarEquipoComparacion(cantidad);
				desordenarEquipoComparacion(a);
				
				// AQUÍ USAMOS EL METODO NANOTIME DONDE CREAMOS UN INICIO Y UN FINAL PARA LUEGO MOSTRAR EL TIEMPO DE EJECUCIÓN
				long inicio = System.nanoTime();
				
				//CREAMOS UN DUPLICADO DEL ARRAY ORIGINAL PARA QUE CADA UNO EJECUTE UN ARRAY DESORDENADO
				int [] newArray = Arrays.copyOf(a, a.length);
				System.out.println("****QUICK-SORT****");
				quickSortComparacion(newArray, 0, newArray.length -1);
			
				long fin = System.nanoTime(); //ESTE ES EL FINAL DEL NANO TIME Y CALCULARÁ LO QUE SE EJECUTA DENTRO DE EL.
				double resultado = (double) (fin - inicio) / 1e+9 ;// AQUÍ HACEMOS UNA CONVERSIÓN A DOUBLE Y LO DIVIDIMOS PARA QUE NOS DE EL RESULTADO EN SEGUNDOS
				//
				
				
				System.out.println("QUICK-SORT HA OBTENIDO UN TIEMPO DE: "+resultado + " Segundos");
				System.out.println();
				
				// AQUÍ CREAMOS OTRO ARRAY DUPLICADO PARA QUE ESTE NO NOS VENGA ORDENADO DESDE ARRIBA
				int [] newArray2 = Arrays.copyOf(a, a.length);
				
				long inicio2 = System.nanoTime();
				bubbleSortComparacion(newArray2);
			
				long fin2 = System.nanoTime();
				double resultado2 = (double)  (fin2 - inicio2) / 1e+9 ;   
				System.out.println("****BUBBLE-SORT****");
				System.out.println("BUBBLE-SORT HA OBTENIDO UN TIEMPO DE: "+resultado2+ " Segundos");
				System.out.println();
				
				if (inicio < inicio2) {
					
					System.out.println("****EL ALGORITMO DE QUICK-SORT HA SIDO MÁS RÁPIDO****");
				}else {
					System.out.println("****EL ALGORITMO DE BUBBLE HA SIDO MÁS RÁPIDO****");
				}
				
		}
				
			/* AQUÍ COMIENZAN LOS MÉTODOS NECESARIOS PARA EL EJERCICIO 6*/
			
			// GENERAR EQUIPO PARA EL EJERCICIO DE COMPARACIÓN
			public static int [] generarEquipoComparacion (int cantidad) {
				int[]equipo = new int [cantidad];
				for (int i = 0; i < equipo.length; i++) {
					equipo [i] = i;
					
				}
				return equipo;
			}
			
			// QUICK ORDENAMIENTO COMPARACIÓN
			public static int[] quickSortComparacion (int[] a, int primero, int ultimo) {
				int pivote = a [(primero + ultimo) /2];
				int i = primero;
				int j = ultimo;
				int aux;
				
				
				
				
				while (i<j) {
					
					while (a [i] < pivote && i<j) {
						i++;
						
					}
					
					while (a [j] > pivote) {
						j--;
					}
					
					if (i<j ) {
						aux = a [i];
						a [i] = a[j];
						a[j] = aux;
						
						
					}
					
				}
				
				
				if (primero < j - 1) {
					quickSortComparacion(a, primero, j);
					
				}
				
				if (i +1 < ultimo) {
					quickSortComparacion(a, i , ultimo);
					
				}
				
				return a;
			}
			
			
			//BUBBLE ORDENAMIENTO COMPARACIÓN
		public static int [] bubbleSortComparacion (int [] equipo ) {
				
				int aux;
				for (int i = 0; i < equipo.length-1; i++) {
					for ( int j = 0; j< equipo.length -1 -i; j++) {
						if (equipo[j] > equipo [j+1]) {
							aux = equipo [j];
							equipo [j] = equipo [j+1];
							equipo [j+1] = aux;
							
						
						}  
					
						
					}
				}
				
				return equipo;
		}
			
			



		//IMPRIMIR ARRAY COMPARACIÓN
			public static void imprimirComparacion (int[]array) {
				for (int i = 0; i < array.length; i++) {
					System.out.println(array[i]);
				}
				
				
			}
			
			
			//DESORDENAR ARRAY COMPARACIÓN
			public static int [] desordenarEquipoComparacion (int [] equipo) {
				int aux;
				for ( int i = 0  ; i < equipo.length   ; i++) {
					int contador = (int) Math.floor(Math.random()*equipo.length);
					aux = equipo [i];
					equipo [i] = equipo [contador];
					equipo [contador] = aux;
					
				}
				return equipo;
			
		}
			

		
		
		
		
		
}
