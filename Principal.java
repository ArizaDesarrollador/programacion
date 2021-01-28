package programacion;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
	
	Jugador [] equipo = generarEquipo(cantidad);
	
	for (Jugador jugador : equipo) {
		jugador.imprimir();
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
			int dorsal=i+1;
			equipo[i]= new Jugador (nombre, apellidos, posicion, dorsal);
		}
		return equipo;
	}
	
	// Método para sacar el nombres aleatorios
	public static String nombreJugador () {
		
		
		String [] nombre = {"Paco","Manuela","Jesús","Naomi","Marcos","Naroa","Rosa","rubén","Antonio","Robber"};
		
		
			 return nombre [(int) Math.floor(Math.random() * nombre.length)];
		
		
		
	}
	
	// Método para sacar el apellidos aleatorios
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
		
		
		
		
		//Método para sacar al equipo completo
		
		public static void imprimirEquipoCompleto(String [] nombreJugador,String [] apellidoJugador,String []posicion,int []dorsal) {
			
			
			for (int i = 0; i < dorsal.length; i++) {
				
				System.out.print(nombreJugador[i] + apellidoJugador[i] + posicion[i] + dorsal[i]);
				System.out.println();
			
			}
		}
		
		
		
}
