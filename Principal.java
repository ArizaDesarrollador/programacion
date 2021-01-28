package programacion;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
	int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
	//AQUÍ SE LLAMA AL METODO DE GENERAR EL EQUIPO SEGUN LA CANTIDAD
	Jugador [] equipo = generarEquipo(cantidad);
	// AQUÍ SE IMPRIME EL EQUIPO ORDENADO
	System.out.println("ORDENADO");
	imprimirEquipo(equipo);
	//AQUÍ SE INICIA EL METODO DE DESORDENACIÓN
	System.out.println();
	desordenarEquipo(equipo);
	//SE IMPRIME DE NUEVO EL EQUIPO QUE SE IMPRIMIRA DESORDENADO
	System.out.println("DESORDENADO");
	imprimirEquipo(equipo);
	System.out.println();


	

	}
	
	
	
	
	
	//Método desordenación de equipo
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
			int dorsal=i+1;
			equipo[i]= new Jugador (nombre, apellidos, posicion, dorsal);
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
