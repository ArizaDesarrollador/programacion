package programacion;

import javax.swing.JOptionPane;

public class GenerarNombreAleatorio {
	public String [] generarNombres (int cantidad) {
		// Introducir numero de jugadores en la variable cantidad
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de jugadores"));
		// Objeto jugador que recoge la cantidad de jugadores
		 Jugador [] plantilla = new Jugador[cantidad];
		// Array Nombres
		String [] nombres = {"Andrea","Baltasar","David","Carlota","Bartolo","Jesus","Marco","Juan","Pepe","Alberto"};
		
		
	}
	
public String [] generarApellidos (String apellido1 , String apellido2) {
	// Array Apellidos
	String [] apellidos = {"Acosta", "Acuña", "Aguilar"," Aguirre", "Agustín","Baca", "Báez", "Baños", "Barba", "Barrera",
				"Caballero", "Cabeza", "Cabrera", "Cadenas", "Caldera","Echeverría", "Elizondo", "Enríquez", "Escalante", "Escamilla" };
}





}
