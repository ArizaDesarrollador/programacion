package programacion;

import javax.swing.JOptionPane;

public class Principal {
	
	//Método MAIN
	public static void main(String[] args) {
	// Opciones del menu
	int opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú elige una opcion\n"
			+ "1 Generar Equipo\n"
			+ "2 Generar Equipo desordenado\n"
			+ "3 Buscar un jugador (Busqueda binaria)"));
	
	menu(opcion);
		

	}
	
	//Método para generar el menu
	public static void menu (int opcion) {
		switch (opcion) {
		case 1: 
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores:"));
		Jugador [] equipo = generarEquipo(cantidad);
		imprimirEquipo(equipo);
		break;
		
		case 2: 
		int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
		equipo = generarEquipo(cantidad2);
		desordenarEquipo(equipo);
		imprimirEquipo(equipo);
		break;
		case 3:
		int cantidad3 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
		equipo = generarEquipo(cantidad3);
		imprimirEquipo(equipo);
		System.out.println();
		System.out.println("RESULTADOS DEL JUGADOR BUSCADO");
		imprimirJugadorBuscado(equipo);
		break;
		
		
		default: System.out.println("Por ahora solo estan disponbles del 1 al 3");
		}
		
	}
	
	//Método para imprimir el el jugador buscado gracias al metodo de  búsqueda de la posicion elegida.
	
	public static void imprimirJugadorBuscado ( Jugador [] equipo ) {
		int jugador =buscarJugador(equipo);
		if (jugador == -1) {
			System.out.println("El jugador no ha sido encontrado");
		}else {
			equipo [jugador ].imprimir();
		}
		
		
	}
	
	//Método para buscar un jugador por su dorsal, este nos devuelve la posicion del jugador para aplicarlo en otro metodo.
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
		
		
	
	//Método para imprimir el equipo
	public static void  imprimirEquipo (Jugador [] equipo) {
		
		for (Jugador jugador : equipo) {
			 jugador.imprimir();
		}
		
	}
	
	
	//Método para generar el equipo
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
	

	//Método  para desordenar el equipo
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
	
	// Método para sacar los nombres aleatorios
	public static String nombreJugador () {
		
		
		String [] nombre = {"Paco","Manuela","Jesús","Naomi","Marcos","Naroa","Rosa","rubén","Antonio","Robber"};
		
		
			 return nombre [(int) Math.floor(Math.random() * nombre.length)];
		
		
		
	}
	
	// Método para sacar los apellidos aleatorios
		public static String apellidosJugador () {
			
			String [] apellido1 = {"Ariza ","Melero","Baena ","Ruíz ","Reyes ","Garcés ","González ","Martín ","Ortega ","Garcia "};
			String [] apellido2 = {"Rosa ","Díaz ","Valverde ","Roldán ","Fernández ","Romero ","Padilla ","Santaella ","Bueno","Ferreiro "};
			
			return apellido1 [(int) Math.floor(Math.random() * apellido1.length)]
					+  apellido2 [(int) Math.floor(Math.random() * apellido2.length)];
			
		}
		
		//Método para sacar la posición
		public static String posicionJugador () {
			
			String [] posiciones = {"Portero","Defensa","Centro-Campista","Delantero"};
			
			return posiciones [(int) Math.floor(Math.random()* posiciones.length )];
		}
		
		
		
		
}
