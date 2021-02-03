/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.programacion;

/**
 *
 * @author Ariza
 */
public class Jugador {
    //Declaración de variables
		private String nombre;
		private String apellidos;
		private String  posicion;
		private int dorsal ;
		
		
		
		
	//Constructor de jugador
		public Jugador (String nombre,String apellidos,String posicion,int dorsal) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.posicion =posicion;
			this.dorsal=dorsal;
		}
		
		
		// El get y el set para nombre.
		public void setNombre (String nombre) {
			this.nombre = nombre;
		}

		public String getNombre () {
			return nombre;
		}

		//El get y el set para apellidos
		public void setApellidos (String apellidos) {
			this.apellidos= apellidos;
		}

		public String getApellidos () {
			return apellidos;
		}

		// El get y el set para posicion
		public void setPosicion (String posicion) {
			this.posicion= posicion;
		}

		public String getPosicion () {
			return  posicion ;
		}

		//El get y el set para dorsal
		public void setDorsal (int dorsal) {
			this.dorsal= dorsal;
		}

		public int getDorsal () {
			return dorsal;
		}
		
		public void imprimir() {
			System.out.println(this.nombre + " "+this.apellidos+" "+this.posicion+" "+this.dorsal);
		}
		
}
