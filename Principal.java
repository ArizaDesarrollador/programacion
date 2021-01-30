
//TRABAJO EN GRUPO DE PROGRAMACIÓN-2º TRIMESTRE.
//INTEGRANTES: JESÚS Y RIDUOAN.

package programacion;

import javax.swing.JOptionPane;

public class Principal {
	
	//Método MAIN
	public static void main(String[] args) {
	// Opciones del menu
	int opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú elige una opcion\n"
			+ "1 Generar Equipo\n"
			+ "2 Generar Equipo desordenado\n"
			+ "3 Buscar un jugador (Busqueda binaria)\n"
			+ "4 Ordenar equipo desordenado con BubbleSort"));
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
		// EN EL CASO DE QUE EL USUARIO INSERTE UN NUMERO SIN CASE APARECERA EL SIGUIENT MENSAJE
		default: System.out.println("Por ahora solo estan disponbles del 1 al 4");
		}
		
	}
	
	
	//MÉTODO PARA ORDENAR UN EQUIPO DESORDENADO CON BUBBLE
	public static Jugador [] equipoBubble (Jugador [] equipo ) {
		
		Jugador aux;
		for (int i = 0; i < equipo.length-1; i++) {
			for ( int j = 0; j < equipo.length -1; j++) {
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
		
		
		
		
}
